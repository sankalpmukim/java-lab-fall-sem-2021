package Q9;

import java.util.Scanner;

public class Faculty {
    int n;
    Student[] arr;

    public Faculty(int N) {
        n = N;
        Scanner sc = new Scanner(System.in);
        arr = new Student[N];
        for (int i = 0; i < N; i++) {
            int cat1, cat2, da1, da2, da3;
            cat1 = sc.nextInt();
            cat2 = sc.nextInt();
            da1 = sc.nextInt();
            da2 = sc.nextInt();
            da3 = sc.nextInt();
            arr[i] = new Student(new int[] { cat1, cat2, da1, da2, da3 });
        }
        sc.close();
    }

    public double findClassAverage() {
        double sum = 0;
        for (Student student : arr) {
            sum += student.getIndividualTotal();
        }
        return sum / (double) n;
    }

    public int findMaxScore() {
        int max = arr[0].getIndividualTotal();
        for (Student student : arr) {
            if (max < student.getIndividualTotal()) {
                max = student.getIndividualTotal();
            }
        }
        return max;
    }
}
