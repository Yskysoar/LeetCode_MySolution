import java.util.Objects;

//力扣题库14题
class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strings = new String[]{"flower", "flow", "flight"};
        String res = solution14.longestCommonPrefix(strings);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }//如果数组的长度为0说明数组里面没有元素，返回""
        String initStrs = strs[0];//设置第一个元素为初始值去做判断
        if (Objects.equals(initStrs, "")) {//如果初始值是空元素那么直接返回""
            return "";
        }
        for (int i = 1; i < length; i++) {
            int j = 0;//因为需要在循环外知道终止的位置，所以j不能在循环内定义
            for (; j < strs[i].length() && j < initStrs.length(); j++) {
                if (strs[i].charAt(j) != initStrs.charAt(j)) {
                    break;
                }//当判断到两边的字母不相等的时候结束判断，j对应的位置就是不同的位置
            }//假如循环不提前终止，说明出现比较的元素是初始值的子集，因为for循环的原理最后一次会自己+1然后结束循环，刚好就是子集的长度
            //假如循环提前终止，因为break直接离开循环，所以j的值刚好就是新公共前缀的长度
            if (initStrs.length() > j) {
                initStrs = "";
                for (int o = 0; o < j; o++) {
                    initStrs += strs[0].charAt(o);
                }
            }
        }
        return initStrs;
    }
}