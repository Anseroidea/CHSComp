import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// correct
public class DryRun {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("dryrun.in"));
        int count = sc.nextInt();
        int value = 0;
        for (int i = 0; i < count; i++) {
            value += sc.nextInt();
        }
        System.out.println(value);
    }

}
