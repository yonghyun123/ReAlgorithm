package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 크기가 N×M인 종이가 있고, 종이는 1×1크기의 칸으로 나누어져 있다. 
 * 이 종이의 각 칸 위에 1×1×1 크기의 정육면체를 놓아 3차원 도형을 만들었다.

종이의 각 칸에 놓인 정육면체의 개수가 주어졌을 때, 이 도형의 겉넓이를 구하는 프로그램을 작성하시오.
1 1
1
6

3 3
1 3 4
2 2 3
1 2 4
60
 */
public class BOJ_16931 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] board;
    private static int row, col;
    private static int[] rectValue;
    private static int[] directionX = {1,0,-1,0};
    private static int[] directionY = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        if(st.hasMoreTokens()){
            row = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            col = Integer.parseInt(st.nextToken());
        }
        board = new int[row][col];
        
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        rectValue = new int[101];
        rectValue[1] = 6;
        for(int i = 2, j = 1; i < 101; i++, j++){
            rectValue[i] = i*6 - (j*2);
        }
        int sum = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sum += rectValue[board[i][j]];
                sum -= numberOfShading(i,j);
            }
        }

        System.out.println(sum);
        
    }

    public static int numberOfShading(int startX, int startY){
        int sum = 0;
        for(int i = 0; i < 4; i++){
            int nextX = startX + directionX[i];
            int nextY = startY + directionY[i];

            if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
            if(board[startX][startY] > board[nextX][nextY]) sum += board[nextX][nextY];
            else sum += board[startX][startY];
        }
        return sum;
    }
}
