//java Q2 Vinay 7000 1500 Andrea 46000 -28000 Venba 18500 -11800  Mithil 78000 3000 Kavin 8600 -10000

public class Q2 {
    public static int withdrawalCharge(int amount) {
        if (amount <= 500) {
            return 5;
        }
        if (amount <= 1000) {
            return 8;
        }
        if (amount <= 5000) {
            return 10;
        }
        if (amount <= 15000) {
            return 12;
        }
        if (amount <= 25000) {
            return 15;
        }
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i += 3) {
            String name = args[i];
            int amount = Integer.parseInt(args[i + 1]);
            int transaction = Integer.parseInt(args[i + 2]);
            System.out.println(name);
            if (transaction < 0) {
                // Withdrawal
                transaction = Math.abs(transaction);
                if (amount < transaction || transaction > 25000) {
                    System.out.println("Failed Transaction");
                    System.out.println(amount);
                    continue;
                }
                int withdrawalCharge;
                if (transaction <= 5000) {
                    withdrawalCharge = 5;
                } else if (transaction <= 1000) {
                    withdrawalCharge = 8;
                } else if (transaction <= 5000) {
                    withdrawalCharge = 10;
                } else if (transaction <= 15000) {
                    withdrawalCharge = 12;
                } else {
                    withdrawalCharge = 15;
                }
                System.out.println((amount - transaction - withdrawalCharge));
            } else {
                System.out.println(amount + transaction);
            }
        }
    }
}
