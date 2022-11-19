import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// complete
// author: aidan
public class vowels {

    public static List<String> vowels = Arrays.asList("A", "P", "L", "U", "S");

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("vowels.dat"));
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            String word = sc.nextLine().toUpperCase();
            if (word.length() >= 3 && (isVow(word.charAt(word.length() - 3) + "") == isVow(word.charAt(word.length() - 2) + "")) && (isVow(word.charAt(word.length() - 2) + "") == isVow(word.charAt(word.length() - 1) + ""))) {
                for (int j = word.length() - 1; j >= 0; j--) {
                    if (j == 0 || isVow(word.substring(j - 1, j)) != isVow(word.substring(word.length() - 1))) {
                        word = word.substring(0, j) + word.substring(j + 1);
                        break;
                    }
                }
                word += "Y";
            } else if (word.length() >= 2 && (isVow(word.charAt(word.length() - 2) + "") == isVow(word.charAt(word.length() - 1) + ""))) {
                word += word.substring(word.length() - 1) + "Y";
            } else if (isVow(word.charAt(word.length() - 1) + "")) {
                word = word.substring(0, word.length() - 1) + "X";
            } else {
                word += "XY";
            }
            System.out.println(word);
        }
    }

    public static boolean isVow(String s) {
        return vowels.contains(s);
    }


}
