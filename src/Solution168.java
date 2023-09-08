//力扣题库第168题
public class Solution168 {
    public static void main(String[] args) {
        Solution168 solution168 = new Solution168();
        String res =solution168.convertToTitle(27);
        System.out.println(res);
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; columnNumber > 0; i++) {
            columnNumber--;
            res.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }//ASCII:0->A->"65":1 25->Z->"90":26
        res.reverse();
        return res.toString();
    }
}
//方法一样，int转换ascii转换String的操作过于复杂
//public String convertToTitle(int columnNumber) {
//    int[] arr = new int[7];//int类型用26进制表示，7位就够了
//    int num = 0;
//    for (int i = 0; columnNumber > 0; i++) {
//        columnNumber--;
//        arr[i] = columnNumber % 26;
//        num++;
//        columnNumber /= 26;
//    }
//    //ASCII:0->A->"65":1 25->Z->"90":26
//    String res = String.valueOf((char)(arr[num - 1] + 65));
//    for(int i = num - 2; i >= 0; i--) {
//        char temp = (char)(arr[i] + 65);
//        res += temp;
//    }
//    return res;
//}