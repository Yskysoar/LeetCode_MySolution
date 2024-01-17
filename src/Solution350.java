import java.util.Arrays;

public class Solution350 {
    public static void main(String[] args) {
        Solution350 solution350 = new Solution350();
        int[] res = solution350.intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(res));
    }

    /**
     * 暴力解法：双重遍历遇到一样的元素就添加到临时数组并且将其标记(元素默认不为负数，所以我们可以设置成负数)
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 交集元素数组
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        int index = 0;
        int[] temp = new int[Math.max(nums1.length, nums2.length)];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    temp[index++] = nums1[i];
                    nums2[j] = -1;
                    break;
                }
            }
        }
        return Arrays.copyOf(temp, index);
    }

    /**
     * 双指针解法：先将其数组排序，并且设置对应的指针，然后根据要求查找并移动指针
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 交集元素数组
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;//记录交集元素个数
        int indexI = 0;//数组一的指针
        int indexII = 0;//数组二的指针
        int[] temp = new int[Math.max(nums1.length, nums2.length)];//临时存放元素
        //因为排序了，任何一方越界那么后面就不可能有交集了
        while (indexI < nums1.length && indexII < nums2.length) {
            if (nums1[indexI] == nums2[indexII]) {//交集元素添加到临时数组并且指针都往前一步
                temp[index++] = nums1[indexI];
                indexI++;
                indexII++;
            } else if (nums1[indexI] < nums2[indexII]) {
                indexI++;
            } else {
                indexII++;
            }
        }
        return Arrays.copyOf(temp, index);
    }
}
