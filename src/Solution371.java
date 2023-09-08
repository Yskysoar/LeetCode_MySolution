public class Solution371 {
    public static void main(String[] args) {
        Solution371 solution371 = new Solution371();
        int res = solution371.getSum(5,9);
        System.out.println(res);
    }
    public int getSum(int a, int b) {
        int xorRes = a ^ b;//本位结果
        int andRes = (a & b) << 1;//上一位的进位
        if (b == 0) {
            return a;
        }
        return getSum(xorRes, andRes);
    }//数电全加器
}
