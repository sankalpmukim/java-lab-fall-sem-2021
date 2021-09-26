package Q8;

public class Encoding {
    public static String[] overAllStrings = new String[0];
    public String inputtext;
    public String[] SA;
    public int[] IA;

    private static String[] removeTheElement(String[] arr, int index) {
        String[] newArr = new String[arr.length - 1];
        int nextInput = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[nextInput] = arr[i];
                nextInput++;
            }
        }
        return newArr;
    }

    public static int indexOf(String[] arr, String item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private static String[] concatenate(String[] s1, String[] s2) {
        String[] s3 = new String[s1.length + s2.length];
        for (int i = 0; i < s1.length; i++) {
            s3[i] = s1[i];
        }
        for (int j = 0; j < s2.length; j++) {
            s3[s1.length + j] = s2[j];
        }
        return s3;
    }

    private static int[] concatenate(int[] s1, int[] s2) {
        int[] s3 = new int[s1.length + s2.length];
        for (int i = 0; i < s1.length; i++) {
            s3[i] = s1[i];
        }
        for (int j = 0; j < s2.length; j++) {
            s3[s1.length + j] = s2[j];
        }
        return s3;
    }

    private static int max(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public Encoding(String inptt) {
        inputtext = inptt;
        SA = inputtext.split(" ");
        overAllStrings = concatenate(overAllStrings, SA);
        IA = new int[SA.length];
    }

    public static void sort() {
        for (int i = 0; i < overAllStrings.length; i++) {
            for (int j = i + 1; j < overAllStrings.length; j++) {
                if (overAllStrings[i].compareTo(overAllStrings[j]) > 0) {
                    String temp = overAllStrings[i];
                    overAllStrings[i] = overAllStrings[j];
                    overAllStrings[j] = temp;
                }
            }
        }
        for (int i = 1; i < overAllStrings.length; i++) {
            if (overAllStrings[i - 1].equals(overAllStrings[i])) {
                overAllStrings = removeTheElement(overAllStrings, i);
            }
        }

    }

    public void encodeText() {
        sort();
        for (int i = 0; i < SA.length; i++) {
            IA[i] = indexOf(overAllStrings, SA[i]);
        }
    }

    public static void displayFullSorted() {
        sort();
        for (int i = 0; i < overAllStrings.length; i++) {
            System.out.print(overAllStrings[i] + " ");
        }
        System.out.println("");
    }

    public static void encodeText(Encoding[] e) {
        int[] lengths = new int[e.length];
        for (int i = 0; i < e.length; i++) {
            lengths[i] = e[i].IA.length;
        }
        int maxLen = max(lengths);
        for (int i = 0; i < e.length; i++) {
            while (e[i].IA.length < maxLen) {
                int[] x = new int[] { -1 };
                e[i].IA = concatenate(e[i].IA, x);
            }
        }
    }

    public void displayIntegerArray() {
        encodeText();
        System.out.print("[");
        for (int i = 0; i < IA.length; i++) {
            System.out.print(IA[i] + ",");
        }
        System.out.println("]");
    }
}
