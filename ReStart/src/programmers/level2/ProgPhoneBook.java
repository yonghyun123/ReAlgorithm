package programmers.level2;

import java.util.Arrays;


public class ProgPhoneBook {
    public static void main(String[] args) {
        ProgPhoneBook.Solution solution = new ProgPhoneBook().new Solution();
        String[] phoneBook = {"111", "222", "111333"};
       System.out.println(solution.solution(phoneBook));  
    }

    class Solution {
        public boolean solution(String[] phoneBook) {
            boolean answer = true;

            // Arrays.sort(phoneBook, (o1, o2) ->  o1.length()-o2.length());
            Arrays.sort(phoneBook);
            Arrays.stream(phoneBook).forEach(v -> System.out.print(v + " "));
            for(int i = 0; i < phoneBook.length-1; i++){
                if (phoneBook[i + 1].startsWith(phoneBook[i])) return false; // 3. 여기까지 오면 접두어가 없다는 것이다. 
            }
            
            return answer;
        }
    }
}
