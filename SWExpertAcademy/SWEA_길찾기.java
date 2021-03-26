import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
class Solution
{
    final static int MAX = 100;
    static int[][] map;
    static boolean available;
     
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
             
            map = new int[MAX][MAX];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                 
                map[from][to] = 1;
            }
             
            available = false;
            bfs();
            sb.append("#").append(tc).append(" ").append(available ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
     
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[MAX];
         
        visited[0] = true;
        queue.offer(0);
         
        while(!queue.isEmpty()) {
            int cur = queue.poll();
             
            if (cur == 99) {
                available = true;
                return;
            }
             
            for (int i = 0; i < MAX; i++) {
                if (!visited[i] && map[cur][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
