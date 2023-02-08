package day0208;

import java.io.*;
import java.util.*;

public class BOJ_G5_13549_숨바꼭질3 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 수빈이 위치
		K = Integer.parseInt(st.nextToken());	// 동생 위치
		
		bfs();
	}

	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {N, 0});	// 현재위치, 시간
		
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);
		visited[N] = 0;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			// 순간이동
			if(2*cur[0] <= 100000) {
				if(visited[2*cur[0]]==-1 || visited[2*cur[0]] > cur[1]) {
					visited[2*cur[0]] = cur[1];
					que.offer(new int[] {2*cur[0], cur[1]});
				}
			}
			
			// 걷기
			if(cur[0]+1 <= 100000) {	// 앞으로 한칸 
				if(visited[cur[0]+1]==-1 || visited[cur[0]+1] > cur[1]+1) {
					visited[cur[0]+1] = cur[1]+1;
					que.offer(new int[] {cur[0]+1, cur[1]+1});
				}
			}
			
			if(cur[0]-1 >=0) {	// 뒤로 한칸 
				if(visited[cur[0]-1]==-1 || visited[cur[0]-1] > cur[1]+1) {
					visited[cur[0]-1] = cur[1]+1;
					que.offer(new int[] {cur[0]-1, cur[1]+1});
				}
			}
		}
		
		System.out.println(visited[K]);
	}
}
