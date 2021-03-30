package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1번 연산은 배열을 상하 반전시키는 연산이다.
 * 2번 연산은 배열을 좌우 반전시키는 연산이다.
 * 3번 연산은 오른쪽으로 90도 회전시키는 연산이다.
 * 4번 연산은 왼쪽으로 90도 회전시키는 연산이다.
 * 5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 
 * 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.
 * 5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.
 * 6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.
 * 1
 *  1 6 2 9 8 4 → 4 2 9 3 1 8
    7 2 6 9 8 2 → 9 2 3 6 1 5
    1 8 3 4 2 9 → 7 4 6 2 3 1
    7 4 6 2 3 1 → 1 8 3 4 2 9
    9 2 3 6 1 5 → 7 2 6 9 8 2
    4 2 9 3 1 8 → 1 6 2 9 8 4
 * 
 * 2
 *  1 6 2 9 8 4 → 4 8 9 2 6 1
    7 2 6 9 8 2 → 2 8 9 6 2 7
    1 8 3 4 2 9 → 9 2 4 3 8 1
    7 4 6 2 3 1 → 1 3 2 6 4 7
    9 2 3 6 1 5 → 5 1 6 3 2 9
    4 2 9 3 1 8 → 8 1 3 9 2 4
 */

public class BOJ_16935 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] inputArray;
    private static int[][] resultArray;
    private static int n,m,methodCnt;
    private static int[] methodsArray;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        methodCnt = Integer.parseInt(st.nextToken());
        
        inputArray = new int[n][m];

        

        methodsArray = new int[methodCnt];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                inputArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        if(methodCnt > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < methodCnt; i++){
                methodsArray[i] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < methodCnt; i++){
            switch(methodsArray[i]){
                case 1: methos1(); break;
                case 2: methos2(); break;
                case 3: methos3(); break;
                case 4: methos4(); break;
                case 5: methos5(); break;
                case 6: methos6(); break;
            }
            copyArrary();
        }
        arrayPrint();

    }

    public static void copyArrary(){
        inputArray = new int[resultArray.length][resultArray[0].length];
        for(int i = 0; i < resultArray.length; i++){
            for(int j = 0; j < resultArray[i].length; j++){
                inputArray[i][j] = resultArray[i][j];
            }
        }
    }

    public static void methos1(){
        int row = inputArray.length;
        int col = inputArray[0].length;
        resultArray = new int[row][col];
        for(int i = 0; i < inputArray.length; i++){
            for(int j = 0; j < inputArray[i].length; j++){
                resultArray[i][j] = inputArray[(row-1)-i][j];
            }
        }
    }

    public static void methos2(){
        int col = inputArray[0].length;
        int row = inputArray.length;
        resultArray = new int[row][col];
        for(int i = 0; i < inputArray.length; i++){
            for(int j = 0; j < inputArray[i].length; j++){
                resultArray[i][j] = inputArray[i][(col-1)-j];
            }
        }
    }

    public static void methos3(){
        int col = inputArray[0].length;
        int row = inputArray.length;
        resultArray = new int[col][row];
        for(int i = 0; i < inputArray.length; i++){
            for(int j = 0; j < inputArray[i].length; j++){
                resultArray[j][row-1-i] = inputArray[i][j];
            }
        }
    }

    public static void methos4(){
        int col = inputArray[0].length;
        int row = inputArray.length;
        resultArray = new int[col][row];
        for(int i = 0; i < inputArray.length; i++){
            for(int j = 0; j < inputArray[i].length; j++){
                resultArray[col-1-j][i] = inputArray[i][j];
            }
        }
    }

    public static void methos5(){
        int dividedN = inputArray.length/2;
        int dividedM = inputArray[0].length/2;
        int row = inputArray.length;
        int col = inputArray[0].length;
        resultArray = new int[row][col];

        for(int i = 0; i < dividedN; i++){
            for(int j = 0 ; j < dividedM; j++){
                 // 1->2 심기
                resultArray[i][j+dividedM] = inputArray[i][j];
                // 2->3
                resultArray[i+dividedN][j+dividedM] = inputArray[i][j+dividedM];
                // 3->4
                resultArray[i+dividedN][j] = inputArray[i+dividedN][j+dividedM];
                // 4->3
                resultArray[i][j] = inputArray[i+dividedN][j];
            }
        }
    }

    public static void methos6(){
        int dividedN = inputArray.length/2;
        int dividedM = inputArray[0].length/2;
        int row = inputArray.length;
        int col = inputArray[0].length;
        resultArray = new int[row][col];
        for(int i = 0; i < dividedN; i++){
            for(int j = 0 ; j < dividedM; j++){
                 // 1->4 심기
                resultArray[i+dividedN][j] = inputArray[i][j];
                // 4->3
                resultArray[i+dividedN][j+dividedM] = inputArray[i+dividedN][j];
                // 3->2
                resultArray[i][j+dividedM] = inputArray[i+dividedN][j+dividedM];
                // 4->3
                resultArray[i][j] = inputArray[i][j+dividedM];
            }
        }
    }

    public static void arrayPrint(){
        
        for(int i = 0; i < resultArray.length; i++){
            for(int j = 0; j < resultArray[i].length; j++){
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
