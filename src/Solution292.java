public class Solution292 {
    public static void main(String[] args) {
        Solution292 solution292 = new Solution292();
        boolean res = solution292.canWinNim(51);
        System.out.println(res);
    }

    public boolean canWinNim(int n) {
        //4是获胜的判断条件，谁先到N-4的那个那个数谁一定可以赢
        return n % 4 != 0;
    }
}
