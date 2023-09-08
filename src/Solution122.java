public class Solution122 {
    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int res = solution122.maxProfit1(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }
    public int maxProfit1(int[] prices) {
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        boolean isCost = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < cost) {
                cost = prices[i];
                isCost = true;
            }
            if (prices[i + 1] > prices[i] && isCost) {
                profit += prices[i + 1] - prices[i];
                isCost = false;
                cost = Integer.MAX_VALUE;
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i  = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
