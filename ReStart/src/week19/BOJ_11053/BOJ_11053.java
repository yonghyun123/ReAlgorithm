package week19.BOJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.


둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
6
10 20 10 30 20 50
 */
public class BOJ_11053 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        int[] board = new int[T];
        int[] dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < T; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }

        // for(int i = 0; i < T; i++){
        //     System.out.print(board[i] + " ");
        // }

        for(int i = 0; i < T; i++){
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                if(board[i] > board[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            
            }
        }
        int max = -1;
        for(int i = 0 ; i < T; i++){
            max = max < dp[i] ? dp[i] : max;
        }
        System.out.println(max);
        
    }
}
