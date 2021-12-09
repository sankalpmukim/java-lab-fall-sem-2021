package Midterm;

public class CountVertical extends Thread {
    public boolean notFinished;
    public boolean odd;
    public int element;
    public int count;
    int[][] arr;

    public CountVertical(int[][] getArr, boolean countOdd, int ele) {
        arr = getArr;
        odd = countOdd;
        element = ele;
        notFinished = true;
    }

    public boolean verticalTriplet(int atX, int atY) {

        return (arr[atX][atY] == element && arr[atX + 1][atY] == element && arr[atX + 2][atY] == element);
    }

    public void run() {
        int start = odd ? 1 : 0;
        for (int i = start; i < arr.length - 2; i += 2) {
            for (int j = 0; j < arr.length; j++) {
                if (verticalTriplet(i, j)) {
                    count++;
                }
            }
        }
        notFinished = false;
    }
}