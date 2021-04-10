package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2178 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] directionX = {1,0,-1,0};
    private static int[] directionY = {0,1,0,-1};

    private static int row, col;

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

        for(int i = 0; i < row; i++){
            String tempStr = br.readLine();
            for(int j = 0; j < tempStr.length(); j++){
                board[i][j] = tempStr.charAt(j) - '0';
            }
        }

        int[] startPosition = {0,0,1};

        System.out.println(bfs(startPosition));
    }
    public static int bfs(int[] startPosition){
        Queue<int[]> q = new LinkedList<>();
        q.add(startPosition);
        visited[startPosition[0]][startPosition[1]] = true;
        int result = 0;

        while(!q.isEmpty()){
            int currX = q.peek()[0];
            int currY = q.peek()[1];
            int currCnt = q.peek()[2];

            q.poll();

            if(currX == row-1 && currY == col-1){
                return currCnt;
            }

            for(int i =0; i < 4; i++){
                int nextX = currX+directionX[i];
                int nextY = currY+directionY[i];
                int nextCnt = currCnt+1;

                if(nextX<0 || nextY < 0 || nextX >= row || nextY >=col) continue;
                if(board[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    int[] nextPosition = {nextX, nextY, nextCnt};
                    q.add(nextPosition);
                }
            }
            
            result = currCnt;
        }
        return result;
    }

}
