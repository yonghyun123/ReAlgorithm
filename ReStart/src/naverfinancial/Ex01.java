package naverfinancial;

public class Ex01 {
    public static void main(String[] args) {
        
    }

    class Solution {
        int solution(int[] A) {
            int N = A.length;
            int result = 0;
            boolean breakFlag = false;
            // for (int i = 0; i < N; i++)
            //     for (int j = 0; j < N; j++)
            //         if (A[i] == A[j])
            //             result = Math.max(result, Math.abs(i - j));
    
            for (int i = 0; i < N; i++){
                for (int j = N-1; j > i; j--){
                    if(A[i] == A[j]){
                        result = Math.max(result, Math.abs(i - j));
                        breakFlag = true;
                        break;
                    }
                }
                if(breakFlag) break;   
            }
    
            return result;
        }
    }
}
