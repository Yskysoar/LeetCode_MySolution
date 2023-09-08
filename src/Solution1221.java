public class Solution1221 {
    public static void main(String[] args) {
        Solution1221 solution1221 = new Solution1221();
        int res = solution1221.balancedStringSplit("RLRRLLRLRL");
        System.out.println(res);
    }
    public int balancedStringSplit(String s) {//贪心算法
        int num = 0;
        int resNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                num++;
            }else {
                num--;
            }
            if (num == 0) {
                resNum++;
            }
        }
        return resNum;
    }
}
//暴力遍历
//    public int balancedStringSplit(String s) {
//        int numL = 0;
//        int numR = 0;
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == 'L') {
//                numL++;
//            }else if (s.charAt(i) == 'R') {
//                numR++;
//            }
//            if (numL == numR) {
//                num++;
//                numL = 0;
//                numR = 0;
//            }
//        }
//        return num;
//    }