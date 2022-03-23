package kakaobank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 * 로드 밸런싱(Load Balancing)이란 여러 대의 서버에 사용자 요청을 분산하는 네트워크 기술입니다. 대표적인 로드 밸런싱 알고리즘은 다음과 같습니다.

Round Robin(순차방식): 사용자 요청을 서버에 순차적으로 하나씩 분배합니다.
Least Connection(최소 접속 방식): 열려있는 커넥션1 이 가장 적은 서버로 사용자 요청을 분배합니다.
두 알고리즘 각각 장단점이 있기 때문에 서버 성능, 요청 및 트래픽 등을 고려하여 적절한 알고리즘을 선택해야 합니다.

본 문제에서는 각 요청이 들어온 시각과 처리시간이 로그 문자열 형태로 주어질 때, 모든 요청을 처리하는데 두 알고리즘 중 어떤 것이 얼마만큼 더 빠른지 구해야 합니다. 각 서버는 한 번에 하나의 요청만 처리할 수 있다고 가정하며, 각 요청은 서버에 할당된 순서대로 처리합니다.

서버는 numServer대만큼 있으며, 각 서버에는 1번부터 numServer까지 번호가 하나씩 붙어있습니다.

Round Robin은 1번 서버부터 마지막 서버까지 번호가 증가하는 순서대로 하나씩 요청을 할당한 후 다시 1번 서버부터 요청을 할당합니다.

Least Connection은 열려있는 커넥션 수(각 서버에 현재 할당된 요청의 개수)가 가장 적은 서버로 요청을 할당합니다. 커넥션 수가 가장 적은 서버가 여러 대라면 그중 번호가 가장 작은 서버로 할당합니다. 이때, 서버에 할당된 요청이 완료되는 시각과 새로운 요청이 들어온 시각이 같은 경우, 서버에 할당된 요청이 먼저 완료된다고 가정합니다.

성능이 동일한 전체 서버 수 numServer와 로그 문자열이 담긴 배열 logs가 매개변수로 주어질 때, 어떤 알고리즘이 얼마만큼 더 빠른지 순서대로 배열에 담아 반환하도록 solution 함수를 완성해주세요.

제한사항
numServer는 1 이상 10 이하인 자연수입니다.
logs의 길이는 1 이상 10,000 이하입니다.
logs의 원소는 "요청시각 처리시간"형식의 문자열입니다.
요청시각과 처리시간은 공백으로 구분되어 주어집니다.
요청시각은 HH:MM:SS.SSS 형식의 문자열로, 24시간 표기법을 사용합니다.
처리시간은 S.SSS 형식의 문자열입니다.
예를 들어 13:22:08.030 0.100은 13시 22분 8.03초에 요청이 들어왔으며, 요청을 처리하려면 0.1초가 필요하다는 뜻입니다.
처리시간은 최대 3초입니다.
요청시각은 00:00:00.000 ~ 23:59:59.999로 주어지며, 하루 동안의 로그를 나타냅니다.
요청시각이 중복되는 경우는 없습니다.
logs의 원소는 요청시각 순으로 정렬되어 있습니다.
배열에 [더 빠른 알고리즘 번호, 시간 차이]를 순서대로 담아 반환해주세요.
Round Robin 알고리즘의 번호는 1, Least Connection 알고리즘의 번호는 2입니다.
시간 차이는 ms(밀리세컨드) 단위로 나타냅니다. 예를 들어 Least Connection이 13.501초만큼 더 빠르다면 [2, 13501]을 반환합니다.
두 알고리즘에 차이가 없다면 [0, 0]을 반환합니다.
입출력 예
numServer	logs	result
2	["12:00:00.100 0.400","12:00:00.200 0.500","12:00:00.300 0.100","12:00:00.400 0.600","12:00:00.500 0.200","12:00:00.600 0.400"]	[2, 400]
입출력 예
입출력 예 #1

입력으로 주어진 로그는 다음과 같습니다.

번호	요청 시각	처리 시간(초)
1	12:00:00.100	0.400
2	12:00:00.200	0.500
3	12:00:00.300	0.100
4	12:00:00.400	0.600
5	12:00:00.500	0.200
6	12:00:00.600	0.400
Round Robin의 경우 각 요청이 다음과 같이 분배됩니다:

시각	서버 1이 처리 중인 요청	서버 1에 대기 중인 요청	서버 2가 처리 중인 요청	서버 2에 대기 중인 요청
12:00:00.100	1번	[없음]	없음	[없음]
12:00:00.200	1번	[없음]	2번	[없음]
12:00:00.300	1번	[3번]	2번	[없음]
12:00:00.400	1번	[3번]	2번	[4번]
12:00:00.500	3번	[5번]	2번	[4번]
12:00:00.600	5번	[없음]	2번	[4번, 6번]
12:00:00.700	5번	[없음]	4번	[6번]
12:00:00.800	없음	[없음]	4번	[6번]
...				
12:00:01.300	없음	[없음]	6번	[없음]
...				
12:00:01.700	없음	[없음]	없음	[없음]
1번 서버는 12:00:00.800에 할당된 요청을 모두 처리하며, 2번 서버는 12:00:01.700에 할당된 요청을 모두 처리합니다. 따라서 모든 요청을 처리한 시각은 12:00:01.700입니다.

