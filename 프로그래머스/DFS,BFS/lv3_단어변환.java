import java.io.*;
import java.util.*;
class Solution {
    static int n;
    static int min = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        n = words.length;
        boolean[] isUsed = new boolean[n];
        
        dfs(begin, isUsed, 0, target, words);
        
        answer = min == Integer.MAX_VALUE ? 0 : min;
        return answer;
    }
    
    public void dfs(String cur, boolean[] isUsed, int cnt, String target, String[] words) {
     
        if(cur.equals(target)) {
            min = Math.min(min, cnt);
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!isUsed[i] && isChange(cur, words[i])) {
                isUsed[i] = true;
                dfs(words[i], isUsed, cnt+1, target, words);
                isUsed[i] = false;
            }
        }
    }
    
    public boolean isChange(String from, String to) {
        int diff = 0;
        int len = from.length();
        
        for(int i=0; i<len; i++) {
            if(from.charAt(i) != to.charAt(i)) {
                diff++;
            }
            
            if(diff > 1) {  // 두개 이상 알파벳이 다른 경우 변경 불가능.
                return false;
            }
        }
        
        return true;
    }
}
