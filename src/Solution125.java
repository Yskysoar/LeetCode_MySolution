public class Solution125 {
    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        boolean res = solution125.isPalindrome("0P");
        System.out.println(res);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                str += s.charAt(i);
            }
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
