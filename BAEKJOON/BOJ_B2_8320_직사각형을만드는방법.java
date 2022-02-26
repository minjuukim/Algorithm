import java.util.Scanner;

public class BOJ_B2_8320_직사각형을만드는방법 {
	
	static int N, count;
	static int[] length;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();		// 정사각형 개수
		length = new int[2];	// 직사각형의 가로, 세로 변의 길이 리스트
								// length[0]: 세로, length[1]: 가로
		visited = new boolean[N+1];	// 사용 체크
		
		comb(0, 1);
		System.out.println(count);
	}
	
	// 직사각형 만들기(조합) ==> 정사각형 6개 -> (1,1)(1,2)(1,3)(1,4)(1,5)(1,6)(2,2)(2,3) 직사각형 만들수 있음 
	public static void comb(int cnt, int start) {
		
		if(cnt==2) {
			count++;
			return;
		}
		
		for (int i = start; i <= N; i++) {
			visited[i] = true;
			length[cnt] = i;
			if(cnt==1 && length[0]*length[1] > N) return;	// 넓이=가로*세로가 N이 넘으면 더이상 보지 않는다.
			comb(cnt+1, i);
			visited[i] = false;
		}
	}

}
