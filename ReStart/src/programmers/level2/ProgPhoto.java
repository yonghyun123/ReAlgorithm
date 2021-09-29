package programmers.level2;

import java.beans.Visibility;

public class ProgPhoto {
    public static void main(String[] args) {
        ProgPhoto.Solution solution = new ProgPhoto().new Solution();
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        solution.solution(n, data);

    }
    class Solution {
        public int[] board;
        public boolean[] visited;
        public int solution(int n, String[] data) {
            int answer = 0;
            board = new int[3];
            visited = new boolean[3];
            permutation(0);
            return answer;
        }

        public void permutation(int depth){
            if(depth == 3){
                for(int i = 0; i < 3; i++){
                    System.out.print(board[i] + " "); 
                }
                System.out.println();
                return;
            }

            for(int i = 0; i < 3; i++){
                if(!visited[i]){
                    visited[i] = true;
                    board[depth] = i + 1;
                    permutation(depth+1);
                    visited[i] = false;
                }
            }

        }
    }
}
