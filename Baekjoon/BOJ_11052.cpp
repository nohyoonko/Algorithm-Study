/*
*   Baekjoon
*   #11052 카드 구매하기 - DP
*   2020.09.27
*/
#include <iostream>
#include <vector>

using namespace std;

//전역변수로 선언하면 0으로 초기화됨
vector<int> p(10001);
int dp[1001];

void solution(int n){
    //n개의 카드를 넘어가면 안 되기 때문에 1<=j<=i
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            //최대값만 dp에 저장
            dp[i] = max(dp[i], p[j] + dp[i-j]);
        }
    }

    cout << dp[n] << '\n';
}
int main(void){
    int n;
    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> p[i];
    }

    solution(n);
}
