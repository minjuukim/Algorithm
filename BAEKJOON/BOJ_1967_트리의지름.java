package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {

	static ArrayList<Node>[] adjList;
	static boolean[] visit;
	static int max, max_node;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N+1];	// 양방향 인접리스트
		visit = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());	// 부모노드
			int child = Integer.parseInt(st.nextToken());	// 자식노드
			int weight = Integer.parseInt(st.nextToken());	// 가중치
			
			adjList[parent].add(new Node(child, weight));
			adjList[child].add(new Node(parent, weight));
		}
		
		visit[1] = true;
		dfs(1, 0);	// 1.루트 노드로부터 가장 먼 노드(max_node)를 구하기
		
		max = 0;
		visit = new boolean[N+1];
		visit[max_node] = true;
		dfs(max_node, 0);	// 2.max_node를 시작으로 가장 멀리 있는 노드를 구하기
		
		System.out.println(max);

	}
	
	public static void dfs(int node, int dist) {	// 가장 먼 경로에 있는 노드 구하기
		
		if(max < dist) {
			max = dist;
			max_node = node;
		}
		
		for(Node n : adjList[node]) {
			if(!visit[n.num]) {
				visit[n.num] = true;
				dfs(n.num, dist + n.dist);
			}
		}
	}
	
	static class Node {
		int num;	// 노드번호
		int dist;	// 거리
		
		public Node(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}
	}

}
