/*
*   Baekjoon
*   #2740 행렬 곱셈
*   2020.08.17
*/
#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    int N, M, K, tmp;

    /* input */
    cin >> N >> M;
    vector<vector<int> > A(N, vector<int>(M)); // N X M
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            cin >> A[i][j];
        }
    }
    
    cin >> M >> K;
    vector<vector<int> > B(M, vector<int>(K)); // M X K
    for(int i=0; i<M; i++) {
        for(int j=0; j<K; j++) {
            cin >> B[i][j];
        }
    }

    /* solution */
    vector<vector<int> > multi(N, vector<int>(K)); //곱한 행렬의 사이즈는 N X K
    for(int i=0; i<N; i++) {
        for(int j=0; j<K; j++) {
            for(int l=0; l<M; l++) {
                multi[i][j] += A[i][l] * B[l][j];
            }
        }
    }

    /* output */
    for(int i=0; i<N; i++) {
        for(int j=0; j<K; j++) {
            cout << multi[i][j] << " ";
        }
        cout << '\n';
    }

    return 0;
}
