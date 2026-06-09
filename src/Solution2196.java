import java.util.*;

/**
 * @author Yskysoar
 * @createTime 2026-06-08 02:18
 * @description 2196. 根据描述创建二叉树
 * 给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值
 * 互不相同 。此外：
 * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
 * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
 * 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
 * 测试用例会保证可以构造出 有效 的二叉树。
 * 示例 1：
 * 输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
 * 输出：[50,20,80,15,17,19]
 * 解释：根节点是值为 50 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 * 示例 2：
 * 输入：descriptions = [[1,2,1],[2,3,0],[3,4,1]]
 * 输出：[1,2,null,null,3,4]
 * 解释：根节点是值为 1 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 * 提示：
 * 1 <= descriptions.length <= 10^4
 * descriptions[i].length == 3
 * 1 <= parenti, childi <= 10^5
 * 0 <= isLefti <= 1
 * descriptions 所描述的二叉树是一棵有效二叉树
 */
public class Solution2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int[] description : descriptions) {//记录有哪些节点值
            hashSet.add(description[0]);
            hashSet.add(description[1]);
        }
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        for (int[] description : descriptions) {
            hashSet.remove(description[1]);//作为子节点不可能是根
            if (!hashMap.containsKey(description[0])) {
                int[] temp = new int[]{-1, -1};
                hashMap.put(description[0], temp);
            }
            if (description[2] == 1) {
                hashMap.get(description[0])[0] = description[1];
            } else {
                hashMap.get(description[0])[1] = description[1];
            }
        }
        // 根节点
        TreeNode root = new TreeNode(hashSet.iterator().next());

        // 队列建树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // 如果当前节点没有子节点信息，跳过
            if (!hashMap.containsKey(currentNode.val)) {
                continue;
            }

            int[] children = hashMap.get(currentNode.val);
            int leftVal = children[0];
            int rightVal = children[1];

            // 构建左子节点
            if (leftVal != -1) {
                currentNode.left = new TreeNode(leftVal);
                queue.offer(currentNode.left);
            }

            // 构建右子节点
            if (rightVal != -1) {
                currentNode.right = new TreeNode(rightVal);
                queue.offer(currentNode.right);
            }
        }
        return root;
    }

}
    