import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {
    private static int summer(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        List<int[]> jaggedArray = new ArrayList<int[]>();
        for (int i = 2; i < arr.length; i++) {
            int[] sumArray = new int[arr.length - i + 1];
            for (int j = 0; j < sumArray.length; j++) {
                sumArray[j] = summer(arr, j, j + i - 1);
            }
            jaggedArray.add(sumArray.clone());
        }
        for (int i = 0; i < jaggedArray.size(); i++) {
            boolean terminate = false;
            boolean manuallyTerminated = false;
            manuallyTerminated = false;
            for (int j = 0; j < jaggedArray.get(i).length; j++) {
                for (int k = 0; k < jaggedArray.get(i).length; k++) {
                    if (j <= k) {
                        int or = jaggedArray.get(i)[j] | jaggedArray.get(i)[k];
                        int xor = jaggedArray.get(i)[j] ^ jaggedArray.get(i)[k];
                        if (jaggedArray.get(i)[j] == jaggedArray.get(i)[k]) {
                            continue;
                        }
                        if (or != xor) {
                            System.out.println("(" + jaggedArray.get(i)[j] + "," + jaggedArray.get(i)[k] + ")" + " OR="
                                    + or + " XOR=" + xor);
                        } else {
                            System.out.println("(" + jaggedArray.get(i)[j] + "," + jaggedArray.get(i)[k] + ")" + " OR="
                                    + or + " XOR=" + xor);
                            System.out.println("Row " + i + " abruptly terminated");
                            terminate = true;
                            break;
                        }
                    }
                }
                if (terminate) {
                    terminate = false;
                    manuallyTerminated = true;
                    break;
                }
            }

            if (!manuallyTerminated) {
                System.out.println("Row " + (i) + " is processed entirely");
            }
        }
        sc.close();
    }
}
