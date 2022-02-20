package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_10971_외판원순회2 {
	
	static int[][] map;
	static int N, ans=Integer.MAX_VALUE;	// 최소 비용
	static int[] course;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 도시의 수
		map = new int[N][N];
		isSelected = new boolean[N];
		course = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 비용값을 입력받아 저장.
			}
		}
		getRoute(0, 0);
		System.out.println(ans);
	}

	public static void getRoute(int cnt, int sum) {
		
		if(sum>ans) return;		// 중간 비용이 현재 최소비용보다 이미 클 경우 반환. (가지치기)
		
		if(cnt==N) {	// 도시의 순서를 전부 선택하였을 경우
			if(map[course[cnt-1]][course[0]]==0) return;	// 두 도시간의 비용이 0일 경우 갈 수 없으므로 반환.
			
			sum += map[course[cnt-1]][course[0]];
			ans = Math.min(ans, sum);	// 최소 비용을 저장
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			course[cnt] = i;
			isSelected[i] = true;
			
			if(cnt>0) {
				if(map[course[cnt-1]][course[cnt]]==0) {	// 비용이 0이면 갈 수 없는 경우이므로 이후는 더이상 보지 않는다.(가지치기)
					isSelected[i] = false;
					continue;
				}
				getRoute(cnt+1, sum+ map[course[cnt-1]][course[cnt]]);
			} else {	// 한개의 도시만 선택했을 경우 경로가 없으므로 비용은 0이고, 다음 도시를 선택.
				getRoute(cnt+1, 0);
			}
			
			isSelected[i] = false;
		}
	}
}
