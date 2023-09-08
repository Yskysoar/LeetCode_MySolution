import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * @author Yskysoar
 * @createTime 2023-04-10 9:26
 * @description 1019. 链表中的下一个更大节点
 *
 * 给定一个长度为 n 的链表 head
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 * 示例 1：
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 */
public class Solution1019 {
    public static void main(String[] args) {
        Solution1019 solution1019 = new Solution1019();
        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(7, node2);
        ListNode head  = new ListNode(2, node1);
        int[] ans = solution1019.nextLargerNodes2(head);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 暴力遍历，寻找下一个严格大于的指针
     * @param head 头指针
     * @return 严格大节点值的数组
     */
    public int[] nextLargerNodes1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp;
        while (head != null) {
            int num = head.val;
            temp = head.next;
            while (temp != null) {
                if (num < temp.val) {
                    list.add(temp.val);
                    break;
                }
                temp = temp.next;
            }
            if (temp == null) list.add(0);
            head = head.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 单调栈
     * @param head 头指针
     * @return 严格大节点值的数组
     */
    public int[] nextLargerNodes2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Deque<int[]> stack = new ArrayDeque<>();
        ListNode temp = head;
        int index = -1;//记录每一个元素在链表的次序
        while (temp != null) {
            list.add(0);
            index++;
            while (!stack.isEmpty() && stack.peek()[0] < temp.val) {//栈不为空且栈顶元素小于
                list.set(stack.pop()[1], temp.val);
            }
            stack.push(new int[] {temp.val, index});
            temp = temp.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
