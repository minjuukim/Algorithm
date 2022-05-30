package day0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals(".")) break;
			
			sb.append(solve(str)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static String solve(String str) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c==')') {
				if(stack.empty() || stack.peek()!='(') {
					return "no";
				} else {
					stack.pop();
				}
			} else if(c==']') {
				if(stack.empty() || stack.peek()!='[') {
					return "no";
				} else {
					stack.pop();
				}
			} else if(c=='(' || c=='[') {
				stack.push(c);
			} 
		}
		
		if(stack.isEmpty()) {
			return "yes";
		} else return "no";
	}

}
