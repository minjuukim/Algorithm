import java.io.*;
import java.util.*;

class Solution_타겟넘버 {

    static int ans;
    static int[] symbol = {+1, -1};

    public int solution(int[] numbers, int target) {
        int answer = 0;

        bfs(numbers, target);
        answer = ans;

        return answer;
    }

    public static void bfs(int[] numbers, int target){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        int N = numbers.length;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int sum = cur[0];
            int idx = cur[1];

            if(idx==N){
                if(sum==target) ans++;
                continue;
            }

            int nxt = sum + symbol[0] * numbers[idx];
            que.offer(new int[]{nxt, idx+1});

            nxt = sum + symbol[1] * numbers[idx];
            que.offer(new int[]{nxt, idx+1});
        }
    }
}
