/*
*   Baekjoon
*   #14889 스타트와 링크 - Back Tracking
*   2021.01.24
*/
#include <iostream>
#include <vector>
using namespace std;

#define MAX_SIZE 21

int N;
bool selected[MAX_SIZE];
int S[MAX_SIZE][MAX_SIZE];
int answer = 1000000000; // 10억

// pos번 선수를 선택한다, cnt는 선택된 선수의 수
void DFS(int pos, int cnt) {
    // 기저조건 : N/2로 구성된 한 팀이 만들어짐
    if (cnt == N / 2) {
        vector<int> team_link, team_start;

        // 뽑혔으면 스타트 팀, 아니면 링크 팀
        for (int i = 1; i <= N; i++) {
            if (selected[i]) team_start.push_back(i);
            else team_link.push_back(i);
        }

        // 각 팀의 능력치 합 구하기
        int stat_start = 0, stat_link = 0;
        // 팀에 선택된 선수는 vector이기 때문에 0부터 시작
        for (int i = 0; i < team_start.size(); i++) {
            // team_start = [1,2,3]이므로 i+1부터 해야 (1,2) (1,3) (2,3) 의 조합이 만들어짐
            for (int j = i + 1; j < team_start.size(); j++) {
                stat_start += S[team_start[i]][team_start[j]] + S[team_start[j]][team_start[i]];
                stat_link += S[team_link[i]][team_link[j]] + S[team_link[j]][team_link[i]];
            }
        }

        // 두 팀의 차이 구해서 최소값 갱신
        answer = min(answer, abs(stat_start - stat_link));
        return;
    }

    // 팀 배정에서 중복이 일어난 경우를 막기 위해 N - 1까지, pos는 DFS로 넘어오기 전의 값을 기억해서 그 값보다 이전의 범위는 탐색하지 않게 하기 위해 필요
    // 두 팀의 차이를 보는 것이기 때문에 S(1,2,3) L(4,5,6)과 S(4,5,6) L(1,2,3)은 중복!
    for (int i = pos; i < N; i++) { // 전체 선수만큼 반복
        selected[i] = true;
        DFS(i + 1, cnt + 1); // pos: 다음 선수를 보기 위해 +1, cnt: 현재 선수를 true로 선택해서 +1
        selected[i] = false;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    cin >> N;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> S[i][j];
        }
    }
    DFS(1, 0); // pos는 1부터 cnt는 0부터 시작
    cout << answer << '\n';
    return 0;
}
