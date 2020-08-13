/*
* Programmers - Mock test
* Brute-Force Lv.1
* 2020.02.20
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> correct(3); // count the number of correct answers for each person
    vector<int> a = {1,2,3,4,5};
    vector<int> b = {2,1,2,3,2,4,2,5};
    vector<int> c = {3,3,1,1,2,2,4,4,5,5};
    
    int correctA = 0, correctB = 0, correctC = 0;
    
    for(int i=0; i<answers.size(); i++){
        // Check the answers of a, b, and c over and over again ex. 1, 2, 3, 4, 5, 1, 2, 3, ...
        if(answers[i] == a[i % a.size()]) correct[0]++; // person 1(a)
        if(answers[i] == b[i % b.size()]) correct[1]++; // person 2(b)
        if(answers[i] == c[i % c.size()]) correct[2]++; // person 3(c)
    }
    
    int max = *max_element(correct.begin(), correct.end());
    
    for(int i=0; i<3; i++){
        if(correct[i] == max) answer.push_back(i+1);
    }
    
    return answer;
}

int main(void){
    int size;
    cin >> size;

    vector<int> answers(size);
    for(int i=0; i<size; i++){
        cin >> answers[i];
    }

    vector<int> result = solution(answers);
    for(int i=0; i<result.size(); i++){
        cout << result[i];
    }

    return 0;
}
