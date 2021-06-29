package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 
이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

30
 */
public class BOJ_1932 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int T;
    private static int[][] board;
    private static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());
        board = new int[T][T];

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        dp = new int[501][501];
        dp[0][0] = board[0][0];

        for(int i = 1; i < T; i++){
            for(int j=0; j <= i; j++){
                if(j == 0){// 맨왼쪽
                    dp[i][j] = dp[i-1][0] + board[i][0];
                } else if(j == i){ //맨 오른쪽
                    dp[i][j] = dp[i-1][j-1] + board[i][j];
                } else{ //가운데
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + board[i][j];
                }

                // System.out.println("i="+i+", j="+j+", dp="+dp[i][j]);
            }
        }
        int max = -1;
        for(int i = 0; i < T; i++){

            max = Math.max(dp[T-1][i], max);
        }

        System.out.println(max);
    }
}
