package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] dp;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        boolean breakFlag = false;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N];

        for(int i = 1; i < K; i++){
            for(int j = i; j < K; j ++){
                dp[0] = i; //초기값 셋팅
                dp[1] = j; //초기값 셋팅
                //DP 점화식
                for(int k = 0; k < N-2; k++){
                    dp[k+2] = dp[k+1] + dp[k];
                }
                if(dp[N-1] == K){
                    breakFlag = true; // Get Answer
                    break;
                } 
            }
            if(breakFlag) break;
        }
        if(!breakFlag){
            System.out.println("만족하는 수가 없습니다.");
        } else {
            System.out.println("A = " + dp[0] + ", B = " + dp[1]);    
        }
        
    }
}

