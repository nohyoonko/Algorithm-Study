import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_좌표압축 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 중복 제거, 정렬하기 위해서 TreeSet 사용
        Set<Integer> set = new TreeSet<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        // set : -10 -9 2 4
        // map : <-10, 0> <-9, 1> <2, 2> <4, 3>
        Map<Integer, Integer> map = new HashMap<>();
        Iterator iter = set.iterator();
        int cnt = 0;
        while (iter.hasNext()) {
            map.put((Integer) iter.next(), cnt++);
        }

        // 입력 순서대로 map에서 찾아서 출력
        StringBuilder output = new StringBuilder();
        for (String n : input) {
            output.append(map.get(Integer.parseInt(n))).append(" ");
        }
        System.out.print(output);
    }

}
