import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// incomplete
// author: aayush
public class marble {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File(""));
        while (in.hasNextLine()) {
            String[] thing = in.nextLine().split(" ");
            int[] nums = Arrays.stream(thing).mapToInt(Integer::parseInt).toArray();

        }
    }

}
