package day0321;

import java.util.ArrayList;
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

public class BOJ_2606_바이러스_3 {
	
	static ArrayList<Integer>[] list;
	static boolean[] visited;	// 정점 탐색여부 체크
	static int num, count;			// 정점과 연결된 바이러스 걸리는 컴퓨터 수
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();			// 컴퓨터의 수 (정점)
		int link = sc.nextInt();	// 컴퓨터 쌍의 수 (간선)
		
		list = new ArrayList[num+1];
		visited = new boolean[num+1];
		
		// 인접리스트 이용
		for (int i = 1; i <= num; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < link; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from].add(to);
			list[to].add(from);
		}
		
		dfs(1);
		System.out.println(count);

	}
	
	public static void dfs(int i) {
		visited[i] = true;
		
		for (int j : list[i]) {
			if(!visited[j]) {
				count++;
				dfs(j);
			}
		}
	}
}
