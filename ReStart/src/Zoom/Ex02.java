package Zoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 ["0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"]	["0001", "0002"]
["1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"]	["1101", "1102", "1901", "1902", "1903"]
["1901 10 50", "1909 10 50"]	["None"]
 */
public class Ex02 {
    
    
    class Solution{
    
            
        // Id 별 푼 점수
        public Map<String, List<String>> pMap = new HashMap<String, List<String>>();
        // Id 별 푼 문제
        public Map<String, List<Integer>> sMap = new HashMap<String, List<Integer>>();
        public List<String> answerV = new ArrayList<>();
        public List<String> ids = new ArrayList<>();

        public String[] solution(String[] logs) {
            String[] answer = {};
            // aLogs = {{id, 문제번호, 점수},}
            String[][] aLogs = new String[logs.length][3];
            for (int i = 0; i < logs.length; i++) {
                String[] tmp = logs[i].split(" ");
                for (int j = 0; j < 3; j++) {
                    aLogs[i][j] = tmp[j];
                }
            }
    
            
            for (int i = 0; i < aLogs.length; i++) {
                String id = aLogs[i][0];// id
                if (ids.indexOf(id) == -1) {
                    ids.add(id);
                }
            }
            
    
            for (int i = 0; i < ids.size(); i++) {
                String id = ids.get(i);
                //list에 담을 id 별 푼 문제와 점수
                List<String> pv = new ArrayList<String>();
                List<Integer> sv = new ArrayList<Integer>();
    
                for (int j = 0; j < aLogs.length; j++) {
                    if (aLogs[j][0].equals(id)) {
                        // 푼 문제 중복 제거
                        int idx = pv.indexOf(aLogs[j][1]);
                        int score = Integer.parseInt(aLogs[j][2]);
                        // 중복일때
                        if (idx != -1) {
                            // 추가되는 같은 문제의 점수가 더 크면
                            if (sv.get(idx) < score) {
                                // 추가하지않고 점수만 바꿈
                                sv.set(idx, score);
                            }
                            //아닐경우 그냥 추가    
                        } else {
                            pv.add(aLogs[j][1]);
                            sv.add(Integer.parseInt(aLogs[j][2]));
                        }
                    }
                }
                //id별로 넣기
                pMap.put(id, pv);
                sMap.put(id, sv);
            }
            // AB비교
            
            for (int i = 0; i < ids.size(); i++) {
                String id = ids.get(i);
                //A 푼문제 정렬
                Object[] pa = pMap.get(id).toArray();
                Arrays.sort(pa);
                //A 푼 문제 점수 정렬
                Object[] sa = sMap.get(id).toArray();
                Arrays.sort(sa);
                int pSize = pa.length;
                //B와 비교
                for (int j = i + 1; j < ids.size(); j++) {
                    // B id
                    String tid = ids.get(j);
                    // B 푼 문제
                    Object[] tpa = pMap.get(tid).toArray();
                    // B 푼 점수
                    Object[] tsa = sMap.get(tid).toArray();
                    // 정렬
                    Arrays.sort(tpa);
                    Arrays.sort(tsa);
                    int tpSize = tpa.length;
                    if ((pSize == tpSize) && pSize >= 5) {
                        int flag = 0; // 완전히 같으면 0
                        for (int k = 0; k < pSize; k++) {
                            if (!(pa[k].equals(tpa[k]) && sa[k].equals(tsa[k]))) {
                                flag = 1;
                                break;
                            }
                        }
                        //푼 수/ 문제/ 점수 완전히 같으면 
                        //중복되지않게 부정자 모두 담음
                        if (flag == 0) {
                            if (answerV.indexOf(id) == -1) {
                                answerV.add(id);
                            }
                            if (answerV.indexOf(tid) == -1) {
                                answerV.add(tid);
                            }
                        }
                    }
                }
            }
            //부정자 아무도 없으면 None 담아서 제출
            if (answerV.size() == 0) {
                answer = new String[1];
                answer[0] = "None";
            } else {
                //있으면 오름차순 정렬해서 제출
                answer = new String[answerV.size()];
                for (int i = 0; i < answerV.size(); i++) {
                    answer[i] = answerV.get(i);
                }
                Arrays.sort(answer);
            }
            return answer;
        }
    }
}
