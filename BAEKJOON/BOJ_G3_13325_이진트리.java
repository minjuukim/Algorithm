package day0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_13325_이진트리 {
	static int k, sum;
	static int[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());	// 트리 레벨
		int n = (int) Math.pow(2, k+1);		// 노드의 개수
		
		tree = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(sum);
	}
	
	public static int dfs(int depth, int cur) {
		
		int l = dfs(depth+1, cur*2+1);
		int r = dfs(depth+1, cur*2+2);
	}

}
