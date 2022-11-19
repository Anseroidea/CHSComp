import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyAndPasteCodeFromHere {
//    public static void main(String[] args) throws FileNotFoundException {
//    }

    private static int binarySearch(int[] values, int target, int rangeStart, int rangeEnd) {
        if (rangeStart >= rangeEnd) {
            return values[rangeStart];
        }

    }

    public static int knapsack(int[] w, int[] v, int N, int W) {
        if (N <= 0 || W <= 0) return 0;
        int[][] m = new int[N + 1][W + 1];
        for (int j = 0; j < W; j++) {
            m[0][j] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - w[i - 1]] + v[i - 1]
                    );
                }
            }
        }
        return m[N][W];
    }

}
