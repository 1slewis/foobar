import java.util.Arrays;

public class Solution {
    public static int recursiveMethod(int h, int qi) {
        int startNum = 0;
        for (int i = 0; i < h; i++) {
            startNum = (2 * startNum + 1);
            if (qi == startNum && h > (i + 1)) {
                int ret = (2 * startNum) + 1;
                return ret;
            }
            if (qi == 1 && h > (i + 1)) {
                return 3;
            }
            if (qi == (startNum - 1)) {
                return startNum;
            }
            if (qi < startNum) {
                int add = ((startNum - 1) / 2);
                int ret = add + Solution.recursiveMethod(i, qi - add);
                return ret;
            }
            return -1;
        }
    }
    public static int[] solution(int h, int[] q) {
        // Your code here
        int[] output = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            output[i] = Solution.recursiveMethod(h, q[i]);
        }
        return output;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(5, new int[]{19, 14, 28}))); // [21,15,29]
        System.out.println(Arrays.toString(Solution.solution(3, new int[]{7, 3, 5, 1}))); // [-1,7,6,3]
    }
}
