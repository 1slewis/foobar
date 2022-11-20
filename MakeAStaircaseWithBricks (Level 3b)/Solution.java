public class Solution {
    public static int[] addArrays(int[] arrayA, int[] arrayB) {
        int length = arrayA.length;
        int[] arrayRet = new int[length];
        for (var a = 0; a < length; a++) {
            arrayRet[a] = arrayA[a] + arrayB[a];
        }
        return arrayRet;
    }
    public static int mathMethod(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (var i = 1; i < n; i++) {
            int[] newRes = new int[n + 1];
            for (var j = 0; j < res.length;j++) {
                if (j + i <= n) {
                    newRes[j + i] = res[j];
                }
            }
            res = Solution.addArrays(res, newRes);
        }
        return res[n];
    }
    public static int solution(int n) {
        // Your code here
        return mathMethod(n);
    }
    public static void main(String[] args) {
        System.out.println(Solution.solution(3)); //1
        System.out.println(Solution.solution(200)); //487067745
    }
}
