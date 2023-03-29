import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long left = times[0];
        long right = times[times.length-1] * (long) n;
        long mid = 0;
        System.out.println(right);
        
        while(left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            for(int time : times) {
                sum += mid/time;
            }
            
            if(sum < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}
