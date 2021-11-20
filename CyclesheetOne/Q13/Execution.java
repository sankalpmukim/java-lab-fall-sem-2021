package Q13;

public class Execution {
    public static void main(String[] args) {
        int[] studentCount = { 3, 4, 17, 8, 23, 10, 4, 6, 5, 2 };
        int[] marks = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Numerator n1 = new Numerator(true, marks, studentCount);
        Numerator n2 = new Numerator(false, marks, studentCount);
        n1.start();
        n2.start();

        Denominator d1 = new Denominator(true, studentCount);
        Denominator d2 = new Denominator(false, studentCount);
        d1.start();
        d2.start();

        while (n1.notDone || n2.notDone || d1.notDone || d2.notDone) {
            try {
                n1.join();
                n2.join();
                d1.join();
                d2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double numeratorTotal = n1.sum + n2.sum;
        double denominatorTotal = d1.sum + d2.sum;

        System.out.println("Total numerator = " + numeratorTotal);
        System.out.println("Total denominator = " + denominatorTotal);
        System.out.println("Total mean = " + (numeratorTotal / denominatorTotal));
    }
}
