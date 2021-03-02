package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17427 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        long result = 0;

        for(long i = 1; i <= n; i++){
            result += i*(n/i);
        }
        System.out.println(result);
    }
    
}
