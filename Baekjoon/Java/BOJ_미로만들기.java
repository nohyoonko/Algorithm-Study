import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_미로만들기 {

    static int n;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int change = 0; change <= n * n; change++) {
            if (bfs(change)) {
                System.out.print(change);
                break;
            }
        }
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static boolean bfs(int changeCnt) {
        // changeCnt가 0으로 들어오면 배열 생성이 안 됨.
        boolean[][][] visited = new boolean[changeCnt + 1][n][n];
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0][0] = true;
        queue.offer(new int[] {0, 0, changeCnt});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            if (r == (n - 1) && c == (n - 1)) { // 도착점 도달
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[now[2]][nr][nc]) {
                    visited[now[2]][nr][nc] = true;
                    if (board[nr][nc] == '1') {
                        queue.offer(new int[] {nr, nc, now[2]});
                    } else if (board[nr][nc] == '0' && now[2] > 0) {
                        queue.offer(new int[] {nr, nc, now[2] - 1});
                    }
                }
            }
        }
        return false;
    }

}
