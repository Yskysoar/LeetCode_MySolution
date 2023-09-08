public class Solution2413 {
    public static void main(String[] args) {
        Solution2413 solution2413 = new Solution2413();
        int res = solution2413.smallestEvenMultiple(5);
        System.out.println(res);
    }
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return 2 * n;
    }
}
