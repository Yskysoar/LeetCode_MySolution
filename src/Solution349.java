import java.util.Arrays;

public class Solution349 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 5, 1, 3, 5, 7, 8};
        int[] arr2 = new int[]{5, 5};
        Solution349 solution349 = new Solution349();
        int[] res = solution349.intersection(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        //利用Arrays类进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //设置两个指针开始查找
        int[] temp = new int[Math.max(nums1.length, nums2.length)];//保证临时存放的数组不会出现越界
        int elementNum = 0;//记录交集元素数量
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {//当任意一个数组超出范围就可以停止了，因为是增序
            if (nums1[index1] == nums2[index2]) {
                if (elementNum == 0 || temp[elementNum - 1] != nums1[index1]) {//为了防止数组越界要把数量放在前面
                    temp[elementNum++] = nums1[index1];
                }
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOf(temp, elementNum);
    }
}
//    暴力
//    public int[] intersection(int[] nums1, int[] nums2) {
//        int[] temp = new int[Math.max(nums1.length, nums2.length)];
//        int elementNum = 0;
//        for (int value : nums1) {
//            for (int k : nums2) {
//                if (value == k) {
//                    temp[elementNum++] = value;
//                    break;
//                }
//            }
//        }
//        //temp里面现在存放的是所有的交集元素但是没有去重，接下来就是去重操作
//        //题目说明数组元素都大于0，所以重复的元素可以改为-1
//        int num = 0;//存放重复的元素个数
//        for (int i = 0; i < elementNum; i++) {
//            for (int j = i + 1; j < elementNum; j++) {
//                if (temp[i] == -1) {
//                    break;
//                }
//                if (temp[i] == temp[j]) {
//                    temp[j] = -1;
//                    num++;
//                }
//            }
//        }
//        int[] resArr = new int[elementNum - num];
//        int index = 0;
//        for (int i = 0; i < elementNum; i++) {
//            if (temp[i] > 0) {
//                resArr[index++] = temp[i];
//            }
//        }
//        return resArr;
//    }

