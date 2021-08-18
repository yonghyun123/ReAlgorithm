package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class ProgColoringBook {
    
    public static void main(String[] args) {
        ProgColoringBook.Solution solution = new ProgColoringBook().new Solution();
        int m = 6;
        int n = 4;
        int[][] picture = {
            {1, 1, 1, 0}, 
            {1, 2, 2, 0}, 
            {1, 0, 0, 1}, 
            {0, 0, 0, 1}, 
            {0, 0, 0, 3}, 
            {0, 0, 0, 3}
        };
        int[] temp = solution.solution(m, n, picture);
        System.out.println(temp[0]+", "+temp[1]); 
    }

    class Solution {
        private int row,col;
        private int[] distancRow = {0,1,0,-1};
        private int[] distancCol = {1,0,-1,0};
        private boolean[][] visited;
        private int maxSize = 0;


        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            row = m;
            col = n;
            visited = new boolean[row][col];

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(picture[i][j] != 0 && !visited[i][j]){
                        maxSize = 0;
                        numberOfArea += 1;
                        bfs(picture, i, j, picture[i][j]);
                        maxSizeOfOneArea = Math.max(maxSize, maxSizeOfOneArea);
                    }
                }
            }
    
            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public void initVisited(){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    visited[i][j] = false;
                }
            }
        }

        public void bfs(int [][]picture, int startRow, int startCol, int startValue){
            Queue<int[]> q = new LinkedList<>();

            visited[startRow][startValue] = true;
            maxSize += 1;
            int[] startPos = {startRow, startCol, startValue};
            q.add(startPos);

            while(!q.isEmpty()){
                int curRow = q.peek()[0];
                int curCol = q.peek()[1];
                int curValue = q.peek()[2];

                q.poll();

                for(int i = 0; i < 4; i++){
                    int nextRow = curRow + distancRow[i];
                    int nextCol = curCol + distancCol[i];
                    if(nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) continue;
                    if(!visited[nextRow][nextCol] && picture[nextRow][nextCol] == startValue){
                        visited[nextRow][nextCol] = true;
                        maxSize += 1;
                        int[] nextPos = {nextRow, nextCol, curValue};
                        q.add(nextPos);
                    }

                }
            }
            System.out.println(maxSize);
            
        }
    }
}
