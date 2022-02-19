import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1780_종이의개수 {

	static int negative;	// -1로만 채워진 종이의 개수
	static int zero;		// 0으로만 채워진 종이의 개수
	static int positive;	// 1로만 채워진 종이의 개수
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 종이 크기
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 입력받아 저장.
			}
		}
		
		cut(0, 0, N);
		System.out.println(negative);
		System.out.println(zero);
		System.out.println(positive);
	}
	
	public static void cut(int r, int c, int size) {
		
		int sum = 0;
		boolean isZero = true;
		
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum += map[i][j];
				if(map[i][j]!=0 && isZero) {
					isZero = false;
				}
			}
		}
		
		if(sum==size*size*(-1)) negative++;
		else if(sum==size*size) positive++;
		else if(isZero) zero++;
		else {
			
			int newSize = size/3;
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cut(r+newSize*i, c+newSize*j, newSize);
				}
			}
		}
	}

}
