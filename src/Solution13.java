public class Solution13 {
    public static void main(String[] args) {
        Solution13 solution1 = new Solution13();
        int num = solution1.romanToInt("XIX");
        System.out.println(num);
    }

    public int romanToInt(String s) {
        int length = s.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case 'I' -> arr[i] = 1;
                case 'V' -> arr[i] = 5;
                case 'X' -> arr[i] = 10;
                case 'L' -> arr[i] = 50;
                case 'C' -> arr[i] = 100;
                case 'D' -> arr[i] = 500;
                case 'M' -> arr[i] = 1000;
            }
        }//将罗马数字转换成阿拉伯数字
        int res = 0;
        for (int m = 0; m < length; m++) {
            if (m < length - 1 && arr[m] < arr[m + 1]) {
                arr[m] = -arr[m];
            }//如果左边小于右边是减法，直接将减数变号即可
            res += arr[m];
        }
        return res;
    }
}
