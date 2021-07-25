package week31;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 키패드 누르기
 * 
 * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

 [제한사항]
numbers 배열의 크기는 1 이상 1,000 이하입니다.
numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
hand는 "left" 또는 "right" 입니다.
"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.

[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5] "right" "LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
 */

public class ProgKeypad {
    public static void main(String[] args) {
        ProgKeypad.Solution solution = new ProgKeypad().new Solution();
        int[] numbers = {7,0,8,2,8,3,1,5,7,6,2};
        String hand = "left";
        System.out.println(solution.solution(numbers, hand));
    }

    class Solution{
        int[][] constArray = {
            {0,0},
            {0,1},
            {0,2},
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {2,2},
            {3,0},
            {3,1},
            {3,2},
        };
        private Stack<Integer> rightStack, leftStack;
        private List<String> resultList;
        private Map<Integer,int[]> boardMap;
        //1,4,7은 왼손만
        //3,6,9는 오른손만
        

        public String solution(int[] numbers, String hand) {
            resultList = new ArrayList<>();
            boardMap = new HashMap<>(); 
            rightStack = new Stack<>();
            leftStack = new Stack<>();

            rightStack.push(12);
            leftStack.push(10);
            
            for(int i = 1; i <= 12; i++){
                boardMap.put(i, constArray[i-1]);
            }
            //keypad를 아래와 같이 생각
            /**
             * 1  2  3
             * 4  5  6 
             * 7  8  9
             * 10 11 12
             */

            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                    leftStack.push(numbers[i]);
                    resultList.add("L");
                }
                else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                    rightStack.push(numbers[i]);
                    resultList.add("R");
                }
                else {
                    if(numbers[i] == 0) numbers[i] = 11;

                    int[] curPos = boardMap.get(numbers[i]);
                    int[] leftPos = boardMap.get(leftStack.peek());
                    int[] rightPos = boardMap.get(rightStack.peek());

                    int leftDistance = calDistance(curPos, leftPos);
                    int rightDistance = calDistance(curPos, rightPos);

                    if("right".equals(hand)){
                        if(leftDistance >= rightDistance){
                            rightStack.add(numbers[i]);
                            resultList.add("R");
                        } else {
                            leftStack.add(numbers[i]);
                            resultList.add("L");
                        }
                    } else {
                        if(leftDistance <= rightDistance){
                            leftStack.add(numbers[i]);
                            resultList.add("L");
                        } else {
                            rightStack.add(numbers[i]);
                            resultList.add("R");
                        }
                    }
                }
            }

            String answer = resultList.stream().map(item -> String.valueOf(item)).collect(Collectors.joining());
            return answer;
        }

        public int calDistance(int[] curPos, int[] stackPos){
            int posX = Math.abs(curPos[0] - stackPos[0]);
            int posY = Math.abs(curPos[1] - stackPos[1]);
            return posX+posY;
        }

        
    }
}

