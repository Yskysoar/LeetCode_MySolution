public class Solution1669 {
    public static void main(String[] args) {

    }

    /**
     * 将[a,b]结点删除然后将list2接上删除位置
     * @param list1 初始链表
     * @param a 左边界
     * @param b 右边界
     * @param list2 接入链表
     * @return 接入后的list1链表的头指针
     */
    public ListNode mergeInBetween1(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = list1;//记录list1在a-1点的指针
        ListNode bNode = list1;//记录list1在b+1点的指针
        for (int i = 0; i < a - 1; i++) {
            aNode = aNode.next;//此时已经指向a-1点
        }
        for (int i = 0; i < b + 1; i++) {
            bNode = bNode.next;//此时已经指向b+1点
        }
        aNode.next = list2;
        while (aNode.next != null) {
            aNode = aNode.next;
        }
        aNode.next = bNode;
        return list1;
    }

    public ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = list1;//记录list1在a-1点的指针
        ListNode bNode = list1.next;//记录list1在b+1点的指针
        while (b-- > 0) {
            if (--a > 0) {
                aNode = aNode.next;
            }
            bNode = bNode.next;
        }
        aNode.next = list2;
        while (aNode.next != null) {
            aNode = aNode.next;
        }
        aNode.next = bNode;
        return list1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}