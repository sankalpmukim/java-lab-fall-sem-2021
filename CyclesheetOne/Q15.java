import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int LIMIT = 10;
        int[] iArr = new int[LIMIT];
        int intPtr = 0, floatPtr = 0;
        float[] fArr = new float[LIMIT];

        int i = 0;

        while (i < LIMIT) {
            try {
                iArr[intPtr] = sc.nextInt();
                intPtr++;
            } catch (InputMismatchException e) {
                fArr[floatPtr] = sc.nextFloat();
                floatPtr++;
            }

            i++;
        }

        System.out.println("Integer Array inputted: " + Arrays.toString(iArr));
        System.out.println("Total integer numbers: " + intPtr);
        System.out.println("Float Array inputted: " + Arrays.toString(fArr));
        System.out.println("Total float numbers: " + floatPtr);

        sc.close();
    }
}
