package programmers.level2;
import java.util.HashMap;
import java.util.Map;

/**
 * 가을을 맞아 카카오프렌즈는 단체로 소풍을 떠났다. 즐거운 시간을 보내고 마지막에 단체사진을 찍기 위해 카메라 앞에 일렬로 나란히 섰다.
 *  그런데 각자가 원하는 배치가 모두 달라 어떤 순서로 설지 정하는데 시간이 오래 걸렸다. 네오는 프로도와 나란히 서기를 원했고, 
 * 튜브가 뿜은 불을 맞은 적이 있던 라이언은 튜브에게서 적어도 세 칸 이상 떨어져서 서기를 원했다. 
 * 사진을 찍고 나서 돌아오는 길에, 무지는 모두가 원하는 조건을 만족하면서도 다르게 서는 방법이 있지 않았을까 생각해보게 되었다.
 *  각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수를 계산하는 프로그램을 작성해보자.

입력 형식
입력은 조건의 개수를 나타내는 정수 n과 n개의 원소로 구성된 문자열 배열 data로 주어진다. 
data의 원소는 각 프렌즈가 원하는 조건이 N~F=0과 같은 형태의 문자열로 구성되어 있다. 제한조건은 아래와 같다.

1 <= n <= 100
data의 원소는 다섯 글자로 구성된 문자열이다. 각 원소의 조건은 다음과 같다.
첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다. {A, C, F, J, M, N, R, T} 
각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브를 의미한다. 첫 번째 글자는 조건을 제시한 프렌즈,
세 번째 글자는 상대방이다. 첫 번째 글자와 세 번째 글자는 항상 다르다.
두 번째 글자는 항상 ~이다.
네 번째 글자는 다음 3개 중 하나이다. {=, <, >} 각각 같음, 미만, 초과를 의미한다.
다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
출력 형식
모든 조건을 만족하는 경우의 수를 리턴한다.

예제 입출력
n	data	answer
2	["N~F=0", "R~T>2"]	3648
2	["M~C<2", "C~M>1"]	0
 */

public class ProgPhoto {
    public static void main(String[] args) {
        ProgPhoto.Solution solution = new ProgPhoto().new Solution();
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        
        solution.solution(n, data);



    }
    class Solution {
        public int[] board;
        public boolean[] visited;
        public Map<String, Integer> kakaoMap;
        public int cnt = 0;
        public int solution(int n, String[] data) {
            int answer = 0;
            board = new int[8];
            visited = new boolean[8];
            //A, C, F, J, M, N, R, T 각 캐릭터가 key인 Map 자료구조 필요
            //A=1, C=2, F=3, J=4, M=5, N=6, R=7, T=8 
            kakaoMap = new HashMap<>();
            kakaoMap.put("A", 0);
            kakaoMap.put("C", 1);
            kakaoMap.put("F", 2);
            kakaoMap.put("J", 3);
            kakaoMap.put("M", 4);
            kakaoMap.put("N", 5);
            kakaoMap.put("R", 6);
            kakaoMap.put("T", 7);
        
            permutation(0,data);
            
            return cnt;
        }

        public void permutation(int depth, String[] data){
            if(depth == 8){
                //순열이 완료되었으면 경우의 수 판단

                if(isRightLine(data)){
                    cnt+=1;
                }
                return;
            }

            for(int i = 0; i < 8; i++){
                if(!visited[i]){
                    visited[i] = true;
                    board[depth] = i ;
                    permutation(depth+1,data);
                    visited[i] = false;
                }
            }

        }

        public boolean isRightLine(String[] data){
            // = 일땐, 거리 -1, 아니면 그대로 계산
            for(String stmt : data){
                String firstKakao = Character.toString(stmt.charAt(0));
                String secondKakao = Character.toString(stmt.charAt(2));
                String op = Character.toString(stmt.charAt(3));
                int distance = Integer.parseInt(Character.toString(stmt.charAt(4)));
                

                int firstValue  = kakaoMap.get(firstKakao ); 
                int secondValue = kakaoMap.get(secondKakao); 

                
                if("=".equals(op)){
                    if(Math.abs(board[firstValue]-board[secondValue]) - 1 != distance) return false;
                } else if(">".equals(op)){
                    if(Math.abs(board[firstValue]-board[secondValue]) - 1 <= distance) return false;
                } else{
                    if(Math.abs(board[firstValue]-board[secondValue]) - 1 >= distance) return false;
                }
                
            }


            return true;
        }
    }
}
