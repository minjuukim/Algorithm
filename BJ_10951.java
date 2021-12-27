package Baekjoon;
//import java.util.Scanner;	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ10951 {
//	**************방법3
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	// 출력에 이용
		String str;
		
		while( (str=br.readLine()) != null) {
			//charAt() 은 해당 문자의 아스키코드 값을 반환하기 때문에 반드시 정수 형태로 변경하려면 -48 또는 -'0'을 해줘야함
			int a = str.charAt(0) - 48;		
			int b = str.charAt(2) - 48;
			sb.append(a+b).append("\n");
		}
		System.out.print(sb);
	}
	
//	**************방법2
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();	// 출력에 이용
//		StringTokenizer st;
//		String str;
//		
//		//readLine을 통해 입력을 하여 str에 저장된 데이터가 null일 경우 while 반복문 종료
//		while( (str=br.readLine()) != null) {
//			st = new StringTokenizer(str, " ");
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			sb.append(a+b).append("\n");
//		}
//		System.out.print(sb);
//	}
	
	/* **************방법1
	 * public static void main(String[] args) { int a, b; Scanner sc = new
	 * Scanner(System.in);
	 * 
	 * while (sc.hasNextInt()){ a = sc.nextInt(); b = sc.nextInt();
	 * 
	 * System.out.println(a+b); } }
	 */
}


