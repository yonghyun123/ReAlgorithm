package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int num1, num2, num3;

    public static void main(String[] args) throws NumberFormatException, IOException {

        st = new StringTokenizer(br.readLine());
        if(st.hasMoreTokens()){
            num1 = Integer.parseInt(st.nextToken());
        }
        if(st.hasMoreTokens()){
            num2 = Integer.parseInt(st.nextToken());    
        }
        if(st.hasMoreTokens()){
            num3 = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        int step15 = 0;
        int step28 = 0;
        int step19 = 0;
        while(true){
            

            if(step15 % 15 == 0) step15 = 0;
            if(step28 % 28 == 0) step28 = 0;
            if(step19 % 19 == 0) step19 = 0;
            
            step15 += 1;
            step19 += 1;
            step28 += 1;
            result += 1;
            
            if(step15 == num1 && step28 == num2 && step19 == num3) break;
        }

        System.out.println(result);
    }
}
