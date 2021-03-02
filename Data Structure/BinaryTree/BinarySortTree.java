/**
 * 二叉排序树
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/18 21:42
 */
public class BinarySortTree {

    private Node root = null;

    /**
     * 二叉排序树插入
     *
     * @param key
     */
    public void insertBST(int key) {
        Node p = root;
        Node prev = null;
        while (p != null) {
            prev = p;
            if (key < p.getValue()) {
                p = p.getLeft();
            } else if (key > p.getValue()) {
                p = p.getRight();
            } else {
                return;
            }
        }

        if (root == null) {
            root = new Node(key);
        } else if (key < prev.getValue()) {
            prev.setLeft(new Node(key));
        } else {
            prev.setRight(new Node(key));
        }
    }


    /**
     * 删除二叉排序树中的结点
     * 分为三种情况：（删除结点为*p 。其父结点为*f）
     * （1）要删除的*p结点是叶子结点，仅仅须要改动它的双亲结点的指针为空
     * （2）若*p仅仅有左子树或者仅仅有右子树，直接让左子树/右子树取代*p
     * （3）若*p既有左子树，又有右子树，用p左子树中最大的那个值（即最右端S）取代P。删除s，重接其左子树
     *
     * @param key
     */
    public void deleteBST(int key) {
        deleteBST(root, key);
    }

    private boolean deleteBST(Node node, int key) {
        if (node == null) {
            return false;
        } else {
            if (key == node.getValue()) {
                return delete(node);
            } else if (key < node.getValue()) {
                return deleteBST(node.getLeft(), key);
            } else {
                return deleteBST(node.getRight(), key);
            }
        }
    }

    private boolean delete(Node node) {
        Node temp = null;
        // 右子树空，仅仅须要重接它的左子树
        // 假设是叶子结点，在这里也把叶子结点删除了
        if (node.getRight() == null) {
            temp = node;
            node = node.getLeft();
        }
        // 左子树空， 重接它的右子树
        else if (node.getLeft() == null) {
            temp = node;
            node = node.getRight();
        }
        // 左右子树均不为空
        else {
            temp = node;
            Node s = node;
            // 转向左子树，然后向右走到“尽头”
            s = s.getLeft();
            while (s.getRight() != null) {
                temp = s;
                s = s.getRight();
            }
            node.setValue(s.getValue());
            if (temp != node) {
                temp.setRight(s.getLeft());
            } else {
                temp.setLeft(s.getLeft());
            }
        }
        return true;
    }

    /**
     * 二叉排序树查询
     *
     * @param key
     * @return
     */
    public boolean searchBST(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.getValue()) {
                return true;
            } else if (key < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    /**
     * 中序非递归遍历二叉树
     * 获得有序序列
     */
    public void nrInOrderTraverse() {
        StringBuilder sb = new StringBuilder("中序遍历结果为: ");
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            sb.append(node.getValue() + " ");
            node = node.getRight();
        }
        System.out.println(sb);
    }
}
