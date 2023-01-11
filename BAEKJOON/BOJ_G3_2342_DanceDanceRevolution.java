package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G3_2342_DanceDanceRevolution {
	static List<Integer> numbers;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new ArrayList<>();
		
		while(true) {
			int k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			numbers.add(k);
		}
		
		dp = new int[numbers.size()][5][5];
		System.out.println(dfs(0, 0, 0));
	}
	
	static int dfs (int idx, int left, int right) {
		if(idx == numbers.size()) return 0;
		
		if(dp[idx][left][right] != 0) {
			return dp[idx][left][right];	// dp[현재 스탭 인덱스][왼발최종위치][오른발최종위치]
		}
		
		int moveLeft = dfs(idx+1, numbers.get(idx), right) + cal(left, numbers.get(idx));
		int moveRigth = dfs(idx+1, left, numbers.get(idx)) + cal(right, numbers.get(idx));
		dp[idx][left][right] = Math.min(moveLeft, moveRigth);
		
		return dp[idx][left][right];
	}

	static int cal(int i, int j) {
		if(i==0) return 2;	// 가운데 출발
		else if(i==j) return 1;	// 지금 위치 누를 경우
		else if(Math.abs(i-j) == 2) return 4;	// 크로스 누를 경우
		else return 3;	// 인접 스텝 누를 경우
	}
}
