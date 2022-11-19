import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// correct
// author: kason
public class chemistry {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("chemistry.dat"));
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            sc.nextInt();
            sc.nextLine();
            String[] values = sc.nextLine().split(" ");
            List<String> strs = new ArrayList<>(Arrays.asList(values));
            List<String> list = new ArrayList<>(getPermutations(strs));
            Collections.sort(list);
            for (int index = 0; index < list.size(); index++) {
                System.out.println((index + 1) + ". " + list.get(index));
            }
            System.out.println();
        }
    }

    private static final Map<List<String>, Set<String>> cache = new HashMap<>();

    public static Set<String> getPermutations(List<String> elements) {
        if (cache.containsKey(elements)) {
            return cache.get(elements);
        } else if (elements.size() == 1) {
            return new HashSet<>(elements);
        } else if (elements.size() == 2) {
            Set<String> res = new HashSet<>(
                    List.of(elements.get(0) + " " + elements.get(1),
                            elements.get(1) + " " + elements.get(0))
            );
            cache.put(elements, res);
            return res;
        }
        Set<String> finalResult = new HashSet<>();
        for (String element : elements) {
            List<String> without = new ArrayList<>(elements);
            without.remove(element);
            Set<String> results = getPermutations(without);
            for (String result : results) {
                finalResult.add(element + " " + result);
            }
        }
        cache.put(elements, finalResult);
        return finalResult;
    }
}
