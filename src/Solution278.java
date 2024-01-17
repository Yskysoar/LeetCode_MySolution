public class Solution278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle = 0;
        while (left < right) {
            middle = (right - left) >> 1 + left;
            if (isBadVersion(middle) && !isBadVersion(middle - 1)) {
                break;
            } else if (isBadVersion(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return middle;
    }

    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (isBadVersion(middle)) {
                right = middle;//并不知道前一个版本是否是正确的
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int i) {
        return (int) (Math.random() * 3) <= 1;
    }
}
