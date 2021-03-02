import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2292번 벌집
// #1	   #2		 #3
// 1번(1), 2-7번(6), 8-19번(12), ...

public class BOJ_2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int cnt = 1, start = 1, end = 1;
		while (true) {
			// cnt번째 방 범위 내에 있으면 반복 종료
			if (start <= N && N <= end) break;
			else {
				start = end + 1;
				end += 6 * cnt;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
}
