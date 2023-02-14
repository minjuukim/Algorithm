package day0214;

import java.io.*;
import java.util.*;

public class BOJ_G4_3343_장미 {
	static long N, min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());	// 장미 개수
		long cntA = Long.parseLong(st.nextToken());		// 꽃집A의 꽃다발 장미 개수
		long priceA = Long.parseLong(st.nextToken());	// 꽃집A의 꽃다발 가격
		long cntB = Long.parseLong(st.nextToken());		// 꽃집B의 꽃다발 장미 개수
		long priceB = Long.parseLong(st.nextToken());	// 꽃집B의 꽃다발 가격
		
		// A : 가성비 좋은 세트, B : 가성비 안좋은 세트로 저장  => A를 B개 구매한 가격 < B를 A개 구매한 가격
		if(cntB*priceA > cntA*priceB) {		
			long cntTmp = cntA;
			cntA = cntB;
			cntB = cntTmp;
			long priceTmp = priceA;
			priceA = priceB;
			priceB = priceTmp;
		}
		
		for(int b=0; b<cntA; b++) {		// B를 A개 이상 구매할 필요가 없다
			long a = (long) Math.ceil((double)(N - b*cntB)/cntA);
			
			boolean isOver = false;
			if (a < 0) {
				a = 0;
				isOver = true;
			}
			
			min = Math.min(min, a*priceA + b*priceB);
			if(isOver) break;
		}
		System.out.println(min);
	}
}
