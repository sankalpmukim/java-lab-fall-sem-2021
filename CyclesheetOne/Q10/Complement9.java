package Q10;

public class Complement9 extends Class8421 {
    public Complement9(int n) {
        super(n);
    }

    public void ninesComplement() {
        char[] charArr = code.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                continue;
            } else {
                if (charArr[i] == '1') {
                    charArr[i] = '0';
                } else {
                    charArr[i] = '1';
                }
            }
        }
        code = String.valueOf(charArr);
    }

    public int findDecimal() {
        String[] indiviDigits = code.split(" ");
        int num = 0;

        for (String string : indiviDigits) {
            num *= 10;
            num += NestedClass.CodeToDecimal(string);
        }
        return num;
    }
}
