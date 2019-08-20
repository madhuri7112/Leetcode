public class MinTicketsCost {
    public int mincostTickets(int[] days, int[] costs) {
         int[] result = new int[days.length];
         for (int i=0;i<result.length;i++) {
             result[i] = -1;
         }
         return util(days, 0, costs , result);
    }

    private int util(int[] days, int i, int[]  costs, int[] result) {
        if (i>=days.length) {
            return 0;
        }
        if (result[i] != -1) {
            return result[i];
        }
        //1 day cost
        int oneDayCost = costs[0];
        oneDayCost += util(days, i+1, costs, result);

        int sevenDayCost = costs[1];
        int j = i+1;
        while (j < days.length && days[j] < days[i]+7) {
            j++;
        }
        sevenDayCost += util(days, j, costs, result);

        int thirtyDayCost = costs[2];
        j = i+1;
        while (j < days.length && days[j] < days[i]+30) {
            j++;
        }
        thirtyDayCost += util(days, j, costs, result);

        int minCost = Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));

        result[i] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] tickets = {2,7,15};
        new MinTicketsCost().mincostTickets(days, tickets);
    }
}
