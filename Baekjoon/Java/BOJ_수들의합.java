import java.util.Scanner;

public class Main {

    static long S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLong();

        long sum = 0;
        long num = 0;
        while (S >= sum) {
            sum += (++num);
        }
        if (sum != S) num -= 1;

        System.out.print(num);
    }

}
