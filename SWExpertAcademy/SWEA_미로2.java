import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_미로2 {
	
	final static int size = 100;
	static char[][] map;
	static int answer;
	
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(in.readLine());
			
			int sr = 0, sc = 0;
			map = new char[size][size];
			for (int i = 0; i < size; i++) {
				String s = in.readLine();
				char[] c = s.toCharArray();
				for (int j = 0; j < size; j++) {
					map[i][j] = c[j];
					// 시작점 찾기
					if (map[i][j] == '2') {
						sr = i;
						sc = j;
					}
				}
			}
			
			answer = 0;
			bfs(sr, sc);
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[size][size];
		
		// 시작점을 큐에 넣고 true로 바꾸기
		queue.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while (!queue.isEmpty()) {
			// 큐의 맨 앞에 있는 것 가져와서 확인
			int[] q = queue.poll();
			int r = q[0], c = q[1];
			
			if (map[r][c] == '3') { // 도착점 찾으면 1로 바꿔주고 종료
				answer = 1;
				return;
			}
			for (int d = 0; d < 4; d++) { // 4방 탐색
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// nr, nc가 범위 안에 있는지 확인
				// 방문하지 않았는지 확인
				// 장애물이 아닌지 확인
				if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 &&
						!visited[nr][nc] && map[nr][nc]!='1') {
					// 갈 수 있으면 큐에 넣어서 계속 진행
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
