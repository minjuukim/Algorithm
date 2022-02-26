import java.util.Scanner;

public class BOJ_S3_2491_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		// 수열의 길이
		int[] num = new int[N];		// 수열 저장할 배열
		
		for(int i=0; i<N; i++) num[i] = sc.nextInt();	// 수열 저장
		
		int max = 1;
		
		// 연속으로 커질 때
		int asc = 1;	// 오름차순 카운트
		for(int i=0; i<N-1; i++) {
			
			if (num[i] <= num[i+1]) {
				asc++;
			} else asc = 1;
			max = Math.max(max, asc);
		} 
		
		// 연속으로 작아질 때
		int desc = 1;	// 내림차순 카운트
		for(int i=0; i<N-1; i++) {
			if (num[i] >= num[i+1]) {
				desc++;
			} else desc = 1; 
			max = Math.max(max, desc);
		}

		System.out.println(max);
	}
}
