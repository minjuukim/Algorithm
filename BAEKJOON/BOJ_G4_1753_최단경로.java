package day0214;

import java.io.*;
import java.util.*;

public class BOJ_G4_1753_최단경로 {
	static int[] dist;
	static List<Node>[] arrList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());	// 정점의 개수
		int E = Integer.parseInt(st.nextToken());	// 간선의 개수
		int K = Integer.parseInt(br.readLine());	// 시작 정점
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		arrList = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			arrList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arrList[u].add(new Node(v, w));
		}
		
		dist[K] = 0;
		dijkstra(K);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF" + "\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.add(new Node(start, 0));
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			
			if(dist[cur.v] < cur.w) continue;
			
			for(int i=0; i<arrList[cur.v].size(); i++) {
				int nv = arrList[cur.v].get(i).v;
				int nw = arrList[cur.v].get(i).w + cur.w;
				
				if(dist[nv] > nw) {
					dist[nv] = nw;
					que.add(new Node(nv, nw));
				}
				
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int v;	// 정점
		int w;	// 가중치
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}
