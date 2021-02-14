class Solution {
    public String solution(String s) {
        int mid = s.length() / 2;
        // 홀수인 경우(가운데 1글자), 짝수인 경우(가운데 2글자) 나눠서 수행
        if (s.length() % 2 == 0)
            return s.substring(mid - 1, mid + 1);
        else
            return s.substring(mid, mid + 1);
    }
}
