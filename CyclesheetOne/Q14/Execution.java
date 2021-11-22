package Q14;

import java.util.LinkedList;
import java.util.Queue;

public class Execution {
    public static void main(String[] args) {
        Queue<Faculty> faculty = new LinkedList<>();
        Queue<Male> males = new LinkedList<>();
        Queue<Female> females = new LinkedList<>();

        // Input process
        Faculty a = new Faculty(1, 2, 3, 4);
        Faculty b = new Faculty(2, 3, 4, 2);
        Faculty c = new Faculty(4, 3, 5, 1);
        Faculty d = new Faculty(8, 5, 3, 1);

        Male aM = new Male(2, 3, 6, 2);
        Male bM = new Male(4, 5, 3, 1);
        Male cM = new Male(4, 3, 4, 3);

        Female aF = new Female(5, 4, 3, 2);
        Female bF = new Female(4, 5, 5, 8);
        Female cF = new Female(1, 2, 3, 4);

        faculty.add(a);
        faculty.add(b);
        faculty.add(c);
        faculty.add(d);

        males.add(aM);
        males.add(bM);
        males.add(cM);

        females.add(aF);
        females.add(bF);
        females.add(cF);

        int numMale = males.size();
        int numFemale = females.size();
        int numFaculty = faculty.size();

        int studentTotal = 0, facTotal = 0;

        while (faculty.size() > 0 || males.size() > 0 || females.size() > 0) {
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

        System.out.println("\nTotal spent by students = " + studentTotal);
        System.out.println("Total spent by faculty = " + facTotal);

        System.out.println("\nTotal money made by the canteen that day = " + (studentTotal + facTotal));

        System.out.println("students that visited canteen = " + (numMale + numFemale));
        System.out.println("faculty that visited canteen= " + numFaculty);
    }
}
