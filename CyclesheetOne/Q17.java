import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Q17 {
    public static List<String> readFileData(String fileName) {
        List<String> lst = new ArrayList<>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lst.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return lst;
    }

    static String[] removeSymbols(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String string = words[i];
            if (string.charAt(string.length() - 1) == '?' || string.charAt(string.length() - 1) == '!'
                    || string.charAt(string.length() - 1) == '.' || string.charAt(string.length() - 1) == '|'
                    || string.charAt(string.length() - 1) == '/') {
                string = string.substring(0, string.length() - 1);
            }
            words[i] = string;
        }
        return words;
    }

    static String[] extractSentence(String line) {
        line = line.toLowerCase();
        int bracket = line.indexOf("(");
        line = line.trim();
        String sentence = line.substring(0, bracket);
        sentence = sentence.trim();

        String[] words = sentence.split(" ");
        words = removeSymbols(words);
        return words;
    }

    static String[] extractTerms(String line) {
        line = line.toUpperCase();
        int bracket = line.indexOf("(");
        line = line.trim();
        String sentence = line.substring(bracket + 1, line.length() - 1);
        sentence = sentence.trim();

        String[] words = sentence.split(" ");
        words = removeSymbols(words);
        return words;
    }

    static Map<String, Set<String>> mapAdder(String[] words, String[] terms, Map<String, Set<String>> dataMap) {

        for (int i = 0; i < terms.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (dataMap.containsKey(terms[i])) {
                    Set<String> s = dataMap.get(terms[i]);
                    s.add(words[i]);
                    dataMap.put(terms[i], s);
                } else {
                    Set<String> s = new HashSet<>();
                    s.add(words[i]);
                    dataMap.put(terms[i], s);
                }
            }
        }
        return dataMap;
    }

    public static void main(String[] args) {
        List<String> fileData = readFileData("./q17text.txt");

        Map<String, Set<String>> dataMap = new HashMap<>();
        for (String line : fileData) {

            String[] words = removeSymbols(extractSentence(line));
            String[] terms = removeSymbols(extractTerms(line));

            dataMap = mapAdder(words, terms, dataMap);
        }

        System.out.println("Data map:");
        dataMap.forEach((k, v) -> System.out.println("" + k + ":" + v));

        System.out.println("");
        System.out.println("Enter the test phrase:");
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine().trim();
        List<Set<String>> phrases = new ArrayList<>();
        String[] phraseWords = phrase.split(" ");

        for (String phrWord : phraseWords) {
            Set<String> str = new HashSet<>();
            for (Map.Entry<String, Set<String>> entry : dataMap.entrySet()) {
                if (entry.getValue().contains(phrWord)) {
                    str.add(entry.getKey());
                }
            }
            phrases.add(str);
        }

        System.out.println("");
        System.out.println("The 2D Jagged array:");
        System.out.println(phrases);

        System.out.println("");
        System.out.println("Enter the tag sequence:");
        String tagSequnce = sc.nextLine().trim();
        String[] tagSeqWords = tagSequnce.split(" ");
        sc.close();

        boolean accepted = true;

        int i = 0;
        for (String tag : tagSeqWords) {
            if (phrases.get(i).contains(tag) == false) {
                accepted = false;
                break;
            }
            i++;
        }

        if (accepted) {
            System.out.println("The string is accepted.");
        } else {
            System.out.println("The string is not accepted.");
        }
    }
}
