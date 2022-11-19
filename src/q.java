import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// incomplete
// author: aidan
public class q {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("q.dat"));
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            String[] str = sc.nextLine().split(" ");
            int[] ints = new int[str.length];
            for (int j = 0; j < str.length; j++) {
                ints[j] = Integer.parseInt(str[j]);
            }
            fifo(ints);
            lru(ints);

        }

    }

    public static void fifo(int[] line) {
        Queue<Integer> q = new LinkedList<>();
        int qnum = 0;
        for (int i = 0; i < line.length; i++) {
            int i1 = line[i];
            if (q.contains(i)) {
                continue;
            }
            if (q.size() == 3) {
                q.remove();
            }
            q.add(i1);
            qnum = (qnum + 1) % 3;
        }
        for (int i = qnum; i < 3; i++) {
            q.add(q.remove());
        }
        StringBuilder sb = new StringBuilder(" ");
        for (Integer i : q) {
            sb.append(i);
        }
        System.out.println("FIFO: " + sb.toString());
    }

    public static void lru(int[] line) {
        List<Integer> q = new ArrayList<>();
        int qnum = 0;
        for (int i = 0; i < line.length; i++) {
            int i1 = line[i];
            qnum = (qnum + 1) % 3;
            if (q.contains(i1)) {
                continue;
            }
            if (q.size() == 3) {
                q.set(qnum, i1);
            } else {
                q.add(i1);
            }
        }
        StringBuilder sb = new StringBuilder(" ");
        for (Integer i : q) {
            sb.append(i);
        }
        System.out.println("LRU: " + sb.toString());
    }


}
