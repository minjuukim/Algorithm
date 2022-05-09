package day0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20955_민서의응급수술 {
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 뉴런 개수
		int M = Integer.parseInt(st.nextToken());	// 시냅스 개수
		
		parent = new int[N+1];	// 각 노드의 부모 노드를 저장한 배열
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		int count = 0;	// 두 노드를 연결한 간선의 개수 
		int cycle = 0;	// 사이클일 경우 끊는 간선의 개수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());	
			int v = Integer.parseInt(st.nextToken());	
			
			if(find(u) == find(v)) {	// 사이클이 있다면 한 간선 제거 => 카운트 증가
				cycle++;
			} else {
				union(u, v);	// 사이클이 아니라면 두 노드를 연결
			}
		}
		
		for (int i = 1; i < N; i++) {	// 한 노드씩 확인
			if(find(i) == find(i+1)) continue;
			union(i, i+1);	// 부모가 다르다면 연결 => 연결 간선 개수 카운트
			count++;
		}
		
		System.out.println(cycle + count);
		
	}
	
	public static int find(int node) {	// 부모노드 구하기
		if(parent[node] != node) {
			parent[node] = find(parent[node]);
		}
		return parent[node];
	}
	
	public static void union(int a, int b) {	// 두 노드를 연결
		int parent_a = find(a);
		int parent_b = find(b);
		
		if(parent_a > parent_b) {
			parent[parent_a] = parent_b;
		} else {
			parent[parent_b] = parent_a;
		}
	}

}
