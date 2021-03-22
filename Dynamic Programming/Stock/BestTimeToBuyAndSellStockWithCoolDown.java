package Stock;

//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//
//
// 示例:
//
// 输入: [1,2,3,0,2]
//输出: 3
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
// Related Topics 动态规划

/**
 * 最佳买卖股票时机含冷冻期
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/03/23 00:52
 */
public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // dp[i][j]表示[0, i]区间内，在下标为i这一天状态为j时，我们手上拥有的金钱数
        // j可以取3个值
        // 0表示：今天不是卖出股票的不持股状态；
        // 1表示：持股；
        // 2表示：今天由于卖出了股票的不持股状态；
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            // 手上不持有股票，并且今天不是由于卖出股票而不持股拥有的现金数
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][2]);
            // 手上持有股票时拥有的现金数
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
            // 手上不持有股票，并且今天是由于卖出而不持股拥有的现金数
            dp[i % 2][2] = dp[(i - 1) % 2][1] + prices[i];
        }
        return Math.max(dp[(len - 1) % 2][0], dp[(len - 1) % 2][2]);
    }
}
