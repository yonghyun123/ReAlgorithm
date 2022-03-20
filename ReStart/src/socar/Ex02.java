package socar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Ex02 {

    public static void main(String[] args) {
        Ex02.Solution solution = new Ex02().new Solution();
        int[] numbers = {18,10,2};
        int K = 7;
        System.out.println(solution.solution(numbers, K)); 

    }

    class Solution{
        public boolean[] visited;
        public int[] board;
        public int leastCnt = Integer.MAX_VALUE;

        public int solution(int[] numbers, int K){
            
            visited = new boolean[numbers.length];
            board = new int[numbers.length];

            permutation(numbers, K, 0, numbers.length);
            if(leastCnt == Integer.MAX_VALUE) leastCnt = -1;
            return leastCnt;
        }

        public void permutation(int[] numbers, int K, int depth, int size){
            if(depth == size){
                //순열이 완료되었으면 경우의 수 판단
                //조건을 만족하는지 판단
                if(isCorrect(board, K)){
                    // for(int i = 0; i < size; i++){
                    //     System.out.print(board[i]+" ");
                    // }
                    // System.out.println();

                    //여기에서 몇번 swap이 일어났는지 판단
                    leastCnt = Math.min(swapCountCalculator(board, numbers), leastCnt);

                }
                return;
            }

            for(int i = 0; i < size; i++){
                if(!visited[i]){
                    visited[i] = true;
                    board[depth] = numbers[i];
                    permutation(numbers, K, depth+1, size);
                    visited[i] = false;
                }
            }
        }

        public boolean isCorrect(int[] board, int K){

            for(int i = 0; i < board.length-1; i++){
                if(Math.abs(board[i+1] - board[i]) > K) return false;
            }

            return true;
        }

        public int swapCountCalculator(int[] board, int[] numbers){
            List<Integer> arrayToList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
            int swapCount = 0;
            for(int i = 0; i < board.length; i++){
                if(board[i] != arrayToList.get(i)){
                    int idx = arrayToList.indexOf(board[i]);
                    //swap이 일어나야함.
                    int temp = board[i];
                    board[i] = board[idx];
                    board[idx] = temp;
                    swapCount += 1;
                }
                if(leastCnt < swapCount) return leastCnt;

            }
            return swapCount;
        }

    }
    
}
