package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 크기가 N×M인 지도가 존재한다. 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다. 이 지도의 위에 주사위가 하나 놓여져 있으며, 주사위의 전개도는
 * 아래와 같다. 지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수이다. 2 4
 * 1 3 5 6 주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x,
 * y) 이다. 가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
 * 
 * 지도의 각 칸에는 정수가 하나씩 쓰여져 있다. 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가
 * 칸에 복사된다. 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다. 주사위를 놓은
 * 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오. 주사위는
 * 지도의 바깥으로 이동시킬 수 없다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다
 */
public class BOJ_14999 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] board;
    private static int[] dice;
    private static int row, col, startX, startY;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
        }
        board = new int[row][col];
        dice = new int[6];

        
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                if(st.hasMoreTokens()){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        // System.out.println();

        // for(int i = 0; i < row; i++){
        //     for(int j = 0; j < col; j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.print(row+","+col+","+startX+","+startY+","+calCount);

        String[] tempStr = br.readLine().split(" ");
        for(int i =0 ; i < tempStr.length; i++){
            int direction = Integer.parseInt(tempStr[i]);
            // System.out.print("direction="+direction);
            //남쪽이동
            if(direction == 4){  //dice[0] = 아래, dice[1] = 뒤, dice[2] 오른, dice[3] 왼, dice[4] 앞, dice[5] = 위
                if(startX+1 >= row) continue;
                startX += 1;
                int temp = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = temp;
            } else if(direction == 3){// 북쪽이동
                if(startX-1 < 0) continue;
                startX -= 1;
                int temp = dice[5];
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = temp;
            } else if(direction == 2) {// 서쪽이동
                if(startY-1 < 0) continue;
                startY -= 1;
                int temp = dice[5];
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = temp;
            } else { //동쪽이동
                if(startY+1 >= col) continue;
                startY += 1;
                int temp = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = temp;
            }
            
            // System.out.println("startx="+startX+",startY="+startY);
            if(board[startX][startY] == 0){
                board[startX][startY] = dice[0];
            } else {
                dice[0] = board[startX][startY];
                board[startX][startY] = 0;
            }

             System.out.println(dice[5]);

        }


    }
}
