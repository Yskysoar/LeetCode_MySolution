import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2023-08-29 16:38
 * @description 823.带因子的二叉树
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。
 * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 10^9 + 7 取余 的结果。
 * 示例 1:
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 * 输入: arr = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 */
public class Solution823 {
    public static void main(String[] args) {
        Solution823 solution823 = new Solution823();
        int ans = solution823.numFactoredBinaryTrees(new int[]{2, 4, 5, 10});
        System.out.println(ans);
    }

    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = (long) 1e9 + 7;//取模
        Arrays.sort(arr);//将输入数据排序，根结点按小到大
        HashMap<Integer, Long> hashMap = new HashMap<>();//存放每个数据作为根结点的子树数量
        for (int i = 0; i < arr.length; i++) {//每个数据作为根结点开始遍历
            hashMap.put(arr[i], 1L);//根结点加入map,本身也为一个解
            for (int j = 0; j < i; j++) {//找出每对因子
                if (arr[i] % arr[j] == 0 && hashMap.containsKey(arr[i] / arr[j])) {//arr[j]是它的因数且存在另外一个对应的因数
                    hashMap.put(arr[i], (hashMap.get(arr[i]) + hashMap.get(arr[j]) * hashMap.get(arr[i] / arr[j])) % MOD);
                }
            }
        }
        //直接使用stream流会溢出
        long ans = 0;
        for (long num : hashMap.values()) {
            ans = (ans + num) % MOD;
        }
        return (int) ans;
    }
}


