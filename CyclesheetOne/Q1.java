import java.util.*;

public class Q1 {
    private static boolean onlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        int numRegnos = 0, numCgpas = 0, numNames = 0;
        int[] regnos = new int[n];
        float[] cgpas = new float[n];
        String[] names = new String[n];
        String currenString;
        for (int i = 0; i < n; i++) {
            currenString = sc.nextLine();
            if (currenString.contains(".")) {
                cgpas[numCgpas++] = Float.parseFloat(currenString);
                continue;
            }
            if (Q1.onlyDigits(currenString)) {
                regnos[numRegnos++] = Integer.parseInt(currenString);
                continue;
            }
            names[numNames++] = currenString;
        }
        System.out.print(numRegnos);
        System.out.println(" (Count of reg.no)");
        System.out.print(numCgpas);
        System.out.println(" (Count of CGPA)");
        System.out.print(numNames);
        System.out.println(" (Count of names)");
        float avg = 0;
        for (int i = 0; i < numCgpas; i++) {
            avg += cgpas[i];
        }
        avg /= numCgpas;
        System.out.print(avg);
        System.out.println(" (Average of CGPA)");
        int leastRegNo = 100000, greatestRegNo = -1;

        for (int i = 0; i < numRegnos; i++) {
            if (regnos[i] < leastRegNo) {
                leastRegNo = regnos[i];
            }
            if (regnos[i] > greatestRegNo) {
                greatestRegNo = regnos[i];
            }
        }
        System.out.print(leastRegNo);
        System.out.println(" (Least reg.no)");
        System.out.print(greatestRegNo);
        System.out.println(" (Greatest reg.no)");
        for (int i = 0; i < numNames; i++) {
            if (i != numNames - 1) {
                System.out.print(names[i] + ", ");
            } else {
                System.out.println(names[i]);
            }
        }
        sc.close();
    }
}
