import java.util.Scanner;

public class BOJ_S5_2578_빙고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] board = new int[5][5];
		
		// 빙고판 숫자 입력받기
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// 사회자가 부르는 수 배열
		int[] num = new int[25];
		for(int i=0; i<25; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i<25; i++) {
			
			for(int r=0; r<5; r++) {
				for(int c=0; c<5; c++) {
					if(num[i]==board[r][c]) {
						board[r][c] = 0;	// 해당 숫자를 부르면 0으로 표시
					}
				}
			}
			
			if( i<5 ) continue;
			
			int count = 0;	// 빙고 개수
			int sum = 0;
			// 가로 빙고 체크
			for(int r=0; r<5; r++) {
				sum = 0;
				for(int c=0; c<5; c++) {
					sum += board[r][c];
				}
				if(sum==0) count++;
			}
			
			// 세로 빙고 체크
			for(int c=0; c<5; c++) {
				sum = 0;
				for(int r=0; r<5; r++) {
					sum += board[r][c];
				}
				if(sum==0) count++;
			}
			
			// 대각선 빙고 체크
			int sum1=0, sum2=0;
			for(int j=0, k=4; j<5; j++, k--) {
				sum1 += board[j][j];
				sum2 += board[j][k];
			}
			if(sum1==0) count++;
			if(sum2==0) count++;
			
			if(count>=3) {
				System.out.println(i+1);
				break;
			}
		}
	}

}
