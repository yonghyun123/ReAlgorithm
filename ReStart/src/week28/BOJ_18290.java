package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 크기가 N×M인 격자판의 각 칸에 정수가 하나씩 들어있다. 이 격자판에서 칸 K개를 선택할 것이고, 
 * 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 구하려고 한다. 단, 선택한 두 칸이 인접하면 안된다. 
 * r행 c열에 있는 칸을 (r, c)라고 했을 때, (r-1, c), (r+1, c), (r, c-1), (r, c+1)에 있는 칸이 인접한 칸이다.
 * 
input
2 2 2
1 2
3 4

output
5

3 3 2

1 2 3 
4 5 6
7 10 9
 */
public class BOJ_18290 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] board;
    private static boolean[][] visited;
    private static int row, col, depth, resultValue;
    private static int[] dirRow = {1,1,-1,-1};
    private static int[] dirCol = {1,-1,-1,1};

    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if(st.hasMoreTokens()){
            row = Integer.parseInt(st.nextToken());
        }
        if(st.hasMoreTokens()){
            col = Integer.parseInt(st.nextToken());
        }
        if(st.hasMoreTokens()){
            depth = Integer.parseInt(st.nextToken());
        }

        board = new int[row][col];
        visited = new boolean[row][col];
        resultValue = -999999999;

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        int tempResult = 0;
        if(row == 1){
            for(int idx = 0; idx < 2; idx++){
                int cnt = 1;
                tempResult = 0;
                for(int i = idx; i < col; i+=2){
                    tempResult += board[0][i];
                    
                    if(depth == cnt){
                        break;
                    }

                    if(depth==1){
                        tempResult = board[0][i];
                        break;
                    } 
                    cnt+=1;
                }
                resultValue = Math.max(resultValue,tempResult);
            }
        }


        if(col == 1){
            for(int idx = 0; idx < 2; idx++){
                int cnt = 1;
                tempResult = 0;
                for(int i = idx; i < row; i+=2){
                    tempResult += board[i][0];
                    
                    if(depth == cnt){
                        break;
                    }

                    if(depth==1){
                        tempResult = board[i][0];
                        break;
                    } 
                    cnt+=1;
                }
                resultValue = Math.max(resultValue,tempResult);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(i, j, 0, board[i][j]);
                initVisited();
            }
        }
        System.out.println(resultValue);
    }

    public static void printBoard(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initVisited(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
               visited[i][j] = false;
            }
        }
    }

    public static void dfs(int startRow, int startCol, int curDepth, int curValue){
        
        visited[startRow][startCol] = true;

        if(depth-1 == curDepth){
            // System.out.println("row="+startRow+" col="+startCol+" value="+curValue);
            resultValue = Math.max(resultValue, curValue);
            return;
        }


        for(int i = 0; i < 4; i++){
            int nextRow = dirRow[i] + startRow;
            int nextCol = dirCol[i] + startCol;
            if(nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col) continue;
            if(!visited[nextRow][nextCol]){
                dfs(nextRow, nextCol, curDepth+1, curValue+board[nextRow][nextCol]);
                visited[nextRow][nextCol] = false;
            }
        }
    }
}
