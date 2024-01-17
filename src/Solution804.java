import java.util.HashSet;

/**
 * @author Yskysoar
 * @createTime 2023-02-08 20:55
 * @description 804. 唯一摩尔斯密码词
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 */

public class Solution804 {
    public static void main(String[] args) {
        Solution804 solution804 = new Solution804();
        int res = solution804.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        System.out.println(res);
    }

    /**
     * 先将解码规则存入数组，然后把单词及其字母一一翻译并存入set中去重
     * @param words 解码的单词
     * @return 解码结果不同的个数
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] password = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                int index = (word.charAt(j) - '0') - 49;
                temp.append(password[index]);
            }
            set.add(temp.toString());
        }
        return set.size();
    }
}

























