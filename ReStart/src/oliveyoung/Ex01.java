import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문제 설명
한 통신사가 현재 설치된 기지국이 커버하는 영역의 넓이의 합을 구하려고 합니다. 
각 기지국은 기지국을 중심으로 하는 원의 면적만큼 주변을 커버할 수 있습니다. 
하지만 기지국마다 출력에 차이가 있어 원의 크기가 다를 수도 있고, 
다른 기지국의 영역과 겹칠 수도 있기 때문에 계산이 복잡해질 수 있습니다. 그래서 몬테카를로 기법을 사용하여 면적을 구하려고 합니다.

몬테카를로 방식으로 면적을 계산하는 방법은 다음과 같습니다.

주어진 기지국 영역을 모두 포함하는 가장 작은 직사각형을 찾습니다. 이 직사각형의 네 변은 x축 또는 y축과 평행해야 합니다. 
직사각형의 왼쪽 변의 x좌표를 l, 오른쪽 변의 x좌표를 r, 아래쪽 변의 y좌표를 b, 위쪽 변의 y좌표를 t라고 합니다.
난수를 2개 생성(각각 x, y라고 함)하여 이 직사각형 안의 점을 나타내는 좌표로 변환합니다. 
이 문제에서는 좌표를 정수로만 표현합니다. 직사각형 안에 위치를 특정하기 위해 좌표를 변환할 수도 있습니다. 
변환된 좌표는 (l + x % (r - l), b + y % (t - b))입니다. 여기서 %는 나머지 연산으로, 
a%b는 a를 b로 나눈 나머지를 의미합니다. 나머지 연산은 더하기 연산보다 우선순위가 높습니다.
점이 기지국 영역 내에 있는지 검사합니다. 원 위에 존재하는 경우도 영역 내에 있는 것으로 간주합니다.
생성한 점들 중에서 기지국 영역 내부에 존재하는 점의 비율을 계산합니다. 이 비율을 직사각형의 면적과 곱하여 기지국 영역의 면적을 구합니다.
 예를 들어, 비율을 k라고 한다면 기지국 영역의 면적은 k * (r - l) * (t - b) 입니다.
기지국(원의 중심)의 x좌표와 y좌표를 각각 담은 정수 배열 x, y, 
각 기지국이 커버하는 영역의 반지름(원의 반지름)을 담은 정수 배열 r, 정수로 이루어진 난수 배열 v가 매개변수로 주어집니다. 
배열 v의 원소를 앞에서부터 2개씩 순서대로 사용하여 시뮬레이션에 사용할 점의 좌표로 활용합니다.
 몬테카를로 기법을 사용하여 구한 기지국 영역의 면적을 소수점 아래를 버리고 return 하도록 solution 함수를 완성해주세요.

제한 사항
1 ≤ x의 길이 = y의 길이 = r의 길이 ≤ 100
1 ≤ x의 원소, y의 원소, r의 원소 ≤ 10,000
x[i], y[i], r[i]는 각각 i번 원의 정보를 의미하며, 원의 중심은 (x[i], y[i]), 반지름은 r[i]입니다.
0 ≤ x[i] - r[i]
0 ≤ y[i] - r[i]
2 ≤ v의 길이 ≤ 10,000
v의 길이는 짝수입니다.
0 ≤ v의 원소 ≤ 100,000,000
같은 위치에 점이 2번 이상 생성되더라도 모두 다른 점으로 간주합니다.
입출력 예
x	y	r	v	result
[5]	[5]	[5]	[92, 83, 14, 45, 66, 37, 28, 9, 10, 81]	80
[3, 4]	[3, 5]	[2, 3]	[12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15]	28
입출력 예 설명
입출력 예 #1

주어진 원은 1개로 원의 중심이 (5,5)이고, 반지름이 5입니다.
이 원을 모두 포함하는 가장 작은 직사각형을 찾아 l, r, b, t의 값을 구하면, l = 0, r = 10, b = 0, t = 10 입니다.
주어진 난수는 순서대로 (2,3), (4,5), (6,7), (8,9), (0, 1) 다섯 개의 점을 생성합니다.
이중 점 (0, 1)은 어떤 원 안에도 속하지 않고, 
나머지는 모두 원 내부에 있기 때문에 5개의 점 중에서 4개의 점이 원 내부에 있습니다.
 원의 면적은 (4 / 5) * 10 * 10 = 80으로 계산됩니다. 따라서 80을 return 합니다.

