/**
 * @author Yskysoar
 * @createTime 2025-09-23 1:55
 * @description 165. 比较版本号
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 * 返回规则如下：
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 * 示例 1：
 * 输入：version1 = "1.2", version2 = "1.10"
 * 输出：-1
 * 解释：
 * version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
 * 示例 2：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：
 * 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
 * 示例 3：
 * 输入：version1 = "1.0", version2 = "1.0.0.0"
 * 输出：0
 * 解释：
 * version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
 * 提示：
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是 有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
 */
public class Solution165 {
    public static void main(String[] args) {
        Solution165 solution165 = new Solution165();
        System.out.println(solution165.compareVersion2("1.2", "1.10"));
    }

    /**
     * 分割 + 模拟比较
     * @param version1 版本号1
     * @param version2 版本号1
     * @return 版本号大小关系
     */
    public int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            if (i >= v1.length) {//v1后面都是0，检查v2是否有非零版本号即可
                while (i < v2.length) if (Integer.parseInt(v2[i++]) != 0) return -1;
                break;
            }
            if (i >= v2.length) {//v2后面都是0，检查v1是否有非零版本号即可
                while (i < v1.length) if (Integer.parseInt(v1[i++]) != 0) return 1;
                break;
            }
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return 1;
            } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 双指针
     * 分别记录同一级的对应版本号然后比较大小
     * @param version1 版本号1
     * @param version2 版本号1
     * @return 版本号大小关系
     */
    public int compareVersion2(String version1, String version2) {
        int index1 = 0, index2 = 0;//记录索引
        while (index1 < version1.length() && index2 < version2.length()) {//找同一级非零版本号比较
            int v1 = 0, v2 = 0;//记录当前同一级版本号的值
            while (index1 < version1.length() && version1.charAt(index1) == '0' && version1.charAt(index1) != '.')
                index1++;//找到第一个非零元素
            if (index1 < version1.length()) {
                if (version1.charAt(index1) != '.') {//否则说明之前全是0
                     int split1 = index1;
                    while (split1 < version1.length() && version1.charAt(split1) != '.') split1++;//找到分割点
                    v1 = Integer.parseInt(version1.substring(index1, split1));
                    index1 = split1 + 1;
                } else {
                    index1++;
                }
            }
            while (index2 < version2.length() && version2.charAt(index2) == '0' && version2.charAt(index2) != '.')
                index2++;//找到第一个非零元素
            if (index2 < version2.length()) {
                if (version2.charAt(index2) != '.') {//否则说明之前全是0
                    int split2 = index2;
                    while (split2 < version2.length() && version2.charAt(split2) != '.') split2++;//找到分割点
                    v2 = Integer.parseInt(version2.substring(index2, split2));
                    index2 = split2 + 1;
                } else {
                    index2++;
                }
            }
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        while (index1 < version1.length()) {
            if (version1.charAt(index1) != '0' && version1.charAt(index1) != '.') return 1;
            index1++;
        }
        while (index2 < version2.length()) {
            if (version2.charAt(index2) != '0' && version2.charAt(index2) != '.') return -1;
            index2++;
        }
        return 0;
    }
}
