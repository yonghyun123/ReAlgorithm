package kakaobank;

import java.util.Arrays;
import java.util.List;

/**
 * ["A", "B", "C"]	["B", "C", "A"]	4
["A", "B", "C"]	["D", "E", "C"]	2
["A", “B”, "C", "D"]	["B", "Z", "D", "C"]	5
 */
public class Ex02 {
    public static void main(String[] args) {
        Ex02.Solution solution = new Ex02().new Solution();

        String[] before = {"A", "B", "C", "D"};
        String[] after = {"B", "Z", "D", "C"};
        System.out.println(solution.solution(before, after)); 
        //A B C D
        //A Z C D
        //B Z C D
        //B Z temp D
        //A B C D
        //A B C D
    }   
    
    class Solution{
        public int result = 0;
        public int solution(String[] before, String[] after) {
            List<String> beforeList = Arrays.asList(before);
            List<String> afterList  = Arrays.asList(after);

            while(!isEquals(beforeList, afterList)){
                
                compareAndSetList(beforeList, afterList);
                tempSetList(beforeList, afterList);
            }

            

            return result;
        }

        public void tempSetList(List<String> beforeList, List<String> afterList){
                //이제 after에 다른문자가 모두 존재하는 before에 존재하는 경우 temp사용
                for(int i = 0; i < beforeList.size(); i++){
                    //같은 열에 있는 문자가 다르다면 해당 after문자가 다른위치에 있는지 판단
                    if(!beforeList.get(i).equals(afterList.get(i))){ 
                        beforeList.set(i, "temp");
                        result +=1 ;
                        break;
                    }
                }
        }

        public void compareAndSetList(List<String> beforeList, List<String> afterList){
            for(int i = 0; i < beforeList.size(); i++){
                //같은 열에 있는 문자가 다르다면 해당 after문자가 다른위치에 있는지 판단
                if(!beforeList.get(i).equals(afterList.get(i))){
                    //before 다른위치에 없다면 
                    if(!beforeList.contains(afterList.get(i))){
                        //바로 스왑 후 다시 index를 i부터
                        beforeList.set(i, afterList.get(i));
                        result += 1;
                        i = -1;
                    }
                }
            }
        }



        public void showList(List<String> beforeList){
            beforeList.stream().forEach(v -> System.out.print(v + ", "));
            System.out.println();
        }

        public boolean isEquals(List<String> beforeList, List<String> afterList){
            for(int i = 0; i < beforeList.size(); i++){
                if(!beforeList.get(i).equals(afterList.get(i))) return false;
            }
            return true;
        }
    }
}
