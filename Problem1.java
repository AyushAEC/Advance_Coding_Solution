import java.util.*;

public class Problem1 {
    public static int maxSum(String S) {
        int n = S.length();
        if (n == 0) return 0;
        String T = S + S;
        int len = T.length(); 
      
        Map<Character, Integer> freq = new HashMap<>();
        int currentSum = 0;
        int maxSum = 0;
        int left = 0;
        for (int right = 0; right < len; right++) {
            char c = T.charAt(right);
            while (freq.getOrDefault(c, 0) > 0 || (right - left) >= n) {
                char lc = T.charAt(left);
                freq.put(lc, freq.get(lc) - 1);
                if (freq.get(lc) == 0) freq.remove(lc);
                currentSum -= (lc - 'a' + 1);
                left++;
            }
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            currentSum += (c - 'a' + 1);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String S = sc.nextLine().trim();
        System.out.println("Max Cyclic Substring Sum = " + maxSum(S));
        
        sc.close();
    }
}
