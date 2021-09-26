package Q3;

import java.util.Scanner;

public class Q32 {
    private static String stringMultiplier(String x, int n) {
        String initString = "";
        for (int i = 0; i < n; i++) {
            initString += x;
        }
        return initString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        // First Half
        for (int i = 1; i <= n; i++) {
            System.out.print(stringMultiplier(" ", (n - i)) + "1");
            if (i > 1) {
                System.out.println(stringMultiplier(" ", ((i - 1) * 2) - 1) + i);
            } else {
                System.out.println("");
            }
        }
        // Second Half
        for (int i = n - 1; i >= 1; i--) {
            System.out.print(stringMultiplier(" ", (n - i)) + "1");
            if (i > 1) {
                System.out.println(stringMultiplier(" ", ((i - 1) * 2) - 1) + i);
            } else {
                System.out.println("");
            }
        }
    }
}
