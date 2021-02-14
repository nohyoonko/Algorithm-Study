class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] dates = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day = -1; // 0으로 하면 1월 1일도 계산이 됨
        for (int i = 0; i < a - 1; i++) {
            day += dates[i];
        }
        day += b;
        
        answer = days[day % 7];
        return answer;
    }
}
