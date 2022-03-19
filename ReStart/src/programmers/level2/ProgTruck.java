package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class ProgTruck {

    public static void main(String[] args) {
        ProgTruck.Solution solution = new ProgTruck().new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution.solution(bridge_length, weight, truck_weights)); 
    }

    class Solution{
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            
            Queue<TruckInfo> waitingQ = new LinkedList<>();
            LinkedList<TruckInfo> runningQ = new LinkedList<>();

            for(int i = 0; i < truck_weights.length; i++){
                waitingQ.add(new TruckInfo(truck_weights[i], bridge_length));
            }

            int sumWeight = 0;
            int passTime = 0;

            while(!waitingQ.isEmpty() || !runningQ.isEmpty()){
                if(!runningQ.isEmpty()){
                    if(runningQ.peek().getOnTime() == 0){
                        sumWeight -= runningQ.peek().getWeight();
                        runningQ.poll();
                    }
                }
                if(!waitingQ.isEmpty()){
                    if(sumWeight + waitingQ.peek().getWeight() <= weight){
                        sumWeight += waitingQ.peek().getWeight();
                        runningQ.add(waitingQ.peek());
                        waitingQ.poll();
                    } 
                } 
                for(TruckInfo item: runningQ){
                    item.setOnTime(item.getOnTime()-1);
                }
                passTime += 1;
            }

            return passTime;
        }
    }
    
}

class TruckInfo{
    private int weight;
    private int onTime;

    public TruckInfo(int weight, int onTime){
        super();
        this.weight = weight;
        this.onTime = onTime;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public int getOnTime(){
        return this.onTime;
    }

    public void setOnTime(int onTime){
        this.onTime = onTime;
    }
}
