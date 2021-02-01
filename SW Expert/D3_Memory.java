import java.util.Scanner;

public class SW_Memory {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
	
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] m = sc.next().toCharArray();
			int len = m.length;

			int ans = 0;
			char first = '0';
			for (int i = 0; i < len; i++) {
        // char[len]을 만들어서 for문으로 직접 바꿔주면서 구현했었는데
				// 앞뒤만 비교해서 다르면 바꿔주면 되니까 pivot(first 변수)을 기준으로 비교만 하면 됨.
				if (m[i] != first) {
					ans++;
					first = m[i];
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
		
		sc.close();
	}
