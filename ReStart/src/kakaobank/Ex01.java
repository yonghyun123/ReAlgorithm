package kakaobank;

/**
 * 당신은 사용하던 계좌의 잔액을 다른 계좌로 모두 옮기려고 합니다. 
 * 그런데 잔액이 얼마나 남아있는지 알 수 없기 때문에 1일 이체 한도 내에서 여러 번 송금을 시도하고자 하며,
 *  이때 송금 성공 횟수와 실패 횟수를 구하려고 합니다. 단, 잔액은 항상 1일 이체 한도보다 작거나 같습니다.

만약 잔액보다 큰 금액을 송금하려고 하면 잔액부족으로 인해 송금에 실패하며,
 그렇지 않은 경우에는 송금에 성공합니다. 다음과 같은 규칙에 따라 송금 작업을 반복합니다.

처음에는 1일 이체 한도만큼 송금을 시도합니다.
송금에 성공한 경우, 성공한 금액만큼 한 번 더 송금을 시도합니다.
송금에 실패한 경우, 시도했던 금액을 2로 나눈 몫만큼 줄여서 다시 송금을 시도합니다.
단, 첫 송금에 성공하거나, 송금을 두 번 연속 성공하거나, 1원 송금에 실패하면 작업을 종료합니다.
예를 들어 계좌에 남아있는 잔액이 3원, 1일 이체 한도가 5원이라면 다음과 같은 과정을 거치게 됩니다.

5원만큼 송금을 시도합니다. 잔액부족으로 실패하여 다음 시도 금액을 5를 2로 나눈 몫인 2로 줄입니다.
2원만큼 송금을 시도합니다. 송금에 성공하여 잔액은 1원이 됩니다.
2원만큼 송금을 시도합니다. 송금에 실패하여 다음 시도 금액을 2를 2로 나눈 몫인 1로 줄입니다.
1원만큼 송금을 시도합니다. 송금에 성공하여 잔액은 0원이 됩니다.
1원만큼 송금을 시도합니다. 송금에 실패하였으며, 1원 송금에 실패한 것이므로 작업을 종료합니다.
위와 같은 과정을 거쳐, 송금 성공 2회, 송금 실패 3회 만에 작업을 마칠 수 있습니다.

계좌에 남아있는 잔액을 나타내는 정수 money, 1일 이체 한도를 나타내는 정수 limit이 매개변수로 주어집니다.
 위 규칙에 따라 송금을 반복할 경우, 송금에 성공하는 횟수와 실패하는 횟수를 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ money ≤ limit ≤ 1,000,000,000
입출력 예
money	limit	result
3	5	[2, 3]
4	10	[2, 2]
7	11	[2, 4]
4	4	[1, 0]
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.

입출력 예 #2

다음과 같은 송금 과정을 거칩니다.

시도 금액	성공 여부	잔액
10	false	4
5	false	4
2	true	2
2	true	0
2원 송금에 두 번 연속 성공했기 때문에 그 순간 송금 작업을 종료합니다. 따라서 송금 성공 횟수는 2회, 실패 횟수는 2회이며, 이를 순서대로 배열에 담아 [2, 2]를 return 합니다.

입출력 예 #3

다음과 같은 송금 과정을 거칩니다.

시도 금액	성공 여부	잔액
11	false	7
5	true	2
5	false	2
2	true	0 (잔액이 0원이 되어도 송금 작업이 종료되지 않는 점에 유의합니다.)
2	false	0
1	false	0
1원 송금에 실패했기 때문에 그 순간 송금 작업을 종료합니다. 따라서 송금 성공 횟수는 2회, 실패 횟수는 4회이며, 이를 순서대로 배열에 담아 [2, 4]를 return 합니다.

입출력 예 #4

1일 이체 한도만큼 시도한 첫 송금이 성공했기 때문에, 바로 작업을 종료합니다. 송금 성공 횟수는 1회, 실패 횟수는 0회이며, 이를 순서대로 배열에 담아 [1, 0]을 return 합니다.
 */
public class Ex01 {
    public static void main(String[] args) {
        Ex01.Solution solution = new Ex01().new Solution();
        int money = 4;
        int limit = 4;

        solution.solution(money, limit);

    }

    class Solution{
        public int[] solution(int money, int limit) {
            int[] answer = {};

            boolean isDouble = false;
            int firstSuccessCnt = 0;
            int falseCnt = 0;
            int trueCnt = 0;
            int idx = 0;
            while(true){
                //이체를 실패했을때
                System.out.println("성공:"+ trueCnt  + ", 실패:" + falseCnt);
                System.out.println("money:"+ money  + ", limit:" + limit);
                if(money - limit < 0 ){
                    falseCnt += 1;
                    if(money == 0 && limit == 1) break;
                    limit = limit / 2;
                    isDouble = false;
                } else { //이체를 성공했을때,
                    if(idx == 0){
                        firstSuccessCnt += 1;
                        break;
                    } 
                    trueCnt += 1;
                    money -= limit;
                    if(isDouble){
                        break;
                    }
                    isDouble = true;
                }
                idx += 1;
            }
            

            System.out.println("성공:"+ (trueCnt+firstSuccessCnt)  + ", 실패:" + falseCnt);

            return answer;
        }
    }
}
