/*
*	Programmers - Carpet
*	Brute-Force Lv.2
*	2020.08.25
*/
#include <cmath> //sqrt()
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;

    int x, y, total;
    bool find = false;
    total = brown + yellow; //전체 크기
    for(x=3; x<total/2; x++) {
        for(y=3; y<total/2; y++) {
            if(x*y == total && y <= sqrt(total) && ((x-2)*(y-2)==yellow)) {
                find = true;
                break;
            }
        }
        if(find) break;
    }
    answer.push_back(x);
    answer.push_back(y);

    return answer;
}
