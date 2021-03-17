//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/03/17 10:13
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        // 计算字符串p中各个元素出现的次数
        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        // 定义窗口区间
        int left = 0, right = -1;
        while (left < s.length()) {
            // 还有剩余元素未考察, 且窗口内字符串长度小于字符串p的长度
            if (right + 1 < s.length() && right - left + 1 < p.length()) {
                right++;
            } else {
                left++;
            }

            if (right - left + 1 == p.length() && isAnagrams(s.substring(left, right + 1), pFreq)) {
                resultList.add(left);
            }

        }
        return resultList;
    }

    /**
     * 判断是否是异位词
     *
     * @param window
     * @param pFreq
     * @return
     */
    private boolean isAnagrams(String window, int[] pFreq) {
        // 计算窗口内字符串各元素的出现次数
        int[] windowFreq = new int[26];
        for (int i = 0; i < window.length(); i++) {
            windowFreq[window.charAt(i) - 'a']++;
        }

        // 比较窗口内各元素的出现次数和字符串p中各元素的出现元素次数是否一样
        for (int j = 0; j < 26; j++) {
            if (windowFreq[j] != pFreq[j]) {
                return false;
            }
        }
        return true;
    }
}
