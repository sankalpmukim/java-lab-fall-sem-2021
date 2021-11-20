
public class CountHorizontal extends Thread {
    public boolean notFinished;
    public boolean odd;
    public int element;
    public int count;
    int[][] arr;

    public CountHorizontal(int[][] getArr, boolean countOdd, int ele) {
        arr = getArr;
        odd = countOdd;
        element = ele;
        notFinished = true;
    }

    public boolean horizontalTriplet(int atX, int atY) {

        return (arr[atX][atY] == element && arr[atX][atY + 1] == element && arr[atX][atY + 2] == element);
    }

    public void run() {
        int start = odd ? 1 : 0;
        for (int i = start; i < arr.length; i += 2) {
            for (int j = 0; j < arr.length - 2; j++) {
                if (horizontalTriplet(i, j)) {
                    count++;
                }
            }
        }
        notFinished = false;
    }
}