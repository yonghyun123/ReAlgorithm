package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

1	1	6	14
2	2	7	21
3	4	8	22
4	11	9	24
5	12	10	41
 */

public class Prog_124Number {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
    
        
            int N = Integer.parseInt(br.readLine());
            String[] dp = new String[4];
            StringBuilder sb = new StringBuilder();

            dp[0] = "4";
            dp[1] = "1";
            dp[2] = "2";
            while(N != 0){
                int divider = N / 3;
                int divided = N % 3;
                N = divider;
                if(divided == 0){
                    N--;
                }

                sb.append(dp[divided]);
                
            }
            
            System.out.println(sb.reverse());
        
    }
    
}
