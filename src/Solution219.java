import java.util.HashSet;

public class Solution219 {
    public static void main(String[] args) {
        Solution219 solution219 = new Solution219();
        boolean res = solution219.containsNearbyDuplicate1(new int[]{1, 0,1,1,}, 1);
        System.out.println(res);

    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + k && j < len; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

   public boolean containsNearbyDuplicate2(int[] nums, int k) {
       HashSet<Integer> set = new HashSet<>();
       int len = nums.length;
       for(int i = 0; i < len; i++) {
           if(set.contains(nums[i])) {
               return true;
           }
           set.add(nums[i]);
           if(set.size() > k) {
               set.remove(nums[i - k]);
           }
       }
       return false;
   }
}