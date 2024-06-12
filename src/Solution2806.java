/**
 * @author Yskysoar
 * @createTime 2024-06-12 9:19
 * @description
 */
public class Solution2806 {
    /**
     * 数学问题：四舍五入
     * @param purchaseAmount 购买金额
     * @return 支付后剩余金额
     */
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount / 10) * 10 - ((purchaseAmount % 10) >= 5 ? 10 : 0);
    }
}
