package Q13;

public class Denominator extends Thread {
    public int sum;
    public boolean odds;
    public boolean notDone;
    public int[] marks;
    public int[] studentCount;

    public Denominator(boolean odds, int[] studentCount) {
        this.sum = 0;
        this.odds = odds;
        this.notDone = true;
        this.studentCount = studentCount;
    }

    public void run() {
        int startVal = this.odds ? 1 : 0;
        for (int i = startVal; i < studentCount.length; i += 2) {
            sum += (studentCount[i]);
        }
        notDone = false;
    }
}
