import java.util.HashMap;
import java.util.Map;

public class TestEquals {

  public static void main(String[] args) {
    Map<Point, Integer> myMap = new HashMap<>();
    myMap.put(new Point(0,0), 0);
    myMap.put(new Point(0,1), 1);
    myMap.put(new Point(1,0), 1);

    Point pt = new Point(1, 1);
    //myMap.put(pt, 3);
    System.out.println("(1,1) is found " + myMap.containsKey(pt));
    pt = new Point(0, 1);
    System.out.println("(0,1) get " + myMap.get(pt));
    System.out.println("(0,1) is found " + myMap.containsKey(new Point(0,1)));
/*
    for(Point p : myMap.keySet()) {
      System.out.println("(" + p.getx() + ", " + p.gety() + ") " + pt.equals(pt));
    }*/
  }  
}

class Point {
  private int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int getx() {return x; }
  public int gety() {return y; }

  public boolean equals(Object o) {
    Point p = (Point)o;
    return (this.x == p.getx() && this.y == p.gety());
  }

  public int hashCode() {
    return x+y;
  }
}

