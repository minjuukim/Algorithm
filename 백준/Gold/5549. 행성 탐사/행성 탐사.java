import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		
		int[][][] map = new int[R+1][C+1][3];		// map[r][c][땅의 종류] : 각 위치에는 각 위치까지 탐색했을 때 땅의 종류의 개수들이 저장. 
		
		for(int i=1; i<=R; i++) {
			String input = br.readLine();
			for(int j=1; j<=C; j++) {
				for(int k=0; k<3; k++) {
					map[i][j][k] = map[i][j-1][k];		// 이전 열의 값을 저장
				}
				
				char tmp = input.charAt(j-1);
				if(tmp == 'J') map[i][j][0]++;
				else if(tmp == 'O') map[i][j][1]++;
				else map[i][j][2]++;
			}
			
			for(int j=1; j<=C; j++) {
				for(int k=0; k<3; k++) {
					map[i][j][k] += map[i-1][j][k];		// 이전 행의 값을 더함.
				}
			}
		}
		
		int[] ans = new int[3];
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<3; i++) {	// 구하려는 좌표에서 (이전행의 해당 열까지의 값)과 (이전열의 해당 행까지의 값)을 빼고 중복값을 더해줘서 구한다.
				ans[i] = map[r2][c2][i] - map[r1-1][c2][i] - map[r2][c1-1][i] + map[r1-1][c1-1][i];
			}
			System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
		}
	}
}