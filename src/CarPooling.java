public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] numPassengers = new int[1002];
        for (int[] trip: trips) {
            numPassengers[trip[1]] += trip[0];
            numPassengers[trip[2]] -= trip[0];
        }

        int currentPassengerCount = 0;
        for (int num: numPassengers) {
            currentPassengerCount += num;
            if (currentPassengerCount > capacity) {
                return false;
            }
        }

        return true;
    }
}
