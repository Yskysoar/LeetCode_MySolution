import java.util.HashSet;
import java.util.Set;

/**
 * @author Yskysoar
 * @createTime 2023-07-30 23:33
 * @description 142.环形链表II
 * 给定一个链表的头结点  head ，返回链表开始入环的第一个结点。 如果链表无环，则返回 null。
 * 如果链表中有某个结点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表结点
 * 解释：链表中有一个环，其尾部连接到第二个结点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表结点
 * 解释：链表中有一个环，其尾部连接到第一个结点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 */
public class Solution142 {
    public static void main(String[] args) {
        Solution142 solution142 = new Solution142();
    }

    /**
     * 暴力遍历：从每一个位置开始遍历，只要当前位置是入口，那么一定会第二次遍历到当前位置，返回即可
     * @param head 头结点
     * @return 环的入口
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode node1 = head;
        ListNode node2;
        while (node1 != null) {
            node2 = node1;
            for (int i = 0; i <= 10000; i++) {
                if (node2.next == null) {
                    return null;
                } else if (node2.next != node1) {
                    node2 = node2.next;
                } else {
                    return node1;
                }
            }
            node1 = node1.next;
        }
        return null;
    }

    /**
     * 哈希表：set去重，当第一个重复出现就是入口
     * @param head 头结点
     * @return 环的入口
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (!listNodes.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /*
      Q:为什么在第一圈就会相遇呢？
      A:设环的长度为 L，当慢指针刚进入环时，慢指针需要走 L 步(即 L 秒)才能走完一圈，此时快指针距离慢指针的最大距离为 L-1
        我们再次以慢指针为参考系，如上所说，快指针在按照1结点/秒的速度在追赶慢指针，所以肯定能在 L 秒内追赶到慢指针

      Q:快慢指针的数学计算
      A:https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     */

    /**
     * 快慢指针
     * @param head 头结点
     * @return 环的入口
     */
    public ListNode detectCycle3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {//排除空链表、单链表
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode start = head;
                ListNode end = slow;
                while (start != end) {
                    start = start.next;
                    end = end.next;
                }
                return start;
            }
        }
        return null;
    }

}

