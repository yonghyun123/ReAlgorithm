package programmers.level2;

import java.util.ArrayList;

/**
 * ows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다. 
 * 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해,
 *  테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다. 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.

x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
다음은 6 x 6 크기 행렬의 예시입니다.

grid_example.png

이 행렬에 (2, 2, 5, 4) 회전을 적용하면, 아래 그림과 같이 2행 2열부터 5행 4열까지 영역의 테두리가 시계방향으로 회전합니다. 
이때, 중앙의 15와 21이 있는 영역은 회전하지 않는 것을 주의하세요.

rotation_example.png

행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때,
 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */
public class ProgRotateArray {
    
    public static void main(String[] args) {
        ProgRotateArray.Solution solution = new ProgRotateArray().new Solution();
        int row = 100;
        int col = 97;
        int[][] query = {
            {1,1,100,97}
        };
        // Arrays.stream(solution.solution(row, col, query)).forEach(v -> System.out.println(v)); 
        solution.solution(row, col, query);
    }


    class Solution {

        public int[][] originBoard, copyBoard;
        public ArrayList<Integer> resultValue;
        public int[] solution(int row, int col, int[][] queries) {
            
            int value = 1;
            originBoard = new int[row][col];
            copyBoard   = new int[row][col];
            resultValue = new ArrayList<>();

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    originBoard[i][j] = value;
                    copyBoard[i][j] = value;
                    value++;
                    
                }
            }

            
            
            for(int i = 0; i < queries.length; i++){
                resultValue.add(rotate(queries[i]));    
                copyArr(copyBoard,originBoard);
            }
            
            printArr(originBoard);
            
            
            
            int[] answer = resultValue.stream().mapToInt(x -> x).toArray();

            return answer;
        }

        public void copyArr(int[][] copyBoard, int[][] originBoard){
            for(int i = 0; i < copyBoard.length; i++){
                for(int j = 0; j < copyBoard[i].length; j++){
                    copyBoard[i][j] = originBoard[i][j];
                }
            }
        }

        public int rotate(int[] queries){
            //각 좌표 인덱스
            int minResult = Integer.MAX_VALUE;
            int x1 = queries[0]-1;
            int y1 = queries[1]-1;
            int x2 = queries[2]-1;
            int y2 = queries[3]-1;

            //top
            for(int i = y1; i < y2; i++){
                minResult = Math.min(minResult, copyBoard[x1][i]);
                originBoard[x1][i+1] = copyBoard[x1][i];
            }

            //right
            for(int i = x1; i < x2; i++){
                minResult = Math.min(minResult, copyBoard[i][y2]);
                originBoard[i+1][y2] = copyBoard[i][y2];
            }

            //bottom
            for(int i = y2; i > y1; i--){
                minResult = Math.min(minResult, copyBoard[x2][i]);
                originBoard[x2][i-1] = copyBoard[x2][i];
            }

            //left
            for(int i = x2; i > x1; i--){
                minResult = Math.min(minResult, copyBoard[i][y1]);
                originBoard[i-1][y1] = copyBoard[i][y1];
            }
            return minResult;
        }

        public void printArr(int[][] arr){
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j]+ " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
