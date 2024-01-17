public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        boolean res = solution9.isPalindrome(9159519);
        System.out.println(res);
    }

    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
