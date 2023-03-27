import java.io.*;
import java.util.*;

class Solution {
    static int R, C;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        R = maps.length;
        C = maps[0].length;
        bfs(0, 0);
        return answer;
    }
    
    public void bfs(int r, int c){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!que.isEmpty()) {
            Node cur = que.poll();
            
            for(int d=0; d<4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]==0 || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                que.offer(new Node(nr, nc, cur.cnt+1));
            }
        }
    }
    
    public class Node {
        int r;
        int c;
        int cnt;
        
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
