import java.util.*;

public class Solution2089 {
    public static void main(String[] args) {
        Solution2089 solution2089 = new Solution2089();
        List<Integer> res = solution2089.targetIndices(new int[] {1,2,5,2,3}, 2);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
    //直接读数
    public List<Integer> targetIndices(int[] nums, int target) {
        int minTarget = 0;
        int resNum = 0;
        for (int i : nums) {
            if (i < target) {
                minTarget++;
            }else if (i == target) {
                resNum++;
            }
        }
        List<Integer> list = new ArrayList();
        while (resNum-- != 0) {
            list.add(minTarget++);
        }
        return list;
    }
}


//先排序后读数
//    public List<Integer> targetIndices(int[] nums, int target) {
//        Arrays.sort(nums);
//        int minTarget = 0;
//        int resNum = 0;
//        for (int i : nums) {
//            if (i < target) {
//                minTarget++;
//            }else if (i == target) {
//                resNum++;
//            }else {
//                break;
//            }
//        }
//        List<Integer> list = new ArrayList();
//        while (resNum-- != 0) {
//            list.add(minTarget++);
//        }
//        return list;
//    }
