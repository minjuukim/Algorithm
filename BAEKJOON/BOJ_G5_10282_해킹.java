package day0211;

import java.io.*;
import java.util.*;

public class BOJ_G5_10282_해킹 {
	static int n;
	static List<Node>[] arrList;
	static int[] dist;	// 최단거리

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());		// 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken());	// 의존성 개수
			int c = Integer.parseInt(st.nextToken());	// 해킹당한 컴퓨터 번호
			
			dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			arrList = new ArrayList[n+1];
			for(int i=0; i<=n; i++) {
				arrList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				arrList[b].add(new Node(a, s));
			}
			
			dijkstra(c);	// 다익스트라
			
			int cnt = 0;
			int time = 0;
			for(int i=1; i<=n; i++) {
				if(dist[i] != Integer.MAX_VALUE){
					cnt++;
					time = Math.max(time, dist[i]);
				}
			}
			sb.append(cnt + " " + time).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int c) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.add(new Node(c, 0));
		dist[c] = 0;
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int idx = cur.idx;
			int time = cur.time;
			
			if(dist[idx] < time) continue;
			
			for(int i=0; i<arrList[idx].size(); i++) {
				int nxtIdx = arrList[idx].get(i).idx;
				int nxtTime = arrList[idx].get(i).time + time;	// 현재까지 걸린 시간 + 다음노드에 가는데 걸리는 시간
				
				if(dist[nxtIdx] > nxtTime) {
					dist[nxtIdx] = nxtTime;
					que.add(new Node(nxtIdx, nxtTime));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int idx;
		int time;
		
		public Node(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
}
