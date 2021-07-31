package hyundaicard;

public class ex02 {
    
    class Solution{
        private int[] board;
        private boolean[] visited;
        private int n, result, multiValue;

        public int solution(int k, int m){
            int answer = -1;
            result = 0;
            board = new int[k];
            visited = new boolean[k];
            n = k;
            multiValue = m;

            permutation(0);
            return result;
        }

        public void permutation(int depth){
            if(depth == n){
                String tempStr = "";
                int tempResult = 0;

                for(int i = 0; i < board.length; i++){
                    tempStr += board[i] + "";
                }
                if(!"".equals(tempStr)){
                    tempResult = Integer.parseInt(tempStr);
                }
                if(tempResult % multiValue == 0) result += 1;
            }

            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    visited[i] = true;
                    board[depth] = i+1;
                    permutation(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
