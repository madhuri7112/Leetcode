import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) {
            return 0;
        }
        int numPoints = 0;
        int maxPoints = 0;
        int currentPower = P;
        Arrays.sort(tokens);

        int leftPointer = 0, rightPointer = tokens.length-1;

        while (leftPointer <= rightPointer) {
            if (tokens[leftPointer] <= currentPower) {
                currentPower -= tokens[leftPointer];
                numPoints++;
                leftPointer ++;
            } else {
                if (numPoints == 0) {
                    return 0;
                }
                currentPower += tokens[rightPointer];
                numPoints--;
                rightPointer--;
            }
            maxPoints = Math.max(maxPoints, numPoints);
        }

        return maxPoints;
    }
}
