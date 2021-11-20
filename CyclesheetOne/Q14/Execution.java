package Q14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Execution {
    public static void main(String[] args) {
        Queue<Faculty> faculty = new LinkedList<>();
        Queue<Male> males = new LinkedList<>();
        Queue<Female> females = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of faculty members, males students, female students");
        int numFac = sc.nextInt();
        int numMale = sc.nextInt();
        int numFemale = sc.nextInt();
        sc.close();

        // Input process
        for (int i = 0; i < numFac; i++) {
            Faculty x = new Faculty();
            faculty.add(x);
        }
        for (int i = 0; i < numMale; i++) {
            Male x = new Male();
            males.add(x);
        }
        for (int i = 0; i < numFemale; i++) {
            Female x = new Female();
            females.add(x);
        }

        int studentTotal = 0, facTotal = 0;

        while (faculty.size() >= 0 || males.size() >= 0 || females.size() >= 0) {
            for (int i = 0; faculty.size() > 0 && i < 3; i++) {
                Faculty x = faculty.remove();
                System.out.println("Total for this faculty:" + x.total());
                facTotal += x.total();
            }
            for (int i = 0; males.size() > 0 && i < 1; i++) {
                Male x = males.remove();
                System.out.println("Total for this male student:" + x.total());
                studentTotal += x.total();
            }
            for (int i = 0; females.size() > 0 && i < 1; i++) {
                Female x = females.remove();
                System.out.println("Total for this female student:" + x.total());
                studentTotal += x.total();
            }
        }

        System.out.println("Total spent by students = " + studentTotal);
        System.out.println("Total spent by faculty = " + facTotal);

        System.out.println("students that visited canteen = " + numMale + numFemale);
        System.out.println("faculty that visited canteen= " + numFemale);
    }
}
