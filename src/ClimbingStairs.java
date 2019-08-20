public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] numWays = new int[n+1];
        for (int i=0; i<n+1; i++) {
            numWays[i] = -1;
        }
        return util(n, numWays);
    }

    private int util(int n, int[] numWays) {

        if (n < 0) {
            return 0;
        }
        if (numWays[n] != -1) return numWays[n];
        if (n == 0) {
            numWays [n] = 1;
            return 1;
        }

        int result = util(n-1, numWays) + util(n-2, numWays);
        numWays[n] = result;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(4));
    }
}
