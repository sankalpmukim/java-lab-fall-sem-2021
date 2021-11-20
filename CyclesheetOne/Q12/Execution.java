package Q12;

import java.util.Scanner;

import Q12.Exceptions.TriangleNotPossibleException;

public class Execution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter coordinates of 2 lines to make a triangle!");

        boolean line1 = true, line2 = true, triangle = true;
        Line l1 = null, l2 = null;
        Triangle t = null;
        while (triangle) {
            triangle = false;
            line1 = true;
            line2 = true;
            while (line1) {
                line1 = false;
                System.out.println("Enter coordinates of line 1");
                int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
                try {
                    l1 = new Line(x1, y1, x2, y2);
                } catch (NumberFormatException e) {
                    System.out.println("Bad line! Points at the same place! Try again!");
                    line1 = true;
                }
            }
            while (line2) {
                line2 = false;
                System.out.println("Enter coordinates of line 2");
                int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
                try {
                    l2 = new Line(x1, y1, x2, y2);
                } catch (NumberFormatException e) {
                    System.out.println("Bad line! Points at the same place! Try again!");
                    line2 = true;
                }
            }
            try {
                t = new Triangle(l1, l2);
            } catch (TriangleNotPossibleException e) {
                triangle = true;
                System.out.println("Bad triangle! No points connect!");
            }
        }
        in.close();
        System.out.println(t.success());
    }
}
