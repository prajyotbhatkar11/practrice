package practice.scaler.day10;

public class SubSequenceAG {
    public static void main(String[] args) {
        String A = "ABCGAG";
        System.out.println(solve(A));

    }

    public static int solve(String A) {
        int n = A.length();
        int mod = 1000000007;
        int countA = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'A') {
                countA++;
            } else if (A.charAt(i) == 'G') {
                count = count + countA;
                count = count % mod;
            }
        }
        return count;
    }
}
