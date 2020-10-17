/*
*   Baekjoon
*   #1922 네트워크 연결 - 그래프
*   2020.10.17
*/
#include <iostream>
#include <vector>
#include <algorithm> // sort
#define MAX 1000 + 1
using namespace std;

int N, M;
vector<vector<int>> computer;
int parent[MAX];

void input() {
    cin >> N >> M;

    int a, b, c;
    for(int i=0; i<M; i++){
        vector<int> v(3);
        cin >> v[0] >> v[1] >> v[2];
        computer.push_back(v);        
    }
}

bool compare(vector<int> a, vector<int> b) {
    return a[2] < b[2]; // 최소 비용 찾기
}

int findParent(int x) {
    // 최상위 부모가 일치하면 사이클 발생
    if (x == parent[x]) return x;
    else return parent[x] = findParent(parent[x]);
}

bool connect(int a, int b) {
    a = findParent(a);
    b = findParent(b);

    // 부모가 같으면 연결하지 않음
    if (a == b) return false;
    else {
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }
    return true;
}

void solution() {
    int answer = 0;
    for (int i=0; i<N; i++) parent[i] = i;

    sort(computer.begin(), computer.end(), compare); // 비용 오름차순 정렬
    for (int i=0; i<computer.size(); i++) {
        // false라면 사이클이 생기므로 연결하지 않음
        if (connect(computer[i][0], computer[i][1]) == true) {
            answer += computer[i][2]; // cost
        }
    }
    cout << answer << '\n';
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    input();
    solution();

    return 0;
}
