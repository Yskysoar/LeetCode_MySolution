import java.util.ArrayList;

/**
 * @author Yskysoar
 * @createTime 2023-07-31 21:59
 * @description 143.重排链表
 * 给定一个单链表 L 的头结点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯改变结点内部的值，而是需要实际的进行结点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 */
public class Solution143 {
    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node0 = new ListNode(0, node1);
        solution143.reorderList(node0);
        while (node0 != null) {
            System.out.println(node0.val);
            node0 = node0.next;
        }
    }

    /**
     * 线性表：先将单向链表保存到表中，然后根据要求插入即可
     * (若n+1为奇数，有n/2组，有中轴；若n+1为偶数，有(n+1)/2组，无中轴；只要到了索引为(n)/2就要开始反向排序)
     * @param head 头结点
     */
    public void reorderList(ListNode head) {
        ListNode node = head;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (node != null) {
            listNodes.add(node);
            node = node.next;
        }
        if (listNodes.size() <= 2) return;
        ListNode start = head;
        ListNode end = head.next;
        for (int i = listNodes.size() - 1; i > listNodes.size() / 2; i--) {
            start.next = listNodes.get(i);
            listNodes.get(i).next = end;
            start = end;
            end = end.next;
        }
        listNodes.get(listNodes.size() / 2).next = null;
    }
}

/*
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 */