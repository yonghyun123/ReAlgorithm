package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 프렌즈대학교 컴퓨터공학과 조교인 제이지는 네오 학과장님의 지시로, 학생들의 인적사항을 정리하는 업무를 담당하게 되었다.

그의 학부 시절 프로그래밍 경험을 되살려, 모든 인적사항을 데이터베이스에 넣기로 하였고, 
이를 위해 정리를 하던 중에 후보키(Candidate Key)에 대한 고민이 필요하게 되었다.

후보키에 대한 내용이 잘 기억나지 않던 제이지는, 정확한 내용을 파악하기 위해 데이터베이스 
관련 서적을 확인하여 아래와 같은 내용을 확인하였다.

관계 데이터베이스에서 릴레이션(Relation)의 튜플(Tuple)을 유일하게 식별할 수 있는 속성(Attribute) 
또는 속성의 집합 중, 다음 두 성질을 만족하는 것을 후보 키(Candidate Key)라고 한다.
유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.
 즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다.
제이지를 위해, 아래와 같은 학생들의 인적사항이 주어졌을 때, 후보 키의 최대 개수를 구하라.
relation은 2차원 문자열 배열이다.
relation의 컬럼(column)의 길이는 1 이상 8 이하이며, 각각의 컬럼은 릴레이션의 속성을 나타낸다.
relation의 로우(row)의 길이는 1 이상 20 이하이며, 각각의 로우는 릴레이션의 튜플을 나타낸다.
relation의 모든 문자열의 길이는 1 이상 8 이하이며, 알파벳 소문자와 숫자로만 이루어져 있다.
relation의 모든 튜플은 유일하게 식별 가능하다.(즉, 중복되는 튜플은 없다.)
입출력 예
relation	result
[["100","ryan","music","2"],
["200","apeach","math","2"],
["300","tube","computer","3"],
["400","con","computer","4"],
["500","muzi","music","3"],
["600","apeach","music","2"]]	

2
 */

public class ProgCandidateKey {
    public static void main(String[] args) {
        ProgCandidateKey.Solution solution = new ProgCandidateKey().new Solution();
        String[][] relation = {
            {"100","ryan","music","2"},
            {"200","apeach","math","2"},
            {"300","tube","computer","3"},
            {"400","con","computer","4"},
            {"500","muzi","music","3"},
            {"600","apeach","music","2"},
        };
        
        System.out.println(solution.solution(relation));
    }
    class Solution {
        private final List<HashSet<Integer>> condidateSet = new ArrayList<>();
        public int solution(String[][] relation) {
            int answer = 0;
            HashSet<Integer> set = new HashSet<>();

            for(int i = 0; i < relation[0].length; i++){
                combination(0, 0, i+1, set, relation);
            }
            
            
            //  System.out.println(condidateSet);
            return condidateSet.size();
        }

        public void combination(int idx, int depth, int size, HashSet<Integer> newKey, String[][] relation){
            if(depth == size){
                // newKey.stream().forEach(v -> System.out.print(v + " "));
                // System.out.println();
                if(!isKey(newKey, relation)) return;
                    
                for(HashSet<Integer> item : condidateSet){
                    if(newKey.containsAll(item)) return;   
                }      
                
                condidateSet.add(newKey);
                // System.out.println("condidateSet="+condidateSet);
                
                return;
            }

            for(int i = idx; i < relation[0].length; i++){
                HashSet<Integer> keySet = new HashSet<>(newKey);
                keySet.add(i);
                combination(i+1, depth+1, size, keySet, relation);
            }
        }

        public boolean isKey(HashSet<Integer> inputKey, String[][] relation){
            List<String> dicisionList = new ArrayList<>();
            // System.out.println("inputkey"+inputKey);
            for(int i = 0; i < relation.length; i++){
                String data = "";
                for(Integer key : inputKey){
                    data += relation[i][key];
                }
                // System.out.println(dicisionList);
                if(dicisionList.contains(data)) return false;
                else dicisionList.add(data);
            }
            return true;
        }
    }
}
