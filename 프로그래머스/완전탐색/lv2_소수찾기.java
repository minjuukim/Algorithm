import java.util.*;
import java.io.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();      // 중복값 제거를 위한 HashSet
    static char[] arr; 
    static int N;
    static boolean[] isSelected;
    
    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        arr = numbers.toCharArray();
        
        isSelected = new boolean[N];
        perm("", 0);
        answer = set.size();
        return answer;
    }
    
    // 순열
    public void perm(String str, int idx) {
        if(idx == N) {
            if(str != "") {
                int num = Integer.parseInt(str);
                if(prime(num)) {
                    set.add(num);
                }
            }
            return;
        }
        
        for(int i=0; i<N; i++) {
            
            if(isSelected[i]) continue;
            
            isSelected[i] = true;
            perm(str + arr[i], idx+1);
            isSelected[i] = false;
            perm(str, idx+1);
        }
    }
    
    // 소수 판별
    public boolean prime(int num) {
        if(num==1 || num==0) return false;
        for(int i=2; i<num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
