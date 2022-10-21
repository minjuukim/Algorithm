package day1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_1068_Ʈ�� {
	
	static int N, deleteNode, ans;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// ����� ����
		tree = new ArrayList[N];
		int root = 0;

		// ��������Ʈ �迭 �ʱ�ȭ 
		for(int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			
		    /* �Է°��� ���� �� �ʱ�ȭ�� ���� �ϰ� �Ǹ�, �ڽ��� �θ𺸴� ��ȣ�� ���� ��� ���� �ʱ�ȭ�� ���� ���� �����̱� ������ 
			   ==> NullpointerException �߻� => ��Ÿ�� ���� �߻�!
			adjList[i] = new ArrayList<>();   --> ���� �ݵ�� �Է� ���� �ޱ� �� �ʱ�ȭ�� ����� �Ѵ�!! 		 */
			
			int parent = Integer.parseInt(st.nextToken());
			
			if(parent != -1) {
				tree[parent].add(i);	// ����� �ڽ� ������ ����Ʈ�� �߰�
			} else {
				root = i;
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());	// ������ ��� ��ȣ
		
		if(deleteNode == root) System.out.println(0);
		else {
			dfs(root);
			findLeaf(root);
			System.out.println(ans);
		}
	}
	
	// ��������� ���� ������ ��� (deleteNode) �����ϱ�
	public static void dfs(int node) {
		
		for(int n = 0; n < tree[node].size(); n++) {
			int child = tree[node].get(n);
			
			if(child == deleteNode) {
				tree[node].remove(n);	// ��� ����
				return;
			}
			
			dfs(child);
		}
	}
	
	// ������� ���� ���ϱ�
	public static void findLeaf(int node) {
		
		if(tree[node].size() == 0) {	// �ڽ��� ���� ����� ��� ī��Ʈ 
			ans++;
			return;
		}
		
		for(int n = 0; n < tree[node].size(); n++) {
			findLeaf(tree[node].get(n));
		}
	}
}
