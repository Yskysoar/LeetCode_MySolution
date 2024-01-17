/**
 * @author Yskysoar
 * @createTime 2023-04-12 9:39
 * @description 1041. 困于环中的机器人
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * 机器人可以接受下列三条指令之一：
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 * 示例 1：
 * 输入：instructions = "GGLLGG"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * “L”:逆时针旋转90度。位置:(0,2).方向:西。
 * “L”:逆时针旋转90度。位置:(0,2)方向:南。
 * “G”:移动一步。位置:(0,1)方向:南。
 * “G”:移动一步。位置:(0,0)方向:南。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(0,2)——>(0,1)——>(0,0)。
 * 在此基础上，我们返回true
 * 示例 2：
 * 输入：instructions = "GG"
 * 输出：false
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * 重复这些指示，继续朝北前进，不会进入循环。
 * 在此基础上，返回false
 * 示例 3：
 * 输入：instructions = "GL"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “L”:逆时针旋转90度。位置:(0,1).方向:西。
 * “G”:移动一步。位置:(- 1,1)方向:西。
 * “L”:逆时针旋转90度。位置:(- 1,1)方向:南。
 * “G”:移动一步。位置:(- 1,0)方向:南。
 * “L”:逆时针旋转90度。位置:(- 1,0)方向:东方。
 * “G”:移动一步。位置:(0,0)方向:东方。
 * “L”:逆时针旋转90度。位置:(0,0)方向:北。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(- 1,1)——>(- 1,0)——>(0,0)。
 * 在此基础上，我们返回true。
 */
public class Solution1041 {
    public static void main(String[] args) {
        Solution1041 solution1041 = new Solution1041();
        boolean ans = solution1041.isRobotBounded("GG");
        System.out.println(ans);
    }

    /**
     * 每一条指令最终效果可以实现0°，90°，180°的偏移，要想不困在环中，就需要完成指令后必须是不位于原点且方向朝北
     * 90°偏转可以进行4次操作抵消，180°偏转可以进行2次操作抵消
     * 我们可以直接根据指令完成后的最终位置作为偏移矢量，来判断其偏移方向，无论过程如何变换方向都会被指令本身抵消剩下最终的偏移效果
     * @param instructions 待完成指令
     * @return 是否绕圈
     */
    public boolean isRobotBounded(String instructions) {
        boolean ans = true;
        int xIndex = 0;//横坐标
        int yIndex = 0;//纵坐标
        int direction = 1;//1：北  2：东  3：南  4：西
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'L' -> direction = (direction - 1 + 4) % 4;//逆时针成环
                case 'R' -> direction = (direction + 1) % 4;//顺时针成环
                case 'G' -> {
                    if (direction == 1) {
                        yIndex++;
                    } else if (direction == 2) {
                        xIndex++;
                    } else if (direction == 3) {
                        yIndex--;
                    } else {
                        xIndex--;
                    }
                }
            }
        }
        if ((xIndex != 0 || yIndex != 0) && direction == 1) ans = false;//必须是不位于原点且方向朝北才可以摆脱循环
        return ans;
    }
}



























