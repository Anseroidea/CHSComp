import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// correct
// author: kason
public class raddeg {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("raddeg.dat"));
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.isEmpty() || str.isBlank()) continue;
            if (str.contains(".")) {
                double radian = Double.parseDouble(str);
                int degrees = (int) Math.round(Math.toDegrees(radian));
                String radianString = String.format("%.2f", radian);
                System.out.println(radianString + " radians = " + degrees + " degrees");
            } else {
                int degrees = Integer.parseInt(str);
                double radians = Math.toRadians(degrees);
                String radianString = String.format("%.2f", radians);
                System.out.println(degrees + " degrees = " + radianString + " radians");
            }
        }
    }

}
