import java.util.Arrays;

public class Solution283 {
    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] arr = new int[]{0, 0, 1, 2, 0, 3};
        solution283.moveZeroes5(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes1(int[] nums) {
        int pIndex = 0;//指向索引
        int pNum = 0;//指向结果
        while (pIndex != nums.length) {
            if (nums[pIndex] != 0) {
                nums[pNum++] = nums[pIndex];
            }
            pIndex++;
        }
        for (int i = pNum; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int pNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pNum++] = nums[i];
            }
        }
        for (int i = pNum; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int index = 0;
        int[] arr = new int[nums.length];
        for (int i : nums) {
            if (i != 0) {
                arr[index++] = i;
            }
        }
        System.arraycopy(arr, 0, nums, 0, nums.length);
    }

    public void moveZeroes4(int[] nums) {
        int num = 0;//记录要移动的0的数量
        for (int i = 0; i < nums.length - 1; i++) {
            if (i + 1 == nums.length - num) {
                break;//当前索引位置等于总长度减去移动的0的数量即可停止循环
            }
            if (nums[i] == 0) {
                num++;
                for (int j = i; j < nums.length - 1; j++) {//将当前元素冒泡到最后一个位置
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                i--;//因为后一位元素前移了，所以当前位置要再次判断
            }
        }
    }

    public void moveZeroes5(int[] nums) {
        int k = 0;//记录0的个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k++;
            } else if (k > 0) {
                nums[i - k] = nums[i];//[(i+1)-k]-1:（当前遍历的元素个数 - 0的个数） - 1 = 当前非零数的索引
                nums[i] = 0;
            }
        }
    }
}
