import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            // 네 정수 입력
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int[] first = new int[2];
            int[] second = new int[2];
            first[0] = Integer.parseInt(st.nextToken());
            first[1] = Integer.parseInt(st.nextToken());
            second[0] = Integer.parseInt(st.nextToken());
            second[1] = Integer.parseInt(st.nextToken());
             
            // 가로이동 -> 세로이동 -> 가로이동
            int start_x = first[0];
            int start_y = first[1];
            boolean change = false;
            int moveGaro = 0;
            while (true) {
                if (start_x == second[0] && start_y == second[1]) break;
                 
                if (!change) {
                    if (start_x < second[0]) start_x++;
                    else start_x--;
                    change = true;
                }
                else {
                    if (start_y < second[1]) start_y++;
                    else start_y--;
                    change = false;
                }
                moveGaro++;
            }
             
            // 세로이동 -> 가로이동 -> 세로이동
            start_x = first[0]; start_y = first[1];
            change = true;
            int moveSero = 0;
            while (true) {
                if (start_x == second[0] && start_y == second[1]) break;
                 
                if (!change) {
                    if (start_x < second[0]) start_x++;
                    else start_x--;
                    change = true;
                }
                else {
                    if (start_y < second[1]) start_y++;
                    else start_y--;
                    change = false;
                }
                moveSero++;
            }
             
            // 둘의 최소 비교 후 최소값 갱신
            int min = Math.min(moveGaro, moveSero);
            sb.append("#").append(test_case).append(" ").append(min).append("\n");
        }
         
        System.out.print(sb);
    }
 
}
