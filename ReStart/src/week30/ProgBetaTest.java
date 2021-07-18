package week30;

import java.util.ArrayList;
import java.util.List;

/**
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 
return 하도록 solution 함수를 작성해주세요

시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요


answers	    return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
 */

public class ProgBetaTest {
    public static int[] board;
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,3,2,4,2};
        int[] result = solution.solution(test);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }
}

class Solution {
    //1번 수포자 1 2 3 4 5 1 2 3 4 5
    //2번 수포자 2 1 2 3 2 4 2 5 2 1
    //3번 수포자 3 3 1 1 2 2 4 4 5 5 3 3 

    public int[] firstAbandonMath = {1,2,3,4,5};
    public int[] secondAbandonMath = {2,1,2,3,2,4,2,5};
    public int[] thirdAbandonMath = {3,3,1,1,2,2,4,4,5,5};

    List<Integer> valueList = new ArrayList<>();

    public int[] solution(int[] answers) {
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        int[] answer = {};
        
        for(int i = 0,j = 0; i < answers.length; i++,j++){
            if(answers[i] == firstAbandonMath[j%5]) {
                firstCount += 1;
            }
            if(answers[i] == secondAbandonMath[j%8]) {
                secondCount += 1;
            }
            if(answers[i] == thirdAbandonMath[j%10]) {
                thirdCount += 1;
            }
        }

        valueList.add(firstCount);
        valueList.add(secondCount);
        valueList.add(thirdCount);
        int result = Math.max(Math.max(firstCount, secondCount),thirdCount);

        int indexValue = valueList.indexOf(result);
        int indexValue2 = valueList.lastIndexOf(result);

        if(firstCount == 0 && firstCount == secondCount && secondCount == thirdCount){
            return answer;
        }

        if(indexValue == indexValue2){
            answer = new int[1];
            answer[0] = indexValue + 1;
        } else {
            if(firstCount == secondCount && secondCount == thirdCount){
                answer = new int[3];
                answer[0] = 1;
                answer[1] = 2;
                answer[2] = 3;
            } else {
                answer = new int[2];
                answer[0] = indexValue+1;
                answer[1] = indexValue2+1;
            }
        }

        return answer;
    }
}