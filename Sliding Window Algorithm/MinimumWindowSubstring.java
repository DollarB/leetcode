//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.HashMap;

/**
 * 最小覆盖子串
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/03/15 23:22
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // 需要凑齐的字符
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        // 窗口中的字符
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        // 增加right指针扩大窗口
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 从左边开始收缩窗口
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
