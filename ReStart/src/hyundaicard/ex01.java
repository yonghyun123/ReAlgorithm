package hyundaicard;

public class ex01 {
    
    class Solution{
        public int solution(String[] color, int[] prices){
            int answer = 0;
            for(int i = 0; i < color.length; i++){
                for(int j = i+1; j < color.length; j++){
                    if(color[i].charAt(0) == color[j].charAt(1)){
                        if(color[j].charAt(0) == color[j].charAt(1)) continue;
                        char tempChar = color[i].charAt(1);
                        color[i] = color[i].replace(color[i].charAt(1), color[j].charAt(1));
                        color[j] = color[j].replace(color[j].charAt(1), tempChar);
                    }
                }
            }

            for(int i = 0; i < color.length; i++){
                if(color[i].charAt(0) == color[i].charAt(1)){
                    answer += prices[0];
                } else {
                    answer += prices[1];
                }
            }

            answer = Math.min(answer, prices[0] * 5);
            return answer;
        }
    }
}

