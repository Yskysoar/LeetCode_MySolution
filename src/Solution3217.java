import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Yskysoar
 * @createTime 2025-11-01 9:59
 * @description 3217. 从链表中移除在数组中存在的节点
 * 给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。
 * 示例 1：
 * 输入： nums = [1,2,3], head = [1,2,3,4,5]
 * 输出： [4,5]
 * 解释：
 * 移除数值为 1, 2 和 3 的节点。
 * 示例 2：
 * 输入： nums = [1], head = [1,2,1,2,1,2]
 * 输出： [2,2,2]
 * 解释：
 * 移除数值为 1 的节点。
 * 示例 3：
 * 输入： nums = [5], head = [1,2,3,4]
 * 输出： [1,2,3,4]
 * 解释：
 * 链表中不存在值为 5 的节点。
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * nums 中的所有元素都是唯一的。
 * 链表中的节点数在 [1, 105] 的范围内。
 * 1 <= Node.val <= 105
 * 输入保证链表中至少有一个值没有在 nums 中出现过。
 */
public class Solution3217 {
    public static void main(String[] args) {
        Solution3217 solution3217 = new Solution3217();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode ans = solution3217.modifiedList(new int[]{1, 2, 3}, node1);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    /**
     * 快慢双指针 + hashset空间换时间
     * 找到不需要删除的元素赋值即可，并不需要真的删除
     * @param nums 待删除元素值
     * @param head 链表头结点
     * @return 删除对应元素后的头结点
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode ans = new ListNode();
        ListNode index = head;
        HashSet<Integer> num = new HashSet<>();
        for (int i : nums) num.add(i);
        while (index != null) {//找到第一个合适的数
            if (!num.contains(index.val)) {
                ans = index;
                head = index;
                index = index.next;
                break;
            }
            index = index.next;
        }
        while (index != null) {//此时index是ans的下一个节点
            if (!num.contains(index.val)) {
                ans = ans.next;
                ans.val = index.val;
            }
            index = index.next;
        }
        ans.next = null;
        return head;
    }
}
