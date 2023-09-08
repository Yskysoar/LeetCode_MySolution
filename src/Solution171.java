public class Solution171 {
    public static void main(String[] args) {
        Solution171 solution171 = new Solution171();
        int res = solution171.titleToNumber("AAA");
        System.out.println(res);
    }
    public int titleToNumber(String columnTitle) {
        //特殊的26进制，A->1：65  Z->26：90
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int temp = columnTitle.charAt(i) -'A' + 1;
            res = res * 26 + temp;
            /* 26为一个进制，我们会从头到尾遍历整个columnTitle，我们从位权最高的项开始
               当我们每次循环一次，上一次的结果就要提高一次位权(索引从0开始刚好对应权重)
               如CBD = 3X26²+2X26¹+4X26⁰ -> 第一次循环:3 第二次循环:3X26+2 第三次循环:(3X26+2)X26+4
            */
        }
        return res;
    }
}
//暴力循环，每一个位置都遍历并且重新定义
//    public int titleToNumber(String columnTitle) {
//        //特殊的26进制，A->1：65  Z->26：90
//        int res = 0;
//        for (int i = 0; i < columnTitle.length(); i++) {
//            int temp = 0;
//            switch (columnTitle.charAt(i)) {
//                case 'A' -> temp = 1;
//                case 'B' -> temp = 2;
//                case 'C' -> temp = 3;
//                case 'D' -> temp = 4;
//                case 'E' -> temp = 5;
//                case 'F' -> temp = 6;
//                case 'G' -> temp = 7;
//                case 'H' -> temp = 8;
//                case 'I' -> temp = 9;
//                case 'J' -> temp = 10;
//                case 'K' -> temp = 11;
//                case 'L' -> temp = 12;
//                case 'M' -> temp = 13;
//                case 'N' -> temp = 14;
//                case 'O' -> temp = 15;
//                case 'P' -> temp = 16;
//                case 'Q' -> temp = 17;
//                case 'R' -> temp = 18;
//                case 'S' -> temp = 19;
//                case 'T' -> temp = 20;
//                case 'U' -> temp = 21;
//                case 'V' -> temp = 22;
//                case 'W' -> temp = 23;
//                case 'X' -> temp = 24;
//                case 'Y' -> temp = 25;
//                case 'Z' -> temp = 26;
//            }
//            res += Math.pow(26, columnTitle.length() - 1 - i) * temp;
//        }
//        return res;
//    }

//暴力循环，对遍历重定义进行优化
//    public int titleToNumber(String columnTitle) {
//        //特殊的26进制，A->1：65  Z->26：90
//        int res = 0;
//        for (int i = 0; i < columnTitle.length(); i++) {
//            int temp = columnTitle.charAt(i) -'A' + 1;
//            res += Math.pow(26, columnTitle.length() - 1 - i) * temp;
//        }
//        return res;
//    }