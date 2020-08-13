/*
* Programmers - 2016
* Lv.1
* 2020.08.12
*/

#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    
    //윤년: 2월 29일이 있으므로 366일
    string days[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int dates[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //1월 1일 금요일 = 5
    int first_day = 5;
    
    int total_date = 0;
    for(int i=0; i<a-1; i++){
        total_date += dates[i];
    }
    total_date += b-1;
    
    answer = days[(first_day+(total_date%7))%7];
    return answer;
}

int main(void) {
    int a, b, result;
    cin >> a >> b;
    
    result = solution(a, b);
    cout << result;
    
    return 0;
}
