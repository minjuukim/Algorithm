package Baekjoon;

import java.util.StringTokenizer;
import java.io.*;

public class BK15552 {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// String�� ���ϰ��̶� ����ȯ �ʼ�! ���δ�����
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			// readLine()�� ���� �Է¹��� ���� ��������� �����Ͽ�  ������� ȣ��
			int a = Integer.parseInt(st.nextToken());	
			int b = Integer.parseInt(st.nextToken());
			bw.write(a+b+"\n");		// ���ۿ� �ִ� �� ���� ���
		}
		bw.close();	// ��Ʈ���� ����
	}
}

