public class Solution2535 {
    public static void main(String[] args) {
        Solution2535 solution2535 = new Solution2535();
        int res = solution2535.differenceOfSum2(new int[]{1000});
        System.out.println(res);
    }

    public int differenceOfSum1(int[] nums) {
        int sumElement = 0;
        int sumNumber = 0;
        for (int i : nums) {
            sumElement += i;
            while (i > 0) {
                sumNumber += i % 10;
                i /= 10;
            }
        }
        return sumElement - sumNumber;
    }

    public int differenceOfSum2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            if (i < 100) {//两位数
                sum += (i / 10) * 9;
            } else if (i < 1000) {//三位数
                sum += (i / 10) % 10 * 9 + (i / 100) * 99;
            } else if (i < 10000) {//四位数
                sum += (i / 10) % 10 * 9 + (i / 100) % 10 * 99 + (i / 1000) * 999;
            }
        }
        return sum;
    }

    public int differenceOfSum3(int[] nums) {
        int sumElement = 0;
        int sumNumber = 0;
        for (int i : nums) {
            sumElement += i;
            for (char j : Integer.toString(i).toCharArray()) {
                sumNumber += j - '0';
            }
        }
        return sumElement - sumNumber;
    }
}
