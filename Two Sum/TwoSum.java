//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/03/02 00:09
 */
public class TwoSum {

    /**
     * 暴力枚举
     *
     * 时间复杂度O(N2)
     * 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        boolean stop = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    stop = true;
                }

                if (stop) {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 哈希匹配
     *
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByHashMap(int[] nums, int target) {
        Map<Integer,Integer> res = new HashMap<>();
        for (int i = 0; i< nums.length;i++) {
            if (res.containsKey(target-nums[i])) {
                return new int[]{res.get(target-nums[i]),i};
            }
            res.put(nums[i],i);
        }
        return new int[0];
    }
}
