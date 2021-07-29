import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static class Puyo {
        int r, c;
        char color;

        public Puyo(int r, int c, char color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
    
    static int N = 12, M = 6;
    static char field[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        field = new char[N][];

        for (int i = 0; i < N; i++) {
            field[i] = in.readLine().toCharArray();
        }

        int answer = 0;
        while (checkSameColor()) {
            downPuyo();
            answer++;
        }
        System.out.println(answer);
    }

    static int dr[] = new int[] {1, -1, 0, 0};
    static int dc[] = new int[] {0, 0, 1, -1};

    private static boolean checkSameColor() {
        boolean flag = false;
        Queue<Puyo> queue = new LinkedList<>();
        List<Puyo> list = new ArrayList<>();
        boolean visited[][] = new boolean[N][M];

        for (int r = N - 1; r >= 0; r--) { // 맨 바닥부터 올라가기
            for (int c = 0; c < M; c++) {
                if (visited[r][c] || field[r][c] == '.') continue;

                int same = 1;
                list.clear();

                visited[r][c] = true;
                queue.offer(new Puyo(r, c, field[r][c]));
                list.add(new Puyo(r, c, field[r][c]));

                while (!queue.isEmpty()) {
                    Puyo cur = queue.poll();
                    int cr = cur.r;
                    int cc = cur.c;

                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];

                        if (nr >= 0 && nr < N && nc >=0 && nc < M && !visited[nr][nc] && cur.color == field[nr][nc]) {
                            visited[nr][nc] = true;
                            queue.offer(new Puyo(nr, nc, field[nr][nc]));
                            list.add(new Puyo(nr, nc, field[nr][nc]));
                            same++;
                        }
                    }
                }

                if (same >= 4) {
                    bombPuyo(list);
                    flag = true;
                }
            }
        }

        return flag;
    }

    private static void bombPuyo(List<Puyo> list) {
        for (Puyo p: list) {
            field[p.r][p.c] = '.';
        }
    }

    /**
     * 폭탄이 터져서 한 칸씩 내려오는 것을 배열 새로 만들어서 옮김.
     */
    private static void downPuyo() {
        char newField[][] = new char[N][M];
        Queue<Character> horizontal = new LinkedList<>();

        for (int c = 0; c < M; c++) { // 열 하나마다
            horizontal.clear();
            for (int r = N - 1; r >= 0; r--) { // 행 하나씩 위로 올라감
                if (field[r][c] == '.') continue;
                horizontal.offer(field[r][c]);
            }

            for (int r = N - 1; r >= 0; r--) {
                if (!horizontal.isEmpty())
                    newField[r][c] = horizontal.poll();
                else
                    newField[r][c] = '.';
            }
        }

        field = newField;
    }

}
