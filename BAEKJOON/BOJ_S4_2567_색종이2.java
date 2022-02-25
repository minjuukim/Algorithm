import java.util.Scanner;

public class BOJ_S4_2567_색종이2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[101][101];
		int n = sc.nextInt();	// 색종이의 수
		int length = 0;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int r=x; r<x+10; r++) {
				for(int c=y; c<y+10; c++) {
					map[r][c] = 1;	// 색종이가 덮어지는 영역을 1로 표시
				}
			}
		}
		
		// 4방 탐색 => 상/하/좌/우가 비어있으면 둘레에 해당
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(map[i][j]==1) {
					for(int d=0; d<4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(map[nx][ny]==0) length++;	// 탐색하는 영역이 색종이가 덮어진 영역이 아니라면 둘레 1 추가
					}
				}
			}
		}
		
		System.out.println(length);
	}
}
