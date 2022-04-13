import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	
	static int N;
	static ArrayList<Integer>[] arrList;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arrList = new ArrayList[N+2];
			Pos[] location = new Pos[N+2];
			visited = new boolean[N+2];
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				location[i] = new Pos(r,c);
				arrList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N+1; i++) {
				for (int j = i+1; j < N+2; j++) {
					int d = Math.abs(location[i].r - location[j].r) + Math.abs(location[i].c - location[j].c);
					if(d <= 1000) {
						arrList[i].add(j);
						arrList[j].add(i);
					}
				}
			}
			
			System.out.println(bfs() ? "happy" : "sad");
		}
	}
	
	public static boolean bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);
		visited[0] = true;
		
		while(!que.isEmpty()) {
			int idx = que.poll();
			
			if(idx == N+1) return true;	// 도착지에 도착한 경우
			
			for (int i = 0; i < arrList[idx].size(); i++) {
				if(!visited[arrList[idx].get(i)]) {
					visited[arrList[idx].get(i)] = true;
					que.offer(arrList[idx].get(i));
				}
			}
		}
		
		return false;
	}
	
	static class Pos {
		int r;
		int c;
		int d;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}
