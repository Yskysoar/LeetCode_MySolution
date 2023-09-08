import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-05-14 18:22
 * @description 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * 示例 1：
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 */
public class Solution1054WA {
    public static void main(String[] args) {
        Solution1054WA solution1054 = new Solution1054WA();
        int[] ans = solution1054.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
        System.out.println(Arrays.toString(ans));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int indexA = 0;//循环指针
        int indexB = 1;//寻找指针
        while (indexA < barcodes.length && indexB < barcodes.length) {
            if (barcodes[indexA] == barcodes[indexB]) {
                while (++indexB < barcodes.length) {
                    if (barcodes[indexA] != barcodes[indexB]) {
                        barcodes[indexA + 1] ^= barcodes[indexB];
                        barcodes[indexB] ^= barcodes[indexA + 1];
                        barcodes[indexA + 1] ^= barcodes[indexB];
                        break;
                    }
                }
            }
            indexA++;
            indexB = indexA + 1;
        }
        return barcodes;
    }
}
