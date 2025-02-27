/**
 * @author Yskysoar
 * @createTime 2025-02-27 12:28
 * @description 2296. 设计一个文本编辑器
 * 请你设计一个带光标的文本编辑器，它可以实现以下功能：
 * 添加：在光标所在处添加文本。
 * 删除：在光标所在处删除文本（模拟键盘的删除键）。
 * 移动：将光标往左或者往右移动。
 * 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
 * 请你实现 TextEditor 类：
 * TextEditor() 用空文本初始化对象。
 * void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
 * int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
 * string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * 示例 1：
 * 输入：
 * ["TextEditor", "addText", "deleteText", "addText", "cursorRight", "cursorLeft", "deleteText", "cursorLeft",
 * "cursorRight"]
 * [[], ["leetcode"], [4], ["practice"], [3], [8], [10], [2], [6]]
 * 输出：
 * [null, null, 4, null, "etpractice", "leet", 4, "", "practi"]
 * 解释：
 * TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
 * textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
 * textEditor.deleteText(4); // 返回 4
 * // 当前文本为 "leet|" 。
 * // 删除了 4 个字符。
 * textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
 * textEditor.cursorRight(3); // 返回 "etpractice"
 * // 当前文本为 "leetpractice|".
 * // 光标无法移动到文本以外，所以无法移动。
 * // "etpractice" 是光标左边的 10 个字符。
 * textEditor.cursorLeft(8); // 返回 "leet"
 * // 当前文本为 "leet|practice" 。
 * // "leet" 是光标左边的 min(10, 4) = 4 个字符。
 * textEditor.deleteText(10); // 返回 4
 * // 当前文本为 "|practice" 。
 * // 只有 4 个字符被删除了。
 * textEditor.cursorLeft(2); // 返回 ""
 * // 当前文本为 "|practice" 。
 * // 光标无法移动到文本以外，所以无法移动。
 * // "" 是光标左边的 min(10, 0) = 0 个字符。
 * textEditor.cursorRight(6); // 返回 "practi"
 * // 当前文本为 "practi|ce" 。
 * // "practi" 是光标左边的 min(10, 6) = 6 个字符。
 * 提示：
 * 1 <= text.length, k <= 40
 * text 只含有小写英文字母。
 * 调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 10^4 次。
 */
public class Solution2296 {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorLeft(2));
        System.out.println(textEditor.cursorRight(6));
    }
}


class TextEditor {

    public StringBuffer textWindow;
    public int curIndex;

    public TextEditor() {
        textWindow = new StringBuffer();
        curIndex = 0;//下标所在的索引值，和右边的字符共享一个位置（curIndex的值就代表了光标左边有多少的字符）
    }

    public void addText(String text) {
        textWindow.insert(curIndex, text);//在当前光标位置开始添加文本,光标原右边的文本右移
        curIndex += text.length();
    }

    public int deleteText(int k) {
        if (curIndex >= k) {
            textWindow.delete(curIndex - k, curIndex);
            curIndex -= k;
            return k;
        } else {
            textWindow.delete(0, curIndex);
            int num = curIndex;
            curIndex = 0;
            return num;
        }
    }

    public String cursorLeft(int k) {
        if (curIndex >= k) {
            curIndex -= k;
            return textWindow.substring(curIndex - Math.min(10, curIndex), curIndex);
        } else {
            curIndex = 0;
            return "";
        }
    }

    public String cursorRight(int k) {
        if (curIndex + k <= textWindow.length()) {
            curIndex += k;
        } else {
            curIndex = textWindow.length();
        }
        return textWindow.substring(curIndex - Math.min(10, curIndex), curIndex);
    }
}