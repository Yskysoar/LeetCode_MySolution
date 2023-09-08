import java.util.Arrays;
import java.util.HashSet;

public class Solution26 {
    public static void main(String[] args) {
        int[] n = new int[]{1,1,2};
        Solution26 solution26 = new Solution26();
        int length = solution26.removeDuplicates1(n);
        System.out.println(length);
        System.out.println(Arrays.toString(n));
    }
    public int removeDuplicates1(int[] nums) {
        int num = 0;//记录要舍去的重复元素数量
        for (int i = 0; i < nums.length - 1; i++) {
            if (i + 1 == nums.length - num) {
                break;//当前索引位置等于总长度减去重复元素数量即可停止循环
            }
            if (nums[i] == nums[i + 1]) {//当前一个元素和后一个元素一样的时候就是有重复元素
                num++;
                for (int j = i; j < nums.length - 1; j++) {//将当前元素冒泡到最后一个位置
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                i--;//因为后一位元素前移了，所以当前位置要再次判断
            }
        }
        return nums.length - num;
    }

    public int removeDuplicates2(int[] nums) {
        //获取长度
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        //重置数组
        int pIndex = 0;//数组目前的索引位置
        int pNum = 0;//新数组元素
        while (pNum != set.size() - 1) {
            if (nums[pIndex] == nums[pNum]) {
                pIndex++;
            } else {
                nums[++pNum] = nums[pIndex];
            }
        }
        return set.size();
    }

    public int removeDuplicates3(int[] nums) {
        int pIndex= 0;
        int pNum = 0;
        while (pIndex != nums.length) {
            if (nums[pIndex] == nums[pNum]) {
                pIndex++;
            } else {
                nums[++pNum] = nums[pIndex];
            }
        }
        return pNum + 1;
    }

    public int removeDuplicates4(int[] nums) {
        int pNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pNum] != nums[i]) {
                nums[++pNum] = nums[i];
            }
        }
        return pNum + 1;
    }
}
