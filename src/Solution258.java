//力扣题库第258题
public class Solution258 {
    public static void main(String[] args) {
        Solution258 solution258 = new Solution258();
        int res = solution258.addDigits(38);
        System.out.println(res);
    }

    public int addDigits(int num) {
        //数学观察法：return (num - 1) % 9 +1;
        int sum = 0;
        while (num >= 0) {
            sum += num % 10;
            num /= 10;
            if (num == 0) {
                if (sum < 10) {
                    break;
                }
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }
}
