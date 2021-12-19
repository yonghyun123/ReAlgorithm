package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ProgMoreSpicy {
    public static void main(String[] args) {
        ProgMoreSpicy.Solution solution = new ProgMoreSpicy().new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println( solution.solution(scoville, 7));
    }
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            // List<Integer> scovilleList = new ArrayList<>(scoville);
            //int[] to ArrayList
            // Queue의 기능을 사용하기 위해 LinkedList를 사용
            List<Integer> tempList = Arrays.stream(scoville).boxed().collect(Collectors.toList());
            Collections.sort(tempList);
            PriorityQueue<Integer> inputList = new PriorityQueue<>(tempList);
            
            
            // 조건을 Stream으로 만들면 아주 좋다.

            while(inputList.peek() < K){
                int first = inputList.peek();
                inputList.poll();

                int second = inputList.peek();

                int result = first + second * 2;
                inputList.poll();
                inputList.offer(result);
                answer += 1;
            }
            return answer;
        }
    }
}
