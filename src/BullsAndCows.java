import java.util.HashMap;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        HashMap<Integer, Integer> frequencySecret = new HashMap<>();
        HashMap<Integer, Integer> frequencyGuess = new HashMap<>();
        int numCows = 0;
        int numBulls = 0;
        for (int i=0;i<secret.length();i++) {
            int secretInteger = Integer.parseInt(secret.charAt(i)+"");
            int guessInteger = Integer.parseInt(guess.charAt(i)+"");

            if (secretInteger == guessInteger) {
                numBulls ++;
            }
            frequencySecret.put(secretInteger, frequencySecret.getOrDefault(secretInteger, 0) + 1);
            frequencyGuess.put(guessInteger, frequencyGuess.getOrDefault(guessInteger, 0) + 1);
        }

        for (int i = 0; i<10; i++) {
            numCows += Math.min(frequencyGuess.getOrDefault(i,0), frequencySecret.getOrDefault(i, 0));
        }
        numCows -= numBulls;
        return String.valueOf(numBulls)+"A"+String.valueOf(numCows)+"B";
    }
}
