package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 */
public class Prog_stock {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String tempStr = br.readLine();
        int[] board = new int[tempStr.length()];
        int[] result = new int[tempStr.length()];

        
        
        for(int i = 0; i < tempStr.length(); i++){
            board[i] = Integer.parseInt(String.valueOf(tempStr.charAt(i)));
        }

        for(int i = 0; i < board.length; i++){
            
            for(int j = i+1; j < board.length; j++){
                
                if(board[i] > board[j]){
                    result[i] = j-i;
                    break;
                } 
                
                if(j == board.length-1){
                    result[i] = j-i;
                }
            }
            
        }

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i]+ " ");
        }
        System.out.println();


    }
}
