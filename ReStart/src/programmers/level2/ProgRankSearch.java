package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ProgRankSearch {

    public static void main(String[] args) {
        ProgRankSearch.Solution solution = new ProgRankSearch().new Solution();
        String[] info = {
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        };

        String[] query = {
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        };
        solution.solution(info, query);
    }

    class Solution {
        public int[] solution(String[] info, String[] query) {
            int[] answer = {};
            List<RankInfo> inputRank = new ArrayList<>();
            List<RankInfo> resultRank = new ArrayList<>();

              //초기 데터 셋팅완료
            Arrays.asList(info)
                  .stream()
                  .forEach(v -> {
                    String[] rankStr = v.split(" ");
                    RankInfo rank = new RankInfo();
                    rank.setLanguage(rankStr[0]);
                    rank.setPosition(rankStr[1]);
                    rank.setCareer(rankStr[2]);
                    rank.setFavorite(rankStr[3]);
                    rank.setScore(rankStr[4]);
                    inputRank.add(rank);
            } );;

            
            Arrays.asList(query)
                  .stream()
                  .forEach( v -> {

                    String[] rankStr = v.split(" ");
                    List<String> tempList = new ArrayList<>();
                    for(int i = 0; i < rankStr.length; i++){
                        if(!"and".equals(rankStr[i])){
                            tempList.add(rankStr[i]);
                        }
                    }
                    RankInfo rank = new RankInfo();
                    rank.setLanguage(tempList.get(0));
                    rank.setPosition(tempList.get(1));
                    rank.setCareer(tempList.get(2));
                    rank.setFavorite(tempList.get(3));
                    rank.setScore(tempList.get(4));
                
                    resultRank.add(rank);
            });
            answer = new int[resultRank.size()];
            int resultIdx = 0;
            for(RankInfo queryQuestion : resultRank){
                int hitCount = 1;
                int rankScore = Integer.parseInt(queryQuestion.getScore());
                for(RankInfo input: inputRank){
                    int inputScore = Integer.parseInt(input.getScore());
                    if( ("-".equals(queryQuestion.getLanguage()) || input.getLanguage().equals(queryQuestion.getLanguage())) &&
                        ("-".equals(queryQuestion.getCareer())   || input.getCareer().equals(queryQuestion.getCareer()))     &&
                        ("-".equals(queryQuestion.getPosition()) || input.getPosition().equals(queryQuestion.getPosition())) &&
                        ("-".equals(queryQuestion.getFavorite()) || input.getFavorite().equals(queryQuestion.getFavorite())) &&
                        ("-".equals(queryQuestion.getScore())    || rankScore <= inputScore) 
                       ){
                           answer[resultIdx] = hitCount;
                           hitCount += 1;;
                       }
                }
                resultIdx += 1;
            }
            
            for(int i = 0; i < answer.length; i++){
                System.out.print(answer[i] + ", ");
            }

            System.out.println(inputRank);
            System.out.println();
            System.out.println(resultRank);


            return answer;
        }
    }

    class RankInfo{

        private String language;
        private String position;
        private String career;
        private String favorite;
        private String score;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language){
            this.language = language;
        }

        public String getPosition(){
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCareer() {
            return career;
        }

        public void setCareer(String career) {
            this.career = career;
        }

        public String getFavorite() {
            return favorite;
        }

        public void setFavorite(String favorite) {
            this.favorite = favorite;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "RankInfo [language=" + language + ", position=" + position + ", career=" + career + ", favorite="
                    + favorite + ", score=" + score + "]";
        }

        
    }
    
}
