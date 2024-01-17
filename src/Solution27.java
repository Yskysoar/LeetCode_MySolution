//力扣题库第27题
public class Solution27 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 2, 3};
        Solution27 solution = new Solution27();
        int res = solution.removeElement(nums, 3);
        System.out.println(res);

    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        boolean isFlag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                isFlag = true;
                break;
            }//只要有一个不相同就跳出循环，否则全部都是和val一样的数据直接全部清空
        }
        if (isFlag) {//至少有一个相同才会进这个循环，把符合的数据排到最后不影响判断
            int num = 0, res = 0;//记录剩余的数据个数
            for (int i = 0; i < nums.length; i++) {
                if (val == nums[i]) {
                    num++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    Swap(nums, i);
                    i--;
                }
                if (i + 1 == nums.length - num) {
                    res = i + 1;
                    break;
                }
            }
            return res;
        }
        return 0;
    }

    public void Swap(int[] n, int index) {
        for (int i = index; i < n.length - 1; i++) {
            int temp = n[i];
            n[i] = n[i + 1];
            n[i + 1] = temp;
        }
    }
}