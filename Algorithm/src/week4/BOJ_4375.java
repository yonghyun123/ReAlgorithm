package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 1로만 이루어진 n의 배수를 찾는 프로그램을
 * 작성하시오. 1로 이루어진 n의 배수 중 가장 작은 수의 자리수를 출력한다.
 * 
 * input 3 7 9901
 * 
 * output 3 6 12
 */
public class BOJ_4375 {

    // private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
         
        // 파일 끝 EOF 처리를 해줘야 정답이 되는 케이스...       
        // while(sc.hasNextInt()){
        //     sc.nextInt();
        // }

        // while(sc.hasNextLine()){
        //     sc.nextLine();
        // }
        //
        // String input = "";
        // while((input = br.readLine()) != null){

        // }
        // 위에 소스로 EOF 처리가 가능 
        //


        while(sc.hasNextInt()){
            int inputNum = sc.nextInt();
            int divided = 1;
            int reminder = 99999999;
            int result = 0;
            while(reminder != 0){
                reminder = divided % inputNum;
                divided = reminder*10 + 1;
                result += 1;
            }
            System.out.println(result);
        }   
    }
    
}
