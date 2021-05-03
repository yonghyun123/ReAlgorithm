package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 4
 * 
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다. 그러한 수열이 여러가지인 경우 아무거나 출력한다.
6
10 20 10 30 20 50

4
10 20 30 50
 */
public class BOJ_14002 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int[] board = new int[T+1];
        int[] dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < T; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }


        int max = -1;
        for(int i = 0; i <= T; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(board[i] > board[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            
            }
        }

        int idx = max;
        for(int i = T; i >= 0; i--){
            if(idx == dp[i]){
                list.add(board[i]);
                idx--;
            }
        }

        System.out.println(max);
        for(int i = list.size()-1 ; i >= 0; i--){
            System.out.print(list.get(i)+" ");
        }
        
    }
}
