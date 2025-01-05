import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-01-05 20:59
 * @description 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Solution94 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return ans;
        if (root.left != null) inorderTraversal1(root.left);
        ans.add(root.val);
        if (root.right != null) inorderTraversal1(root.right);
        return ans;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
