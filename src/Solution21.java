/**
 * @author Yskysoar
 * @createTime 2024-07-03 9:35
 * @description 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class Solution21 {

    /**
     * 非递减链表的拼接循环
     * @param list1 链表1
     * @param list2 链表2
     * @return 非递减拼接结果
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode listNode = new ListNode();
        ListNode ans = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                listNode.next = list1;
                list1 = list1.next;
            } else {
                listNode.next = list2;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }
        if (list1 == null) listNode.next = list2;
        if (list2 == null) listNode.next = list1;
        return ans.next;
    }
}
