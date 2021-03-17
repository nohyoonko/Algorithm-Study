import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시뮬레이션, 수학
 * 1. 수학적 규칙 찾아서 해결
 * 		x축 기준 2 * w의 사이클 주기가 있어 time을 더해서 주기 안에서의 위치 측정
 * 		p를 2 * w로 나눈 나머지가 w를 넘었을 때, 전체의 길이(2 * w)에서 현재 개미가 간 거리를 뺌
 */

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int w = Integer.parseInt(st.nextToken()); // 2 <= w <= 40,000
		int h = Integer.parseInt(st.nextToken()); // 2 <= h <= 40,000
		
		st = new StringTokenizer(in.readLine(), " "); 
		int p = Integer.parseInt(st.nextToken()); // 초기위치 열, 0 < p < w
		int q = Integer.parseInt(st.nextToken()); // 초기위치 행, 0 < q < h
		
		int t = Integer.parseInt(in.readLine()); // 개미가 움직일 시간, 1 <= t <= 200,000,000

		p += t; q += t;
		p %= (2 * w); q %= (2 * h);
		
		if (p > w) p = 2 * w - p;
		if (q > h) q = 2 * h - q;
		
		System.out.println(p + " " + q);
	}

}
