public class Offer10I {
    public static void main(String[] args) {
        Offer10I offer10I = new Offer10I();
        int res = offer10I.fib4(6);
        System.out.println(res);
    }
    public int fib1(int n) {//显然超时
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fib1(n - 1) % 1000000007 + fib1(n - 2) % 1000000007;
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];//第0项也在内
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 1000000007;
        }
        return nums[n];
    }

    public int fib3(int n) {
        int F0 = 0;
        int F1 = 1;
        int res = 0;
        if (n < 2) {
            return n;
        }
        while (n != 1) {
            res = (F1 + F0) % 1000000007;
            F0 = F1;
            F1 = res;
            n--;
        }
        return res;
    }

    public int fib4(int n) {
        int x = 0;
        int y = 1;
        for (int i = 0; i < n; i++) {
            int temp = (x + y) % 1000000007;
            x = y;
            y = temp;
        }
        return x;
    }
}
