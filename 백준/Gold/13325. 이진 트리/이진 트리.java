import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k, sum;
	static int[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());	// 트리 레벨
		int n = (int) Math.pow(2, k+1)-1;		// 노드의 개수
		
		tree = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			sum += tree[i];
		}
		
		dfs(0, 0);	// 낮은 레벨부터 가중치 증가
		System.out.println(sum);
	}
	
	public static int dfs(int depth, int cur) {
		
		if(depth == k+1) {
			return 0;
		}
		
		int lc = dfs(depth+1, cur*2+1);		// 왼쪽 자식 노드
		int rc = dfs(depth+1, cur*2+2);		// 오른쪽 자식 노드
		sum += Math.abs(lc-rc);		// 자식 노드들 중 큰쪽과 동일하게 바꿈
		
		return tree[cur] + Math.max(lc, rc);	// 해당 노드가 가진 자식들의 가중치들 중 최대값을 자기 자신과 더함
	}
}