package com.algo.ws0324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1600 {
	
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	// 원숭이: 우, 하, 상, 좌
	static int[] mr = {0, 1, -1, 0};
	static int[] mc = {1, 0, 0, -1};
	// 말: 우하, 우상, 좌하, 좌상
	static int[] hr = {1, 2, -1, -2, 1, 2, -1, -2};
	static int[] hc = {2, 1, 2, 1, -2, -1, -2, -1};

	private static void bfs() {
		Queue<State> queue = new LinkedList<State>();
		visited = new boolean[H][W][K + 1];
		
		visited[0][0][0] = true;
		queue.offer(new State(0, 0, 0, 0));
		
		while (!queue.isEmpty()) {
			State cur = queue.poll();
			
			if (cur.r == H - 1 && cur.c == W - 1) {
				answer = cur.cnt;
				return;
			}
			
			// 말 점프를 할 수 있으면, 말 점프로 먼저 가지만 12번 다 봐야함!
			if (cur.jump < K) {
				for (int i = 0; i < 8; i++) {
					int nr = cur.r + hr[i];
					int nc = cur.c + hc[i];
					if (isAvailable(nr, nc, cur.jump + 1)) {
						visited[nr][nc][cur.jump + 1] = true;
						queue.offer(new State(nr, nc, cur.cnt + 1, cur.jump + 1));
					}
				}
			}
			// 못 한다면, 원숭이로만 감!
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + mr[i];
				int nc = cur.c + mc[i];
				if (isAvailable(nr, nc, cur.jump)) {
					visited[nr][nc][cur.jump] = true;
					queue.offer(new State(nr, nc, cur.cnt + 1, cur.jump));
				}
			}
		}
	}
	
	public static boolean isAvailable(int r, int c, int k) {
		// 범위를 벗어나면 pass
		if (r < 0 || c < 0 || r >= H || c >= W) return false;
		// 벽이면 pass
		if (map[r][c] == 1) return false;
		// 이미 방문한 곳이면 pass
		if (visited[r][c][k]) return false;
        
        return true;
	}
	
	static class State {
		int r, c, cnt, jump;

		public State(int r, int c, int cnt, int jump) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.jump = jump;
		}
	}
}
