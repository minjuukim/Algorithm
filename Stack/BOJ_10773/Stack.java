package step_11to20.BOJ_10773;

import java.util.Scanner;

public class Stack {
	int[] arr;
	int count;
	
	public Stack (int size) {
		arr = new int[size];
		count = 0;
	}
	
	public void push(int data) {
		if( count == 0) {
			
		}
		arr[count] = data;
		count++;
	}
	
	public int pop() {
		if( count == 0 ) {
			System.out.println("Stack is empty.");
			return -1;
		}
		else {
			int ret = arr[count];
			arr[count-1] = arr[count];
			count--;
			return ret;
		}
	}
	
	public int sum() {
		int sum=0;
		for(int i=0; i<count; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();	// 명령어 개수 
		int data;
		Stack stack = new Stack(K);

		for( int i=0; i<K; i++) {
			data = sc.nextInt();
			if( data == 0 ) {
				stack.pop();
			}
			else {
				stack.push(data);
			}	
		}
		System.out.println(stack.sum());
	}

}
