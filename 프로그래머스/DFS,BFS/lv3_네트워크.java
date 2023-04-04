import java.io.*;
import java.util.*;
class Solution {
    
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        check = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!check[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int from, int n, int[][] computers) {
        check[from] = true;
        
        for(int i=0; i<n; i++) {
            if(from==i) continue;
            
            if(!check[i] && computers[from][i]==1) {
                dfs(i, n, computers);
            }
        }
    }
}
