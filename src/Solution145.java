import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-01-15 14:02
 * @description 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 解释：
 * 示例 2：
 * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * 输出：[4,6,7,5,2,9,8,3,1]
 * 解释：
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 示例 4：
 * 输入：root = [1]
 * 输出：[1]
 * 提示：
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Solution145 {
    //封装遍历的结点
    public final List<Integer> ans = new ArrayList<>();

    /**
     * 后序遍历
     * @param root 根节点
     * @return 结点
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Postorder(root);
        return ans;
    }

    /**
     * 递归后序遍历
     * @param root 根节点
     */
    public void Postorder(TreeNode root) {
        if (root == null) return;
        Postorder(root.left);
        Postorder(root.right);
        ans.add(root.val);
    }
}
