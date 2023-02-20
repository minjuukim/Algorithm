import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int T = Integer.parseInt(br.readLine()); // Test case
		int[][][] map = new int[N+1][M+1][3];
		
		String tmp;
		for(int i = 1 ; i <= N ; i++) {
			tmp = br.readLine();
			for(int j = 1 ; j <= M ; j++) {
				for(int k = 0 ; k < 3 ; k++)
					map[i][j][k] = map[i][j-1][k];
				char tmp2 = tmp.charAt(j-1);
				if(tmp2 == 'J')
					map[i][j][0]++;
				else if(tmp2 == 'O')
					map[i][j][1]++;
				else if(tmp2 == 'I')
					map[i][j][2]++;
			}
			for(int j = 1 ; j <= M ; j++)
				for(int k = 0 ; k < 3 ; k++)
					map[i][j][k] += map[i-1][j][k];
		}
		
		int[] point = new int[4];
		int[] result = new int[3];
		for(int TT = 0 ; TT < T ; TT++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < 4 ; i++)
				point[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i < 3 ; i++)
				result[i] = map[point[2]][point[3]][i] - map[point[0]-1][point[3]][i] 
						- map[point[2]][point[1]-1][i] + map[point[0]-1][point[1]-1][i];
			
			System.out.println(result[0] + " " + result[1] + " " + result[2]);
		}
	}
}