import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S3_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		boolean check = false; // 태그안에 있는 문자면 true, 밖에 있는 문자면 false

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '<') {
				check = true; // 태그 안을 표시

				// 스택에 저장되어 있는 것을 전부 pop하면서 버퍼에 저장
				while (!stack.isEmpty()) {
					sb.append(stack.pop()); // 문자열 거꾸로 출력
				}

				sb.append(c); // '<' 표시

			} else if (c == '>') {
				check = false;
				sb.append(c); // '>' 표시
			} else if (check) { // 태그 안에 있으면 순서 그대로 출력
				sb.append(c);

			} else { // <> 밖에 있으면
				
				if (c == ' ') { // 공백이라면
					
					// 스택에 저장되어 있는 것을 전부 pop하면서 버퍼에 저장
					while (!stack.isEmpty()) {
						sb.append(stack.pop()); // 문자열 거꾸로 출력
					}
					sb.append(" "); // 공백 출력
					
				} else { // 공백이 아니면
					stack.push(c); // 스택에 추가
				}
			}
		}

		// 나머지 스택에 저장되어 있는 것을 다 pop하면서 출력
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
