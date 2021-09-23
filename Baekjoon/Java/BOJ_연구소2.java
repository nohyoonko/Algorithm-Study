import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_연구소2 {

    static final int INF = 99999999;
    static int N, M, empty, answer = INF;
    static int[][] lab;
    static ArrayList<int[]> virusPos = new ArrayList<>();
    static ArrayList<int[]> combVirus = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                lab[r][c] = Integer.parseInt(st.nextToken());
                if (lab[r][c] == 2) virusPos.add(new int[] {r, c});
                else if (lab[r][c] == 0) empty++;
            }
        }

        combination(0, 0, new int[M]);
        System.out.print(answer == INF ? -1 : answer);
    }

    public static void combination(int cnt, int startIdx, int[] select) {
        if (cnt == M) {
            bfs(select);
            combVirus.clear();
            return;
        }

        for (int i = startIdx; i < virusPos.size(); i++) {
            select[cnt] = i;
            combination(cnt + 1, i + 1, select);
        }
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void bfs(int[] select) {
        // 선택된 조합에 따라 combVirus, newLab 정보 갱신
        // 주의) 선택되지 않은 바이러스는 0으로 바꿔줘야 함!
        int cnt = empty;
        int[][] newLab = copyArray();

        for (int i = 0; i < virusPos.size(); i++) {
            boolean flag = false;
            for (int j = 0; j < M; j++) {
                if (i == select[j]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                combVirus.add(virusPos.get(i));
            } else {
                int[] pos = virusPos.get(i);
                newLab[pos[0]][pos[1]] = 0;
                cnt++;
            }
        }

        // 조합마다 bfs로 최단 시간 확인하며 진행
        int maxTime = 0;
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < combVirus.size(); i++) {
            int[] v = combVirus.get(i);
            visited[v[0]][v[1]] = true;
            q.offer(new int[] {v[0], v[1], 0});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // 주의) 들어오자마자 0인 경우가 있어서 maxTime을 0으로 설정해야 함!
            if (cnt == 0) {
                answer = Math.min(answer, maxTime); // answer : 최단 시간 갱신
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                int nt = cur[2] + 1;

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && newLab[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, nt});
                    maxTime = Math.max(maxTime, nt); // nt : 마지막 도달하는 시간
                    cnt--;
                }
            }
        }
    }

    private static int[][] copyArray() {
        int[][] newArr = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                newArr[r][c] = lab[r][c];
            }
        }

        return newArr;
    }

}
