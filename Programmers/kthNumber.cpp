/*
* Programmers - Kth Number
* Sort Lv.1
* 2020.08.18
*/
#include <iostream>
#include <vector>
#include <algorithm> //sort

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    int start, end, nth;

    for (int i = 0; i < commands.size(); i++) {
        vector<int> cut;
        start = commands[i][0];
        end = commands[i][1];
        nth = commands[i][2];

        for (int j = start - 1; j < end; j++) {
            cut.push_back(array[j]);
        }
        sort(cut.begin(), cut.end());
        answer.push_back(cut[nth - 1]);
    }
    return answer;
}

int main(void) {
    vector<int> array = { 1, 5, 2, 6, 3, 7, 4 };
    vector<vector<int>> commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} };

    vector<int> answer = solution(array, commands);

    for (int i : answer) {
        cout << i << " "; //{5, 6, 3}
    }

    return 0;
}
