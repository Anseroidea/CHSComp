import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// correct
// author: kason
public class sdr {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sdr.dat"));
        while (sc.hasNext()) {
            String s = sc.next();
            int x = sc.nextInt();
            String s1 = s.substring(0, x);
            String s2 = s.substring(x);
            System.out.println(
                    s1 + "-" + reverse(s2) + "-" + reverse(s1) + "-" + s2
            );
        }
    }

    public static String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
