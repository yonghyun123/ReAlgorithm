package Zoom;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 ["0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"]	["0001", "0002"]
["1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"]	["1101", "1102", "1901", "1902", "1903"]
["1901 10 50", "1909 10 50"]	["None"]
 */
public class Ex02 {
    
    
    class Solution{
        
        List<Map<String,String>> allMapList = new ArrayList<>();
        List<String> numOfApplicant = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        
        public String[] solution(String[] logs) {
            for(int i = 0; i < logs.length; i++){
                String tempStr = logs[i];
                String[] seperateStr = tempStr.split(" ");
                if(numOfApplicant.isEmpty()){
                    Map<String,String> gradeMap = new HashMap<>(); //문제 번호와 점수를 담는 Map
                    String numOfEx = seperateStr[1];
                    String numofGrade = seperateStr[2];
                    gradeMap.put(numOfEx, numofGrade);
                    numOfApplicant.add(seperateStr[0]);// 지원자 담는 리스트
                    allMapList.add(gradeMap);
                } else {
                    //현재 지원자리스트에 담겨있던 지원자라면  Map객체를 꺼내 data put
                    if(numOfApplicant.contains(seperateStr[0])){
                        String numOfEx = seperateStr[1];
                        String numofGrade = seperateStr[2];
                        int idx = numOfApplicant.indexOf(seperateStr[0]);
                        Map<String,String> tempMap = allMapList.get(idx);
                        tempMap.put(numOfEx, numofGrade);
                    } else {
                        Map<String,String> gradeMap = new HashMap<>(); //문제 번호와 점수를 담는 Map
                        String numOfEx = seperateStr[1];
                        String numofGrade = seperateStr[2];
                        gradeMap.put(numOfEx, numofGrade);
                        numOfApplicant.add(seperateStr[0]);// 지원자 담는 리스트
                        allMapList.add(gradeMap);
                    }
                }
            }

            for(int i = 0; i < allMapList.size(); i++){
                for(int j = 0; j < allMapList.size(); j++){
                    boolean breakFlag = false;
                    Map<String,String> mapFirst = allMapList.get(i);
                    Map<String,String> mapSecond = allMapList.get(j);

                    if(i == j) continue;

                    for(Entry<String,String> entrySet : mapFirst.entrySet()){
                        if(!entrySet.getValue().equals(mapSecond.get(entrySet.getKey()))){
                            breakFlag = true;
                            break;
                        }
                    }
                    if(breakFlag) continue;
                    if(resultList.contains(numOfApplicant.get(i))) continue;
                    resultList.add(numOfApplicant.get(i));

                }
            }

            Collections.sort(resultList);
            String[] answer = new String[resultList.size()];
            for(int i = 0; i < resultList.size(); i++){
                answer[i] = resultList.get(i);
            }

            return answer;
        }
    }
}
