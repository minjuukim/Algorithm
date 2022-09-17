package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S2_11724_연결요소의개수 {
	static List<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 정점의 개수
		int M = Integer.parseInt(st.nextToken());	// 간선의 개수
		
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}

	public static void dfs(int i) {
		
		if(!visited[i]) {
			visited[i] = true;
			for (int j = 0; j < adjList[i].size(); j++) {
				if(!visited[adjList[i].get(j)]) {
					dfs(adjList[i].get(j));
				}
			}
		}
	}
}
