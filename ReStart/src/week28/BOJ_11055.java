package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 가장 큰 증가 부분 수열은 
A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 이고, 합은 113이다.

input
10
1 100 2 50 60 3 5 6 7 8

output
113

 */
public class BOJ_11055 {
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
        int result = board[0];
        
        for(int i = 0; i < N; i++){
            dp[i] = board[i];

            for(int j = 0; j < i; j++){
                if(board[i] > board[j] && dp[i] < dp[j] + board[i]){
                    dp[i] = dp[j] + board[i];
                }
                result = Math.max(dp[i], result);
            }
        }
        System.out.println(result);

    }
}
