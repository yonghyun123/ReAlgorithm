package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 로또
 * 
 * 독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.

로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.

예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다. 
([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])

집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.

input
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0

1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7


 */
public class BOJ_6603 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] board, tempArr;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T != 0){
            board = new int[T];
            tempArr = new int[6];
            
            int i = 0;
            while(st.hasMoreTokens()){
                board[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            combination(tempArr, 0, T, 6, 0);
            System.out.println();
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
        }
    }

    public static void combination(int[] arr, int index, int n, int r, int valueIdx){
        if(r == 0){
            printArray();
        } else if(valueIdx == n) return;
        else{
            arr[index] = board[valueIdx];
            combination(arr, index+1, n, r-1, valueIdx+1);
            combination(arr, index,   n, r,   valueIdx+1);
        }
    }

    public static void printArray(){
        for(int i = 0; i < tempArr.length; i++){
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();
    }
}
