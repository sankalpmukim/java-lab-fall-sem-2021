import java.util.Scanner;

public class Q5 {
    private static void rotateLeft(String[][] arr, int i) {
        int k = i;
        while (k > 0) {
            String leftMost = arr[i][0];
            for (int j = 0; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i][j + 1];
            }
            arr[i][arr[i].length - 1] = leftMost;
            k--;
        }
    }

    private static void rotateUpwards(String[][] arr, int j) {
        int k = j;
        while (k > 0) {
            String leftMost = arr[0][j];
            for (int m = 0; m < arr[j].length - 1; m++) {
                arr[m][j] = arr[m + 1][j];
            }
            arr[arr[j].length - 1][j] = leftMost;
            k--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] arr = new String[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.next();
            }
        }
        sc.close();

        for (int i = 0; i < arr.length; i++) {
            rotateLeft(arr, i);

        }

        for (int i = 0; i < arr.length; i++) {
            rotateUpwards(arr, i);
        }

        System.out.println("Output:");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
