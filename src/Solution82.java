/**
 * @author Yskysoar
 * @createTime 2024-01-15 22:41
 * @description 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的结点，只留下不同的数字 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 */
public class Solution82 {
    /**
     * 一次遍历：考虑到头结点也可能出现重复的情况，所以设置一个哑结点在头结点前面，然后记录设置一个结点记录位置后开始遍历，遇到重复数字的结点直接搜索到尾部然后重新链接即可
     * @param head 头结点
     * @return 无重复数字的链表头结点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode ans = new ListNode(-1, head);//哑结点
        ListNode num = ans;
        while (num.next != null && num.next.next != null) {
            if (num.next.val == num.next.next.val) {
                int n = num.next.val;
                while (num.next != null && num.next.val == n) {
                    num.next = num.next.next;
                }
            } else {
                num = num.next;
            }
        }
        return ans.next;
    }

    public static void main(String[] args) {
//        ListNode node7 = new ListNode(5);
//        ListNode node6 = new ListNode(4, node7);
//        ListNode node5 = new ListNode(4, node6);
//        ListNode node4 = new ListNode(3, node5);
//        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(1);
        ListNode node1 = new ListNode(1, node2);

        Solution82 solution82 = new Solution82();
        ListNode node = solution82.deleteDuplicates(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
