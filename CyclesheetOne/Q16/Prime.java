package Q16;

public class Prime {
    public static void checkPrime(int n) throws NotPrimeException {
        for (int i = 2; i <= n / 2; i++) {
            if ((n % i) == 0) {
                throw new NotPrimeException("" + n + " is not a prime number");
            }
        }
    }
}
