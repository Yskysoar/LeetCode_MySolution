/**
 * @author Yskysoar
 * @createTime 2023-02-07 0:13
 * @description 374.猜数字大小
 *
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 */
public class Solution374 {
    int pick = 50;

    public static void main(String[] args) {
        Solution374 solution374 = new Solution374();
        int res = solution374.guessNumber2(100);
        System.out.println(res);
    }

    public int guess(int num) {
        if (pick < num) {
            return -1;
        } else if (pick > num) {
            return 1;
        }
        return 0;
    }

    /**
     * 暴力遍历：绝对超时不用想了
     * @param n 猜数范围
     * @return 选中的数
     */
    public int guessNumber1(int n) {
        int i;
        for (i = 1; i <= n; i++) {
            if (guess(i) == 0) break;
        }
        return i;
    }

    /**
     * 二分查找：唯一注意的就是题目范围给的比较大，注意middle的定义不要超过int的内存容量
     * @param n 猜数范围
     * @return 选中的数
     */
    public int guessNumber2(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int middle = (end - start) / 2 + start;
            if (guess(middle) == 0) {
                return middle;
            } else if (guess(middle) == 1) {//pick大于我们选的数字
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }
}
