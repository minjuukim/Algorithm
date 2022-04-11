import java.util.Scanner;

public class Solution_5607_조합 {
	static final int MOD = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			
			long fac[] = new long[N+1];
			fac[0] = 1;
			
			for (int i = 1; i <= N; i++) {
				fac[i] = (fac[i-1]*i) % MOD;
			}
			
			long bottom = (fac[R] * fac[N-R] % MOD);
			long reBottom = fermat(bottom, MOD-2);
			
			System.out.println("#"+tc+" "+ (fac[N] * reBottom) % MOD);
		}
	}

	private static long fermat(long n, int x) {
		if(x==0) return 1;
		long tmp = fermat(n, x/2);
		long ret = (tmp * tmp) % MOD;
		if(x % 2 == 0) return ret;
		else return (ret * n) % MOD;
	}
}
