//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
//
//
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
//
//
// 示例 2：
//
//
//输入：nums = [-1,0]
//输出：[-1,0]
//
//
// 示例 3：
//
//
//输入：nums = [0,1]
//输出：[1,0]
//
//
// 提示：
//
//
// 2 <= nums.length <= 3 * 104
// -231 <= nums[i] <= 231 - 1
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次
//
// Related Topics 位运算

/**
 * 只出现一次的数字II
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/04/04 23:10
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        // 把数组中的所有元素全部都异或一遍
        for (int num : nums) {
            bitmask ^= num;
        }
        // 因为异或运算的结果不一定都是2的n次幂
        // 在二进制中可能会有多个1，为了方便计算，我们只需保留其中的任何一个1，其他的都让他变为0，这里保留的是最右边的1
        bitmask &= -bitmask;
        int[] rets = {0, 0};
        for (int num : nums) {
            // 然后再把数组分为两部分，每部分在
            // 分别异或
            if ((num & bitmask) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
