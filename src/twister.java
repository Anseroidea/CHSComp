import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// correct
// author: kason
public class twister {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("twister.dat"));
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            String[] line = sc.nextLine().split(" ");
            boolean direction = line[0].equals("CL");
            int speed = switch (line[1]) {
                case "FAST" -> FAST;
                case "MEDIUM" -> MEDIUM;
                case "MEDIUM_FAST" -> MEDIUM_FAST;
                case "MEDIUM_SLOW" -> MEDIUM_SLOW;
                case "SLOW" -> SLOW;
                default -> throw new IllegalStateException();
            };
            int starting = switch (line[2]) {
                case "RED" -> RED;
                case "GREEN" -> GREEN;
                case "BLUE" -> BLUE;
                case "YELLOW" -> YELLOW;
                default -> throw new IllegalStateException();
            };
            System.out.println(values[find(direction, speed, starting)]);
        }
    }

    public static final int FAST = (int) (.4 * 360);
    public static final int MEDIUM_FAST = (int) (.7 * 360);
    public static final int MEDIUM = (int) (.3 * 360);
    public static final int MEDIUM_SLOW = (int) (.125 * 360);
    public static final int SLOW = (int) (.5 * 360);

    public static final int GREEN = 45;
    public static final int RED = 135;
    public static final int YELLOW = 225;
    public static final int BLUE = 315;

    public static final String[] values = {
            "GREEN",
            "RED",
            "YELLOW",
            "BLUE"
    };

    public static int find(boolean dir, int speed, int setup) {
        int result;
        if (!dir) { // cw
            result = setup - speed;
        } else {
            result = setup + speed;
        }
        return ((result + 360) % 360) / 90;
    }
}

