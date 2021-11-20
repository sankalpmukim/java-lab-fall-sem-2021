package Q10;

import java.util.Scanner;

public class Execution {
    public static void main(String[] args) {
        System.out.print("Enter digit:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        Complement9 object = new Complement9(num);
        System.out.println("84-2-1 code generated:" + object.code);
        System.out.println("Finding decimal form:" + object.findDecimal());
        object.ninesComplement();
        System.out.println("Finding nine's complement:" + object.code);
        System.out.println("Finding decimal of nine's complement:" + object.findDecimal());

    }
}
