import java.util.Scanner;

public class Q6 {
    private static boolean isVowel(char ch) {
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }

    private static int countCV(String vowelString) {
        int output = 0;
        for (int i = 0; i < vowelString.length() - 1; i++) {
            if (vowelString.charAt(i) == 'V' && vowelString.charAt(i + 1) == 'C') {
                output++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.next();
        }
        for (int i = 0; i < words.length; i++) {
            String vowelString = "";
            for (int j = 0; j < words[i].length(); j++) {
                if (isVowel(words[i].charAt(j))) {
                    if (vowelString.length() == 0 || vowelString.charAt(vowelString.length() - 1) == 'C') {
                        vowelString += "V";
                    }
                } else {
                    if (vowelString.length() == 0 || vowelString.charAt(vowelString.length() - 1) == 'V') {
                        vowelString += "C";
                    }
                }
            }
            System.out.println(vowelString);
            System.out.println(countCV(vowelString));
        }
        sc.close();
    }
}
