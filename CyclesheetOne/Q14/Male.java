package Q14;

import java.util.Scanner;

public class Male {
    public int numDish1;
    public int numDish2;
    public int numDish3;
    public int numDish4;

    public Male() {
        Scanner sc = new Scanner(System.in);
        // sc.nextLine();
        System.out.println("Enter details for male students");
        System.out.print("Enter number of dish1s: ");
        numDish1 = sc.nextInt();
        System.out.print("Enter number of dish2s: ");
        numDish2 = sc.nextInt();
        System.out.print("Enter number of dish3s: ");
        numDish3 = sc.nextInt();
        System.out.print("Enter number of dish4s: ");
        numDish4 = sc.nextInt();
        sc.close();
    }

    public int total() {
        return (numDish1 * 50) + (numDish2 * 75) + (numDish3 * 100) + (numDish4 * 150);
    }
}
