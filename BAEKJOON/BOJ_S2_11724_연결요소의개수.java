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
		
		// 인접 리스트의 각 ArrayList 초기화하기.
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 인접 리스트에 그래프 데이터 저장하기.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {	// 방문하지 않은 노드가 없을때까지 반복
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}

	public static void dfs(int i) {
		
		if(visited[i]) return;
		
		visited[i] = true;
		
		for (int j : adjList[i]) {	
			if(!visited[j]) {	// 연결노드 중 방문하지 않았던 노드만 탐색
				dfs(j);
			}
		}
	}
}
