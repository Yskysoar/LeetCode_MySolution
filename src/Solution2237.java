/**
 * @author Yskysoar
 * @createTime 2023-08-21 14:06
 * @description 2237.移动片段得到字符串
 * 给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
 * 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动
 * 而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
 * 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
 * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：start = "_L__R__R_", target = "L______RR"
 * 输出：true
 * 解释：可以从字符串 start 获得 target ，需要进行下面的移动：
 * - 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
 * - 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
 * - 将第二个片段向右移动三步，字符串现在变为 "L______RR" 。
 * 可以从字符串 start 得到 target ，所以返回 true 。
 * 示例 2：
 * 输入：start = "R_L_", target = "__LR"
 * 输出：false
 * 解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
 * 但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
 * 示例 3：
 * 输入：start = "_R", target = "R_"
 * 输出：false
 * 解释：字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。
 */
public class Solution2237 {
    public static void main(String[] args) {
        Solution2237 solution2237 = new Solution2237();
        boolean ans = solution2237.canChange("_L__R__R_", "L______RR");
        System.out.println(ans);
    }

    /**
     * 双指针：先判断字符串的顺序是否匹配，然后再根据 目标的每个'L'必在源字符串的对应'L'的左侧 和 目标的每个'R'必在源字符串的对应'R'的右侧 两个条件去判断
     * @param start 初始字符串
     * @param target 目标字符串
     * @return 是否可以移动后匹配
     */
    public boolean canChange(String start, String target) {
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }//判断顺序是否相同，且如果相等说明两种字符的数量也一致
        int startIndex = 0;
        int targetIndex = 0;
        while (startIndex < start.length()) {//因为判断了字符串顺序，所以targetIndex不可能越界，只控制startIndex即可
            if (start.charAt(startIndex) == '_') {
                startIndex++;
                continue;
            }//初始字符串遇见空位直接跳过
            while (target.charAt(targetIndex) == '_') targetIndex++;//搜索下一个有效字符
            if (start.charAt(startIndex) == 'L' && startIndex < targetIndex) {//目标的"L"必须在起始字符串的左边
                return false;
            } else if (start.charAt(startIndex) == 'R' && startIndex > targetIndex) {//目标的"R"必须在起始字符串的右边
                return false;
            }
            //满足移动条件则当前位置字符合理，索引均加一开始下一个字符判断
            startIndex++;
            targetIndex++;
        }
        return true;
    }
}
