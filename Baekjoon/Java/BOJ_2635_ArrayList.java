// 2635번 수 이어가기
//	1. 첫번째 수는 양의 정수
//	2. 두번째 수는 양의 정수 중 하나 선택(랜덤)
//	3. 세번째 수부터는 i-2번째 수 - i-1번째 수
//	4. 음의 정수가 만들어지면, 이 음의 정수를 버리고 끝
// 이 규칙으로 만들어지는 최대 개수의 수들을 구하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2635_ArrayList {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int max = -1;
		for (int i = N; i >= N / 2; i--) { // 두번째 수는 랜덤
			list.add(N);
			list.add(i);
			int idx = 2;
			while (list.get(idx - 2) - list.get(idx - 1) >= 0) { // 세번째 수부터 음수 나올 때까지
				list.add(list.get(idx - 2) - list.get(idx - 1));
				idx++;
			}
			if (max < list.size()) { // 최대값 갱신
				max = list.size();
				answer = (ArrayList<Integer>) list.clone();
			}
			list.clear();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n");
		for (int i : answer) {
			sb.append(i).append(" ");
		}
		System.out.print(sb);
	}
	
}
