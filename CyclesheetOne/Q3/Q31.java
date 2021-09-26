package Q3;

import java.util.Scanner;

public class Q31 {
    private static int numGenerator(int n) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            x += n * Math.pow(10, i);
        }
        return x;
    }

    public static void main(String[] args) {
        int sum = 0;
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum += numGenerator(i + 1);
            } else {
                sum -= numGenerator(i + 1);
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
