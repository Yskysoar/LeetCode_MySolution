/**
 * @author Yskysoar
 * @createTime 2025-01-07 14:30
 * @description 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 <= Node.val <= 10^4
 */
public class Solution110 {

    /**
     * 判断左右子树的高度是否合法即可
     * @param root 根
     * @return 是否平衡
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;//只有根或者为空
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;//加一是记录本层高度
    }

}
