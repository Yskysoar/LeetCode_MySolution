import java.util.Objects;

public class Solution290 {
    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        boolean res = solution290.wordPattern("abba", "dog cat cat dog");
        System.out.println(res);
    }
    public boolean wordPattern(String pattern, String s) {
        String[] patterns = pattern.split("");
        String[] words = s.trim().split("\\s+");
        if (patterns.length != words.length) {
            return false;
        }
        for (int i = 0; i < patterns.length; i++) {
            int index = -1;//记录首次出现的位置，每次循环都要重新初始化，否则存在数据不对应
            //因为单词长度不确定，用s.indexOF()获取的是单词首字母的位置而不是单词的位置
            for (int j = 0; j < words.length; j++) {
                if (Objects.equals(words[j], words[i])) {
                    index = j;//找到第一次出现的位置
                    break;
                }
            }
            if (pattern.indexOf(patterns[i]) != index) {//
                return false;
            }
        }
        return true;
    }
}
