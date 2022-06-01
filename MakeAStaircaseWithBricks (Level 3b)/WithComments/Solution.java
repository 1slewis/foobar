public class Solution {
    public static void addArrays(int[] arrayA, int[] arrayB) {
        // This function just gets the contents of two arrays and adds them element by element arithmetically
        // This function mutates arrayA as I am using loops not recursion (However arrayA isnt a public property)
        int length = arrayA.length;
        int[] result = new int[length];
        for (var a = 0; a < length; a++) {
            arrayA[a] = arrayA[a] + arrayB[a];
        }
    }
    public static int mathMethod(int n) {
        // Main logic for multiplying 1(1+x^1)(1+x^2)...
        // Answer is obtained by finding the coefficent of the x^n term which is how many ways to get x^n and x^a * x^b = x^a+b
        // So the answer a in ax^n is addition of unique numbers 
        // Initiate an array just bigger than n
        int[] res = new int[n + 1];
        // First coefficient x^0 == 1 as 1(1+x)(1+x^2) there is an original 1 outside the bracket
        res[0] = 1;
        for (var i = 1; i < n; i++) {
            // Initiate a new Array to contain the x^i * by the already calculated sum
            int[] newRes = new int[n + 1];
            for (var j = 0; j < res.length; j++) {
                // If the sum of indexes is greater than what we need then discard the result
                if (j + i <= n) {
                    // Add the indexes to calculate the new positon of the coefficent
                    newRes[j + i] = res[j];
                }
            }
            // Add 1 * res and x^i * res
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
