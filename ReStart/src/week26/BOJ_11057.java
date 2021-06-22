package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
 */

public class BOJ_11057 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int num = Integer.parseInt(br.readLine());
        int result = 0;
        dp = new int[1001][10];

        //끝자리 0~9까지 값 셋팅
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= num; i++){
            for(int j = 0; j < 10; j++){
                //0  1~10까지 합, 1 1~9까지 합을 구하는 loop 하나 더 필요
                for(int k = j; k < 10; k++){
                    dp[i][j] = (dp[i][j] + dp[i-1][k])%10007;
                }
            }
        }

        for(int i = 0; i < 10; i++){
            result = (result + dp[num][i])%10007;
        }

        System.out.println(result);
    }
}
