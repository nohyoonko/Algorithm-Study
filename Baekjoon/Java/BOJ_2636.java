import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2636 {

	public static int N, M, cheeze, cnt, time;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 입력받으면서 치즈 개수 체크
				if (map[i][j] == 1) cheeze++;
			}
		}
		
		while (cheeze > 0) {
			time++;
			cnt = cheeze;
			bfs();
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0});
		visited = new boolean[N][M];
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				
				if (map[nr][nc] == 1) {
					cheeze--;
					map[nr][nc] = 0;
				} else if (map[nr][nc] == 0) { // 공기를 Queue에 넣는다!
					queue.offer(new int[] {nr, nc});
				}
				
				visited[nr][nc] = true;
			}
		}
	}
	
}
