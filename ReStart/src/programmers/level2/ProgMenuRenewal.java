package programmers.level2;

// import java.util.ArrayList;
// import java.util.Arrays;

// import java.util.Collections;
// 
// import java.util.HashMap;
// import java.util.Map;
import java.util.*;


public class ProgMenuRenewal {
    public static void main(String[] args) {
        ProgMenuRenewal.Solution solution = new ProgMenuRenewal().new Solution();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        String[] result = solution.solution(orders, course);
        
        Arrays.stream(result).forEach(v -> System.out.println(v));
    }

    class Solution {
        public boolean[] visited;
        public ArrayList<String> orderList, resultList, afterSortList;
        public Map<String, Integer> resultMap;

        public String[] solution(String[] orders, int[] course) {
            
            
            orderList = new ArrayList<>();
            resultList = new ArrayList<>();
            afterSortList = new ArrayList<>();
            resultMap = new HashMap<String, Integer>();

            for(int i = 0; i < orders.length; i++){
                for(int j = 0; j < course.length; j++){
                    if(orders[i].length() < course[j]) continue;
                    visited = new boolean[orders[i].length()];
                    combination(orders, orders[i], 0, orders[i].length(), course[j],0);
                }
            }

            
            
            for(int i = 0; i < course.length; i++){
                int max = Integer.MIN_VALUE;
                for(Map.Entry<String,Integer> item : resultMap.entrySet()){
                    if(item.getKey().length() == course[i]){
                        max = Math.max(max, item.getValue());
                    }
                }

                for(Map.Entry<String, Integer> item : resultMap.entrySet()){
                    if(item.getKey().length() == course[i] && item.getValue() == max){
                        resultList.add(item.getKey());
                    }
                }
            }


            for(String item : resultList){
                char[] tempChar = item.toCharArray();
                Arrays.sort(tempChar);
                String tempStr = new String(tempChar, 0, tempChar.length);
                if(!afterSortList.contains(tempStr)){
                    afterSortList.add(tempStr);
                }
            }

            Collections.sort(afterSortList);
            
            
            
            // System.out.println(afterSortList);
            String[] answer = afterSortList.toArray(new String[afterSortList.size()]);

            return answer;
        }

        public void combination(String[] orders, String order, int start, int n, int r, int depth){
            if(depth == r){
                makeMapOrders(orders);
                return;
            }

            for(int i = start; i < n; i++){
                if(!visited[i]){
                    orderList.add(order.charAt(i) + "");
                    visited[i] = true;
                    combination(orders, order, i+1, n, r, depth+1);
                    visited[i] = false;
                    orderList.remove(order.charAt(i)+ "");
                }
            }
        }

        public void makeMapOrders(String[] orders){
            int sameCnt = 0;
            String key = "";
            for(String item :  orderList){
                key += item;
            }

            if(resultMap.containsKey(key)) return;

            for(int i = 0; i < orders.length; i++){
                if(orders[i].length() < key.length()) continue;
                boolean breakFlag = false;
                for(int j = 0; j < key.length(); j++){
                    if(!orders[i].contains(key.charAt(j)+"")){
                        breakFlag = true;
                        break;
                    }
                }
                if(!breakFlag) sameCnt += 1;
            }
            if(sameCnt < 2) return;

            resultMap.put(key,sameCnt);
        }
    }
}
