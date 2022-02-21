import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S2_1260_DFS와BFS {
	
	static int N, M, start;
	static boolean[] visited;	// 방문 여부
	static int adjMatrix[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 정점의 개수
		M = sc.nextInt();	// 간선의 개수
		start = sc.nextInt();	// 시작 정점
		
		adjMatrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무향이므로 간선 하나로 양방향 처리
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		dfs(start);
		visited = new boolean[N+1];
		System.out.println();
		bfs();
	}
	
	public static void dfs(int current) {
		
		visited[current] = true;
		System.out.print(current+" ");
		
		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for (int j = 1; j <= N; j++) {
			if(!visited[j] && adjMatrix[current][j]==1) {	// 기저조건인 셈. 인접했을때만 재귀를 호출하므로 만족하지 않으면 자동으로 종료.
				dfs(j);		// 인접한 j정점으로 넘어가는 것
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);		// 시작점도 Queue에 넣어야 함.
		visited[start] = true;
		System.out.print(start+" ");
		
		// Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
		while(!queue.isEmpty()) {
			int current = queue.poll();
			//System.out.println(current);
			
			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (int j = 1; j <= N; j++) {
				if(!visited[j] && adjMatrix[current][j]==1) {
					queue.offer(j);
					visited[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}

}



