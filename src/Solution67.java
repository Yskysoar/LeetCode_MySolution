//力扣题库第67题
public class Solution67 {
    public static void main(String[] args) {

    }
    public String addBinary(String a, String b) {
        return "0";
    }
}
//存在越界问题
//    public String addBinary(String a, String b) {
//        int aNum = Integer.parseInt(a);
//        int bNum = Integer.parseInt(b);
//        String num = String.valueOf(aNum + bNum);
//        int[] arrNum = new int[num.length() + 1];
//        arrNum[0] = 0;
//        for (int i = arrNum.length - 1; i >= 1; i--) {
//            arrNum[i] = num.charAt(i - 1) - '0';
//        }
//        boolean isCarryOver = false;
//        for (int i = arrNum.length - 1; i >= 0; i--) {
//            if (isCarryOver) {
//                arrNum[i]++;
//                isCarryOver = false;
//            }
//            if (arrNum[i] == 2) {
//                arrNum[i] = 0;
//                isCarryOver = true;
//            }else if (arrNum[i] == 3) {
//                arrNum[i] = 1;
//                isCarryOver = true;
//            }
//        }
//        String res = "";
//        for (int i = 0; i < arrNum.length; i++) {
//            if (arrNum[0] == 0) {
//                arrNum[0] = -1;
//                continue;
//            }
//            res += String.join("", arrNum[i] + "");
//        }
//        return res;
//    }