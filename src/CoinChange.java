public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[] result = new int[amount+1];
        for (int i=0; i<result.length;i++) {
            result[i] = -1;
        }
        result[0] = 0;

        return coinChangeUtil(coins, amount, result);
    }

    public int coinChangeUtil(int[] coins, int amount, int[] result) {
        if (result[amount] != -1) {
            return result[amount];
        }
        int minCoins = Integer.MAX_VALUE;

        for (int coin: coins) {
            if (amount >= coin) {
                minCoins = Math.min(minCoins, coinChangeUtil(coins, amount-coin, result));
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            result[amount] = 0;
            return 0;
        } else {
            result[amount] = minCoins+1;
            return minCoins+1;
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        new CoinChange().coinChange(coins, 11);
    }
}
