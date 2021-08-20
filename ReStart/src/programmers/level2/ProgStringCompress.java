package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class ProgStringCompress {
    public static void main(String[] args) {
        ProgStringCompress.Solution solution = new ProgStringCompress().new Solution();
        String s= "aabbaccc";
        System.out.println(solution.solution(s));
        
    }

    class Solution {
        List<String> stringList = new ArrayList<>();

        public int solution(String s) {
            int answer = 1001;

            for(int sliceIdx = 1; sliceIdx <= (s.length() / 2); sliceIdx++){
                answer = Math.min(resultLength(sliceIdx, s), answer);
            }
            
            return answer;
        }

        public int resultLength(int sliceCnt, String s){
            
            String resultSliceStr = "";
            for(int i = 0; i < s.length()-sliceCnt; i = i+sliceCnt){ 
                String sliceStr = s.substring(i, i+sliceCnt);
                if(s.length() < i+sliceCnt+sliceCnt){
                    stringList.add(sliceStr);
                    stringList.add(s.substring(i+sliceCnt, s.length()));
                    continue;
                } 
                String otherStr = s.substring(i+sliceCnt, i+sliceCnt+sliceCnt);
                // System.out.println("1"+sliceStr+", 2"+otherStr);
                if(sliceStr.equals(otherStr)){
                    stringList.add(sliceStr);
                }
                else{
                    if(!stringList.isEmpty()){
                        resultSliceStr += (stringList.size()+1 +""+stringList.get(0));
                        stringList.clear();
                    } else{
                        resultSliceStr += sliceStr;
                    }
                }
            }
            if(!stringList.isEmpty()){
                resultSliceStr += (stringList.size()+1 +""+stringList.get(0));
                stringList.clear();
            }
            System.out.println(resultSliceStr);
            return resultSliceStr.length();
        }
    }
}
