import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int max = 0;
        int N = citations.length;   // 논문 개수
        
        Arrays.sort(citations);
        
        for(int i=0; i<N; i++) {
            int min = Math.min(citations[i], N-i);
            max = Math.max(max, min);
        }
        return max;
    }
}
