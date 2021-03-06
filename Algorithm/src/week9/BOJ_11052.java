package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[1001];
        int[] inputDp = new int[1001];
        for(int i = 1; i <= n; i++){
            inputDp[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i-j]+inputDp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
