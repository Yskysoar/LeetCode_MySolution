/**
 * @author Yskysoar
 * @createTime 2023-08-25 21:50
 * @description 1448.统计二叉树中好结点的数目
 */
public class Solution1448 {
    public int ans = 1;//根结点一定是好结点

    public static void main(String[] args) {
        Solution1448 solution1448 = new Solution1448();
        TreeNode node6 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8, null, node5);
        TreeNode node3 = new TreeNode(10);
        TreeNode node2 = new TreeNode(4, node3, node4);
        TreeNode node1 = new TreeNode(2, null, node2);
        int ans = solution1448.goodNodes(node1);
        System.out.println(ans);
    }

    public int goodNodes(TreeNode root) {
        int pathMax = root.val;//路径中的最大值
        dfs(root, pathMax);
        return ans;
    }

    /**
     * 深度优先搜索：记录路径上的最大值，与两个子结点进行比较，符合条件就记录，无论是否符合，都继续深度搜索
     * @param root    根结点
     * @param pathMax 路径上的最大值
     */
    public void dfs(TreeNode root, int pathMax) {
        int left = pathMax;
        int right = pathMax;
        if (root.left != null) {//左结点
            if (root.left.val >= left) {
                ans++;
                left = root.left.val;
            }//判断结点是否是好结点
            dfs(root.left, left);
        }
        if (root.right != null) {//右结点
            if (root.right.val >= right) {
                ans++;
                right = root.right.val;
            }//判断结点是否是好结点
            dfs(root.right, right);
        }
    }
}
