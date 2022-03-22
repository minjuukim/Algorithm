package day0321;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* I/O
7
6
1 2
2 3
1 5
5 2
5 6
4 7
==> 4
*/

public class BOJ_S3_2606_바이러스 {
	
	static int map[][];			// 각 정점간 탐색 경로 저장
	static boolean[] visited;	// 정점 탐색여부 체크
	static int count;			// 정점과 연결된 바이러스 걸리는 컴퓨터 수
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();		// 컴퓨터의 수 (정점)
		int link = sc.nextInt();	// 컴퓨터 쌍의 수 (간선)
		
		map = new int[num+1][num+1];
		visited = new boolean[num+1];
		
		// 인접행렬 이용
		for (int i = 0; i < link; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		bfs(1);
		System.out.println(count);

	}
	
	public static void bfs(int i) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(i);
		visited[i] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for (int j = 1; j < map.length; j++) {
				if(map[cur][j]==1 && !visited[j]) {
					que.offer(j);
					visited[j] = true;
					count++;
				}
			}
		}
	}
}
