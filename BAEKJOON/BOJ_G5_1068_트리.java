package day1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_1068_트리 {
	
	static int N, deleteNode, ans;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 노드의 개수
		tree = new ArrayList[N];
		int root = 0;

		// 인접리스트 배열 초기화 
		for(int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			
		    /* 입력값을 받을 때 초기화를 같이 하게 되면, 자식이 부모보다 번호가 작을 경우 아직 초기화를 하지 않은 시점이기 때문에 
			   ==> NullpointerException 발생 => 런타임 에러 발생!
			adjList[i] = new ArrayList<>();   --> 따라서 반드시 입력 값을 받기 전 초기화를 해줘야 한다!! 		 */
			
			int parent = Integer.parseInt(st.nextToken());
			
			if(parent != -1) {
				tree[parent].add(i);	// 노드의 자식 노드들을 리스트에 추가
			} else {
				root = i;
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());	// 삭제할 노드 번호
		
		if(deleteNode == root) System.out.println(0);
		else {
			dfs(root);
			findLeaf(root);
			System.out.println(ans);
		}
	}
	
	// 재귀적으로 돌며 삭제할 노드 (deleteNode) 삭제하기
	public static void dfs(int node) {
		
		for(int n = 0; n < tree[node].size(); n++) {
			int child = tree[node].get(n);
			
			if(child == deleteNode) {
				tree[node].remove(n);	// 노드 삭제
				return;
			}
			
			dfs(child);
		}
	}
	
	// 리프노드 개수 구하기
	public static void findLeaf(int node) {
		
		if(tree[node].size() == 0) {	// 자식이 없는 노드일 경우 카운트 
			ans++;
			return;
		}
		
		for(int n = 0; n < tree[node].size(); n++) {
			findLeaf(tree[node].get(n));
		}
	}
}
