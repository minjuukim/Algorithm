package day0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21278_호석이두마리치킨_BFS {
	
	static int N, c1, c2, min=Integer.MAX_VALUE;
	static int map[][], numbers[], times[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 건물 개수
		int M = Integer.parseInt(st.nextToken());	// 도로 개수
		
		map = new int[N+1][N+1];
		numbers = new int[2];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		comb(0, 1);
		
		System.out.println(c1+" "+c2+" "+min);
	}
	
	public static void comb(int cnt, int start) {		// 치킨집 2개 선택하기
		
		if(cnt==2) {
			times = new int[N+1];
			int sum = bfs();
			
			if(sum<min) {
				min = sum;
				c1 = numbers[0];
				c2 = numbers[1];
			} 
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static int bfs() {
		Queue<Integer> que = new LinkedList<>();
		int chicken1 = numbers[0];	// 치킨집1
		int chicken2 = numbers[1];	// 치킨집2
		que.offer(chicken1);	
		que.offer(chicken2);	
		int sum = 0;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 1; i <= N; i++) {
				if(i==chicken1 || i==chicken2 || times[i]!=0 || map[cur][i]==0) continue;
				
				times[i] = times[cur]+1;
				sum += times[i];
				que.offer(i);
			}
		}
	
		return sum*2;
	}
	
}