Least Connection의 경우 각 요청이 다음과 같이 분배됩니다:

시각	서버 1이 처리 중인 요청	서버 1에 대기 중인 요청	서버 2가 처리 중인 요청	서버 2에 대기 중인 요청
12:00:00.100	1번	[없음]	없음	[없음]
12:00:00.200	1번	[없음]	2번	[없음]
12:00:00.300	1번	[3번]	2번	[없음]
12:00:00.400	1번	[3번]	2번	[4번]
12:00:00.500	3번	[5번]	2번	[4번]
12:00:00.600	5번	[6번]	2번	[4번]
12:00:00.700	5번	[6번]	4번	[없음]
12:00:00.800	6번	[없음]	4번	[없음]
...				
12:00:01.100	6번	[없음]	4번	[없음]
12:00:01.200	없음	[없음]	4번	[없음]
12:00:01.300	없음	[없음]	없음	[없음]
1번 요청이 12:00:00.500에 완료됩니다. 따라서 5번 요청은 열려있는 커넥션 수가 더 적은 1번 서버에 할당됩니다.
3번 요청이 12:00:00.600에 완료됩니다. 따라서 6번 요청은 열려있는 커넥션 수가 더 적은 1번 서버에 할당됩니다.
1번 서버는 12:00:01.200에 할당된 요청을 모두 처리하며, 2번 서버는 12:00:01.300에 할당된 요청을 모두 처리합니다.
 따라서 모든 요청을 처리한 시각은 12:00:01.300입니다.

Least Connection(12:00:01.300)이 Round Robin(12:00:01.700)보다 0.4초(400ms) 빠르므로 [2, 400]을 반환합니다.
 */
public class Ex03Re {
    public static void main(String[] args) {
        Ex03Re.Solution solution = new Ex03Re().new Solution();
        int numServer = 2;
        String[] logs = {
            "12:00:00.100 0.400",
            "12:00:00.200 0.500",
            "12:00:00.300 0.100",
            "12:00:00.400 0.600",
            "12:00:00.500 0.200",
            "12:00:00.600 0.400"
        };

        solution.solution(numServer, logs);
    }

