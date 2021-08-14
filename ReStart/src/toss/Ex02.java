package toss;


import java.util.ArrayList;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        Ex02.Solution solution = new Ex02().new Solution();
        int servers = 2;
        boolean sticky = true;
        int[] requests = {1,2,2,3,4,1};
        System.out.println(solution.solution(servers, sticky, requests));
            
    }

    
    class Solution{
        ArrayList<ArrayList<Integer>> numberList;
        ArrayList<Integer> choiceNextList;
        public int[][] solution(int servers, boolean sticky, int[] requests) {
        
            int[][] answer = {};
            numberList = new ArrayList<>();
            choiceNextList = new ArrayList<>();

            answer = new int[servers][];
            if(sticky){
                for(int i = 0; i < requests.length; i++){
                    boolean breakFlag = false;
                    if(numberList.isEmpty()){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(requests[i]);
                        numberList.add(list);
                    }
                    else{
                        for(int j = 0; j <numberList.size(); j++){
                            if(numberList.get(j).contains(requests[i])){
                                numberList.get(j).add(requests[i]);
                                breakFlag = true;
                                choiceNextList.add(j);
                                break;
                            } 
                        }
                        if(breakFlag) continue;
                        if(numberList.size() < servers){
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(requests[i]);
                            numberList.add(list);
                        }
                        else{
                            if(!choiceNextList.isEmpty()){
                                int nextIdx = choiceNextList.get(choiceNextList.size()-1);
                                List<Integer> list = numberList.get((nextIdx+1)%servers);
                                list.add(requests[i]);
                                choiceNextList.add(nextIdx+1);
                            } else {
                                List<Integer> list = numberList.get(i%servers);
                                list.add(requests[i]);
                            }
                            
                            
                        }
                    }
                }
            } else {
                for(int i = 0; i < requests.length; i++){
                    
                    if(numberList.isEmpty()){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(requests[i]);
                        numberList.add(list);
                    }
                    else{
                        if(numberList.size() < servers){
                            ArrayList<Integer> list = new ArrayList<>();
                            list = new ArrayList<>();
                            list.add(requests[i]);
                            numberList.add(list);
                        }
                        else{
                            ArrayList<Integer> list = numberList.get(i%servers);
                            list.add(requests[i]);
                        }
                    }   
                }
            }
            System.out.println(numberList);     
            // System.out.println(numberList.get(1));
            answer = new int[numberList.size()][];
            for(int i = 0; i < numberList.size(); i++){
                answer[i] = new int[numberList.get(i).size()];
                for(int j = 0; j < numberList.get(i).size(); j++){
                    answer[i][j] = numberList.get(i).get(j);
                }
            }
            
            return answer;
        }
    }
}
