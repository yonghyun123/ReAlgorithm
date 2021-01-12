package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오

INPUT
10
OUTPUT
3

 */
public class BOJ_1463 {
      /**
         *  arr2 =1
         *   arr3 = 1
         *   arr4 = 1 + arr2 = 2
         *   arr5 = 1 + arr4 = 3
         *   Arr6 = 1 + arr2 = 2
         *   Arr7 = 1 + arr6 = 3
         *   arr8 = 1 + arr4 = 3
         *   arr9 = 1 + arr3 = 2
         *   Arr10 = 1 + arr5 
         *   arr11 = 1 + arr10
         *   Arr12 = 1 + arr4
         *   Arr13 = 1 + arr12
         *   arr14 = 1 + arr7
         *   arr15 = 
         */

        
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int inputNum = Integer.parseInt(br.readLine());
        long dp[] = new long[10000000];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
      
        for(int i = 2; i <= inputNum; i++){
            dp[i] = 1 + dp[i-1];
            if(i % 3 == 0){
                dp[i] = Math.min((1 + dp[i/3]), dp[i]);
            }
            if(i % 2 == 0){
                dp[i] = Math.min( (1 + dp[i/2]), dp[i]);
            } 
            
            
        }
        System.out.println(dp[inputNum]);
        
        
    }   
}
