import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int leftPointer = 0, rightPointer = people.length-1;

        while(leftPointer <= rightPointer) {
            int left = people[leftPointer];
            int right = people[rightPointer];


            if (left + right <= limit) {
                leftPointer++;
            }
            rightPointer--;
            count ++;
        }

        return count;

    }
}
