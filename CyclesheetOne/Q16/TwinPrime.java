package Q16;

import java.util.Scanner;

public class TwinPrime extends Prime {
    public static void checkTwinPrime(int x, int y) throws NotTwinException, NotPrimeException {
        try {
            checkPrime(x);
        } catch (NotPrimeException e) {
            throw e;
        }
        try {
            checkPrime(y);
        } catch (NotPrimeException e) {
            throw e;
        }
        if (x - y != -2 && x - y != 2) {
            throw new NotTwinException("Difference not = 2");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                checkTwinPrime(x, y);
                System.out.println("Valid twin prime numbers: " + x + " & " + y);
            } catch (NotPrimeException e) {
                System.out.println("Numbers not prime!");
            } catch (NotTwinException e) {
                System.out.println("Numbers not twin prime!");
            }
        }
        sc.close();
    }
}
