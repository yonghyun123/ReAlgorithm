package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class ProgStringCompress {
    public static void main(String[] args) {
        ProgStringCompress.Solution solution = new ProgStringCompress().new Solution();
        String s= "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        System.out.println(solution.solution(s));
        
    }

    class Solution {
        List<String> stringList = new ArrayList<>();

        public int solution(String s) {
            int answer = s.length();

            for(int sliceIdx = 1; sliceIdx <= (s.length() / 2); sliceIdx++){
                answer = Math.min(resultLength(sliceIdx, s), answer);
            }
            
            return answer;
        }

        public int resultLength(int sliceCnt, String s){
            
            String resultSliceStr = "";
            String beforeStr = "";
            int cnt = 1;
            for(int i = 0; i <= s.length()+sliceCnt; i = i+sliceCnt){ 
                String sliceStr = "";
                //마지막 문자열
                if(i >= s.length()){
                    sliceStr = "";
                } else if(s.length() < i +sliceCnt){
                    sliceStr = s.substring(i);
                } else  {
                    sliceStr = s.substring(i, i+sliceCnt);
                }
                
                System.out.println(sliceStr);
    

                if(sliceStr.equals(beforeStr)){
                    cnt += 1;
                } else if(cnt >= 2){
                    resultSliceStr += cnt+beforeStr;
                    cnt = 1;
                }else{
                    resultSliceStr += beforeStr;
                }
                
                beforeStr = sliceStr;
            }
           
            System.out.println(resultSliceStr);
            return resultSliceStr.trim().length();
        }
    }
}
