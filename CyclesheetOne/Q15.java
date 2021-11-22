import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int LIMIT = 10;
        int[] arr = new int[10];

        int i = 0;

        while (i < LIMIT) {
            try {
                arr[i] = sc.nextInt();
                i++;
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Array inputted: " + Arrays.toString(arr));

        sc.close();
    }
}
