public class Solution121 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        Solution121 solution121 = new Solution121();
        int res = solution121.maxProfit1(arr);
        System.out.println(res);
    }

    public int maxProfit1(int[] prices) {//超时，时间复杂度太高
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    /**
     * 贪心算法，记录前i天的最小买入，前i天的最大利润和第i天的利润比较
     * @param prices 股价
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        int minCost = prices[0];
        int maxProfit = 0;
        for (int i : prices) {
            minCost = Math.min(minCost, i);
            maxProfit = Math.max(maxProfit, i - minCost);
        }
        return maxProfit;
    }

    /**
     * 贪心算法，逆序记录第i天右边的最高价，最高价和第i天的差就是当前利润，当前利润和最大利润比较即可
     * @param prices 股价
     * @return 最大利润
     */
    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        int maxPrice = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
        }
        return maxProfit;
    }
}