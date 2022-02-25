import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B1_3985_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();	// 롤케이크 길이
		int N = sc.nextInt();	// 방청객의 수
		
		int[] cake = new int[L+1];
		int max = 0;	// 실제로 가장 많이 받는 방청객의 조각 개수
		int max_idx = 0;	// 실제로 가장 많이 받는 방청객의 번호
		int expect = 0;		// 예상되는 조각 개수
		int expect_idx = 0;	// 가장 많이 받을 것이라고 예상되는 방청객 번호
		
		for(int i=1; i<=N; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			if(expect < to-from) {	// 예상되는 최대 조각 수 방청객 구하기
				expect = to-from;
				expect_idx = i;
			}
			
			int count = 0;
			for(int j=from; j<=to; j++) {
				if(cake[j]==0) {	// 아무도 조각을 선택하지 않았으면
					cake[j] = i;	// 케이크를 선택한 방청객의 번호를 저장
					count++;
				}
			}
			if(max < count) {	// 가장 많이 받는 방청객 구하기
				max = count;
				max_idx = i;
			}
		}
		
		System.out.println(expect_idx);
		System.out.println(max_idx);
	}

}
