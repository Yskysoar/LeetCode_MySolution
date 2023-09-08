public class Solution1534 {
    public static void main(String[] args) {
        Solution1534 solution1534 = new Solution1534();
        int res = solution1534.countGoodTriplets(new int[]{3,0,1,1,9,7}, 7 ,2, 3);
        System.out.println(res);
    }
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int resNum = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            resNum++;
                        }
                    }
                }
            }
        }
        return resNum;
    }
}
