/*
*   Programmers
*   Lv.3 섬 연결하기 - Greedy
*   2020.10.16
*/
#include <vector>
#include <algorithm>

using namespace std;

vector<int> parent(101); // 최상위 부모 섬을 담을 배열

bool compare(vector<int> a, vector<int> b) {
    return a[2] < b[2];
}

int findParent(int x) {
    // 최상위 부모 섬을 찾을 때까지 재귀적으로 나아감
    if (x == parent[x]) return x;
    else return parent[x] = findParent(parent[x]);
}

bool connect(int a, int b) {
    // 두 섬의 최상위 부모 섬을 찾음
    a = findParent(a);
    b = findParent(b);

    // 최상위 부모가 서로 같으면 사이클이 생기므로 다리를 설치하지 않음
    if (a == b) return false;
    else {
        // 최상위 부모 섬을 배열에 기록
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }
    return true;
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    for (int i = 0; i < n; i++) parent[i] = i;

    sort(costs.begin(), costs.end(), compare); // 비용 오름차순으로 정렬
    for (int i = 0; i < costs.size(); i++) {
        //다리를 잇는 작업 but 만약 false라면 사이클이 생기는 경우로 다리를 설치하지 않음
        if (connect(costs[i][0], costs[i][1]) == true) answer += costs[i][2];
    }

    return answer;
}
