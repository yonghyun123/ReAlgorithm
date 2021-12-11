package programmers.level2;


import java.util.ArrayList;

import java.util.List;
import java.util.regex.Pattern;

public class ProgNewClustering {
    public static void main(String[] args) {
        ProgNewClustering.Solution solution = new ProgNewClustering().new Solution();
        System.out.println(solution.solution("E=M*C^2", "e=m*c^2")); 

     
    }

    class Solution {
        private static final String pattern = "^[a-zA-Z]*$";
        private final List<String> firstList = new ArrayList<>();
        private final List<String> secondList = new ArrayList<>();
        
        private final List<String> intersectionList = new ArrayList<>();
        
        public int solution(String str1, String str2) {
            int answer = 0;

            for(int i = 0; i < str1.length()-1; i++){
                String splitStr = str1.substring(i, i+2).toLowerCase();
                if(Pattern.matches(pattern, splitStr)){
                    firstList.add(splitStr);
                }
            }

            for(int i = 0; i < str2.length()-1; i++){
                String splitStr = str2.substring(i, i+2).toLowerCase();
                if(Pattern.matches(pattern, splitStr)){
                    secondList.add(splitStr);
                }
            }

            //합집합 만들기
            for(String item: firstList){
                //같다면
                if(secondList.contains(item)){
                    intersectionList.add(item);
                    secondList.remove(item);
                }   
            }
            firstList.addAll(secondList);


            if(firstList.size() == 0){
                answer = 65536;
            } else {
                answer = (int)(((double)intersectionList.size() / (double)firstList.size())) * 65536;    
            }
            
            
            return answer;
        }
    }

}
