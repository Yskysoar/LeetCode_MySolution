public class Solution1876 {
    public static void main(String[] args) {
        Solution1876 solution1876 = new Solution1876();
        int res = solution1876.countGoodSubstrings("a");
        System.out.println(res);
    }

    public int countGoodSubstrings(String s) {
        int resNum = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) != s.charAt(i) && s.charAt(i) != s.charAt(i + 1) && s.charAt(i - 1) != s.charAt(i + 1)) {
                resNum++;
            }
        }
        return resNum;
    }
}
