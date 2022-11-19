import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// correct
// author: kason
public class basecon {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("basecon.dat"));
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            char type = sc.next().charAt(0);
            String value = sc.nextLine().trim();
            int intValue = switch (type) {
                case 'D' -> Integer.parseInt(value);
                case 'H' -> Integer.parseInt(value, 16);
                case 'B' -> Integer.parseInt(value, 2);
                case 'O' -> Integer.parseInt(value, 8);
                default -> throw new IllegalStateException();
            };
            System.out.println(intValue + " " +
                    Integer.toString(intValue, 16) + " " +
                    Integer.toString(intValue, 8) + " " +
                    Integer.toString(intValue, 2)
            );
        }
    }
}
