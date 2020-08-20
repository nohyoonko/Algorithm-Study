/* 
*   Baekjoon
*   #14501 퇴사 - DP, Brute Force
*   2020.08.19
*/
#include <iostream>
#include <vector>
#define MAX(a, b) a > b ? a : b
#define max 16 // 1 <= N <= 15
using namespace std;

int N, result = -1;
int D[max]; // i번째 날 받을 수 있는 최대 금액을 기록
vector<int> T, P; // T: 일하는데 걸리는 기간, P: 일하고 받는 금액

void maxProfit(void) {
	// 마지막 날 하루 일하는 것까지 계산하기 위해 N + 1까지
	for (int i = 1; i <= N + 1; i++) {
		for (int j = 1; j < i; j++) {
			// j번째 날에서 일을 안 하고 i번째 날까지 온 경우
			D[i] = MAX(D[i], D[j]);

			// j번째 날에서 T[j] 기간 동안 일을 하고 P[j]를 받은 경우(돈은 j + t[j]날 받음)
			if (j + T[j] == i) 
				D[i] = MAX(D[i], D[j] + P[j]);
		}

		// 매번 최대값 갱신
		result = MAX(result, D[i]);
	}
	cout << result << '\n';
}

int main(void) {
	int t, p;

	cin >> N;

	T.push_back(0);
	P.push_back(0);
	for (int i = 0; i < N; i++) {
		cin >> t >> p;
		T.push_back(t);
		P.push_back(p);
	}

	maxProfit();
}
