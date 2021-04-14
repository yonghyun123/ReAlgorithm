package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.

4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 
또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.

이 추측은 아직도 해결되지 않은 문제이다.

백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
 */

public class BOJ_6588 {
    private static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        String input;
        dp = new int[1000001];
        for(int i = 0; i < 1000000; i++){
            dp[i] = 1;
        }
        dp[1] = 0;

        for(int i = 2; i <= 1000000; i++){
            for(int j = 2; i*j <=1000000; j++){
                dp[i*j] = 0;
            }
        }
        while((input = br.readLine()) != null){
            int N = Integer.parseInt(input);
            if(N==0){
                break;
            }

            for(int i = 3; i <= N/2; i++){
                if(dp[i] == 1 && dp[N-i] == 1){
                    int tempInt = N-i;
                    System.out.println(N + " = " + i + " + " +tempInt);
                    break;
                }
    
                if(i == N/2){
                    System.out.println("Goldbach's conjecture is wrong.");
                    break;
                }
            }
        }
    }
}
