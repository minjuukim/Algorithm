import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		int d = 0, v = N*N;
		int curR = 1;
		int curC = 1;
		int nr, nc = 0;
		map[1][1] = v;
		
		while(true) {
			if(curR==(N/2+1) && curC==(N/2+1)) break;
			
			nr = curR + dr[d];
			nc = curC + dc[d];
			
			if(nr<1 || nr>=N+1 || nc<1 || nc>=N+1 || map[nr][nc]!=0) {
				d = (d+1)%4;
				nr = curR;
				nc = curC;
				continue;
			} 
			
			map[nr][nc] = --v;
			curR = nr;
			curC = nc;
			
		}
		
		int posR = 0, posC = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sb.append((map[i][j] + " "));
				if(map[i][j] == num) {
					posR = i; posC = j;
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		System.out.println(posR+" "+posC);

	}
}
