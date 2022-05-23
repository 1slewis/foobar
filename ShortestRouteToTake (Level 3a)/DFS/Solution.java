import java.util.ArrayList;

public class Solution {
    public static int solution(int[][] map) {
        // Your code here
        Solutions solution1 = new Solutions(map);
        solution1.calc();
        int output = solution1.ret();
        return output;
    }
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 1}, new int[]{1, 1, 0, 0}, new int[]{1, 1, 1, 0}}));
        //7
        System.out.println(Solution.solution(new int[][]{new int[]{0, 0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1, 0}, new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 1, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 0, 0}}));
        //11
    }
}

class Pnt {
    final int xPnt;
    final int yPnt;
    public Pnt(int x, int y) {
        xPnt = x;
        yPnt = y;
    }
    public int getX() {
        return xPnt;
    }
    public int getY() {
        return yPnt;
    }
}

class Solutions {
    final int[][] map;
    final ArrayList<Integer> outputArrayList;
    public Solutions(int[][] map) {
        this.outputArrayList = new ArrayList<Integer>();
        this.map = map;
    }
    public void calc() {
        recursiveMethodRoutes(0, 0, new ArrayList<Pnt>(), false);
    }
    public int ret() {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < outputArrayList.size(); i++) {
            if ((int)outputArrayList.get(i) < shortest) {
                shortest = (int)outputArrayList.get(i);
            }
        }
        return shortest;
    }
    public boolean isXYinHistory(int x, int y, ArrayList<Pnt> historyArrayList) {
        for (int i = 0; i < historyArrayList.size(); i++) {
            Pnt historyIPnt = historyArrayList.get(i);
            if (historyIPnt.getX() == x && historyIPnt.getY() == y) {
                return true;
            }
        }
        return false;
    }
    public void recursiveMethodRoutes(int x, int y, ArrayList<Pnt> historyArrayList, Boolean hasRemoved) {
        Pnt historyXYPnt = new Pnt(x, y);
        historyArrayList.add(historyXYPnt);
        if (x == map[map.length - 1].length - 1 && y == map.length - 1) {
            outputArrayList.add(Integer.valueOf(historyArrayList.size()));
            return;
        }
        if (y > 0 && (x < map[y - 1].length)) {
            int newY = y - 1;
            int u = map[newY][x];
            if (!(isXYinHistory(x, newY, historyArrayList))) {
                if (u == 0) {
                    recursiveMethodRoutes(x, newY, new ArrayList<Pnt>(historyArrayList), hasRemoved);
                } else if (!hasRemoved) {
                    recursiveMethodRoutes(x, newY, new ArrayList<Pnt>(historyArrayList), true);
                }
            }
        }
        if (y < map.length - 1 && (x < map[y + 1].length)) {
            int newY = y + 1;
            int d = map[newY][x];
            if (!(isXYinHistory(x, newY, historyArrayList))) {
                if (d == 0) {
                    recursiveMethodRoutes(x, newY, new ArrayList<Pnt>(historyArrayList), hasRemoved);
                } else if (!hasRemoved) {
                    recursiveMethodRoutes(x, newY, new ArrayList<Pnt>(historyArrayList), true);
                }
            }
        }
        if (x > 0) {
            int newX = x - 1;
            int l = map[y][newX];
            if (!(isXYinHistory(newX, y, historyArrayList))) {
                if (l == 0) {
                    recursiveMethodRoutes(newX, y, new ArrayList<Pnt>(historyArrayList), hasRemoved);
                } else if (!hasRemoved) {
                    recursiveMethodRoutes(newX, y, new ArrayList<Pnt>(historyArrayList), true);
                }
            }
        }
        if (x < map[0].length - 1) {
            int newX = x + 1;
            int r = map[y][newX];
            if (!(isXYinHistory(newX, y, historyArrayList))) {
                if (r == 0) {
                    recursiveMethodRoutes(newX, y, new ArrayList<Pnt>(historyArrayList), hasRemoved);
                } else if (!hasRemoved) {
                    recursiveMethodRoutes(newX, y, new ArrayList<Pnt>(historyArrayList), true);
                }
            }
        }
    }
}
