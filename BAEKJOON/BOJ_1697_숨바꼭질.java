package day0421;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 수빈이의 위치
		int K = sc.nextInt();	// 동생의 위치
		
		int[] dx = {-1, 1, 0};
		boolean[] visit = new boolean[200001];
		
		int time = Integer.MAX_VALUE;
		
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(N, 0));
		visit[N] = true;
		
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			int x = cur.x;
			int t = cur.t;
			
			if(x==K) {
				time = Math.min(time, t);
				break;
			} 
			
			for (int d = 0; d < 3; d++) {
				int nx = x + dx[d];
				if(d==2) nx *= 2;
				
				if(nx>=0 && nx<200000 && !visit[nx]) {
					
					que.offer(new Pos(nx, t+1));
					visit[nx] = true;
				}
			}
		}
		
		System.out.println(time);
		
	}
	
	static class Pos {
		int x;
		int t;	// 시간
		
		public Pos(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}
	}

}
