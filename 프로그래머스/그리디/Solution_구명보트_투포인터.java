import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(); // 만들어야 할 문자열
        int len = number.length() - k;      // 내가 만들어야 할 수의 길이
        int start = 0;    
        
        while(start < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;      // '맨 뒤부터 보장되어야 할 자릿수' 맨앞의 인덱스
            int max = 0;
            for(int i=start; i<leftNum; i++) {
                if(max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    start = i + 1;
                }
            }
            answer.append(Integer.toString(max));
        }
        return answer.toString();
    }
}
