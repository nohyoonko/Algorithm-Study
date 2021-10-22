import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_아기상어 {
	
	static class Shark {
		int x, y, time;

		public Shark(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N, sharkSize, eatCnt, answer;
	static boolean isUpdate;
	static int[][] space;
	static Shark shark;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		space = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 9) {
					shark = new Shark(i, j, 0);
				}
				space[i][j] = input;
			}
		}
		
		sharkSize = 2;
		isUpdate = true;
		while (isUpdate) {
			isUpdate = false;
			bfs();
			// 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가.
			if (eatCnt == sharkSize) {
				eatCnt = 0;
				sharkSize++;
			}
		}
		System.out.println(answer);
	}
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	private static void bfs() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Shark> pq = new PriorityQueue<>(new Comparator<Shark>() {

			@Override
			public int compare(Shark o1, Shark o2) {
				// 가장 빠른 시간 -> 가장 위 -> 가장 왼쪽 
				if (o1.time == o2.time) {
					if (o1.x == o2.x) {
						return o1.y - o2.y;
					} else {
						return o1.x - o2.x;
					}
				} else {
					return o1.time - o2.time;
				}
			}
			
		});
		
		visited[shark.x][shark.y] = true;
		pq.offer(shark);
		space[shark.x][shark.y] = 0;
		
		while (!pq.isEmpty()) {
			Shark cur = pq.poll();
			
			// 먹을 수 있음.
			if (space[cur.x][cur.y] != 0 && space[cur.x][cur.y] < sharkSize) {
				space[cur.x][cur.y] = 0;
				answer += cur.time;
				shark = new Shark(cur.x, cur.y, 0);
				eatCnt++;
				isUpdate = true;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dr[d];
				int ny = cur.y + dc[d];
				int ntime = cur.time + 1;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && space[nx][ny] <= sharkSize) {
					// 지나갈 수 있음.
					visited[nx][ny] = true;
					pq.offer(new Shark(nx, ny, ntime));
				}
			}
		}
	}
	
}
