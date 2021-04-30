//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Related Topics 链表 双指针

/**
 * 旋转链表
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/04/30 20:13
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1, index;
        ListNode temp = head, newHead;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        // 循环链表
        temp.next = head;
        // 取余避免重复操作
        k %= len;
        // 新的链表头结点
        index = len - k;
        while (index-- > 0) {
            temp = temp.next;
        }
        newHead = temp.next;
        // 断开循环链表
        temp.next = null;
        return newHead;
    }
}
