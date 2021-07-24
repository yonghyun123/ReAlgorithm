package week31;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 크레인 인형 뽑기
 * 
 * 게임개발자인 "죠르디"는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
"죠르디"는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.

게임 화면은 "1 x 1" 크기의 칸들로 이루어진 "N x N" 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
 (위 그림은 "5 x 5" 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
  모든 인형은 "1 x 1" 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다. 
  게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 
  집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터
 인형이 순서대로 쌓이게 됩니다. 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.

 [제한사항]
board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하입니다.
board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
0은 빈 칸을 나타냅니다.
1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
moves 배열의 크기는 1 이상 1,000 이하입니다.
moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

 */
public class ProgCrane {
    public static void main(String[] args) {
        ProgCrane.Solution solution = new ProgCrane().new Solution();
        int[][] board = {
            {0,0,0,0,0},
            {0,0,1,0,3},
            {0,2,5,0,1},
            {4,2,4,4,2},
            {3,5,1,3,1}
        };
        int[] moves =  {1,5,3,5,1,2,1,4};
        
        System.out.println(solution.solution(board, moves)); 
    }

    class Solution{
        private List<Integer> resultList = new ArrayList<>();
        private int result = 0;
        
        public int solution(int[][] board, int[] moves){
            for(int i = 0; i < moves.length; i++){
                int selectedLine = moves[i]-1;

                for(int j = 0; j < board.length; j++){
                    if(board[j][selectedLine] != 0 ){
                        resultList.add(board[j][selectedLine]);
                        board[j][selectedLine] = 0;
                        break;
                    }
                }

                checkDupNumber();
            }
            return result;
        }

        public void checkDupNumber(){
            if(resultList.size() >= 2){
                int lastIdx = resultList.size()-1;
                int otherLastIdx = resultList.size()-2;
                if(resultList.get(lastIdx).equals(resultList.get(otherLastIdx))){
                    resultList.remove(resultList.size()-1);
                    resultList.remove(resultList.size()-1);
                    result += 2;
                }
            }
        }
    }
}
