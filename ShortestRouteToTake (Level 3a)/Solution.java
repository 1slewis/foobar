import java.util.*;

public class Solution {
    public static boolean isXYinHistory(int x, int y, ArrayList<HashMap> historyArrayList) {
        for (int i = 0; i < historyArrayList.size(); i++) {
            HashMap<String, Integer> historyIHashMap = historyArrayList.get(i);
            if (historyIHashMap.get("x") == x && historyIHashMap.get("y") == y) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList recursiveMethodRoutes(int[][] map, int x, int y, ArrayList<HashMap> historyArrayList, Boolean hasRemoved) {
        ArrayList outputArrayList = new ArrayList();
        HashMap<String, Integer> historyXYHashMap = new HashMap<String, Integer>();
        historyXYHashMap.put("x", x);
        historyXYHashMap.put("y", y);
        historyArrayList.add(historyXYHashMap);
        if (x == map[0].length - 1 && y == map.length - 1) {
            outputArrayList.add(Integer.valueOf(historyArrayList.size()));
            return outputArrayList;
        }
        if (y > 0) {
            int newY = y - 1;
            int u = map[newY][x];
            if (!(isXYinHistory(x, newY, historyArrayList))) {
                if (u == 0) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, x, newY, new ArrayList<HashMap>(historyArrayList), hasRemoved));
                } else if (!hasRemoved) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, x, newY, new ArrayList<HashMap>(historyArrayList), true));
                }
            }
        }
        if (y < map.length - 1) {
            int newY = y + 1;
            int d = map[newY][x];
            if (!(isXYinHistory(x, newY, historyArrayList))) {
                if (d == 0) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, x, newY, new ArrayList<HashMap>(historyArrayList), hasRemoved));
                } else if (!hasRemoved) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, x, newY, new ArrayList<HashMap>(historyArrayList), true));
                }
            }
        }
        if (x > 0) {
            int newX = x - 1;
            int l = map[y][newX];
            if (!(isXYinHistory(newX, y, historyArrayList))) {
                if (l == 0) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, newX, y, new ArrayList<HashMap>(historyArrayList), hasRemoved));
                } else if (!hasRemoved) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, newX, y, new ArrayList<HashMap>(historyArrayList), true));
                }
            }
        }
        if (x < map[0].length - 1) {
            int newX = x + 1;
            int r = map[y][newX];
            if (!(isXYinHistory(newX, y, historyArrayList))) {
                if (r == 0) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, newX, y, new ArrayList<HashMap>(historyArrayList), hasRemoved));
                } else if (!hasRemoved) {
                    outputArrayList.add(Solution.recursiveMethodRoutes(map, newX, y, new ArrayList<HashMap>(historyArrayList), true));
                }
            }
        }
        if (outputArrayList.size() == 0) {
            outputArrayList.add(Integer.MAX_VALUE);
            return outputArrayList;
        }
        return outputArrayList;
    }
    public static int recursiveMethodShortest(ArrayList inputArrayList, int shortest) {
        for (int i = 0; i < inputArrayList.size(); i++) {
            //System.out.println(inputArrayList.get(i).getClass());
            if (inputArrayList.get(i).getClass() == Integer.valueOf(1).getClass() && ((int)inputArrayList.get(i)) < shortest) {
                shortest = (int)inputArrayList.get(i); 
            }
            if (inputArrayList.get(i).getClass() == ArrayList.class) {
                shortest = recursiveMethodShortest((ArrayList)inputArrayList.get(i), shortest);
            }
        }
        return shortest;
    }
    public static int solution(int[][] map) {
        // Your code here
        ArrayList outputArrayList = recursiveMethodRoutes(map, 0, 0, new ArrayList<HashMap>(), false);
        int shortest = recursiveMethodShortest(outputArrayList, Integer.MAX_VALUE);
        return shortest;
    }
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 1}, new int[]{1, 1, 0, 0}, new int[]{1, 1, 1, 0}}));
        //7
        System.out.println(Solution.solution(new int[][]{new int[]{0, 0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1, 0}, new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 1, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 0, 0}}));
        //11
    }
}
