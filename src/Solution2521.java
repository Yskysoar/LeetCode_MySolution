import java.util.HashSet;

public class Solution2521 {
    public static void main(String[] args) {
        Solution2521 solution2521 = new Solution2521();
        int res = solution2521.distinctPrimeFactors2(new int[]{2, 4, 3, 7, 10, 6});
        System.out.println(res);
    }

    public int distinctPrimeFactors1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (isPrime(i)) {
                set.add(i);
            } else {
                for (int j = 2; j <= i; j++) {
                    if (i % j == 0) {
                        if (isPrime(j)) {
                            set.add(j);
                        }
                        i /= j;
                        j--;
                    }
                }
            }
        }
        return set.size();
    }

    public int distinctPrimeFactors2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {//除1外，一个数不是质数就是合数
            for (int j = 2; j * j <= i; j++) {//如果一个数是合数，那么它的因数除1外都是质数
                if (i % j == 0) {//因为限制条件是平方，所以符合判断条件的j一定是质数
                    set.add(j);
                    while (i % j == 0) {
                        i /= j;
                    }
                }
            }
            if (i > 1) {
                set.add(i);
            }
        }
        return set.size();
    }

    public boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
