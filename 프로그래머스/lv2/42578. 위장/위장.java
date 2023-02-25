import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            } else {
                map.put(clothes[i][1], 1);    
            }
        }
        
        for(Integer c : map.values()){
            answer *= c + 1;    // 각 종류의 입지 않는 경우의 수 포함하여 연산
        }
        
        return answer-1;    // 아무것도 입지 않는 경우 제외
    }
}