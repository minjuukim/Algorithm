package day1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// ABCDE관계 -> 재귀 함수 형태와 비슷 
// 5개의 노드가 재귀 형태로 연결 => 재귀의 깊이가 5이상이면 1, 아니면 0 출력
public class BOJ_G5_13023_ABCDE {
	
	static boolean arrive, visited[];
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 사람의 수
		int M = Integer.parseInt(st.nextToken());	// 친구 관계의 수
		adjList = new ArrayList[N];
		visited = new boolean[N];
		
		// 인접 리스트의 각 ArrayList 초기화
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 인접 리스트에 그래프 데이터 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		// 각 노드마다 dfs 실행
		for(int i=0; i<N; i++) {
			dfs(i, 1);			// depth 1부터 시작
			if(arrive) break;	// depth가 5에 도달한 적이 있다면
		}
		
		if(arrive) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
	}
	
	public static void dfs(int i, int depth) {
		
		if(depth==5 || arrive) {	// depth가 5가 되면 프로그램 종료
			arrive = true;		// 도착 확인
			return;
		}
		
		visited[i] = true;
		
		for(int k : adjList[i]) {
			if(!visited[k]) {
				dfs(k, depth+1);	// 재귀 호출이 될 때마다 depth를 1씩 증가
			}
		}
		visited[i] = false;
	}

}
