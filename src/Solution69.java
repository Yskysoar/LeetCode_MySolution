//力扣题库第69题
public class Solution69 {
    public static void main(String[] args) {
        Solution69 solution10 = new Solution69();
        int res = solution10.mySqrt(46340*46340 - 1);
        System.out.println(res);
    }
    public int mySqrt(int x) {
        return 0;
    }
}
//可以过但是效率低，时间复杂度太高
//    public int mySqrt(int x) {
//        //先找到左边最近的完全平方数
//        int recentNum = 0;
//        while (true) {
//            if (recentNum * recentNum < x) {
//                recentNum++;
//            }else if (recentNum *recentNum == x) {
//                return recentNum;
//            }else {
//                return recentNum - 1;
//            }
//            if (recentNum == 46340 && recentNum *recentNum <= x) {
//                return recentNum;
//            }
//        }
//    }