import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// correct
// author: aidan
public class zoo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("zoo.dat"));
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
        list.sort(Comparator.comparing(String::length));
        while (!list.isEmpty()) {
            StringBuilder s = new StringBuilder(list.remove(0));
            int length = s.length();
            while (!list.isEmpty() && list.get(0).length() == length) {
                s.append(" ").append(list.remove(0));
            }
            System.out.println(length + " " + s);
        }
    }
}
