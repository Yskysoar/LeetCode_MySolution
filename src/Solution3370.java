/**
 * @author Yskysoar
 * @createTime 2025-10-29 11:21
 * @description
 */
public class Solution3370 {
    public int smallestNumber(int n) {
        return (int) (Math.pow(2,Integer.toBinaryString(n).length())-1);
    }
}
