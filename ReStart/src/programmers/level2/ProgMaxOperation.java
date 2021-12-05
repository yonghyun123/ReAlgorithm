package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
IT 벤처 회사를 운영하고 있는 라이언은 매년 사내 해커톤 대회를 개최하여 우승자에게 상금을 지급하고 있습니다.
이번 대회에서는 우승자에게 지급되는 상금을 이전 대회와는 다르게 다음과 같은 방식으로 결정하려고 합니다.
해커톤 대회에 참가하는 모든 참가자들에게는 숫자들과 3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며,
 참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없어야 합니다. 즉, + > - > * 또는 - > * > + 등과
 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,-처럼 2개 이상의 연산자가 동일한 순위를 가지도록
  연산자 우선순위를 정의할 수는 없습니다. 수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며,
   연산자가 3개라면 3! = 6가지 조합이 가능합니다.
만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며, 
우승자가 제출한 숫자를 우승상금으로 지급하게 됩니다.

예를 들어, 참가자 중 네오가 아래와 같은 수식을 전달받았다고 가정합니다.

"100-200*300-500+20"

일반적으로 수학 및 전산학에서 약속된 연산자 우선순위에 따르면 더하기와 빼기는 서로 동등하며 곱하기는 더하기, 
빼기에 비해 우선순위가 높아 * > +,- 로 우선순위가 정의되어 있습니다.
대회 규칙에 따라 + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,- 처럼 
2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
수식에 연산자가 3개 주어졌으므로 가능한 연산자 우선순위 조합은 3! = 6가지이며, 그 중 + > - > * 로 연산자 우선순위를 정한다면 결괏값은 22,000원이 됩니다.
반면에 * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420 이지만, 
규칙에 따라 우승 시 상금은 절댓값인 60,420원이 됩니다.

참가자에게 주어진 연산 수식이 담긴 문자열 expression이 매개변수로 주어질 때, 
우승 시 받을 수 있는 가장 큰 상금 금액을 return 하도록 solution 함수를 완성해주세요.

"100-200*300-500+20"	60420
"50*6-3*2"	300

 */
public class ProgMaxOperation {
    public static void main(String[] args) {
        ProgMaxOperation.Solution solution = new ProgMaxOperation().new Solution();
        solution.solution("50*6-3*2");
        
    }

    class Solution {
        //permutation 구현
        private final Character[] opList = {'*','+','-'};
        private final static int OP_COUNT = 3;
        private final static long min = Long.MIN_VALUE;
        private final List<Long> numList = new ArrayList<>();
        private final List<Character> inputOpList = new ArrayList<>();
        private final Character[] newOpList = new Character[OP_COUNT];
        private final boolean[] visited = new boolean[OP_COUNT];
        private long result = 0;

        public long solution(String expression) {
            long answer = 0;
            result = min;

            String numStr = "";
            for(int i = 0; i < expression.length(); i++){
                
                if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                    numStr += expression.charAt(i);
                }else{
                    inputOpList.add(expression.charAt(i));
                    numList.add(Long.parseLong(numStr));
                    numStr = "";
                }
            }
            numList.add(Long.parseLong(numStr));

            permutation(0);
            System.out.println(result);
            return answer;
        }

        public void permutation(int depth){
            if(depth == OP_COUNT){
                // Arrays.stream(newOpList).forEach(v -> System.out.print(v + " "));
                result = Math.max(calculate(newOpList), result);
                // 계산로직 
                return;
            }

            for(int i = 0; i < opList.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    newOpList[depth] = opList[i];
                    permutation(depth+1);
                    visited[i] = false;
                }
            }
        }

        public long calculate(Character[] newOpList){
            List<Long> tempNumList = new ArrayList<>(numList);
            List<Character> tempInputOpList = new ArrayList<>(inputOpList);


            for(int i = 0; i < newOpList.length; i++){
                for(int j = 0; j < tempInputOpList.size(); j++){
                    if(newOpList[i] == tempInputOpList.get(j)){
                        long nextNum = 0;
                        switch(newOpList[i]){
                            case '+':
                            nextNum = tempNumList.get(j) + tempNumList.get(j+1);
                            break;
                            case '-':
                            nextNum = tempNumList.get(j) - tempNumList.get(j+1);
                            break;
                            case '*':
                            nextNum = tempNumList.get(j) * tempNumList.get(j+1);
                            break;
                        }


                        tempNumList.remove(j+1);
                        tempNumList.set(j, nextNum);
                        tempInputOpList.remove(j);
                        j -= 1;


                    }
                    
                }
            }
            
            return Math.abs(tempNumList.get(0));
        }
    }
}


