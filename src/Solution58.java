public class Solution58 {
    public static void main(String[] args) {
        String s = "Hello World moon  ";
        Solution58 solution7 = new Solution58();
        int res = solution7.lengthOfLastWord(s);
        System.out.println(res);
    }

    public int lengthOfLastWord(String s) {
        int strLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && strLength != 0) {
                break;
            }
            if (s.charAt(i) != ' ') {
                strLength++;
            }
        }
        return strLength;
    }
}
