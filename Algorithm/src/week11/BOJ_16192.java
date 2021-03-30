package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 예를 들어, 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 갖기
 * 위해 지불해야 하는 금액의 최솟값은 4원이다. 1개 들어있는 카드팩을 4번 사면 된다.
 * 
 * P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는 카드가 2개 들어있는 카드팩을 2번 사면 4원이고, 이 경우가 민규가
 * 지불해야 하는 금액의 최솟값이다.
 * 
 * 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최솟값을 구하는 프로그램을 작성하시오. N개보다
 * 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다. 즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은
 * N과 같아야 한다.
 * 
 * 첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최솟값을 출력한다.
 * 
 * input 4 1 5 6 7 output 4
 * 
 */
public class BOJ_16192 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        int []inputArr = new int[1001];
        int []dp = new int[1001];
        st = new StringTokenizer(br.readLine());
        int idx = 1;

        while(st.hasMoreTokens()){
            inputArr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        Arrays.fill(dp, 99999999);
        dp[0]= 0;

        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i], (dp[i-j] + inputArr[j]) );
            }
        }
        // for(int i = 0; i<5; i++){
            System.out.println(dp[n]);
    }
}
