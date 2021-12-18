package programmers.level2;

import java.util.Arrays;
import java.util.stream.*;


// import java.util.;
// import java.util.stream.Stream;

/**
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"
 */
public class ProgMostBigger {

    public static void main(String[] args) {
        ProgMostBigger.Solution solution = new ProgMostBigger().new Solution();
        int[] numbers = {10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution.solution(numbers));   
    }

    class Solution {
        public long biggerNum = Long.MIN_VALUE;
        public String solution(int[] numbers) {
            
            boolean[] visited = new boolean[numbers.length];
            int[] board = new int[numbers.length];
            permutation(visited, numbers, board, 0, numbers.length);
            return String.valueOf(biggerNum);
        }

        public void permutation(boolean[] visited, int[] numbers, int[] board, int depth, int size){
            if(depth == size){
                // Stream.of(board).forEach(v -> System.out.print(v + " ")); //Collections to Stream
                String result = Arrays.stream(board)
                                      .mapToObj(v -> String.valueOf(v))
                                      .collect(Collectors.joining());

                biggerNum = Math.max(biggerNum, Long.parseLong(result));
                
                return;
            }

            for(int i = 0; i < numbers.length; i++){
                if(!visited[i]){
                    board[depth] = numbers[i];
                    visited[i] = true;
                    permutation(visited, numbers, board, depth+1, size);
                    visited[i] = false;
                }
            }
        }
    }
}
