package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 * 
 * 1+1+1+1 1+1+2 1+2+1 2+1+1 2+2 1+3 3+1 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의
 * 수를 구하는 프로그램을 작성하시오.
 * 
 * input 3 4 7 10
 * 
 * 7 44 274
 */
public class BOJ_9095 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        int[] dp = new int[10];
        dp[0] = 1; //1을 만드는 가짓수
        dp[1] = 2; //2을 만드는 가짓수
        dp[2] = 4; //3을 만드는 가짓수

        for(int i = 3; i < 10; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i = 0; i < testCaseNum; i++){
            int answerIdx = Integer.parseInt(br.readLine());
            System.out.println(dp[answerIdx-1]);
        }

    }
}
