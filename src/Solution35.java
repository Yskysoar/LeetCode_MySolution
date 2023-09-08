//力扣题库第35题
public class Solution35 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        int target = 1;
        Solution35 solution35 = new Solution35();
        int res = solution35.searchInsert3(nums, target);
        System.out.println(res);
    }
    public int searchInsert1(int[] nums, int target) {
        int start = 0;//起点
        int end = nums.length - 1;//终点
        int resNum = 0;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }else if (target < nums[0]) {
            return 0;
        }//判断首尾，直接放置
        while(start <= end) {
            int middle = (start + end) / 2;//中间位置
            if (target == nums[middle]) {
                resNum = middle;
                break;
            }else if (target > nums[middle]) {
                if (target < nums[middle + 1]) {
                    return middle + 1;
                }
                start = middle + 1;//middle已经判断过了，不用再判断了
            }else if (target < nums[middle]) {
                if (target > nums[middle - 1]) {
                    return middle;
                }
                end = middle - 1;//middle已经判断过了，不用再判断了
            }
        }
        return resNum;
    }
    public int searchInsert2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
    public int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (target <= nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
