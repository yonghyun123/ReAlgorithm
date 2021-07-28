package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;





/**
 * 점프점프
 * 재환이가 1×N 크기의 미로에 갇혀있다. 미로는 1×1 크기의 칸으로 이루어져 있고, 
 * 각 칸에는 정수가 하나 쓰여 있다. i번째 칸에 쓰여 있는 수를 Ai라고 했을 때,
 *  재환이는 Ai이하만큼 오른쪽으로 떨어진 칸으로 한 번에 점프할 수 있다. 예를 들어, 3번째 칸에 쓰여 있는 수가 3이면, 
 * 재환이는 4, 5, 6번 칸 중 하나로 점프할 수 있다.

재환이는 지금 미로의 가장 왼쪽 끝에 있고, 가장 오른쪽 끝으로 가려고 한다. 
이때, 최소 몇 번 점프를 해야 갈 수 있는지 구하는 프로그램을 작성하시오. 만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.

재환이가 최소 몇 번 점프를 해야 가장 오른쪽 끝 칸으로 갈 수 있는지 출력한다. 만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.
input
10
1 2 0 1 3 2 1 5 4 2

output
5
 */
public class BOJ_11060 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int T;
    private static int[] board,dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        board = new int[T];
        dp = new int[T];

        int i = 0;
        while(st.hasMoreTokens()){
            board[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(i = 0; i < T-1; i++){
            if(dp[i] == -1) continue;
            for(int j = 1; j <= board[i]; j++){
                if(i+j < T){
                    // System.out.print("i="+i+", j="+j+", dp[i+j]="+dp[i+j] + ", dp[i]+1=" + (dp[i]+1));
                    // 이 조건이 어렵다. j에 의해 이미 점프순서가 많아져있다면 최솟값을 찾아서 대입
                    if(dp[i+j] == -1 || dp[i+j] > dp[i]+1){
                        dp[i+j] = dp[i] + 1;
                    }
                    // System.out.println();
                }
            }
        }
        // for(i = 0; i < T; i++){
        //     System.out.print(dp[i] + " ");
        // }
        System.out.println(dp[T-1]);
    }
}
