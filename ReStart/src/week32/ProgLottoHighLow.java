package week32;


public class ProgLottoHighLow {

    public static void main(String[] args) {
        ProgLottoHighLow.Solution solution = new ProgLottoHighLow().new Solution();
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
    
        int[] result = solution.solution(lottos,win_nums);
        System.out.println(result[0] + " "+ result[1]);
    }


    class Solution{
        private int countOfZero;
        private int countOfRight;

        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {};

            for(int i = 0; i < lottos.length; i++){
                if(lottos[i] == 0) {
                    countOfZero += 1;
                    continue;
                }
                for(int j = 0; j < win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){
                        countOfRight += 1;
                        break;
                    }
                }
            }
            int highScore = 7-(countOfRight + countOfZero);
            int lowScore = 7-countOfRight;

            if(highScore == 7) highScore = 6;
            if(lowScore == 7) lowScore = 6;

            answer = new int[2];
            answer[0] = highScore;
            answer[1] = lowScore;

            return answer;
        }

        
    }
}