    class Solution {
        public int[] solution(int numServer, String[] logs) {
            int[] answer = {};
            List<String[]> inputLogList = new ArrayList<>();
            List<Queue<String[]>> serverList = new ArrayList<>();

            for (int i = 0; i < logs.length; i++) {
                String[] timeInfo = {logs[i].split(" ")[0],logs[i].split(" ")[1]};                
                inputLogList.add(timeInfo);
            }

            for(int i = 0; i <  numServer; i++){
                Queue<String[]> server = new LinkedList<>();
                serverList.add(server); //서버 생성
            }

            //첫번째 서버에 로그를 넣어두고 탐색시작
            int idx = 0;
            String current = inputLogList.get(idx)[0];
            serverList.get(idx).add(inputLogList.get(idx));

            inputLogList.remove(0);//대기 로그에 첫번째 항목 지움.
            //round robin
            // idx += 1;
            // while(!serverList.isEmpty()){
                
            //     String nextTime = increaseTime(current,1); //다음 시간을 받아옴
            //     current = nextTime;
            //     if(!inputLogList.isEmpty()){
            //         //다음로그가 큐에 들어가야함
                    
            //         if(inputLogList.get(0)[0].equals(current)){
            //             System.out.println("Add Q="+inputLogList.get(0)[0]+ ", currTime=" + current);
            //             serverList.get(idx % numServer).add(inputLogList.get(0));
            //             //대기중인 로그 지우기
            //             inputLogList.remove(0);
            //             //다음 라운드로빈을 위함
            //             idx += 1;
            //         }
            //     }

            //     //큐에 들어가있는것중 
            //     for(Queue<String[]> q : serverList){
            //         if(!q.isEmpty()){
            //             String requestTimeFirst = q.peek()[1].substring(0, 1);
            //             String requestTimeSecond = q.peek()[1].substring(2, 5);
    
            //             String requestTime = requestTimeFirst + requestTimeSecond;
            //             String predTime = increaseTime(q.peek()[0], Integer.parseInt(requestTime));
            //             // System.out.println(predTime +", "+ current);
            //             if(predTime.equals(current)){
            //                 System.out.println("Q out" + q.peek()[0] + ", " + q.peek()[1] + "currTime= " + current);
            //                 q.poll();
            //                 if(!q.isEmpty()){
            //                     q.peek()[0] = current;
            //                 }
                            
            //             }
            //         }
                   
            //     }
                
            //     for(int i = 0; i < serverList.size(); i++){
            //         if(serverList.get(i).isEmpty() && inputLogList.isEmpty()){
            //             serverList.remove(i);
            //         } 
            //     }
            // }

            //least connection
            inputLogList = new ArrayList<>();
            serverList = new ArrayList<>();

            for (int i = 0; i < logs.length; i++) {
                String[] timeInfo = {logs[i].split(" ")[0],logs[i].split(" ")[1]};                
                inputLogList.add(timeInfo);
            }

            for(int i = 0; i <  numServer; i++){
                Queue<String[]> server = new LinkedList<>();
                serverList.add(server); //서버 생성
            }
            
            idx = 0;
            current = inputLogList.get(idx)[0];
            serverList.get(idx).add(inputLogList.get(idx));

            inputLogList.remove(0);//대기 로그에 첫번째 항목 지움.
            idx += 1;

            while(!serverList.isEmpty()){
                
                String nextTime = increaseTime(current,1); //다음 시간을 받아옴
                current = nextTime;
                if(!inputLogList.isEmpty()){
                    //다음로그가 큐에 들어가야함
                    
                    if(inputLogList.get(0)[0].equals(current)){
                        System.out.println("Add Q="+inputLogList.get(0)[0]+ ", currTime=" + current);
                        //least conenction
                        int leastCnt = Integer.MAX_VALUE;
                        int serverIdx = -1;
                        for(int i =  serverList.size()-1; i >= 0; i--){
                            if(leastCnt > serverList.get(i).size()){
                                leastCnt = Math.min(leastCnt, serverList.get(i).size());
                                serverIdx = i;
                            }
                        }
                        serverList.get(serverIdx).add(inputLogList.get(0));
                        //대기중인 로그 지우기
                        inputLogList.remove(0);
                        //다음 라운드로빈을 위함
                        idx += 1;
                    }
                }

                //큐에 들어가있는것중 
                for(Queue<String[]> q : serverList){
                    if(!q.isEmpty()){
                        String requestTimeFirst = q.peek()[1].substring(0, 1);
                        String requestTimeSecond = q.peek()[1].substring(2, 5);
    
                        String requestTime = requestTimeFirst + requestTimeSecond;
                        String predTime = increaseTime(q.peek()[0], Integer.parseInt(requestTime));
                        // System.out.println(predTime +", "+ current);
                        if(predTime.equals(current)){
                            System.out.println("Q out" + q.peek()[0] + ", " + q.peek()[1] + "currTime= " + current);
                            q.poll();
                            if(!q.isEmpty()){
                                q.peek()[0] = current;
                            }
                            
                        }
                    }
                   
                }
                
                for(int i = 0; i < serverList.size(); i++){
                    if(serverList.get(i).isEmpty() && inputLogList.isEmpty()){
                        serverList.remove(i);
                    } 
                }
            }

            return answer;
        }

        //시간증가 로직 
        public String increaseTime(String currentTime, int passTime){
            String second = "";
            String minute = "";
            String hour = "";
            String milliSecond = "";
            String nextTime = "";

            for(int i = 0; i < passTime; i++){
                int tempMs = Integer.parseInt(currentTime.substring(9,12)) + 1;
                if(tempMs == 1000){
                    milliSecond = "000";
                    int tempS = Integer.parseInt(currentTime.substring(6,8)) + 1;
                    if(tempS == 60){
                        second = "00";
                        int tempMm = Integer.parseInt(currentTime.substring(3,5)) + 1;
                        if(tempMm == 60){
                            minute = "00";
                            int tempHh = Integer.parseInt(currentTime.substring(0,2)) + 1;
                            if(tempHh < 10) hour = "0" + tempHh;
                            else hour = tempHh + "";
                        } else {
                            if(tempMm < 10) minute = "0" + tempMm;
                            else minute = tempMm + "";
                            hour = currentTime.substring(0,2);
    
                        }
                    } else {
                        hour = currentTime.substring(0,2);
                        minute = currentTime.substring(3,5);
                        if(tempS < 10) second = "0" + tempS;
                        else second = tempS + "";
                    }
                } else {
                    hour = currentTime.substring(0,2);
                    minute = currentTime.substring(3,5);
                    second = currentTime.substring(6, 8);
                    if(tempMs < 10) milliSecond = "00" + tempMs;
                    else if(tempMs < 100) milliSecond = "0" + tempMs;
                    else milliSecond = tempMs + "";
                }
                nextTime = hour+":"+minute+":"+second+"."+milliSecond;
                currentTime = nextTime;
            }
            
            
            return nextTime;
        }

        public void showList(List<Queue<String[]>> inputLogList){
            for(Queue<String[]> item : inputLogList){
                System.out.println(item.peek()[0] + ", " + item.peek()[1]);
            }
        }
    }
}
