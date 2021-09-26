package Q8;

public class Execution {
    public static void main(String[] args) {
        Encoding e1 = new Encoding("this is an example for classes");
        Encoding e2 = new Encoding("students attend their classes online");
        Encoding e3 = new Encoding("online classes are also equally effective");
        Encoding[] arr = new Encoding[] { e1, e2, e3 };
        Encoding.displayFullSorted();
        for (Encoding encoding : arr) {
            encoding.displayIntegerArray();
        }
        // System.out.println(Encoding.indexOf(new String[] { "ABC", "DEF", "GHI" }, new
        // String("GHI")));
        Encoding.encodeText(arr);
        for (Encoding encoding : arr) {
            encoding.displayIntegerArray();
        }
    }
}
