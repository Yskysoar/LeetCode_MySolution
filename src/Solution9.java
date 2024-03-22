public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        boolean res = solution9.isPalindrome(9159519);
        System.out.println(res);
    }

    /**
     * 两端同时进行字符串的比对
     * @param x 待判断数据
     * @return 是否为回文数
     */
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        for (int i = 0; i < num.length() / 2; i++) {//转换为字符进行比较即可
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
