package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  
{1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오
 * input
 * 
 * 10
1 5 2 1 4 3 4 5 2 1

output 
7
 */
public class BOJ_11054 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[] board, dp, rdp;
    private static int N;


    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N+1];
        dp = new int[N+1];
        rdp = new int[N+1];
        

        st = new StringTokenizer(br.readLine());
        int k = 0;
        while(st.hasMoreTokens()){
            board[k] = Integer.parseInt(st.nextToken());
            k++;
        }
        
        for(int i = 0; i < N; i++){
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                if(board[i] > board[j] ){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = N-1; i >= 0; i --){
            rdp[i] = 1;

            for(int j = N-1; j > i; j--){
                if(board[i] > board[j] ){
                    rdp[i] = Math.max(rdp[i], rdp[j] + 1);
                }
            }
        }

        for(int i = 0; i < N; i++){
            dp[i] += rdp[i];
        }
       
        Arrays.sort(dp);
        System.out.println(dp[N]-1);
    }
}
