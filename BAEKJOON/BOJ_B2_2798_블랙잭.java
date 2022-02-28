import java.util.Scanner;

public class BOJ_B2_2798_블랙잭 {
	static int N, M, max;
	static int[] cards, num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 카드의 개수
		M = sc.nextInt();	// 카드의 합
		
		cards = new int[N];
		num = new int[3];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		comb(0, 0);
		System.out.println(max);
	}

	public static void comb(int cnt, int start)	{
		
		if(cnt==3) {
			int sum = num[0]+num[1]+num[2];
			if(sum<=M) {
				max = Math.max(max, sum);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			
			num[cnt] = cards[i];
			comb(cnt+1, i+1);
		}
	}
}
