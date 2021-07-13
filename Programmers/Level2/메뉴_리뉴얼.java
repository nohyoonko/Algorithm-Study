import java.util.*;

public class Solution {
    static char[] single;
    static int num;
    static Map<String, Integer> menu;

    public static String[] solution(String[] orders, int[] course) {
        PriorityQueue <String> pq = new PriorityQueue<>(); // answer
        menu = new HashMap<>();

        for (int i = 0; i < course.length; i++) {
            // 메뉴 개수별로 조합
            num = course[i];
            for (int j = 0; j < orders.length; j++) {
                single = orders[j].toCharArray();
                Arrays.sort(single);
                comb(0, 0, new char[num]);
            }

            // 최대를 list에 저장
            List<String> maxMenu = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (String key : menu.keySet()) {
                if (max < menu.get(key) && menu.get(key) >= 2) {
                    max = menu.get(key);
                    maxMenu.clear();
                    maxMenu.add(key);
                } else if (max == menu.get(key)) {
                    maxMenu.add(key);
                }
            }

            // list에 있는 메뉴를 list에 옮기기(알파벳 오름차순)
            for (String s : maxMenu) {
                pq.offer(s);
            }
            menu.clear();
        }

        // String[]로 변환
        String[] answer = new String[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()){
            answer[idx++] = pq.poll();
        }
        return answer;
    }

    public static void comb(int cnt, int startIdx, char[] select) {
        if (cnt == num) {
            String curMenu = new String(select);
            if (!menu.containsKey(curMenu)) { // 없는 코스
                menu.put(curMenu, 1);
            } else {
                int curCnt = menu.get(curMenu);
                menu.put(curMenu, curCnt + 1);
            }
            return;
        }

        for (int i = startIdx; i < single.length; i++) {
            select[cnt] = single[i];
            comb(cnt + 1, i + 1, select);
        }
    }
}
