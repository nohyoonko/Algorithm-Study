/**
 * 
 * 시뮬레이션, 완전탐색
 *
 */

import java.util.Scanner;

public class BOJ_2635_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력: Scanner
		int N = sc.nextInt(); // 1 <= N <= 30,000

		int maxCnt = Integer.MIN_VALUE; // 수열 길이의 최대값
		String maxResult = ""; // 최대 수열을 저장할 문자열
		for (int i = N; i <= N / 2; i++) { // 두번째 숫자 만들기, 1<=?<=N 반복
			// N, i, N-i, i-(N-i), ...
			int x = N; // 첫번째 숫자
			int y = i; // 두번째 숫자
			int temp; // 세번째 숫자
			StringBuilder result = new StringBuilder(x + " " + y); // 출력할 수열을 문자열로 저장(아이디어)
			int cnt = 2; // 수열의 길이

			while (true) { // 수열 생성
				temp = x - y;
				if (temp < 0) {
					if (maxCnt < cnt) {
						maxCnt = cnt; // 최대값 업데이트
						maxResult = result.toString();
					}
					break; // 음수가 되면 종료
				}
				result.append(" ").append(temp);
				cnt++; // N ? ... 수열의 개수 카운팅
				x = y;
				y = temp;
			} // end of while
		} // end of for
		// 출력: 수열 최대 길이, 수열
		System.out.println(maxCnt);
		System.out.println(maxResult);
	} // end of main
} // end of class
