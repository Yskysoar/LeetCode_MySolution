import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Yskysoar
 * @createTime 2023-08-15 16:51
 * @description 833.字符串中的查找与替换
 * 你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
 * 要完成第 i 个替换操作:
 * 检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
 * 如果没有出现， 什么也不做 。
 * 如果出现，则用 targets[i] 替换 该子字符串。
 * 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
 * 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
 * 例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
 * 在对 s 执行所有替换操作后返回 结果字符串 。
 * 子字符串 是字符串中连续的字符序列。
 * 示例 1：
 * 输入：s = "abcd", indices = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * 输出："eeebffff"
 * 解释：
 * "a" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
 * "cd" 从 s 中的索引 2 开始，所以它被替换为 "ffff"。
 * 示例 2：
 * 输入：s = "abcd", indices = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * 输出："eeecd"
 * 解释：
 * "ab" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
 * "ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
 */
public class Solution833 {
    public static void main(String[] args) {
        Solution833 solution833 = new Solution833();
        String ans = solution833.findReplaceString("jjievdtjfb", new int[]{4,6,1}, new String[]{"md","tjgb","jf"}, new String[]{"foe","oov","e"});
        System.out.println(ans);
    }

    /**
     * 索引值+哈希表：按照索引值从大到小的顺序来进行操作，进行拼接
     * @param s 原字符串
     * @param indices 待操作索引组
     * @param sources 带操作索引组对应字符串
     * @param targets 替换后的字符串
     * @return 操作后的字符串
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder ans = new StringBuilder();
        int[] index = indices.clone();
        Arrays.sort(index);
        //处理开头
        if (index[0] != 0) {
            ans.append(s, 0, index[0]);
        }
        for (int i = 0; i < index.length - 1; i++) {
            int target = index[i];
            OptionalInt optionalInt = IntStream.range(0, indices.length).filter(j -> indices[j] == target).findFirst();
            int indexOfReal = optionalInt.getAsInt();
            if (s.substring(indices[indexOfReal]).indexOf(sources[indexOfReal]) == 0) {//判断是否在当前索引存在子字符串
                ans.append(targets[indexOfReal]);//存在就进行替换
                ans.append(s, index[i] + sources[indexOfReal].length(), index[i + 1]);//将中间位置拼接
            } else {
                ans.append(s, index[i], index[i + 1]);
            }
        }
        //处理结尾
        int target = index[index.length - 1];
        OptionalInt optionalInt = IntStream.range(0, indices.length).filter(j -> indices[j] == target).findFirst();
        int indexOfReal = optionalInt.getAsInt();
        if (s.substring(indices[indexOfReal]).indexOf(sources[indexOfReal]) == 0) {
            ans.append(targets[indexOfReal]);
            ans.append(s, target + sources[indexOfReal].length(), s.length());
        } else {
            ans.append(s, target, s.length());
        }
        return ans.toString();
    }
}
