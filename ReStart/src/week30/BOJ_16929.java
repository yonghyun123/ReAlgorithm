package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**
 * Two Dots
 * 
 * 점 k개 d1, d2, ..., dk로 이루어진 사이클의 정의는 아래와 같다.

모든 k개의 점은 서로 다르다. 
k는 4보다 크거나 같다.
모든 점의 색은 같다.
모든 1 ≤ i ≤ k-1에 대해서, di와 di+1은 인접하다. 또, dk와 d1도 인접해야 한다.
 두 점이 인접하다는 것은 각각의 점이 들어있는 칸이 변을 공유한다는 의미이다.
게임판의 상태가 주어졌을 때, 사이클이 존재하는지 아닌지 구해보자.


3 4
AAAA
ABCA
AAAA

Yes

4 4
YYYR
BYBY
BBBY
BBBY

Yes
 */
public class BOJ_16929 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static char[][] board;
    private static boolean[][] visited;
    private static int row,col;
    private static int[] dirRow = {0,1,0,-1};
    private static int[] dirCol = {1,0,-1,0};
    private static boolean answerFlag;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if(st.hasMoreTokens()){
            row = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            col = Integer.parseInt(st.nextToken());
        }

        board = new char[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String tempStr = br.readLine();
            for(int j = 0; j < tempStr.length(); j++){
                board[i][j] = tempStr.charAt(j);
            }
        }
        // printBoard();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int[] position = {i,j};
                dfs(position, position, 0);
                initVisisted();
                if(answerFlag) break;
            }
            if(answerFlag) break;
        }
        if(answerFlag){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
    }

    public static void dfs(int[] startPos, int[] curPos, int depth){
        int startRow = startPos[0];
        int startCol = startPos[1];

        int curRow = curPos[0];
        int curCol = curPos[1];

        // System.out.println("curRow="+ curRow+ ", curCol="+curCol+", depth="+depth);

        //4번이상 지나갔고, 현재 좌표가 처음좌표랑 같으면 true
        if(depth >= 4 && startRow == curRow && startCol == curCol){
            answerFlag = true;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextRow = dirRow[i] + curRow;
            int nextCol = dirCol[i] + curCol;
            if(nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col) continue;
            if(!visited[nextRow][nextCol] && board[startRow][startCol] == board[nextRow][nextCol]){
                visited[nextRow][nextCol] = true;
                int[] nextPos = {nextRow, nextCol};
                dfs(startPos, nextPos, depth+1);
                visited[nextRow][nextCol] = false;
                if(answerFlag) break;
            }
        }
    }

    public static void initVisisted(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void printBoard(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
