
/*
* BOJ #8958 OX퀴즈
* 2020.08.11
*/

#include <iostream>
#include <vector>
using namespace std;

void marking(string answer) {
    int score = 0, total = 0;

    for (int i = 0; i < answer.size(); i++) {
        if (answer[i] == 'O') {
            score += 1;
        }
        else { //answer[i] == 'X'
            score = 0;
        }
        total += score;
    }

    cout << total << endl;
    return;
}

int main() {
    vector<string> v;
    int num;
    string tmp;

    cin >> num; //testcase #
    for (int i = 0; i < num; i++) { //input
        cin >> tmp;
        v.push_back(tmp);
    }

    for (int i = 0; i < v.size(); i++) { //solution
        marking(v[i]);
    }

    return 0;
}