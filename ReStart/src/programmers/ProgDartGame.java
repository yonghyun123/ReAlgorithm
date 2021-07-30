package programmers;

import java.util.LinkedList;
import java.util.regex.*;

/**
 * 카카오 다트게임
 * 
 * 카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 
 * 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

다트 게임은 총 3번의 기회로 구성된다.
각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

예제	dartResult	answer	설명
1	1S2D*3T	       37	11 * 2 + 22 * 2 + 33
2	1D2S#10S	   9	12 + 21 * (-1) + 101
3	1D2S0T         3	12 + 21 + 03
4	1S*2T*3S	   23	11 * 2 * 2 + 23 * 2 + 31
5	1D#2S*3S	   5	12 * (-1) * 2 + 21 * 2 + 31
6	1T2D3D#	      -4	13 + 22 + 32 * (-1)
7	1D2S3T*	      59	12 + 21 * 2 + 33 * 2
 */

public class ProgDartGame {
    public static void main(String[] args) {
        ProgDartGame.Solution solution = new ProgDartGame().new Solution();
        
        System.out.println(solution.solution("1D2S3T*"));
        
    }
    
    class Solution{
        String regExpr = "^[0-9]*$";
        
        public int solution(String dartResult) {
            int answer = 0;
            LinkedList<String> q = new LinkedList<>();
            LinkedList<Integer> resultList = new LinkedList<>();

            for(int i = 0; i < dartResult.length(); i++){
                if(Pattern.matches(regExpr, dartResult.charAt(i)+"")){
                    q.add(dartResult.charAt(i)+"");
                    continue;
                } else {
                    //q에 숫자가 들어가 있다면 모두 꺼낸다 
                    String dartNumberString = "";
                    int dartNumber = 0;
                    if(q.isEmpty()) {
                        dartNumber = resultList.peek();
                    } else{
                        while(!q.isEmpty()){
                            dartNumberString += q.poll();
                        }
                        if(!"".equals(dartNumberString)){
                            dartNumber = Integer.parseInt(dartNumberString);
                        }
                    }

                 
                    //S,D,T 계산
                    if("D".equals(dartResult.substring(i,i+1))){
                        dartNumber = (int)Math.pow(dartNumber,2);
                        resultList.add(dartNumber);
                    } else if("T".equals(dartResult.substring(i,i+1))){
                        dartNumber = (int)Math.pow(dartNumber,3);
                        resultList.add(dartNumber);
                    } else if("*".equals(dartResult.substring(i,i+1))){
                        // 전에 계산된 값을 가져와야함
                        if(resultList.size() == 1){
                            int value = resultList.poll();
                            value *= 2;
                            resultList.add(value);
                        } else{
                            int value = resultList.getLast();
                            resultList.removeLast();
                            value *= 2;
                            int prevValue = resultList.getLast();
                            resultList.removeLast();
                            prevValue *= 2;
                            resultList.add(prevValue);
                            resultList.add(value);
                        }
                        
                    } else if("#".equals(dartResult.substring(i,i+1))){
                        int value = resultList.getLast();
                        resultList.removeLast();
                        value *= -1;
                        resultList.add(value);
                    }else{
                        resultList.add(dartNumber);
                    }
                }
                

            }
            
            for(Integer item: resultList){
                
                answer += item;
            }
    
            return answer;
        }
    }
}
