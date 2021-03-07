import java.util.*;

class Solution {
 	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		// n명의 학생이 모두 1개의 체육복을 가지고 있음
		int[] pe = new int[n + 1];
		for (int i = 1; i <= n; i++)
			pe[i] = 1;

		// lost 배열에 있는 학생들은 -1
		for (int i = 0; i < lost.length; i++)
			pe[lost[i]]--;
		// reserve 배열에 있는 학생들은 +1
		for (int i = 0; i < reserve.length; i++)
			pe[reserve[i]]++;

		// 체육복의 개수를 확인하면서 빌려주기
		for (int i = 1; i < pe.length; i++) {
			// 왼쪽 학생 확인
			if (pe[i] == 2 && i - 1 >= 1 && pe[i - 1] == 0) {
				pe[i]--;
				pe[i - 1]++;
			}
			// 오른쪽 학생 확인
			else if (pe[i] == 2 && i + 1 < pe.length && pe[i + 1] == 0) {
				pe[i]--;
				pe[i + 1]++;
			}
		}

		// 체육복 보유 현황으로 수업을 들을 수 있는 학생 확인
		for (int i = 1; i < pe.length; i++) {
			if (pe[i] >= 1)
				answer++;
		}

		return answer;
	}
}
