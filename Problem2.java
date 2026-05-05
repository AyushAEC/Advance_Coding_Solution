import java.util.*;

public class Problem2 {
    public static long minCost(int[] A, int K) {
        int N = A.length;
        if (K == 0) {
            for (int x : A) {
                if (x != A[0]) return -1;
            }
            return 0;
        }
        int remainder = A[0] % K;
        for (int i = 1; i < N; i++) {
            if (A[i] % K != remainder) {
                return -1;
            }
        }
        long[] C = new long[N];
        for (int i = 0; i < N; i++) {
            C[i] = (A[i] - remainder) / K;
        }
        Arrays.sort(C);
        long median = C[N / 2];
        long totalOps = 0;
        for (long val : C) {
            totalOps += Math.abs(val - median);
        }
        return totalOps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(minCost(A, K));
      
        sc.close();
    }
}
