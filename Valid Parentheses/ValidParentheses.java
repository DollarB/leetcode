//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: yage
 * @Email: yage@fordeal.com
 * @Date: 2021/03/08 00:46
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                deque.addLast('}');
            } else if (ch == '[') {
                deque.addLast(']');
            } else if (ch == '(') {
                deque.addLast(')');
            } else if (deque.isEmpty() || deque.removeLast() != ch) {
                return false;
            }
        }
        if (deque.isEmpty()) {
            return true;
        }

        return false;
    }
}
