import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// mydict={'A':(1,-2,3),'B':(4,8),'C':(3,6,-4,5),'D':(1,7,8,-2,-6),'E':(9,10)}
public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        sc.close();
        List<Character> keys = new ArrayList<Character>();
        List<Integer> sums = new ArrayList<Integer>();
        int i = 0;
        while (inp.charAt(i) != '{') {
            i++;
        }
        while (inp.charAt(i) != '}') {
            if (Character.isAlphabetic(inp.charAt(i))) {
                keys.add(inp.charAt(i));
            }
            if (inp.charAt(i) == '(') {
                i++;
                int sum = 0;
                String nums = inp.substring(i, inp.indexOf(")", i));
                String[] numbers = nums.split(",");
                for (String string : numbers) {
                    sum += Integer.parseInt(string);
                }
                sums.add(sum);
            }
            i++;
        }
        System.out.println("[");
        for (int j = 0; j < keys.size(); j++) {
            System.out.print("\t\"" + keys.get(j) + "\", ");
        }
        System.out.println("\n]");
        System.out.println("[");
        for (int j = 0; j < keys.size(); j++) {
            System.out.print("\t" + sums.get(j) + ", ");
        }
        System.out.println("\n]");
    }
}
