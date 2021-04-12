package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**
     * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
     * 
     */
public class BOJ_1929 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int firstNum, secondNum;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        dp = new int[1000001];

        if(st.hasMoreTokens()){
            firstNum = Integer.parseInt(st.nextToken());
        }
        
        if(st.hasMoreTokens()){
            secondNum = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= secondNum; i++){
            dp[i] = 0;
        }
        dp[1] = 1;

        for(int i = 2; i <= secondNum; i++){
            for(int j = 2; i*j <=secondNum; j++){
                dp[i*j] = 1;
            }
        }

        for(int i = firstNum; i <= secondNum; i++){
            if(dp[i] != 1){
                System.out.println(i);
            }
        }
        
    }
}
