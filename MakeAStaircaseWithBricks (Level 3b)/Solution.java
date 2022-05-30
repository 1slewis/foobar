public class Solution {
    public static void addArrays(int[] arrayA, int[] arrayB) {
        int length = arrayA.length;
        int[] result = new int[length];
        for (var a = 0; a < length; a++) {
            arrayA[a] = arrayA[a] + arrayB[a];
        }
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
            Solution.addArrays(res, newRes);
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
