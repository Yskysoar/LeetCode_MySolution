import java.util.Arrays;

public class Solution88 {
    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] arr = new int[]{1, 2, 3, 0, 0, 0};
        solution88.merge4(arr, 3, new int[]{2, 3, 5}, 3);
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] res = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (p1 == m) {
                res[i] = nums2[p2++];
            } else if (p2 == n) {
                res[i] = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                res[i] = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                res[i] = nums2[p2++];
            }
        }
//        for (int i = 0; i < m + n; i++) {
//            nums1[i] = res[i];
//        }
        if (m + n >= 0) System.arraycopy(res, 0, nums1, 0, m + n);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i : nums2) {
            nums1[m++] = i;
        }
        Arrays.sort(nums1);
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        for (int i : nums2) {
            nums1[m++] = i;
        }
        for (int i = 1; i < m; i++) {
            boolean isSort = true;
            for (int j = 0; j < m - i; j++) {
                if (nums1[j] > nums1[j + 1]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[j + 1];
                    nums1[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p1 == -1) {
                nums1[i] = nums2[p2--];
            } else if (p2 == -1) {
                break;
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[i] = nums2[p2--];
            }
        }
    }
}
