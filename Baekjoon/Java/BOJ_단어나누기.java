import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_단어나누기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int N = word.length();

        ArrayList<String> list = new ArrayList<>();
        StringBuilder cut = new StringBuilder();
        // 나누는 기준점을 i, j로
        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                String first = cut.append(word.substring(0, i)).reverse().toString();
                cut.setLength(0); // 비우기

                String second = cut.append(word.substring(i, j)).reverse().toString();
                cut.setLength(0);

                String third = cut.append(word.substring(j, N)).reverse().toString();
                cut.setLength(0);

                list.add(first + second + third);
            }
        }

        Collections.sort(list);
        System.out.print(list.get(0));
    }

}
