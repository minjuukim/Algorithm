import java.util.*;
import java.io.*;

class Solution {

    public String solution(int[] numbers) {
        String answer = "";
        int N = numbers.length;
        String[]  str = new String[N];
        
        // int배열 -> String배열
        for(int i=0; i<N; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 내림차순 정렬
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
                // 오름차순 정렬: (o1+o2).compareTo(o1+o2);
            }
        });
        
        // 람다식 사용 버전
        // Arrays.sort(str, (a,b)->{
        //         return (a+b).compareTo(b+a);
        //     }
        // );
        
        // 입력 데이터가 모두 0인 경우 0으로 리턴 ex){0,0,0} -> 0
        // 답이 000이 나오면 안되므로 첫번째 값이 0이면 0을 리턴.
        if(str[0].equals("0")) return "0";
        
        // 0이 아니면 정렬한 모든 문자열을 더함.
        for(String s : str) answer += s;
 
        return answer;
    }
}
