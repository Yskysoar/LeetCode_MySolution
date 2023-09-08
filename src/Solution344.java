//力扣题库第344题
public class Solution344 {
    public static void main(String[] args) {
        char[] arr = new char[] {'h','e','l','l','o'};
        Solution344 solution344 = new Solution344();
        solution344.reverseString(arr);
    }
    void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
