import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class CCTV {
		int num, r, c;

		public CCTV(int num, int r, int c) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, cctvCnt, answer;
	static CCTV[] cctvs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		cctvs = new CCTV[8];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) // CCTV
					cctvs[cctvCnt++] = new CCTV(map[i][j], i, j);
			}
		}
		
		answer = Integer.MAX_VALUE;
		dfs(0, map);
		System.out.println(answer);
	}

	// 방향(상, 우, 하, 좌)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][][] dir = { // 각 cctv가 볼 수 있는 영역(왼쪽으로 회전)
            {{0}},
            {{1}, {2}, {3}, {0}}, // 1번 cctv(우, 상, 좌, 하)
            {{1, 3}, {0, 2}}, // 2번 cctv(좌우, 상하)
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 cctv(상우, 상좌, 하좌, 하우)
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 cctv(상좌우, 상하좌, 하좌우, 상하우)
            {{0, 1, 2, 3}}, // 5번 cctv(상하좌우)
    };

	private static void dfs(int idx, int[][] map) {
		if (idx == cctvCnt) { // CCTV 방향 다 설정했으면, 사각지대 확인
			int remain = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) remain++;
				}
			}
			answer = Math.min(answer, remain);
			return;
		}

        CCTV current = cctvs[idx]; // 각 CCTV 확인
        
        for (int j = 0; j < dir[current.num].length; j++) { // 해당 CCTV가 왼쪽으로 90도씩 회전하며 감시
            int[][] newMap = new int[N][M];
            newMap = copy(map);
        	
            // 현재 상태에서 감시할 수 있는 방향
            for (int k = 0; k < dir[current.num][j].length; k++) {
                int d = dir[current.num][j][k];
                int nr = current.r;
                int nc = current.c;
                
                while(true) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || newMap[nr][nc] == 6) break;
                    newMap[nr][nc] = -1;
                }
            }
            
            dfs(idx + 1, newMap);
        }
	}
	
	private static int[][] copy(int[][] map) {
		int[][] newMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		return newMap;
	}
}
