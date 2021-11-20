package Q13;

public class Numerator extends Thread {
    public int sum;
    public boolean odds;
    public boolean notDone;
    public int[] marks;
    public int[] studentCount;

    public Numerator(boolean odds, int[] marks, int[] studentCount) {
        this.sum = 0;
        this.odds = odds;
        this.notDone = true;
        this.marks = marks;
        this.studentCount = studentCount;
    }

    public void run() {
        int startVal = this.odds ? 1 : 0;
        for (int i = startVal; i < marks.length; i += 2) {
            sum += (marks[i] * studentCount[i]);
        }
        notDone = false;
    }
}
