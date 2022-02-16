import java.util.Scanner;

public class BOJ_S1_1074_Z {
	
	static int count = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();	// 방문 순서 궁금한 행
		int c = sc.nextInt();	// 방문 순서 궁금한 열
		
		int lenght = (int) Math.pow(2, N);	// 한 변의 길이
		
		findVisit(lenght, r, c);
		System.out.println(count);
	}

	public static void findVisit(int lenght, int r, int c) {
		
		if(lenght==1)
			return;
		
		// (r,c)의 위치가
		// 1사분면에 있을 경우
		if( r < lenght/2 && c < lenght/2 ) {
			findVisit(lenght/2, r, c);
		}
		// 2사분면에 있을 경우
		if( r < lenght/2 && c >= lenght/2 ) {
			count += lenght * lenght / 4;				// 앞에 1사분면을 방문한만큼 더해준다
			findVisit(lenght/2, r, c-lenght/2);		// 2사분면에서의 (r,c)의 상대위치를 넘겨줌
		}
		// 3사분면에 있을 경우
		if( r >= lenght/2 && c < lenght/2 ) {
			count += (lenght * lenght / 4)*2;			// 앞에 1,2사분면을 방문한만큼 더해준다
			findVisit(lenght/2, r-lenght/2, c);		// 3사분면에서의 (r,c)의 상대위치를 넘겨줌
		}
		// 4사분면에 있을 경우
		if( r >= lenght/2 && c >= lenght/2 ) {	
			count += (lenght * lenght / 4)*3;			// 앞에 1,2,3사분면을 방문한만큼 더해준다
			findVisit(lenght/2, r-lenght/2, c-lenght/2);	// 4사분면에서의 (r,c)의 상대위치를 넘겨줌
		}
		
	}
 
}
