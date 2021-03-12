package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다. 예를 들어, 2의 약수는 1, 2가 있고, 24의
 * 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다. 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다.
 * x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
 * 
 * 자연수 N이 주어졌을 때, g(N)을 구해보자.
 */
public class BOJ_17425 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;
    private static long[] dp1, dp2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        dp1 = new long[1000001];
        dp2 = new long[1000001];

        Arrays.fill(dp1, 1);

        // for(int i = 0; i < T; i++){
        //     int n = Integer.parseInt(br.readLine());
        //     long sum = 0;
        //     for(int j = 1; j <= n; j++){
        //         sum += (j * (n/j));
        //     }
        //     System.out.println(sum);
        // }

        for(int i = 2; i <=1000000; i++){
            for(int j =1; i*j <=1000000; j++){
                dp1[i*j] += i;
            }
        }
        dp2[1] = 1;
        for(int i = 2; i <= 1000000; i++){
            dp2[i] = dp2[i-1] + dp1[i];
        }
        

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp2[n]).append("\n");
        }
        System.out.println(sb);
    }
}
