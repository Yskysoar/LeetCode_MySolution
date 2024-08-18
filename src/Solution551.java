/**
 * @author Yskysoar
 * @createTime 2024-08-18 23:10
 * @description 551. 学生出勤记录 I
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * 示例 2：
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 */
public class Solution551 {
    public static void main(String[] args) {
        Solution551 solution551 = new Solution551();
        boolean ans = solution551.checkRecord("PPALLL");
        System.out.println(ans);
    }

    /**
     * 数据记录：单次遍历，只有一直遇到L，那么才会增加countL，遇到其他情况重置即可，缺勤正常记录
     * @param s 状态
     * @return 是否可以拿到奖励
     */
    public boolean checkRecord(String s) {
        int countL = 0;
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {//缺勤次数
                countL = 0;
                countA++;
                if (countA >= 2) return false;
            } else if (s.charAt(i) == 'L') {//迟到记录
                countL++;
                if (countL >= 3) return false;
            } else {
                countL = 0;
            }
        }
        return true;
    }
}
