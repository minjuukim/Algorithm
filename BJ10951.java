package Baekjoon;
//import java.util.Scanner;	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ10951 {
//	**************���3
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	// ��¿� �̿�
		String str;
		
		while( (str=br.readLine()) != null) {
			//charAt() �� �ش� ������ �ƽ�Ű�ڵ� ���� ��ȯ�ϱ� ������ �ݵ�� ���� ���·� �����Ϸ��� -48 �Ǵ� -'0'�� �������
			int a = str.charAt(0) - 48;		
			int b = str.charAt(2) - 48;
			sb.append(a+b).append("\n");
		}
		System.out.print(sb);
	}
	
//	**************���2
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();	// ��¿� �̿�
//		StringTokenizer st;
//		String str;
//		
//		//readLine�� ���� �Է��� �Ͽ� str�� ����� �����Ͱ� null�� ��� while �ݺ��� ����
//		while( (str=br.readLine()) != null) {
//			st = new StringTokenizer(str, " ");
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			sb.append(a+b).append("\n");
//		}
//		System.out.print(sb);
//	}
	
	/* **************���1
	 * public static void main(String[] args) { int a, b; Scanner sc = new
	 * Scanner(System.in);
	 * 
	 * while (sc.hasNextInt()){ a = sc.nextInt(); b = sc.nextInt();
	 * 
	 * System.out.println(a+b); } }
	 */
}


