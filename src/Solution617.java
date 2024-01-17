/**
 * @author Yskysoar(我是傻逼 ， 很简单的东西写这么多)
 * @createTime 2023-08-14 21:09
 * @description 617.合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些结点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个结点重叠，那么将这两个结点的值相加作为合并后结点的新值；否则，不为 null
 * 的结点将直接作为新二叉树的结点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根结点开始。
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 */
public class Solution617 {
    public static void main(String[] args) {
        Solution617 solution617 = new Solution617();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = null;
        root1.left.left = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = null;
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        TreeNode ans = solution617.mergeTrees(root1, root2);
        solution617.preorder(ans);
    }

    /**
     * 前序遍历
     * @param treeNode 根结点
     */
    public void preorder(TreeNode treeNode) {
        System.out.print(treeNode.val);//输出父结点
        if (treeNode.left != null) preorder(treeNode.left);//如果当前结点的左结点不为空，则递归继续前序遍历
        if (treeNode.right != null) preorder(treeNode.right);//如果当前结点的右结点不为空，则递归继续前序遍历
    }

    /**
     * 深度优先搜索
     * @param t1 左结点
     * @param t2 右结点
     * @return 合并结点
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees2(t1.left, t2.left);
        merged.right = mergeTrees2(t1.right, t2.right);
        return merged;
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            TreeNode root = new TreeNode(root1.val + root2.val);
            preorder(root1, root2, root);
            return root;
        } else if (root1 == null && root2 == null) {
            return null;
        } else {
            return root1 != null ? root1 : root2;
        }
    }

    public void preorder(TreeNode root1, TreeNode root2, TreeNode root) {
        //左结点
        if (root1.left != null && root2.left != null) {
            root.left = new TreeNode(root1.left.val + root2.left.val);
            preorder(root1.left, root2.left, root.left);
        } else if (root1.left == null && root2.left == null) {
            root.left = null;
        } else {
            if (root1.left != null) {
                root.left = new TreeNode(root1.left.val);
                preorder(root1.left, new TreeNode(), root.left);
            } else {
                root.left = new TreeNode(root2.left.val);
                preorder(new TreeNode(), root2.left, root.left);
            }
        }
        //右结点
        if (root1.right != null && root2.right != null) {
            root.right = new TreeNode(root1.right.val + root2.right.val);
            preorder(root1.right, root2.right, root.right);
        } else if (root1.right == null && root2.right == null) {
            root.right = null;
        } else {
            if (root1.right != null) {
                root.right = new TreeNode(root1.right.val);
                preorder(root1.right, new TreeNode(), root.right);
            } else {
                root.right = new TreeNode(root2.right.val);
                preorder(new TreeNode(), root2.right, root.right);
            }
        }
    }
}


class TreeNode {
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
