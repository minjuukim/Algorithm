import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S3_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 사람의 수
		
		int[] P = new int[N];	// 각 사람이 돈을 인출하는데 걸리는 시간 배열
		for(int i=0; i<N; i++) {
			P[i] = sc.nextInt();
		}
		
		// 인출하는데 필요한 시간의 합의 최솟값 ==> 정렬하여 작은 값부터 더해야함
		Arrays.sort(P); 	// 오름차순 정렬
		int sum = 0;
		int ans = 0;
		for(int i=0; i<N; i++) {
			sum += P[i];
			ans += sum;
		}
		
		System.out.println(ans);
	}

}
