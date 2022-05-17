public class Solution {
    public static String solution(long x, long y) {
        //Your code here
        long n = (x + y - (long)2);
        long result = (n * (n + (long)1)) / (long)2;
        return Long.toString(result + x);
    }
    public static void main(String[] args) {
        System.out.println(Solution.solution(5, 10)); // 96
        System.out.println(Solution.solution(3, 2)); // 9
    }
}
