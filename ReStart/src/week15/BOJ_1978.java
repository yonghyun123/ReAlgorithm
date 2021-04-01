package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

4
1 3 5 7

3
 */
public class BOJ_1978 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int primeNumber = Integer.parseInt(st.nextToken());
            boolean isNotPrime = false;

            if(primeNumber == 1) continue;
            //소수 판단
            for(int j = 2; j <= primeNumber/2; j++){
                
                if(primeNumber % j == 0){
                    isNotPrime = true;
                }
            }

            if(!isNotPrime) result +=1;

        }
        

        System.out.println(result);
    }
}
