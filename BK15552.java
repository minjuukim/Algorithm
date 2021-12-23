package Baekjoon;

import java.util.StringTokenizer;
import java.io.*;

public class BK15552 {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// String이 리턴값이라 형변환 필수! 라인단위임
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			// readLine()을 통해 입력받은 값을 공백단위로 구분하여  순서대로 호출
			int a = Integer.parseInt(st.nextToken());	
			int b = Integer.parseInt(st.nextToken());
			bw.write(a+b+"\n");		// 버퍼에 있는 값 전부 출력
		}
		bw.close();	// 스트림을 닫음
	}
}

