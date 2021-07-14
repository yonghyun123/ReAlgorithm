package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속합 2
 * 
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 단, 수는 한 개 이상 선택해야 한다. 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 수를 제거하지 않았을 때의 정답은 
12+21인 33이 정답이 된다.

만약, -35를 제거한다면, 수열은 10, -4, 3, 1, 5, 6, 12, 21, -1이 되고, 여기서 정답은 10-4+3+1+5+6+12+21인 54가 된다.
input
10
10 -4 3 1 5 6 -35 12 21 -1

output
54
 */

public class BOJ_13398 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N;
    private static int[] board;
    private static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        dp = new int[N][2];
        board = new int[N];

        int idx = 0;
        while(st.hasMoreTokens()){
            board[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        
        dp[0][0] = board[0];
        dp[0][1] = board[0];
        int result = board[0];

        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i-1][0]+board[i], board[i]);//삭제하지 않았을때,
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + board[i]);
            result = Math.max(Math.max(dp[i][0], result),dp[i][1]);
        }

        System.out.println(result);
    }
}
