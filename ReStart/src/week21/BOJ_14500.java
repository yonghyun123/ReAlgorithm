package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**
 * 폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1

19
 */

public class BOJ_14500 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int row, col, max;
    private static int [][] board;
    private static boolean [][] visited;
    private static int []dirCol = {1,0,-1,0};
    private static int []dirRow = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if(st.hasMoreTokens()){
            row = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            col = Integer.parseInt(st.nextToken());
        }
        board = new int[row][col];
        visited = new boolean[row][col];
        max = 0;

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                visited[i][j] = true;
                dfs(i,j,0,board[i][j]);
                visited[i][j] = false;
                lastShape(i,j,board[i][j]);
                
            }
        }
        // dfs(2,2,0,board[2][2]);

        System.out.println(max);
    }

    public static void dfs(int startX, int startY, int depth, int sum){
        if(depth == 3){
            if(max < sum) max = sum;
            // System.out.println("dfs="+sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextRow = startX + dirRow[i];
            int nextCol = startY + dirCol[i];

            if(nextRow < 0 || nextCol < 0 || nextRow >=row || nextCol >= col) continue;

            if(!visited[nextRow][nextCol]){
                visited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, depth+1, sum+board[nextRow][nextCol]);
                visited[nextRow][nextCol] = false;
            }
        }
    }

    /**
     * 4 4
        1 2 1 2 
        1 1 5 1 
        3 2 3 3 
        4 4 1 3 
     */

    public static void lastShape(int startX, int startY, int sum){
        int numOfShape = 0;
        for(int i = 0 ; i < 4; i++){
            int nextRow = startX + dirRow[i];
            int nextCol = startY + dirCol[i];

            if(nextRow < 0 || nextCol < 0 || nextRow >=row || nextCol >= col){
                numOfShape += 1;
                continue;
            }
            sum += board[nextRow][nextCol];

        }
        if(numOfShape == 1){
            if(sum > max){
                max = sum; 
            } 
            return;
        } else if(numOfShape  > 1){
            return;
        } else {
            for(int i = 0 ; i < 4; i++){
                int nextRow = startX + dirRow[i];
                int nextCol = startY + dirCol[i];

                int crossShapeNum = sum - board[nextRow][nextCol];
                if(crossShapeNum > max){
                    max = crossShapeNum;
                } 
            }
            return;
        }
    }
}
