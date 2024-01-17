import java.util.HashSet;

public class Solution575 {
    public static void main(String[] args) {
        Solution575 solution575 = new Solution575();
        int res = solution575.distributeCandies2(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 6, 4});
        System.out.println(res);
    }

    public int distributeCandies1(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);//本题关键就是去重
        }
        return Math.min(candyType.length / 2, set.size());
    }

    public int distributeCandies2(int[] candyType) {
        int count = 0;
        for (int i = 0; i < candyType.length; i++) {
            boolean isEqual = false;
            for (int j = i + 1; j < candyType.length; j++) {
                if (candyType[j] == candyType[i]) {
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                count++;
            }
        }
        return Math.min(candyType.length / 2, count);
    }
}
