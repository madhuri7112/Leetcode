public class Teemo {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonEndTime = 0;
        int totalPoisonedDuration = 0;

        for (int startTime: timeSeries) {
            if (startTime > poisonEndTime) {
                totalPoisonedDuration += duration;
            } else {
                totalPoisonedDuration += duration - (poisonEndTime-startTime+1);
            }
            poisonEndTime = startTime + duration - 1;
        }

        return totalPoisonedDuration;
    }
}
