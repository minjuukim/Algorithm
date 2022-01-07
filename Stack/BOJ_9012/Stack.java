package step_11to20.BOJ_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �־��� ��ȣ ���ڿ��� VPS(�ùٸ� ��ȣ ���ڿ�)���� �ƴ��� �Ǵ��ؼ� ��� YES/NO ���.
public class Stack {
	char[] arr;
	int count;
	boolean validps;
	
	public Stack(int size) {
		arr = new char[size];
		count = 0;
		validps = true;
	}
	
	public void push(char ps) {
		arr[count] = ps;
		count++;
	}
	
	public int pop() {
		if( count == 0 ) {
			validps = false;
			return -1;
		}
		else {
			arr[count-1] = arr[count];
			count--;
			return 0;
		}
	}
	
	public String isValid() {
		if(validps == false) {
			return "NO";
		}
		else if( count == 0 ) {
			return "YES";
		}
		else {
			return "NO";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String ps;	// Parenthesis String ��ȣ ���ڿ�

		for(int i=0; i<T; i++) {
			Stack stack = new Stack(T);
			ps = br.readLine();
		
			for(int j=0; j<ps.length(); j++) {
				
				if( ps.charAt(j) == '(' ) {
					stack.push(ps.charAt(j));
				
				}
				else if( ps.charAt(j) == ')' ) {
					stack.pop();
				
				}
			}
			System.out.println(stack.isValid());

		}
	}

}
