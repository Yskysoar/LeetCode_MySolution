import java.math.BigInteger;

public class Solution66 {
    public static void main(String[] args) {
        Solution66 solution8 = new Solution66();
        for (int j : solution8.plusOne1(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})) {
            System.out.print(j);
        }
        System.out.println();
        for (int j : solution8.plusOne2(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})) {
            System.out.print(j);
        }
        System.out.println();
        for (int j : solution8.plusOne3(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 9, 9})) {
            System.out.print(j);
        }
    }

    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public int[] plusOne2(int[] digits) {
        StringBuilder str = new StringBuilder();
        for (int i : digits) {
            str.append(i);
        }
        String res = String.valueOf(new BigInteger(str.toString()).add(BigInteger.valueOf(Long.parseLong("1"))));
        int[] resArr = new int[res.length()];
        for (int i = 0; i < res.length(); i++) {
            resArr[i] = res.charAt(i) - '0';
        }
        return resArr;
    }

    public int[] plusOne3(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {//当前位置如果有低位进位且不为9就直接+1然后直接输出结果
                digits[i]++;
                return digits;
            } else if (digits[i] == 9) {//当前位置有低位的进位且为9需要把值重置为0且继续进位
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                res[i] = 0;
            }
            return res;
        }
        return digits;
    }
}