/**
 * @author Yskysoar
 * @createTime 2025-01-07 14:53
 * @description 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 提示：
 * 树中节点数的范围在 [0, 10^5] 内
 * -1000 <= Node.val <= 1000
 */
public class Solution111 {
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth1(root.right) + 1;
        if (root.right == null) return minDepth1(root.left) + 1;
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {//超时 （左右分支的处理过于复杂）
        if (root == null) return 0;
        if (minDepth2(root.left) == 0 && minDepth2(root.right) == 0) {
            return 1;
        } else if (minDepth2(root.left) != 0 && minDepth2(root.right) != 0) {//这个分支增加了大量的递归次数
            return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
        } else {
            return minDepth2(root.left) + minDepth2(root.right) + 1;
        }
    }
}
