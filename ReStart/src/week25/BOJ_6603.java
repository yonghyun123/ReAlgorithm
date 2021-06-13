package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.

로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.

예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다. 
([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])

집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
 */

public class BOJ_6603 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] board;
    private static boolean[] visisted;
    private static List<Integer> result;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T != 0){
            result = new ArrayList<Integer>();

            board = new int[T];
            visisted = new boolean[T];
    
            int i = 0;
            while(st.hasMoreTokens()){
                board[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            combination(result,0,6, 0);
            System.out.println();
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
        }


       
       
    }

    public static void combination(List<Integer> result, int start, int finalDepth, int currDepth){

        if(finalDepth == currDepth){
            for(int i = 0; i < result.size(); i++){
                System.out.print(result.get(i)+ " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < board.length; i++){
            if(!visisted[i]){
                visisted[i] = true;
                result.add(board[i]);
                combination(result, i+1, finalDepth, currDepth+1);
                result.remove((Integer)board[i]);
                visisted[i] = false;

            }
        }
    }
}
