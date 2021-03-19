//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n

import java.util.List;

/**
 * 反转链表
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/03/19 21:46
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode flagNode = new ListNode(0, head);
        ListNode preNode = flagNode;

        // 先找到left所在节点指针，并记录它的前指针preNode
        int count = 0;
        while (preNode.next != null && count != left - 1) {
            count++;
            preNode = preNode.next;
        }

        ListNode curNode = preNode.next;
        ListNode tempNode = preNode.next;
        ListNode tppre = null, tpre = null;
        while (curNode != null && count < right) {
            tppre = tpre;
            tpre = curNode;
            curNode = curNode.next;
            tpre.next = tppre;
            count++;
        }

        preNode.next = tpre;
        tempNode.next = curNode;
        return flagNode.next;
    }
}
