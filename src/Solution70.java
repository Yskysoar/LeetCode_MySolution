//力扣题库第70题
public class Solution70 {
    public static void main(String[] args) {
        Solution70 solution11 = new Solution70();
        int res = solution11.climbStairs(5);
        System.out.println(res);
    }
    public int climbStairs(int n) {
        //第n个阶梯的上法 = 第n-1个阶梯的上法 + 第n-2个阶梯的上法
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 2;//n-1
        int second = 1;//n-2
        int temp = 0;
        if (n >= 3) {
            for (int i = 0; i < n - 2; i++) {
                temp = first;
                first += second;
                second = temp;
            }
        }
        return first;
    }
}
