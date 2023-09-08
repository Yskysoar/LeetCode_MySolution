import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-02-10 1:38
 * @description 2553. 分割数组中数字的数位
 *
 * 给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。
 * 对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。
 * 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1]
 */
public class Solution2553 {
    public static void main(String[] args) {
        Solution2553 solution2553 = new Solution2553();
        int[] res = solution2553.separateDigits(new int[]{13, 25, 83, 77});
        System.out.println(Arrays.toString(res));
    }

    public int[] separateDigits(int[] nums) {
        StringBuilder strNum = new StringBuilder();
        for (int num : nums) {
            strNum.append(num);
        }
        int[] answer = new int[strNum.length()];
        for (int i = 0; i < strNum.length(); i++) {
            answer[i] = strNum.charAt(i) - '0';
        }
        return answer;
    }
}
