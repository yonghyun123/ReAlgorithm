package toss;

public class Ex05 {
    public static void main(String[] args) {
        Ex05.Solution solution = new Ex05().new Solution();
        System.out.println(solution.solution(4));
            
    }

    class Solution{

        private long[] dp;
        
        public long solution(int k) {
            int[] answer = {};
            dp = new long[71];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i = 4; i < 71; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            
            return dp[k];
        }
    }
}
