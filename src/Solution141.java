import java.util.HashSet;
import java.util.Set;

public class Solution141 {
    public static void main(String[] args) {
        Solution141 solution141 = new Solution141();
        int[] nums = {3, 2, 0, 4};
        ListNode listNode = new ListNode(nums[0]);
        boolean res = solution141.hasCycle1(listNode);
        System.out.println(res);
    }


    public boolean hasCycle1(ListNode head) {
        ListNode fastPoint = head;
        ListNode slowPoint = head;
        /*
            因为fastPoint走的快，所以用它来做判断
            防止fastPoint本身为空，所以判断要放在前面
            这样可以避免空链表以及到链表边界出现null.next的情况
         */
        while (fastPoint != null && fastPoint.next != null) {
            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;
            if (fastPoint == slowPoint) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        int num = 0;
        while (head != null && num <= 10000) {
            head = head.next;
            num++;
        }
        return num > 10000;
    }

    public boolean hasCycle3(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (!listNodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}