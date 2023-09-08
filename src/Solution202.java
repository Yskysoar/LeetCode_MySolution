import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        Boolean res = solution202.isHappy2(17);
        System.out.println(res);
    }
    public boolean isHappy1(int n) {//能凑到10^n就是快乐数，10以内只有1和7为快乐数，4->16->37->58->89->145->42->20->4
        while (true) {
            if (SquaresSum(n) != 1) {
                n = SquaresSum(n);
            } else {
                return true;
            }
            if (n < 10 && n > 1 && n != 7) {
                return false;
            }
        }
    }
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = SquaresSum(n);
        while (fast != 1 && slow != fast) {
            slow = SquaresSum(slow);//慢指针走一步
            fast = SquaresSum(SquaresSum(fast));//快指针走两步，1的平方和还是1，不影响
        }
        return fast == 1;
    }
    public boolean isHappy3(int n) {
        Set<Integer> cycleMembers = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
        while (n != 1 && !cycleMembers.contains(n)) {
            n = SquaresSum(n);
        }
        return n == 1;

    }
    public int SquaresSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
