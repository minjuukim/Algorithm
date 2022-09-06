package day0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_16637_��ȣ�߰��ϱ� {
	
	static int N;
	static long max=Integer.MIN_VALUE;
	static char[] expression;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// ������ ����
		expression = br.readLine().toCharArray();	// ����
		
		dfs(2, expression[0]-'0');
		System.out.println(max);
	}
	
	public static void dfs(int cur, long sum) {
		// ���� ����
		if(cur>=N) {
			max = Math.max(max, sum);
			return;
		}
		
		// ��ȣ�� ������� ���� ��� => ���ݱ����� �հ� cur�� ����� ����� ���� ���ڿ� �ѱ�.
		dfs(cur+2, cal(sum, expression[cur-1], expression[cur] - '0'));
		
		// cur���� ��ȣ�� ����� ��� 
		if(cur+2 < N) {
			long subSum = cal(expression[cur]-'0', expression[cur+1], expression[cur+2]-'0');	// ��ȣ���� �� ���
			dfs(cur+4, cal(sum, expression[cur-1], subSum));	// ���ݱ����� ����� ��ȣ���� ���� ����ϱ�
		}
	}
	
	public static long cal(long sum, char op, long cur) {
		if(op == '+') return sum + cur;
		else if(op == '-') return sum - cur;
		else return sum * cur;
	}

}
