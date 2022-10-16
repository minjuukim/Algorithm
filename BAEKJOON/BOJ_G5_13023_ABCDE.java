package day1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// ABCDE���� -> ��� �Լ� ���¿� ��� 
// 5���� ��尡 ��� ���·� ���� => ����� ���̰� 5�̻��̸� 1, �ƴϸ� 0 ���
public class BOJ_G5_13023_ABCDE {
	
	static boolean arrive, visited[];
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// ����� ��
		int M = Integer.parseInt(st.nextToken());	// ģ�� ������ ��
		adjList = new ArrayList[N];
		visited = new boolean[N];
		
		// ���� ����Ʈ�� �� ArrayList �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// ���� ����Ʈ�� �׷��� ������ ����
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		// �� ��帶�� dfs ����
		for(int i=0; i<N; i++) {
			dfs(i, 1);			// depth 1���� ����
			if(arrive) break;	// depth�� 5�� ������ ���� �ִٸ�
		}
		
		if(arrive) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
	}
	
	public static void dfs(int i, int depth) {
		
		if(depth==5 || arrive) {	// depth�� 5�� �Ǹ� ���α׷� ����
			arrive = true;		// ���� Ȯ��
			return;
		}
		
		visited[i] = true;
		
		for(int k : adjList[i]) {
			if(!visited[k]) {
				dfs(k, depth+1);	// ��� ȣ���� �� ������ depth�� 1�� ����
			}
		}
		visited[i] = false;
	}

}
