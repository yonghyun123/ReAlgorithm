package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×17 직사각형을 채운 한가지 예이다.


첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

 */

public class BOJ_11727 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static long[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        dp = new long[10001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for(int i = 4; i <= n; i++ ){
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
