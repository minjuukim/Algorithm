import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_스도쿠검증 {
	
	static int[][] map;
	static int[] num;
	static boolean[] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		for(int t=1; t<=T; t++) {
			map = new int[9][9];	
			
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	// 입력받아 표에 저장.
				}
			}
			
			sb.append("#"+t+" ").append(solving()).append("\n");
		}
		System.out.println(sb);

	}
	
	public static int solving() {	// 수평, 수직, 네모에 겹치는 숫자가 없는지 체크
		// horizontal 수평체크
		for(int i=0; i<9; i++) {
			num = new int[10];
			isUsed = new boolean[10];	// 배열에 저장된 숫자가 사용되었는지 여부를 저장하는 배열.
			
			for(int j=0; j<9; j++) {
				if(isUsed[map[i][j]]) {		// 겹치는 숫자가 있다면 0 반환
					return 0;
				}
				isUsed[map[i][j]] = true;	// 겹치는 숫자가 없다면 현재 숫자를 사용한 것으로 저장
			}
		}
		// vertival 수직체크
		for(int i=0; i<9; i++) {
			num = new int[10];
			isUsed = new boolean[10];
			
			for(int j=0; j<9; j++) {
				if(isUsed[map[j][i]]) {
					return 0;
				}
				isUsed[map[j][i]] = true;
			}
		}
		// squre 네모체크
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				
				isUsed = new boolean[10];
				for(int r=0; r<3; r++) {
					for(int c=0; c<3; c++) {
						if(isUsed[map[i*3+r][j*3+c]]) {  // 인덱스 0, 3, 6 이 첫칸인 행/열을 탐색
							return 0;
						}
						isUsed[map[i*3+r][j*3+c]] = true;
					}
				}
			}
		}
		return 1;	// 겹치는 숫자가 없다면 1 반환
	}
}
