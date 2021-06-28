package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;


/**
 * 규현이가 쓴 수를 A라고 하면, A[i]는 규현이가 i번째 쓴 수이다. 그리고, 
 * S[i][j]는 A[i]부터 A[j]까지 합이 0보다 크면 +, 0이면 0, 0보다 작으면 -이다. 여기서 i는 항상 j보다 작거나 같다. 
 * 이렇게 배열을 채우면 배열에는 총 N*(N+1)/2개의 문자가 있다. (+, -, 0 중 하나) 이 S 배열이 주어졌을 때, 
 * 규현이가 쓴 N개의 수 A를 구해서 출력하면 된다.
 *  규현이는 -10부터 10까지의 정수밖에 모르기 때문에, A도 -10부터 10까지의 정수로만 이루어져 있어야 한다.
 * 
 *  input
 *  4
 *  -+0++++--+
 * 
 * output
 * -2 5 -3 1
 */

public class BOJ_1248 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int T;
    private static char[][] board;
    private static ArrayList<Integer> resultList;

    public static void dfs(int depth){

        if(depth == T){
            for(int el: resultList){
                System.out.print(el + " ");
            }
            System.exit(0);
            return;
        }

        for(int i = -10; i <=10; i++){
            
            resultList.add(i);

            if(calculateNumber(depth)){
                
                dfs(depth+1);
            }

            resultList.remove(resultList.size()-1);
        }
    }

    public static boolean calculateNumber(int depth){

        int sum = 0;
        for(int i = depth; i >=0; i--){
            sum += resultList.get(i);
            
            // System.out.println("i="+i+", depth="+depth+", sum="+sum+", board[i][depth]="+board[i][depth]);
            if(board[i][depth] == '+'){
               if(sum <= 0) return false;
            } 

            if(board[i][depth] == '-'){
                if(sum >= 0) return false;
            }

            if(board[i][depth] == '0'){
                if(sum !=0) return false;
            } 
            
        }

        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        resultList = new ArrayList<>();

        board = new char[T][T];
        
        char[] tempChar = st.nextToken().toCharArray();
        int k = 0;
        for(int i = 0; i < T; i++){
            for(int j = i; j < T; j++){
                board[i][j] = tempChar[k];
                k++;
            }
        }

        dfs(0);
        for(int el: resultList){
            System.out.print(el + " ");
        }
    }
}