입출력 예 #2

주어진 원은 2개로, 원의 중심이 (3, 3)이며 반지름이 2인 원, 원의 중심이 (4, 5)이며 반지름이 3인 원이 있습니다.
두 원을 모두 포함하는 가장 작은 직사각형을 찾아 l, r, b, t의 값을 구하면, l = 1, r = 7, b = 1, t = 8 입니다.
주어진 난수는 순서대로 (1, 7), (1, 1), (3, 2), (1, 5), (3, 6), (3, 2) 여섯 개의 점을 생성합니다.
이중 점 (1, 7), (1, 1)은 어떤 원 안에도 속하지 않고, 
나머지는 모두 원 내부에 있기 때문에 6개의 점 중에서 4개의 점이 원 내부에 있습니다.
 원의 면적은 (4 / 6) * 6 * 7 = 28로 계산됩니다. 따라서 28을 return 합니다.
 */

public class Ex01{

    public static void main(String[] args) {
        Ex01.Solution solution = new Ex01().new Solution();

        int[] x= {3,4};
        int[] y= {3,5};
        int[] r= {2,3};
        int[] v= {12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15};

        System.out.println(solution.solution(x,y,r,v));
    }

    class Solution{
        private int valL,valR,valB,valT,xSameCnt;
        private List<Integer[]> xList, yList;
        private int resultCnt = 0;

        public int solution(int[] x, int[] y, int[] r, int[] v) {
            int answer = 0;

            xList = new ArrayList<>();
            yList = new ArrayList<>();

            //l,r,b,t 구하기
            for(int i = 0; i < x.length; i++){
                Integer[] tempX = {x[i],r[i]};
                Integer[] tempY = {y[i],r[i]};
                xList.add(tempX);
                yList.add(tempY);
            }

            Collections.sort(xList, (o1,o2) -> {
                return o1[0].compareTo(o2[0]);
            });

            Collections.sort(yList, (o1,o2) -> {
                return o1[0].compareTo(o2[0]);
            });
            
            int len = xList.size();
            valL = Math.abs(xList.get(0)[1] - xList.get(0)[0]);
            valR = Math.abs(xList.get(len-1)[1] + xList.get(len-1)[0]);
            valB = Math.abs(yList.get(0)[1] - yList.get(0)[0]);
            valT = Math.abs(yList.get(len-1)[1] + yList.get(len-1)[0]);


            //변환된 좌표 구하기
            int convertX = 0;
            int convertY = 0;
            for(int i = 0; i < v.length-1; i=i+2){
                convertX = (valL + v[i] %(valR -valL));
                convertY = (valB + v[i+1] %(valT -valB));
                // System.out.println("valL"+valL+", valB"+valB+", valR"+valR+", valT"+valT);
                

                for(int j= 0; j < r.length; j++){
                    int distanceX = ((x[j] - convertX) *(x[j] - convertX)) + ((y[j] - convertY) *(y[j] - convertY));
                    if(distanceX <= (r[j] * r[j])){
                        break;
                    } 

                    if(j == r.length-1){
                        resultCnt += 1;
                    }
                }
            }
            System.out.println(resultCnt+", "+v.length);
            int vLen = v.length / 2;
            double resultValue = ((double)(vLen-resultCnt)/vLen) * (valR-valL) * (valT-valB);
            
            return (int)resultValue;
        }

        public void calculate(){
        
            for(int i = 0; i < xList.size()-1; i++){
                //같은점에 있을때 가장 큰원 찾기
                if(xList.size() > 1){
                    if(xList.get(i)[0].equals(xList.get(i+1)[0])){
                        xSameCnt += 1;
                    } else break;
                }
            }
            int maxXCircle = xList.get(0)[1];
            
            for(int i = 0; i < xSameCnt; i++){
                if(maxXCircle < xList.get(i)[1]){
                    // Xidx = i;
                    maxXCircle = xList.get(i)[1];
                }
            }
    
        }
    }

   
}