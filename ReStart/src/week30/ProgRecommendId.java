package week30;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import java.util.stream.Collectors;

/**
 * 다음은 카카오 아이디의 규칙입니다.

아이디의 길이는 3자 이상 15자 이하여야 합니다.
아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
"네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 
카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
신규 유저가 입력한 아이디가 new_id 라고 한다면,

1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

new_id는 길이 1 이상 1,000 이하인 문자열입니다.
new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.

예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
예2	"z-+.^."	"z--"
예3	"=.="	"aaa"
예4	"123_.def"	"123_.def"
예5	"abcdefghijklmn.p"	"abcdefghijklmn"

 */

public class ProgRecommendId {
    public static void main(String[] args) {
        ProgRecommendId.Solution solution = new ProgRecommendId().new Solution();
        System.out.println(solution.solution("abcdefghijklmn.p"));
    }

    public class Solution{

        String regExprAlphabet =  "^[a-z]*$";
        String regExprNumber = "^[0-9]*$";

        public String solution(String new_id) {
            String answer = "";
            answer = step1(new_id);
            answer = step2(answer);
            answer = step3(answer);
            answer = step4(answer);
            answer = step5(answer);
            answer = step6(answer);
            answer = step7(answer);
    
            return answer;
        }
    
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        public String step1(String newId){
            return newId.toLowerCase();
        }

        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        public String step2(String newId){
            List<String> tempId = new ArrayList<>();

            for(int i = 0; i < newId.length(); i++){
                tempId.add(String.valueOf(newId.charAt(i)));
            }

            for(int i = tempId.size()-1; i >=0; i--){
                if(!tempId.isEmpty()){
                    if(Pattern.matches(regExprAlphabet, tempId.get(i))) continue;
                    if(Pattern.matches(regExprNumber,   tempId.get(i))) continue;
                    if("-".equals(tempId.get(i))) continue;
                    if("_".equals(tempId.get(i))) continue;
                    if(".".equals(tempId.get(i))) continue;
                    tempId.remove(tempId.get(i));
                }
            }
            //java 8 문법 적용
            String step2Id = tempId.stream().map(item -> String.valueOf(item)).collect(Collectors.joining());
            return step2Id;
        }

        public String step3(String newId){
            List<String> tempId = new ArrayList<>();

            for(int i = 0; i < newId.length(); i++){
                tempId.add(String.valueOf(newId.charAt(i)));
            }

            
            for(int i = tempId.size()-1; i >0; i--){
                if(!tempId.isEmpty()){
                    if(".".equals(tempId.get(i)) && ".".equals(tempId.get(i-1))){
                        tempId.remove(i);
                    }
                }
            }
            String step3Id = tempId.stream().map(item -> String.valueOf(item)).collect(Collectors.joining());

            return step3Id;
        }

        public String step4(String newId){
            List<String> tempId = new ArrayList<>();
            String step4Id = "";
            for(int i = 0; i < newId.length(); i++){
                tempId.add(String.valueOf(newId.charAt(i)));
            }
            if(!tempId.isEmpty()){
                if(".".equals(tempId.get(0))){
                    tempId.remove(0);
                } 
            }

            if(!tempId.isEmpty()){
                if(".".equals(tempId.get(tempId.size()-1))){
                    tempId.remove(tempId.size()-1);
                }   
            }
            step4Id = tempId.stream().map(item -> String.valueOf(item)).collect(Collectors.joining());
        
            return step4Id;
        }

        public String step5(String newId){
            if("".equals(newId)){
                newId += "a";
            }
            return newId;
        }

        public String step6(String newId){
            if(newId.length() >= 16){
                newId = newId.substring(0, 15);
                if(".".equals(String.valueOf(newId.charAt(14)))){
                    newId = newId.substring(0, 14);
                    
                }
            }

            return newId;
        }

        public String step7(String newId){
            if(newId.length() <= 2){
                while(newId.length() < 3){
                    char tempChar = newId.charAt(newId.length()-1);
                    newId += tempChar;
                }
            }
            return newId;
        }
    }
}
