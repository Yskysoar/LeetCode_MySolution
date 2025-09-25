import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-09-26 0:37
 * @description 611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * 示例 1:
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * 提示:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */
public class Solution611 {
    public static void main(String[] args) {
        Solution611 solution611 = new Solution611();
        System.out.println(solution611.triangleNumber2(new int[]{82, 15, 23, 82, 67, 0, 3, 92, 11}));
    }

    /**
     * 暴力
     * @param nums 三角形边长
     * @return 可以组成的三角形个数
     */
    public int triangleNumber1(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {//排序后一定是两个较小的边与最大的边比大小
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 双指针 + 滑动窗口
     * 固定最长边，找两个更小的边，当此时可以构成三角形时，最小边有富余
     * nums[i,j-1]范围内与nums[j]和nums[k]都可以组成三角形，否则需要增大最小的边
     * @param nums 三角形边长
     * @return 可以组成的三角形个数
     */
    public int triangleNumber2(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int k = nums.length - 1; k >= 0; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    ans += (j - i);//nums[i,j-1]范围内与nums[j]和nums[k]都可以组成三角形
                    j--;//第二大的边左移变小
                } else {
                    i++;//最小边右移变大
                }
            }
        }
        return ans;
    }

    public int triangleNumber3(int[] nums) {//我是傻逼
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {//统计各个数字的数量
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);//排序后一定是两个较小的边与最大的边比大小
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {//0直接跳过
                i += hashMap.get(0) - 1;
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] < nums[k]) break;//后面不可能有更小的边了
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {//三者相同则n*(n-1)*(n-2)/3!
                        ans += hashMap.get(nums[i]) * (hashMap.get(nums[i]) - 1) * (hashMap.get(nums[i]) - 2) / 6;
                        //k指针找到第一个不相同的元素，由于已经计数且排序，可以直接跳转
                        k += hashMap.get(nums[i]) - 3;//除去本身的三个数，且循环还有自动加一
                    } else if (nums[i] == nums[j] && nums[i] + nums[j] > nums[k]) {//此时nums[j] != nums[k]，则n*(n-1)/2*m
                        ans += (hashMap.get(nums[i]) * (hashMap.get(nums[i]) - 1) / 2) * hashMap.get(nums[k]);
                        k += hashMap.get(nums[k]) - 1;
                    } else if (nums[j] == nums[k] && nums[i] + nums[j] > nums[k]) {
                        ans += (hashMap.get(nums[j]) * (hashMap.get(nums[j]) - 1) / 2) * hashMap.get(nums[i]);
                        k += hashMap.get(nums[k]) - 2;
                    } else if (nums[i] + nums[j] > nums[k]) {
                        ans += (hashMap.get(nums[i]) * hashMap.get(nums[j]) * hashMap.get(nums[k]));
                        k += hashMap.get(nums[k]) - 1;
                    }
                }
                j += (nums[i] == nums[j] ? hashMap.get(nums[j]) - 2 : hashMap.get(nums[j]) - 1);
            }
            i += hashMap.get(nums[i]) - 1;
        }
        return ans;
    }
}
