package practice.scaler.day9;

public class MinimumSeconds {
    public static void main(String[] args) {
//        int[] A = new int[]{2, 4, 1, 3, 2};
        int[] A = new int[]{731,349,490,781,271,405,811,181,102,126,866,16,622,492,194,735};
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        int curr = A[0];
        int max = A[1];
        int sum =0;
        for(int i =0; i<A.length; i++){
            if(A[i] > max){
                max = A[i];
                curr = A[i+1];
            }
//            System.out.println(max);
        }
        // System.out.println(max);
        for(int i =0; i< A.length; i++){
            sum = sum + max - A[i];
        }

        return sum;
    }
}
