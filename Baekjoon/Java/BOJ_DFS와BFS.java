import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static boolean graph[][], visited[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		/*
		 * input
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		
		graph = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = graph[to][from] = true; // 양방향
		}
		
		/*
		 * solution & output
		 */
		sb = new StringBuilder();
    
		visited = new boolean[N + 1];
		visited[V] = true;
		DFS(1, V);
		
    sb.append("\n");
		
    BFS();
    
		System.out.println(sb.toString());
	}

	private static void DFS(int cnt, int now) {
		sb.append(now).append(" ");
		if (cnt == N) return;
		
		for (int i = 1; i < graph.length; i++) {
			if (i == now) continue;
			
			if (!visited[i] && graph[now][i]) {
				visited[i] = true;
				DFS(cnt + 1, i);
			}
		}
	}
	
	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N + 1];
		
    visited[V] = true;
		queue.offer(V);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");;
			
			for (int i = 1; i < graph.length; i++) {
				if (i == now) continue;
				
				if (!visited[i] && graph[now][i]) { // 이동할 수 있는 정점
					visited[i] = true;
          queue.offer(i);
				}
			}
		}
	}
	
}
