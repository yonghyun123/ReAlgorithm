package naverfinancial;
/**
 * 두개의 시간을 주고 그 사이에 숫자의 digit가 한자리나, 두자리로만 된 케이스를 구하시오
 * ex) 
 * 15:15:00, 15:15:12
 * -> 15:15:11 return 1
 * 
 * 22:22:21, 22:22:23
 * 22:22:21, 
 * 22:22:22,
 * 22:22:23
 * return 3
 */
import java.util.*;
public class Ex03 {
    public static void main(String[] args) {
        String S = "00:22:58";
        String T = "01:21:00";
        System.out.println(solution(S,T));
    }   

    //class Solution {
        public static int solution(String S, String T) {
            // write your code in Java SE 8
            int answer = 0;
            ArrayList<String> arr = new ArrayList<>();
            String time = S;
            String hh = "";
            String mm = "";
            String ss = "";

            while(true)
            {
                arr = new ArrayList<>();
                
                for(int i=0; i<time.length();i++)
                {
                    if(time.charAt(i) != ':') 
                    {
                        if(!arr.contains(time.substring(i,i+1))) 
                            arr.add(time.substring(i,i+1));
                    }
                }

                if(arr.size() == 1 || arr.size() == 2) answer++;

                if(time.equals(T)) break;

                int t_ss = Integer.parseInt(time.substring(6,8)) + 1;
                if(t_ss == 60)
                {
                    ss = "00";
                    int t_mm = Integer.parseInt(time.substring(3,5)) + 1;
                    if(t_mm == 60)
                    {
                        mm = "00";
                        int t_hh = Integer.parseInt(time.substring(0,2)) + 1;
                        if(t_hh < 10) hh = "0" + t_hh;
                        else hh = t_hh + "";
                    }
                    else
                    {
                        if(t_mm < 10) mm = "0" + t_mm;
                        else mm = t_mm + "";
                        hh = time.substring(0,2);

                    }
                }
                else
                {
                    hh = time.substring(0,2);
                    mm = time.substring(3,5);
                    if(t_ss < 10) ss = "0" + t_ss;
                    else ss = t_ss + "";
                }
                time = hh+":"+mm+":"+ss;
                System.out.println(time);
            }
            return answer;
        }
    //}
}
