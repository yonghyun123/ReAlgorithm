package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 */
public class BOJ_2667 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] distanceX = {1,0,-1,0};
    private static int[] distanceY = {0,1,0,-1};

    private static List<Integer> resultList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());

        board = new int[T][T];
        visited = new boolean[T][T];
        resultList = new ArrayList<>();

        for(int i = 0; i < T; i++){
            String tempStr = br.readLine();
            for(int j = 0; j < tempStr.length(); j++){
                board[i][j] = tempStr.charAt(j)-'0';
            }
        }

        for(int i = 0; i < T; i++){
            for(int j = 0; j < T; j++){
                if(!visited[i][j] && board[i][j] != 0){
                    int[] inputPosition ={i,j,1};
                    resultList.add(bfs(inputPosition));
                }
            }
        }

        System.out.println(resultList.size());
        Collections.sort(resultList);
        for(int i = 0; i < resultList.size(); i++){
            System.out.println(resultList.get(i));
        }

    }

    public static int bfs(int[] position){
        Queue<int[]> q = new LinkedList<>();
        int maxNum = 1;
        visited[position[0]][position[1]] = true;

        q.add(position);

        while(!q.isEmpty()){
            int currX = q.peek()[0];
            int currY = q.peek()[1];
            int curCnt = q.peek()[2];
            // System.out.println("curCnt"+curCnt);
            q.poll();
         

            // visited[currX][currY] = true;
            

            for(int i = 0; i <  4; i++){
                int nextX = distanceX[i] + currX;
                int nextY = distanceY[i] + currY;
                if(nextX < 0 || nextY < 0 || nextX >= T || nextY >= T) continue;
                if(!visited[nextX][nextY] && board[nextX][nextY] != 0){
                    // curCnt = curCnt+1;
                    int []nextNode = {nextX, nextY, curCnt};
                    visited[nextX][nextY] = true;
                    maxNum += 1;
                    q.add(nextNode);

                }
            }
            // maxNum = curCnt;
            // System.out.println(maxNum);
        }
        return maxNum;
    }
}
