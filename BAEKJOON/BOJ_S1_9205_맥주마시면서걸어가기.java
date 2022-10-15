package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_9205_���ָ��ø鼭�ɾ�� {
	
	static int N, position[][], map[][];
	static boolean[][] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// �׽�Ʈ���̽� ��
		
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine()) + 2;
			position = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				position[i][0] = Integer.parseInt(st.nextToken());	// x��ǥ
				position[i][1] = Integer.parseInt(st.nextToken());	// y��ǥ
			}
			
			map = new int[N][N];
			visited = new boolean[N][N];
			// ��������� �� ��ġ ������ �Ÿ��� ����
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					map[i][j] = Math.abs(position[i][0] - position[j][0]) + Math.abs(position[i][1] - position[j][1]);
					map[j][i] = map[i][j];
				}
			}
			
			bfs();
			
			// ���� ����
			for (int i = 0; i < N; i++) {
				if(visited[N-1][i]) {
					sb.append("happy\n");
					break;
				}
				if(i==N-1) {
					sb.append("sad\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);	// ������ ���
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for (int i = 0; i < N; i++) {
				if(map[cur][i] <= 1000 && !visited[cur][i]) {	// �Ÿ��� �Ǵ� ��� �������� ������
					// ����� �湮 üũ
					visited[cur][i] = true;
					visited[i][cur] = true;
					que.offer(i);
				}
			}
		}
	}

}
