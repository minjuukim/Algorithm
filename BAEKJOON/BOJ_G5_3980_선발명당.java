package day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_3980_선발명당 {
	static int[][] arr;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			arr = new int[11][11];
			for(int i=0; i<11; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[] position = new boolean[11];
			max = 0;
			sol(0, position, 0);
			System.out.println(max);
		}
	}
	
	public static void sol(int player, boolean[] position, int sum) {
		
		if(player>=11) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<11; i++) {
			if(arr[player][i] == 0 || position[i]) continue;
			position[i] = true;
			sol(player+1, position, sum + arr[player][i]);
			
			position[i] = false;

		}
	}
}
