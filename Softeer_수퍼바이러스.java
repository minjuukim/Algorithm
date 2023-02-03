package day0203;

import java.util.*;
import java.io.*;
/*
 * 2023.02.03
 * 수퍼바이러스
 * long의 최대값이 10^19라고한다.
 * half * half * p의 순간 최대값은 10억 * 10억 * 1억.... 
 *  (half * half % 1000000007) 이렇게 고쳐줬더니 드디어 풀림
 */
public class Softeer_수퍼바이러스 {    
    static int MOD = 1000000007;
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());   // 바이러스 수
        int P = Integer.parseInt(st.nextToken());   // 증가율
        long N = Long.parseLong(st.nextToken());   // 총 시간

        System.out.println(K * calc(P, 10*N) % MOD);
    }

    public static long calc(int P, long N) {
        if(N==1) return P;

        long half = calc(P, N/2);

        if(N%2 == 0){
            return half * half % MOD;
        } else {
            return (half * half % MOD) * P % MOD;
        }
    }
}