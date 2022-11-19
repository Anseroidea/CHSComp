import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// correct
// author: kason
public class search {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("search.dat"));
        String str = sc.nextLine();
        int[] values = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(values);
        StringBuilder s = new StringBuilder();
        for (int value : values) {
            s.append(value).append(" ");
        }
        System.out.println(s);
        sc.nextInt();
        while (sc.hasNext()) {
            int toSearch = sc.nextInt();
            if (toSearch > values[values.length - 1]) {
                System.out.println(toSearch + " was not found and should be it position " + values.length);
                continue;
            }
            for (int i = 0; i < values.length; i++) {
                if (values[i] == toSearch) {
                    System.out.println(toSearch + " was found in position " + i);
                    break;
                } else if (values[i] > toSearch) {
                    System.out.println(toSearch + " was not found and should be in position " + i);
                    break;
                }
            }
        }
    }
}
