package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 인구이동
 * N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, 
 * r행 c열에 있는 나라에는 A[r][c]명이 살고 있다. 인접한 나라 사이에는 국경선이 존재한다. 
 * 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.

오늘부터 인구 이동이 시작되는 날이다.

인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.

국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
input
2 20 50
50 30
20 40
output
1
input
2 40 50
50 30
20 40
output
0
 */

public class BOJ_16234 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N,L,R,result;
    private static int[][] board,afterBoard;
    private static int[] dirRow = {0,1,0,-1};
    private static int[] dirCol = {1,0,-1,0};
    private static boolean[][] visited,afterVisited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if(st.hasMoreTokens()){
            N = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            L = Integer.parseInt(st.nextToken());
        }

        if(st.hasMoreTokens()){
            R = Integer.parseInt(st.nextToken());
        }

        board = new int[N][N];
        afterBoard = new int[N][N];
        visited = new boolean[N][N];
        afterVisited = new boolean[N][N];
        result = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                board[i][j] = Integer.parseInt(st.nextToken());
                afterBoard[i][j] = board[i][j];
                j++;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int[] pos = {i,j};
                bfs(pos);   
            }

            if(isDiffVisited()){
                calulateBoard();//계산을 먼저하고 
            }
            printBoard();
            System.out.println();
            if(isDiffBoard()){
                copyBoard();//계산된 인구 배열로 변경
                copyVisited();
                i = 0;
                result += 1;
            } else {
                break;
            }
        }

        /**
         * debug test
         */
        // int[] pos = {0,0};
        // bfs(pos);
        // printVisited();
        // calulateBoard();
        // copyBoard();
        // printBoard();

        System.out.println(result);   
    }

    
    public static void bfs(int[] startPos){
        Queue<int[]> q = new LinkedList<>();

        q.add(startPos);
        // bfs를 시작하지 못했다면 초기 방문값 false로 셋팅
        boolean searchFlag = false;
        int firstRow = startPos[0];
        int firstCol = startPos[1];
        
        visited[firstRow][firstCol] = true;
        
        while(!q.isEmpty()){
            
            int curRow = q.peek()[0];
            int curCol = q.peek()[1];
            q.poll();

            for(int i = 0; i < 4; i++){
                int nextRow = curRow + dirRow[i];
                int nextCol = curCol + dirCol[i];
                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
                if(!visited[nextRow][nextCol] && isMove(board[curRow][curCol], board[nextRow][nextCol])){
                    visited[nextRow][nextCol] = true;
                    searchFlag = true;
                    int[] nextPos = {nextRow, nextCol};
                    q.add(nextPos);
                }
            }
        }

        if(!searchFlag){
            visited[firstRow][firstCol] = false;
        }
    }
 
    public static void calulateBoard(){
        int trueCnt = 0;
        int totalValue = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]){
                    trueCnt += 1;
                    totalValue += board[i][j];
                }
            }
        }
        int avgValue = totalValue / trueCnt;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]){
                    afterBoard[i][j] = avgValue;
                }else{
                    afterBoard[i][j] = board[i][j];
                }
            }
        }
    }
    public static void copyBoard(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = afterBoard[i][j];
            }
        }
    }

    public static void copyVisited(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                afterVisited[i][j] = visited[i][j];
            }
        }
    }

    public static boolean isDiffBoard(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != afterBoard[i][j]) return true;
            }
        }
        return false;
    }


    public static boolean isDiffVisited(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] != afterVisited[i][j]) return true;
            }
        }
        return false;
    }

    public static boolean isVisited(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) return true;
            }
        }
        return false;
    }

    public static void printBoard(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printVisited(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static boolean isMove(int curNode, int nextNode){
        int resultValue = Math.abs(curNode-nextNode);
        if(L <= resultValue && R >= resultValue){
            return true;
        } else {
            return false;
        }
    }
}
