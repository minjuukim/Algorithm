package day1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14600_샤워실바닥깔기 {
	
	static int num;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int N = (int) Math.pow(2, K);
		map = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		map[y][x] = -1;
		calc(1, 1, N);
		
		for(int i=N; i>=1; i--) {
			for(int j=1; j<=N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void calc(int x, int y, int size) {
		num++;
		int half = size/2;
		
		// 정사각형이 모두 비어있다면 한칸을 제외하고 ㄱ타일을 채울 수 있기 때문에 
		// 제외되는 한칸(꼭지점)에 num으로 숫자 부여.
		if(isEmpty(x, y, half)) map[x+half-1][y+half-1] = num;
		if(isEmpty(x+half, y, half)) map[x+half][y+half-1] = num;
		if(isEmpty(x, y+half, half)) map[x+half-1][y+half] = num;
		if(isEmpty(x+half, y+half, half)) map[x+half][y+half] = num;
		
		if(size==2) return;
		
		calc(x, y, half);
		calc(x+half, y, half);
		calc(x, y+half, half);
		calc(x+half, y+half, half);
	}
	
	// 주어진 정사각형이 모두 비어있는지 체크
	public static boolean isEmpty(int x, int y, int s) {
		for(int i=x; i<x+s; i++) {
			for(int j=y; j<y+s; j++) {
				if(map[i][j] != 0) return false;
			}
		}
		return true;
	}
}
