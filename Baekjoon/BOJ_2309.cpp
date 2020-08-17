/*
*   Baekjoon
*   #2309 일곱 난쟁이 - Brute Force
*   2020.08.16
*/
#include <iostream>
#include <vector>
#include <algorithm> //sort

using namespace std;

void solution(vector<int> heights) {
    int sum = 0, remain;
    bool find = false;

    for(int i:heights) { //전체의 합 구하기
        sum += i; 
    }

    remain = sum - 100; //100을 얼마나 초과하는지 계산

    //벡터 내의 두 개의 수가 합해서 remain이 되는 수를 찾아서 삭제
    for(auto iter=heights.begin(); iter!=heights.end()-1; iter++) {
        for(auto iter2=iter+1; iter2!=heights.end(); iter2++) {
            if((*iter) + (*iter2) == remain) {
                heights.erase(iter2);
                find = true;
                break;
            }
        }
        if(find) {
            heights.erase(iter);
            break;
        }
    }

    for(int i:heights) { //출력
        cout << i << '\n';
    }

    return;
}

int main(void) {
    int dwarf;
    vector<int> heights;

    for(int i=0; i<9; i++) { //9명의 난쟁이의 키 입력
        cin >> dwarf;
        heights.push_back(dwarf);
    }

    sort(heights.begin(), heights.end()); //오름차순으로 정렬
    
    solution(heights);

    return 0;
}
