import java.util.Scanner;

public class BOJ_S3_2559_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 전체 날짜 수
		int K = sc.nextInt();	// 연속적인 날짜의 수
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for(int i=0; i<=N-K; i++) {
			int sum = 0;
			for(int j=i; j<i+K; j++) {	// 연속 K일의 합 구하기
				sum += arr[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
