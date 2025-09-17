import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Yskysoar
 * @createTime 2025-09-17 13:22
 * @description 2349. 设计数字容器系统
 * 设计一个数字容器系统，可以实现以下功能：
 * 在系统中给定下标处 插入 或者 替换 一个数字。
 * 返回 系统中给定数字的最小下标。
 * 请你实现一个 NumberContainers 类：
 * NumberContainers() 初始化数字容器系统。
 * void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
 * int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
 * 示例：
 * 输入：
 * ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
 * [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
 * 输出：
 * [null, -1, null, null, null, null, 1, null, 2]
 * 解释：
 * NumberContainers nc = new NumberContainers();
 * nc.find(10); // 没有数字 10 ，所以返回 -1 。
 * nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
 * nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
 * nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
 * nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
 * nc.find(10); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
 * nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
 * nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
 * 提示：
 * 1 <= index, number <= 10^9
 * 调用 change 和 find 的 总次数 不超过 10^5 次。
 */
public class Solution2349 {
    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        System.out.println(numberContainers.find(10));
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        numberContainers.change(5, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
    }
}

class NumberContainers {
    public HashMap<Integer, Integer> nums = new HashMap<>();
    public HashMap<Integer, PriorityQueue<Integer>> places = new HashMap<>();

    /**
     * 在指定位置替换或插入元素
     * @param index  指定位置
     * @param number 元素
     */
    public void change(int index, int number) {
        // 更新 index -> number
        nums.put(index, number);
        // 把 index 丢进对应 number 的堆里
        places.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
    }


    /**
     * 懒删除匹配
     * @param number 待查找元素
     * @return 待查找元素的最小索引
     */
    public int find(int number) {
        if (!places.containsKey(number)) return -1;
        PriorityQueue<Integer> priorityQueue = places.get(number);

        // 懒删除：清理堆顶过期元素(将对应位置和nums中检查是否匹配)
        while (!priorityQueue.isEmpty() && !nums.get(priorityQueue.peek()).equals(number)) {
            priorityQueue.poll();
        }
        return priorityQueue.isEmpty() ? -1 : priorityQueue.peek();
    }
}