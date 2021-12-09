package Midterm;

class Thread1 extends Thread {
    int counth1 = 0, counth2 = 0;
    int arr[][];

    Thread1(int arr[][]) {
        this.arr = arr;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1) {
                    this.counth1++;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2) {
                    this.counth2++;
                }
            }
        }
    }
}

class Thread2 extends Thread {
    int counth1 = 0, counth2 = 0;
    int arr[][];

    Thread2(int arr[][]) {
        this.arr = arr;
    }

    public void run() {
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1) {
                    this.counth1++;
                }
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2) {
                    this.counth2++;
                }
            }
        }
    }
}

class Thread3 extends Thread {
    int countv1 = 0, countv2 = 0;
    int arr[][];

    Thread3(int arr[][]) {
        this.arr = arr;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 1][j] == 1) {
                    this.countv1++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 2 && arr[i + 1][j] == 2 && arr[i + 2][j] == 2) {
                    this.countv2++;
                }
            }
        }
    }
}

class Thread4 extends Thread {
    int countv1 = 0, countv2 = 0;
    int arr[][];

    Thread4(int arr[][]) {
        this.arr = arr;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 6; j++) {
                if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 1][j] == 1) {
                    this.countv1++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 6; j++) {
                if (arr[i][j] == 2 && arr[i + 1][j] == 2 && arr[i + 2][j] == 2) {
                    this.countv2++;
                }
            }
        }
    }
}

class ques {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int arr[][] = new int[6][6];
        int[][] arr = { { 1, 2, 2, 1, 1, 1 }, { 2, 1, 2, 2, 2, 1 }, { 2, 1, 1, 2, 1, 1 }, { 2, 2, 1, 1, 1, 2 },
                { 1, 2, 2, 1, 1, 1 }, { 2, 1, 1, 1, 2, 2 } };
        // for (int i = 0; i < 6; i++) {
        // for (int j = 0; j < 6; j++) {
        // arr[i][j] = sc.nextInt();
        // }
        // }
        // int counth1 = 0, countv1 = 0, counth2 = 0, countv2 = 0;
        Thread1 ob1 = new Thread1(arr);
        Thread2 ob2 = new Thread2(arr);
        Thread3 ob3 = new Thread3(arr);
        Thread4 ob4 = new Thread4(arr);
        ob1.start();
        ob2.start();
        ob3.start();
        ob4.start();
        try {
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        int count1 = ob1.counth1 + ob2.counth1 + ob3.countv1 + ob4.countv1;
        int count2 = ob1.counth2 + ob2.counth2 + ob3.countv2 + ob4.countv2;
        if (count1 > count2) {
            System.out.println("Player 1 wins");
        } else {
            System.out.println("Player 2 wins");
        }
    }
}