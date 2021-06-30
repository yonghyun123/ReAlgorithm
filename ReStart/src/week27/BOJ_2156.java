package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] board;
    public static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        board = new int[T+2];

        dp = new int[100001];
        for(int i = 1; i <= T; i++){
            board[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = board[0];
        dp[1] = board[1];
        dp[2] = board[1]+board[2];

        for(int i = 3; i <= T; i++){
            dp[i] = Math.max(dp[i-2]+board[i], dp[i-3] + board[i] + board[i-1]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        System.out.println(dp[T]);


        
    }
}
