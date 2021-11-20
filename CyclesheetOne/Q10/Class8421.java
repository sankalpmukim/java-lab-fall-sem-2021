package Q10;

public class Class8421 implements Decode8421 {
    String code;

    String numToCode(int n) {
        NestedClass obj = new NestedClass();
        for (String[] arr : obj.twoDArray) {
            if (Integer.parseInt(arr[1]) == n) {
                return arr[0];
            }
        }
        return "error";
    }

    public Class8421(int n) {
        // number of digits in n
        int temp = n, count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        temp = n;
        String[] codeArr = new String[count];
        for (int i = codeArr.length - 1; i >= 0; i--) {
            codeArr[i] = numToCode(temp % 10);
            temp /= 10;
        }
        code = codeArr[0];
        for (int i = 1; i < codeArr.length; i++) {
            code += " ";
            code += codeArr[i];
        }
    }
}
