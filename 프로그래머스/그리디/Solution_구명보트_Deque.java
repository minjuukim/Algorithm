import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<people.length; i++) {deque.push(people[i]);}

        while(!deque.isEmpty()) {
            answer++;
            int std = deque.pollFirst();
            if(!deque.isEmpty()) {
                if(std + deque.peekLast() <= limit) {
                    deque.pollLast();
                }
            }
        }
        return answer;
    }
}
