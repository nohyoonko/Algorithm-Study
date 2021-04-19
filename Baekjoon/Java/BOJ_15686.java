import java.io.*;
import java.util.*;

// 치킨 배달
// 0: 빈칸, 1: 집, 2: 치킨집
// "치킨 거리"는 집과 가장 가까운 치킨집 사이의 거리 = |r1-r2| + |c1-c2|
// 도시의 치킨 거리는 모든 집의 치킨 거리의 합
// 치킨집 최소 개수를 유지하면서 도시의 치킨 거리의 최소값 구하기

public class Main {

	static class Position {
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, M, city;
	static ArrayList<Position> house, chicken;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new ArrayList<Position>();
		chicken = new ArrayList<Position>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) house.add(new Position(i, j));
				else if (input == 2) chicken.add(new Position(i, j));
			}
		}
		
		city = Integer.MAX_VALUE;
		// M개의 치킨집인 모든 조합 구해서 도시의 치킨 거리 최소값 구하기
		combination(0, 0, new ArrayList<Position>());
		
		System.out.println(city);
	}
	
	public static void combination(int cnt, int startIdx, ArrayList<Position> selectChicken) {
		if (cnt == M) {
			calcChickenDistance(selectChicken);
			return;
		}
		
		for (int i = startIdx; i < chicken.size(); i++) {
			selectChicken.add(chicken.get(i));
			combination(cnt + 1, i + 1, selectChicken);
			selectChicken.remove(chicken.get(i));
		}
	}
	
	static void calcChickenDistance(ArrayList<Position> selectChicken) {
		int total = 0;
		for (Position h : house) {
			int min = Integer.MAX_VALUE;
			for (Position c : selectChicken) {
				int distance = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
				if (min > distance) min = distance;
			}
			total += min;
		}
		if (city > total) city = total;
	}

}
