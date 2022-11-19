import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

// incomplete
// author: aayush
public class discgolf {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("disc.dat"));
        HashMap<String, String> names = new HashMap<>();
        names.put("A", "AUSTIN_RIDGE_BIBLE_CHURCH");
        names.put("B", "BRUSHY_CREEK_CAT_HOLLOW");
        names.put("C", "CEDAR_VALLEY_MIDDLE_SCHOOL");
        HashMap<String, int[]> hm = new HashMap<>();
        for (int x = 0; x < 3; x++) {
            String name = sc.nextLine();
            String line = sc.nextLine();
            String[] golfstring = line.split(" ");
            int[] ints = new int[golfstring.length];
            for (int i = 0; i < golfstring.length; i++) {
                ints[i] = Integer.parseInt(golfstring[i]);
            }
            hm.put(name, ints);
        }
        int t = Integer.parseInt(sc.nextLine());
        for (int x = 0; x < t; x++) {
            long score = 0, sumParCourse = 0, above = 0, below = 0, pars = 0;
            String line = sc.nextLine();
            String l = line.substring(0, 1);
            String[] bjstring = line.substring(2).split(" ");
            for (int i = 0; i < bjstring.length; i++) {
                int num = Integer.parseInt(bjstring[i]);
                score += num;
                int tempCourse = hm.get(names.get(l))[i];
                sumParCourse += tempCourse;
                if (num > tempCourse)
                    above++;
                else if (num < tempCourse)
                    below++;
                else pars++;
            }
            String result = "";
            if (score > sumParCourse)
                result = "ABOVE PAR";
            else if (score < sumParCourse)
                result = "BELOW PAR";
            else
                result = "PAR";
            System.out.println(names.get(l));
            System.out.println("COURSE TOTAL = " + sumParCourse);
            System.out.println("SCORE = " + score);
            System.out.println("PARS = " + pars);
            System.out.println("ABOVE PARS = " + above);
            System.out.println("BELOW PARS =- " + below);
            System.out.println("OVERALL RESULT: " + result);
            System.out.println();
        }
    }
}
