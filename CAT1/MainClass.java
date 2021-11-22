package CAT1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        List<NNumber> list = new ArrayList<NNumber>();
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            NNumber current = new NNumber(n);
            list.add(current);
        }

        System.out.println("The corresponding String array of each object would be as follows");

        for (int i = 0; i < list.size(); i++) {
            System.out.print("{");
            String[] tempArr = list.get(i).arr;
            for (String string : tempArr) {
                System.out.print(string + ',');
            }
            System.out.println("}");
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sort();
        }

        System.out.println("Now after sorting, the string arrays will be");

        for (int i = 0; i < list.size(); i++) {
            System.out.print("{");
            String[] tempArr = list.get(i).arr;
            for (String string : tempArr) {
                System.out.print(string + ',');
            }
            System.out.println("}");
        }

        System.out.println("And so the output should be");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).afterSorting);
        }

        System.out.println("The corresponding count of unchanged values:");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).countSamePositions());
        }

        sc.close();
    }
}
