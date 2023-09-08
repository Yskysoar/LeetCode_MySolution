import java.util.Arrays;

//力扣题库第1620题
public class Solution1620 {
    public static void main(String[] args) {
        Solution1620 solution1620 = new Solution1620();
        int[][] arr = new int[][] {{42, 7, 9},{1,2,5}};
        int radius = 2;
        int[] res = new int[2];
        res = solution1620.bestCoordinate(arr, radius);
        System.out.println(Arrays.toString(res));

    }
    //二维欧几里得距离：sqrt((x^2 + y^2),2)
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] res = new int[] {0,0};//存放答案
        //只有一个信号塔的时候，如果有信号，那本身信号最强
        if (towers.length == 1 && towers[0][2] != 0) {
            res = new int[] {towers[0][0], towers[0][1]};
            return res;
        }else if (towers.length == 1 && towers[0][2] == 0) {
            return res;
        }
        //当信号塔大于1个的时候，数据比较小可以遍历
        int max = 0;
        for (int x = 0; x < 51; x++) {
            for (int y = 0; y < 51; y++) {
                int temp = 0;
                for (int[] t:towers) {
                    double xLength = Math.pow(t[0] - x, 2);
                    double yLength = Math.pow(t[1] - y, 2);
                    double lengthTowers = Math.sqrt(xLength + yLength);
                   if (lengthTowers <= radius) {
                       temp += t[2] / (1 + lengthTowers);
                   }//遍历每一个信号塔，temp存放多个信号塔叠加的信号
                }
                if (max < temp) {
                    max = temp;
                    res = new int[] {x, y};
                }
            }
        }
        return res;
    }
}
