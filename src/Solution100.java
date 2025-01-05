import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yskysoar
 * @createTime 2025-01-05 21:07
 * @description 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
public class Solution100 {
    /**
     * 将左右子树遍历结果对比即可（不存在的记录为null）
     * @param p 树p
     * @param q 树q
     * @return 是否是相同的树
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        isSameTree p_tree = new isSameTree();
        isSameTree q_tree = new isSameTree();
        p_tree.inorderTraversal(p);
        q_tree.inorderTraversal(q);
        if (p_tree.ans.size() != q_tree.ans.size()) return false;
        for (int i = 0; i < p_tree.ans.size(); i++) {
            if (!Objects.equals(p_tree.ans.get(i), q_tree.ans.get(i))) return false;
        }
        return true;
    }
}

class isSameTree {
    public List<Integer> ans = new ArrayList<>();

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            ans.add(null);
            return;
        } else {
            ans.add(root.val);
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        } else {
            ans.add(null);
        }
        if (root.right != null) {
            inorderTraversal(root.right);
        } else {
            ans.add(null);
        }
    }
}
