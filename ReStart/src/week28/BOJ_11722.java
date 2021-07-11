package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.

input
6
10 30 10 20 20 10

output
3
 */
public class BOJ_11722 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[] board, dp;
    private static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int k = 0;
        while(st.hasMoreTokens()){
            board[k] = Integer.parseInt(st.nextToken());
            k++;
        }
        
        for(int i = 0; i < N; i++){
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                if(board[i] < board[j] ){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
    
}
