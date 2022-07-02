package day0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_2234_성곽 {
	static int R, C, rooms;
	static String map[][];
	static int[][] visited;
	static int[] dr = {1, 0, -1, 0};	// 좌상우하
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());	
		R = Integer.parseInt(st.nextToken());	
		map = new String[R][C];
		int num = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				num = Integer.parseInt(st.nextToken());
				map[i][j] = toBinary(num);
			}
		}
		
		rooms = 0;	// 섬에 있는 방의 개수
		int maxRoom = 0;
		list = new ArrayList<>();	// 각 방의 칸의 개수
		list.add(0);
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visited[i][j]==0) {
					rooms++;
					list.add(bfs(i, j));
					maxRoom = Math.max(maxRoom, list.get(rooms));
				}
			}
		}
		
		System.out.println(rooms);
		System.out.println(maxRoom);
		System.out.println(brokenWall());
	}
	
	// 십진수 -> 이진수 로 변환
	public static String toBinary(int decimal) {
		String binary = "";
		for (int i = 3; i >= 0; i--) {
			binary = decimal%2 + binary;
			decimal /= 2;
		}
		return binary;
	}
	
	public static int bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[]{r, c});	// 초기에 (0,0)추가
		visited[r][c] = rooms;
		int cnt = 1;	// 방의 칸의 개수
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			String num = map[cur[0]][cur[1]];
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]!=0 || num.charAt(i)=='1') continue;
				
				visited[nr][nc] = rooms;
				cnt++;
				que.offer(new int[] {nr, nc});
			}
		}
		return cnt;
	}
	
	public static int brokenWall() {
		int brokenMax = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int roomNum = visited[i][j];	// 현재방 번호
				
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]==roomNum) continue;
					
					// 현재방 번호랑 다를 경우
					brokenMax = Math.max(brokenMax, list.get(roomNum) + list.get(visited[nr][nc]));
				}
			}
		}
		return brokenMax;
	}
}
