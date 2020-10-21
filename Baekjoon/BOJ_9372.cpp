/*
*   Baekjoon
*   #9372 상근이의 여행 - 그래프, MST
*   2020.10.18
*/
#include <iostream>
using namespace std;

int main(void) {
    int T;
    cin >> T;

    for(int i=0; i<T; i++) {
        int N, M;
        cin >> N >> M;
        for (int i=0; i<M; i++) {
            int a, b;
            cin >> a >> b;
        }
        // MST는 항상 간선의 개수가 N-1개
        cout << N - 1 << '\n';
    }
    
    return 0;
}
