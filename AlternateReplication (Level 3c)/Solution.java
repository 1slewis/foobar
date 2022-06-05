import java.math.BigInteger;

class Solutions {
    BigInteger distance;
    BigInteger xBigInt;
    BigInteger yBigInt;
    BigInteger small;
    BigInteger big;
    public String calc() {
        while (true) {
            if (small.compareTo(new BigInteger("1")) == 0) {
                return big.add(this.distance).subtract(new BigInteger("1")).toString();
            }
            if (small.compareTo(new BigInteger("1")) == -1) {
                return "impossible";
            }
            BigInteger diff = big.subtract(small);
            BigInteger amountOfSkips = diff.divideAndRemainder(small)[0];
            if (amountOfSkips.compareTo(new BigInteger("1")) >= 0) {
                big = new BigInteger(big.subtract(amountOfSkips.multiply(small)).toString());
            }
            distance = new BigInteger(distance.add(amountOfSkips).toString());
            BigInteger parentX = big.subtract(small);
            BigInteger parentY = small;
            if (parentX.compareTo(parentY) > 0) {
                big = parentX;
                small = parentY;
            }
            if (parentX.compareTo(parentY) < 0) {
                big = parentY;
                small = parentX;
            }
            distance = distance.add(new BigInteger("1"));
        }
        //return this.distance.toString();
    }
    public Solutions(String x, String y) {
        distance = new BigInteger("0");
        xBigInt = new BigInteger(x);
        yBigInt = new BigInteger(y);
        if (xBigInt.compareTo(yBigInt) >= 0) {
            big = xBigInt;
            small = yBigInt;
        }
        if (xBigInt.compareTo(yBigInt) == -1) {
            big = yBigInt;
            small = xBigInt;
        }
    }
}

public class Solution {
    public static String solution(String x, String y) {
        // Your code here
        Solutions solution1 = new Solutions(x,y);
        return solution1.calc();
    }
    public static void main(String[] args) {
        System.out.println(Solution.solution("2", "1")); // 1
        System.out.println(Solution.solution("4", "7")); // 4
    }
}
