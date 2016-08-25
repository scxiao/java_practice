import java.util.*;
import java.io.*;
import java.nio.file.Path;

class Point {
  int x, y;
  public Point() {
    x = y = 0;
  }

  public Point(int a, int b) {
    x = a;
    y = b;
  }
}

class Solution {
   public int maxPoints(Point[] points) {
    if (points.length < 3) {
      return points.length;
    }

    HashMap<Line, Set<Point>> map = new HashMap<>();
    int i, j;
    int retVal = 0;
    for (i = 0; i < points.length; i++) {
      Point p1 = points[i];
      for (j = i + 1; j < points.length; j++) {
        Point p2 = points[j];
        Line l = new Line(p1, p2);
        if (map.containsKey(l) == false) {
            map.put(l, new HashSet<Point>());
          }
          map.get(l).add(p1);
          map.get(l).add(p2);
          if (retVal < map.get(l).size()) {
              retVal = map.get(l).size();
          }
        }
      }

      return retVal;
    }

    class Line {
      public Line(Point p1, Point p2) {
        vertical = false;
        horizontal = false;
        k = c = 0;

        if (p1.x == p2.x) {
          vertical = true;
          c = p1.x * 1000;
        }
        else if (p1.y == p2.y) {
          horizontal = true;
          c = p1.y * 1000;
        }
        else {
          k = 1000 * (p2.y - p1.y) / (p2.x - p1.x);
          c = 1000 * (p2.x * p1.y - p1.x * p2.y) / (p2.x - p1.x);
        }
      }

      public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 1;
        result = prime * result + c;
        result = prime * result + k;
        result = prime * result + (vertical ? 1111 : 1199);
        result = prime * result + (horizontal ? 1119 : 1199);

        System.out.println("hashVal = " + result);

        return result;
      }

      public boolean equals(Object obj) {
        if (obj == null) {
          return false;
        }
        else if (obj == this) {
          return true;
        }
        else if (getClass() == obj.getClass()) {
          return true;
        }

        Line l = (Line)obj;
        if (c != l.c) {
          return false;
        }

        if (k != l.k) {
          return false;
        }

        if (vertical != l.vertical) {
          return false;
        }

        if (horizontal != l.horizontal) {
          return false;
        }

        return true;
      }

      private boolean vertical, horizontal;
      private int k, c;
    }
}

public class TestMaxPointsOnLine {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: Java TestMaxPointsOnLine file");
      return;
    }

    BufferedReader br = null;
    Vector<Point> vecPoints = new Vector<>();
    try {
      br = new BufferedReader(new FileReader(args[0]));
      while (true) {
        String line = br.readLine();
        if (line.isEmpty() == true) {
          break;
        }

        Scanner scanner = new Scanner(line);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        vecPoints.add(new Point(x, y));
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }

    int pointNum = vecPoints.size();
    Point[] points = new Point[pointNum];
    for (int i = 0; i < pointNum; i++) {
      points[i] = vecPoints.get(i);
    }

    Solution sol = new Solution();
    int maxPoints = sol.maxPoints(points);

    System.out.println("maxPoints = " + maxPoints);

    return;
  }
}

