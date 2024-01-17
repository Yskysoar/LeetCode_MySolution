public class Solution1025 {
    public static void main(String[] args) {
        Solution1025 solution1025 = new Solution1025();
        boolean res = solution1025.divisorGame(3);
        System.out.println(res);
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
