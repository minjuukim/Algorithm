package day0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19542_전단지돌리기 {
	
	static int N, S, D, count;
	static ArrayList<Integer>[] adjList;
	static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 노드 개수
		S = Integer.parseInt(st.nextToken());	// 케니소프트 위치
		D = Integer.parseInt(st.nextToken());	// 힘
		
		adjList = new ArrayList[N+1];
		depth = new int[N + 1];		// 리프노드부터의 거리 최댓값
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		count = 0;	// 방문노드 개수
		dfs(S, -1);
		
		// 왕복 간선 개수 => 방문노드 개수(시작점 제외)*2
		System.out.println(count*2);
	}
	
	public static int dfs(int node, int pre) {
		for(int next : adjList[node]) {
			if(next != pre) {	// 부모노드 제외
				// 리프노드 시작으로 depth를 1씩 증가
				// 서브노드 2개 이상일 경우 -> 더 깊은 depth값 저장
				depth[node] = Math.max(depth[node], dfs(next, node)+1);
			}
		}
		
		// 트리의 리프노드로부터 D거리 미만인 노드 => 탐색x
		// D거리 이상 노드 => 이동해야하는 노드
		if(node!=S && depth[node]>=D) {	// 시작점을 제외한 높이 D이상인 노드 카운트
			count++;
		}
		
		return depth[node];
	}

}
