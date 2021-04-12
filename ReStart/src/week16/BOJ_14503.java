package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.

로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다.
 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 
 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.

로봇 청소기는 다음과 같이 작동한다.

현재 위치를 청소한다.
현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다

3 3
1 1 0
1 1 1
1 0 1
1 1 1
 */

public class BOJ_14503 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] board;
    // private static boolean[][] visited;
    private static int row, col;
    // private static int startDir , startRow, startCol;
    // private static int[] directionX = {1,0,-1,0};
    // private static int[] directionY = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if(st.hasMoreTokens()){
            row = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            col = Integer.parseInt(st.nextToken());
        }

        st =new StringTokenizer(br.readLine());

        if(st.hasMoreTokens()){
            // startRow = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            // startCol = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            // startDir = Integer.parseInt(st.nextToken());
        }

        board = new int[row][col];
        // visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String tempStr = br.readLine();
            for(int j = 0; j < tempStr.length(); j++){
                board[i][j] = tempStr.charAt(j) - '0';
            }
        }

        // int[] startPosition = {startRow,startCol,1};

  
    }
}
