import java.io.*;
import java.util.*;

class Solution {
    static int[][] map;
    static int R, C;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
   
        R = maps.length;
        C = maps[0].length;

        map = maps;
        visited = new boolean[R][C];
        answer = bfs();

        
        return answer;
    }
    
    public static int bfs(){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0));
        visited[0][0] = true;
        
        while(!que.isEmpty()) {
            Node cur = que.poll();
            
            for(int d=0; d<4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]==0 || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                map[nr][nc] = map[cur.r][cur.c] + 1;
                que.offer(new Node(nr, nc));
            }
        }
        
        return map[R-1][C-1] == 1 ? -1 : map[R-1][C-1];
    }
    
    public static class Node {
        int r;
        int c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
