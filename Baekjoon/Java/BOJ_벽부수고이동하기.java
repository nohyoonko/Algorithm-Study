import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_벽부수고이동하기 {

        static int N, M, ans = Integer.MAX_VALUE;
        static int[][] map;
        static boolean[][][] visited;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[2][N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(str.charAt(j) + "");
                }
            }

            solve();

            System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
        }

        static int[] dr = new int[] { 0, 0, -1, 1 };
        static int[] dc = new int[] { -1, 1, 0, 0 };

        public static void solve() {
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(0, 0, 1, 0));

            while (!q.isEmpty()) {
                Node node = q.poll();

                int row = node.row;
                int col = node.col;
                int cnt = node.cnt;
                int bomb = node.bomb;

                // 탈출 지점 -> BFS는 최단거리로 가장 먼저 도착함
                if (row == N - 1 && col == M - 1) {
                    ans = cnt;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = row + dr[i];
                    int nc = col + dc[i];

                    if (isBoundary(nr, nc)) {
                        if (bomb == 1) {
                            if (!visited[bomb][nr][nc] && map[nr][nc] == 0) {
                                visited[bomb][nr][nc] = true;
                                q.offer(new Node(nr, nc, cnt + 1, bomb));
                            }
                        } else { // 벽을 안부순 상태
                            if (map[nr][nc] == 1) {
                                if (!visited[bomb + 1][nr][nc]) {
                                    visited[bomb + 1][nr][nc] = true;
                                    q.offer(new Node(nr, nc, cnt + 1, bomb + 1));
                                }
                            } else if (map[nr][nc] == 0) {
                                if (!visited[bomb][nr][nc]) {
                                    visited[bomb][nr][nc] = true;
                                    q.offer(new Node(nr, nc, cnt + 1, bomb));
                                }
                            }
                        }
                    }
                }
            }
        }

        public static boolean isBoundary(int row, int col) {
            if (row >= 0 && row < N && col >= 0 && col < M) return true;
            return false;
        }

        static class Node {
            int row, col, cnt, bomb;

            public Node(int row, int col, int cnt, int bomb) {
                super();
                this.row = row;
                this.col = col;
                this.cnt = cnt;
                this.bomb = bomb;
            }
        }

}
