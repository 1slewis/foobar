import java.util.ArrayList;

public class Solution {
    public static int solution(int[][] map) {
        // Your code here
        Solutions solution1 = new Solutions(map);
        int ret = solution1.calc();
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 1}, new int[]{1, 1, 0, 0}, new int[]{1, 1, 1, 0}}));
        //7
        System.out.println(Solution.solution(new int[][]{new int[]{0, 0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1, 0}, new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 1, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 0, 0}}));
        //11
    }
}

class Pnt {
    final int x;
    final int y;
    final int dist;
    final boolean hasRemoved;
    public Pnt(int x, int y, int dist, boolean hasRemoved) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.hasRemoved = hasRemoved;
    }
    public int getDist() {
        return dist;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean getHasRemoved() {
        return hasRemoved;
    }
}

class Solutions {
    final int[][] map;
    ArrayList<Pnt> queue;
    ArrayList<Pnt> history;
    public Solutions(int[][] map) {
        this.map = map;
        this.queue = new ArrayList<Pnt>();
        this.history = new ArrayList<Pnt>();
    }
    public int calc() {
        int dist = Integer.MAX_VALUE;
        queue.add(new Pnt(0,0,1, false));
        while (queue.size() > 0) {
            Pnt zeroPnt = queue.get(0);
            int x = zeroPnt.getX();
            int y = zeroPnt.getY();
            dist = zeroPnt.getDist();
            boolean hasRemoved = zeroPnt.getHasRemoved();
            if (x == map[map.length - 1].length - 1 && y == map.length - 1) {
                break;
            }
            if (y > 0 && (x < map[y - 1].length)) {
                int newY = y - 1;
                int u = map[newY][x];
                if (!(isXYinHistoryOrQueue(x, newY, hasRemoved))) {
                    if (u == 0) {
                        queue.add(new Pnt(x, newY, dist + 1, hasRemoved));
                    } else if (!hasRemoved) {
                        queue.add(new Pnt(x, newY, dist + 1, true));
                    }
                }
            }
            if (y < map.length - 1 && (x < map[y + 1].length)) {
                int newY = y + 1;
                int d = map[newY][x];
                if (!(isXYinHistoryOrQueue(x, newY, hasRemoved))) {
                    if (d == 0) {
                        queue.add(new Pnt(x, newY, dist + 1, hasRemoved));
                    } else if (!hasRemoved) {
                        queue.add(new Pnt(x, newY, dist + 1, true));
                    }
                }
            }
            if (x > 0) {
                int newX = x - 1;
                int l = map[y][newX];
                if (!(isXYinHistoryOrQueue(newX, y, hasRemoved))) {
                    if (l == 0) {
                        queue.add(new Pnt(newX, y, dist + 1, hasRemoved));
                    } else if (!hasRemoved) {
                        queue.add(new Pnt(newX, y, dist + 1, true));
                    }
                }
            }
            if (x < map[y].length - 1 ) {
                int newX = x + 1;
                int r = map[y][newX];
                if (!(isXYinHistoryOrQueue(newX, y, hasRemoved))) {
                    if (r == 0) {
                        queue.add(new Pnt(newX, y, dist + 1, hasRemoved));
                    } else if (!(hasRemoved)) {
                        queue.add(new Pnt(newX, y, dist + 1, true));
                    }
                }
            }
            queue.remove(0);
            history.add(new Pnt(x,y,dist,hasRemoved));
        }
        return dist;
    }
    public boolean isXYinHistoryOrQueue(int x, int y, boolean hasRemoved) {
        for (int j = 0; j < history.size(); j++) {
            if (history.get(j).getX() == x && history.get(j).getY() == y && history.get(j).getHasRemoved() == hasRemoved) {
                return true;
            }
        }
        for (int j = 1; j < queue.size(); j++) {
            if (queue.get(j).getX() == x && queue.get(j).getY() == y && queue.get(j).getHasRemoved() == hasRemoved) {
                return true;
            }
        }
        return false;
    }
}
