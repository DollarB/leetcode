/**
 * 二叉树
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/03/02 02:00
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
