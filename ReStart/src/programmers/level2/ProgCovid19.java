package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다.

코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.

대기실은 5개이며, 각 대기실은 5x5 크기입니다.
거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.

제한사항
places의 행 길이(대기실 개수) = 5
places의 각 행은 하나의 대기실 구조를 나타냅니다.
places의 열 길이(대기실 세로 길이) = 5
places의 원소는 P,O,X로 이루어진 문자열입니다.
places 원소의 길이(대기실 가로 길이) = 5
P는 응시자가 앉아있는 자리를 의미합니다.
O는 빈 테이블을 의미합니다.
X는 파티션을 의미합니다.
입력으로 주어지는 5개 대기실의 크기는 모두 5x5 입니다.
return 값 형식
1차원 정수 배열에 5개의 원소를 담아서 return 합니다.
places에 담겨 있는 5개 대기실의 순서대로, 거리두기 준수 여부를 차례대로 배열에 담습니다.
각 대기실 별로 모든 응시자가 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 담습니다.

[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], 
["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], 
["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], 
["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], 
["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]

[1, 0, 1, 1, 1]
 */

public class ProgCovid19 {
    public static void main(String[] args) {
        ProgCovid19.Solution solution = new ProgCovid19().new Solution();

        String[][] places = {
            {"PPOOO", "OOOOO", "OOOOO", "OOOOO", "OOOOP"}, 
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] result = solution.solution(places);
        System.out.println(result);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i]+" ");
        }
    }

    class Solution {
        private char[][] board;
        private boolean[][] visited;
        private int[] dirRow = {0,1,0,-1};
        private int[] dirCol = {1,0,-1,0};
        
        public int[] solution(String[][] places) {
            int[] answer = {};
            board = new char[5][5];
            visited = new boolean[5][5];
            answer = new int[5];
            for(int i = 0; i < places.length; i++){
                for(int j = 0; j < places[i].length; j++){
                    String inputStr = places[i][j];
                    board[j] = inputStr.toCharArray();
                }


                //첫번째 케이스 시작
                answer[i] = isCollect(board);                
            }
            return answer;
        }

        public void initVisted(){
            for(int i = 0; i < visited.length; i++){
                for(int j = 0; j < visited[i].length; j++){
                    visited[i][j] = false;
                }
            }
        }

        public int isCollect(char[][] board){

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == 'P'){
                        int[] startPos = {i,j,0,1};
                        if(!bfs(startPos)){
                            return 0;
                        }
                        initVisted();
                    }
                }
            }
            return 1;
        }

        public boolean bfs(int[] startPos){
            /** 
             * P=1, O = 0,  = 2;
             */
            /*
            POOOP
            OXXOX
            OPXPX
            OOXOX
            POXXP
            */
            
            Queue<int[]> q = new LinkedList<>();
            visited[startPos[0]][startPos[1]] = true;
            q.add(startPos);
            while(!q.isEmpty()){

                int curRow = q.peek()[0];
                int curCol = q.peek()[1];
                int curDepth = q.peek()[2];
                int curVal = q.peek()[3];

                q.poll();

                if(curDepth > 2) break;

                if(curDepth <= 2 && curDepth > 0){
                    //큐 인스턴스 중 P가 있을때, 거리두기가 지켜지지 않은상황
                    if(curVal == 1){
                        return false;
                    }
                }
                

                for(int i = 0; i < 4; i++){
                    int nextRow = dirRow[i] + curRow;
                    int nextCol = dirCol[i] + curCol;
                    if(nextRow < 0 || nextRow >= 5 || nextCol < 0 || nextCol >= 5) continue;
                    //P나 0이면 탐색시작
                    if(!visited[nextRow][nextCol] && (board[nextRow][nextCol] == 'P' ||board[nextRow][nextCol] == 'O')){
                        int nextVal = -1;
                        if(board[nextRow][nextCol] == 'P'){
                            nextVal = 1;
                        } else {
                            nextVal = 0;
                        }
                        visited[nextRow][nextCol] = true;
                        int[] nextPos = {nextRow, nextCol, curDepth+1, nextVal};
                        q.add(nextPos);
                    }
                }
            }
                
            return true;
        }
    }
}
