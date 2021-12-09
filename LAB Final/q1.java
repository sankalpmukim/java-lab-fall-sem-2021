import java.util.*;

class SumMatrix extends Thread {
    public int[][] matrix;
    public int x_init, y_init;
    public Double average;

    public SumMatrix(int[][] matrix, int x_init, int y_init) {
        average = null;
        this.matrix = matrix;
        this.x_init = x_init;
        this.y_init = y_init;
    }

    public void run() {
        int sum = 0;
        for (int i = x_init; i < x_init + 3; i++) {
            for (int j = y_init; j < y_init + 3; j++) {
                sum += matrix[i][j];
            }
        }
        average = ((double) sum) / 9.0;
    }
}

class Execution {

    public static boolean checkIsNull(SumMatrix[][] allThreads, int row) {
        for (int j = 0; j < allThreads.length; j++) {
            if (allThreads[row][j].average == null) {
                return true;
            }
        }
        return false;
    }
    // Input matrix
    // 7
    // 1 9 8 4 4 5 7
    // 4 8 6 7 9 1 7
    // 4 0 5 9 3 8 4
    // 7 3 5 9 0 5 4
    // 7 4 1 1 8 1 2
    // 7 6 6 9 8 7 6
    // 3 6 3 5 4 2 7

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of **n**:");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter the matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        SumMatrix[][] allThreads = new SumMatrix[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                allThreads[i][j] = new SumMatrix(matrix, i, j);
            }
        }

        double[][] averagesMatrix = new double[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            // initiallizizng the row
            for (int j = 0; j < n - 2; j++) {
                allThreads[i][j].start();
            }

            // completing the row
            while (checkIsNull(allThreads, i) == true) {
                for (int j = 0; j < n - 2; j++) {
                    try {
                        allThreads[i][j].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            // filling all averages
            for (int j = 0; j < n - 2; j++) {
                averagesMatrix[i][j] = allThreads[i][j].average;
            }
        }

        System.out.println("Output matrix:");
        // displaying the sum matrix
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                System.out.print(averagesMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}