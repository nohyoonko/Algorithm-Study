/* 
*   Baekjoon
*   #2003 수들의 합 2 - Brute Force
*   2020.08.24
*/
#include <iostream>
#include <vector>
using namespace std;

void solution(vector<int> A, int M) {
	int caseNum = 0, len = A.size();

	for (int i = 0; i < len; i++) {
		if (A[i] == M) { //자기 자신이 M인 경우
			caseNum++;
			continue;
		}
		int sum = A[i]; //합을 체크할 변수
		for (int j = i + 1; j < len; j++) {
			if (sum + A[j] < M) { //M보다 작으면 계속 더하면서 확인
				sum += A[j];
			}
			else if (sum + A[j] == M) { //M이랑 같으면 경우의 수++
				caseNum++;
				break;
			}
			else { //M보다 크면 더 볼 필요 없음
				break;
			}
		}
	}

	cout << caseNum;
}
int main(void) {
	int N, M;
	cin >> N >> M;

	vector<int> A(N);
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}

	solution(A, M);

	return 0;
}
