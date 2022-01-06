package step_11to20.BOJ_10828;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack {	// ����
	
	int count;
	int[] arr;
	
	public Stack(int size) {
		count=0;
		arr = new int[size];
	}
	
	public void push(int num) {
		if( isEmpty() == 1) {
			arr[count] = num;
			count++;
		}
		else {
			arr[count] = num;
			count++;
		}
	}
	
	public int pop() {
		if( isEmpty() == 1) {
			return -1;
		}
		else {
			int ret = arr[count-1];
			arr[count-1] = arr[count];
			count--;
			return ret;
		}
	}
	
	public int size() {	// ���� ���� ����
		return count;
	}
	
	public int isEmpty() {
		if( count==0 ) {
			return 1;
		}
		else
			return 0;
	}
	
	public int top() {
		if( isEmpty() == 1) {
			return -1;
		}
		else {
			return arr[count-1];
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// ��ɾ� ��
		int N = Integer.parseInt(br.readLine());
		
		// ��ɾ� �� ũ���� Stack ��ü ����.
		Stack stack = new Stack(N);
		
		// ��ɾ� ����ŭ �ݺ�.
		for( int i=0; i<N; i++ ) {
			// ��ɾ� �Է�.
			String str = br.readLine();
			
			// ���� ���� ����.
			st = new StringTokenizer(str, " ");
			
			String op = st.nextToken();
			
			if( op.equals("push") ) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if( op.equals("pop") ){
				System.out.println(stack.pop());
			}
			else if( op.equals("size") ) {
				System.out.println(stack.size());
			}
			else if( op.equals("empty") ) {
				System.out.println(stack.isEmpty());
			}
			else if( op.equals("top") ) {
				System.out.println(stack.top());
			}
			else {
				System.out.println("unacceptable op");
			}
			
		}
	}

}
