package day0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	
	static int[][] board;
	static ArrayList<int[]> list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		board = new int[9][9];
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j]==0) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		dfs(0);
	}
	
	public static void dfs(int idx) {
		
		if(idx == list.size()) {
			print();
			System.exit(0);
		}
		
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		
		boolean[] check = new boolean[10];	// 1~9 숫자가 사용되고있는지 체크
		
		// 행 체크
		for (int i = 0; i < 9; i++) {
			if(board[r][i] != 0) {
				check[board[r][i]] = true;
			}
		}
		
		// 열 체크
		for (int i = 0; i < 9; i++) {
			if(board[i][c] != 0) {
				check[board[i][c]] = true;
			}
		}
		
		// 3*3 사각형 체크
		int startR = (r/3) * 3;
		int startC = (c/3) * 3;
		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if(board[i][j] != 0) {
					check[board[i][j]] = true;
				}
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if(!check[i]) {
				board[r][c] = i;
				dfs(idx+1);
				board[r][c] = 0;
			}
		}
	}
	
	public static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
