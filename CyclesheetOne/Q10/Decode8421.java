package Q10;

public interface Decode8421 {
    String[] arr = { "0101", "0100", "0000", "1111", "1000", "1011", "1001", "0111", "1010", "0110" };

    public static class NestedClass implements Decode8421 {
        String[][] twoDArray;

        public static int CodeToDecimal(String num) {
            int dig0, dig1, dig2, dig3;
            dig0 = Character.getNumericValue(num.charAt(0)) * 8;
            dig1 = Character.getNumericValue(num.charAt(1)) * 4;
            dig2 = Character.getNumericValue(num.charAt(2)) * -2;
            dig3 = Character.getNumericValue(num.charAt(3)) * -1;
            return dig0 + dig1 + dig2 + dig3;
        }

        public NestedClass() {
            this.twoDArray = new String[10][2];
            int i = 0;
            for (String string : arr) {
                twoDArray[i] = new String[2];
                twoDArray[i][0] = string;
                twoDArray[i][1] = Integer.toString(CodeToDecimal(string));
                i++;
            }
        }
    }
}
