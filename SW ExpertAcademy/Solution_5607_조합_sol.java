import java.io.IOException;
import java.util.Scanner;
//Fermat Little Theorem
/*
JAVA
언어
78,816 kb
메모리
523 ms
실행시간
1,420
코드길이
Pass
결과
 */
public class Solution_5607_조합_sol {

	public static int iT=0,N,R;
	public static int Q=1234567891;

	public static void main(String[] args)  {
		Scanner scann=new Scanner(System.in);
		iT=scann.nextInt();
		for (int T = 1; T <= iT; T++) {

			N=scann.nextInt();
			R=scann.nextInt();
			System.out.printf("#%d %d\n",T,nCr(N,R,Q));
		}
	}
	/*
	 * 디바이드 앤 정복
	 * 5C2%7 -> 5!/(3!*2!) %7 -> 5!* 6^5 * 2^5 %7 -> 
	 *  (5! %7)*(6^1 %7 * 6^4 %7)*(2^1 %7 * 2^4 %7)
	 */
	static long power(long x, long y, long p)  { 
		long res = 1L; 
        x = x % p; 
        //=> 3^7 > 7 3 1   3^7 --> 3^1*3^2*3^4             
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        }  
        return res; 
    } 
    
    static long nCr(int n, int r, int p) { 
        if (r == 0) 
            return 1L; 
        if(r==n) return 1L;
        
        long[] fac = new long[n+1]; 
        fac[0] = 1; 
        // 팩토리아 메모이 제이션 
        for (int i = 1 ;i <= n; i++) 
            fac[i] = fac[i-1] * i % p; 
        // 페르마 소정리
        return (fac[n]* power(fac[r], p-2,p ) 
                % p * power(fac[n-r], p-2,p) 
                                    % p) % p; 
    } 
}
