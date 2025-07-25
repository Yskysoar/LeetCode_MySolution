/**
 * @author Yskysoar
 * @createTime 2025-01-07 13:52
 * @description 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * 提示：
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
public class Solution104 {

    /**
     * 类深度优先遍历
     * @param root 根节点
     * @return 左右子树的最大高度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;//加一是记录本层高度
    }
}
