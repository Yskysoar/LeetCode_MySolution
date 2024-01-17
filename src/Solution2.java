import java.math.BigInteger;

/**
 * @author Yskysoar
 * @createTime 2024-01-17 21:50
 * @description 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode node11 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(9, node9);
        ListNode node7 = new ListNode(9, node8);
        ListNode node6 = new ListNode(9, node7);
        ListNode node5 = new ListNode(9, node6);
        ListNode node4 = new ListNode(9, node5);
        ListNode node3 = new ListNode(9, node4);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode ans = solution2.addTwoNumbers3(node1, node11);
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
    }

    /**
     * 合并链表(使用辅助空间)：直接计算每一位的结果和进位存放到新的链表即可
     * @param l1 链表1的头结点
     * @param l2 链表2的头结点
     * @return 结果合并链表的头结点
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);//相加结果链表
        ListNode ans = head;//存储答案的头结点
        while (l1 != null && l2 != null) {
            if ((l1.val + l2.val + head.val) >= 10) {//需要进位
                head.val = l1.val + l2.val + head.val - 10;
                head.next = new ListNode(1);//因为Node.val之和最大为18
            } else {//不需要进位
                head.val = l1.val + l2.val + head.val;
                head.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null && head.next.val == 0) {//链表长度一致且没有进位，没有剩余的数据需要写入
                head.next = null;
            }
            head = head.next;
        }
        //将剩余的数据进行写入，考虑到有先前的进位需要先判断是否需要向后进位，然后再判断是否是最后一个数据(是否需要创建新的结点)
        while (l1 != null) {
            if (l1.val + head.val >= 10) {
                head.next = new ListNode(1);
            } else {
                if (l1.next == null) {
                    head.next = null;
                } else {
                    head.next = new ListNode(0);
                }
            }
            head.val = ((l1.val + head.val >= 10) ? l1.val + head.val - 10 : l1.val + head.val);
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null) {
            if (l2.val + head.val >= 10) {
                head.next = new ListNode(1);
            } else {
                if (l2.next == null) {
                    head.next = null;
                } else {
                    head.next = new ListNode(0);
                }
            }
            head.val = ((l2.val + head.val >= 10) ? l2.val + head.val - 10 : l2.val + head.val);
            l2 = l2.next;
            head = head.next;
        }
        return ans;
    }

    /**
     * 合并链表(不使用辅助空间)
     * @param l1 链表1的头结点
     * @param l2 链表2的头结点
     * @return 结果合并链表的头结点
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode[] ans = new ListNode[]{l1, l2};
        int num = 0;//记录进位
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + num;
            if (sum >= 10) {
                l1.val = sum - 10;
                l2.val = sum - 10;
                num = 1;
            } else {
                l1.val = sum;
                l2.val = sum;
                num = 0;
            }
            if (l1.next == null && l2.next == null) {//当前位置为尾结点且链表长度一致
                if (num != 0) {//有进位
                    l1.next = new ListNode(1);
                }
                return ans[0];
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (num == 0) {//只要没有进位就可以直接结束合并
                return ans[0];
            } else {//存在初始进位
                if (l1.val + num >= 10) {//仍需要进位
                    l1.val = l1.val + num - 10;
                } else {
                    l1.val = l1.val + num;
                    num = 0;
                }
            }
            if (num != 0 && l1.next == null) {//当前为尾节点计算完后仍需要进位
                l1.next = new ListNode(1);
                num = 0;
            } else if (num == 0 && l1.next == null) {
                return ans[0];
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            if (num == 0) {//只要没有进位就可以直接结束合并
                return ans[1];
            } else {//存在初始进位
                if (l2.val + num >= 10) {//仍需要进位
                    l2.val = l2.val + num - 10;
                } else {
                    l2.val = l2.val + num;
                    num = 0;
                }
            }
            if (num != 0 && l2.next == null) {//当前为尾节点计算完后仍需要进位
                l2.next = new ListNode(1);
                num = 0;
            } else if (num == 0 && l2.next == null) {
                return ans[1];
            }
            l2 = l2.next;
        }
        return null;
    }

    /**
     * 计算求值：直接得出链表的数据然后合并，最后结果划分存入链表
     * @param l1 链表1的头结点
     * @param l2 链表2的头结点
     * @return 结果合并链表的头结点
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        BigInteger num1 = BigInteger.valueOf(l1.val);
        BigInteger num2 = BigInteger.valueOf(l2.val);
        BigInteger n1 = BigInteger.valueOf(10);
        BigInteger n2 = BigInteger.valueOf(10);
        while (l1.next != null) {
            l1 = l1.next;
            num1 = num1.add(BigInteger.valueOf(l1.val).multiply(n1));
            n1 = n1.multiply(BigInteger.valueOf(10));
        }
        while (l2.next != null) {
            l2 = l2.next;
            num2 = num2.add(BigInteger.valueOf(l2.val).multiply(n2));
            n2 = n2.multiply(BigInteger.valueOf(10));
        }
        String strNum = num1.add(num2).toString();
        ListNode head = new ListNode(-1);//相加结果链表
        ListNode ans = head;//存储答案的头结点
        for (int i = strNum.length() - 1; i >= 0; i--) {
            int digit = strNum.charAt(i) - '0';
            head.next = new ListNode(digit);
            head = head.next;
        }
        return ans.next;
    }
}
