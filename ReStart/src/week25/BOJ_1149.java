package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 
아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 * 
 * 
 * 3
26 40 83
49 60 57
13 89 99
 */
public class BOJ_1149 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[][] dp;
    private static int[][] input;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());

        dp = new int[T+1][3];
        input = new int[T+1][3];

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                input[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }            
        }

        dp[0][0] = input[0][0];
        dp[0][1] = input[0][1];
        dp[0][2] = input[0][2];

        for(int i = 1; i < T; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + input[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + input[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + input[i][2];
        }

        int result = Math.min(Math.min(dp[T-1][0],dp[T-1][1]), dp[T-1][2]);
        System.out.println(result);
           
    }
}
