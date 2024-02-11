import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2024-02-11 19:23
 * @description 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Solution144 {
    //封装遍历的结点
    public final List<Integer> ans = new ArrayList<>();

    /**
     * 前序遍历
     * @param root 根节点
     * @return 结点
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Preorder(root);
        return ans;
    }

    /**
     * 递归前序遍历
     * @param root 根节点
     */
    public void Preorder(TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        Preorder(root.left);
        Preorder(root.right);
    }


}
