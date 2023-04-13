import java.io.*;
import java.util.*;
// n: 선수의 수, results: 경기 결과를 담은 2차원 배열 ([A, B]: A선수가 B선수를 이겼다는 의미)
// 정확하게 순위를 매길 수 있는 선수의 수를 return
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] floyd = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
            // w가 l을 이김.
            int w = results[i][0];   
            int l = results[i][1];
            floyd[w][l] = 1;    // w가 l을 이긴경우  -> 1
            floyd[l][w] = -1;   // l이 w한테 진 경우 -> -1
        }
        
        // 플로이드-와샬 알고리즘
        // 1 > 2, 2 > 5 => 1 > 5
        for(int k=1; k<=n; k++) {           // 경유지
            for(int i=1; i<=n; i++) {       // 출발지
                if(i==k) continue;
                for(int j=1; j<=n; j++) {   // 목적지
                    if(i==j || k==j) continue;
                    
                    if(floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    
                    if(floyd[i][k] == -1 && floyd[k][j] == -1) {
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }
        
        // n명의 선수. 각 선수가 순위를 확정 지으려면, 
        // 각 선수별로 n-1번의 승패를 알아야 한다. 
        // ex) 5명인 경우 -> 각 행에 0이 아닌 값이 4개 있는 것을 카운트.
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(floyd[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        return answer;
    }
}
