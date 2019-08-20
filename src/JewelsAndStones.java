import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        HashSet jewels = new HashSet<Character>();
        J.chars().forEach(jewel -> jewels.add(jewel));
        AtomicInteger numJewels = new AtomicInteger(0);
        S.chars().forEach(stone -> {
            if (jewels.contains(stone)) {
                numJewels.getAndIncrement();
            }
        });

        return numJewels.get();
    }

    public static void main(String[] args) {
        System.out.print(numJewelsInStones("aA", "aAAbbbb"));
    }
}
