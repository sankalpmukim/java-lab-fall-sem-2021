
public class NNumber {
    public int n;
    public int afterSorting;
    public String[] arr;
    private String[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    private static int numDigits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        return count;
    }

    private static int indexOf(String item, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    NNumber(int n) {
        this.n = n;
        arr = new String[numDigits(n)];
        if (numDigits(n) < 3) {
            System.out.println("Error!! Number of digits is less than 3");
        } else {
            int x = n;
            int i = 0;
            while (x > 0) {
                arr[i] = digits[x % 10];
                i++;
                x /= 10;
            }
            // Reversing the obtained array
            for (int j = 0; j < arr.length / 2; j++) {
                String temp = arr[arr.length - 1 - j];
                arr[arr.length - 1 - j] = arr[j];
                arr[j] = temp;
            }

            afterSorting = 0;
        }
    }

    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (String string : arr) {
            int num = indexOf(string, digits);
            afterSorting *= 10;
            afterSorting += num;
        }
    }

    public int countSamePositions() {
        int count = 0;
        int x = n;
        int y = afterSorting;
        while (x > 0) {
            if (x % 10 == y % 10) {
                count++;
            }
            x /= 10;
            y /= 10;
        }
        return count;
    }
}