import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.List;

public class ArrayProbs {
  private static List<Integer> common(int[] arr1, int[] arr2) {
    if(arr1 == null || arr2 == null) {
      return null;
    }
    if(arr1.length == 0 || arr2.length == 0 || (arr1[0] > arr2[arr2.length-1]) || arr1[arr1.length-1] < arr2[0]) {
      return new ArrayList<Integer>();
    }

    List<Integer> res = new ArrayList<Integer>();
    for(int i = 0, j = 0; i < arr1.length && j < arr2.length;) {
      if(arr1[i] == arr2[j]) {
        res.add(arr1[i++]);
        j++;
      }
      else if(arr1[i] < arr2[j]) {
        i++;
      }
      else {
        j++;
      }
    }
    return res;
  }

  private static boolean is_rotation(int[] arr1, int[] arr2) {
    if(arr1 == null || arr2 == null) {
      return false;
    }
    if(arr1.length == 0 || arr2.length == 0 || arr1.length != arr2.length) {
      return false;
    }

    // find first common 
    int j = 0, sz = arr1.length;
    for(j = 0; j < sz && arr1[0] != arr2[j]; j++);
    if(j == sz) {
      return false;
    }
    int i = 0;
    for(i = 0; i < sz && arr1[i] == arr2[j%sz]; i++, j++);

    return (i==sz);
  }

  //2-dimensional arrays
  private static void clickMineSweeper(int[][] array, int i, int j) {
    // fill 0s with -2 for neighboring empty cells
    // -1 is a mine, +ve vals say how many mines in nearby cells
    if(array[i][j] != 0) {
      return;
    }
    Stack<Point> s = new Stack<>();
    array[i][j] = -2;
    s.push(new Point(i,j));
    while(!s.isEmpty()) {
      Point p = s.pop();
      pushValidNeighbors(array, s, p);
    }

  }

  private static void pushValidNeighbors(int[][] array, Stack<Point> s, Point p) {
    int rows = array.length;
    int cols = array[0].length;

    if(p.getx() > 0 && array[p.getx()-1][p.gety()] == 0) {
      array[p.getx()-1][p.gety()] = -2;
      s.push(new Point(p.getx()-1,p.gety()));
    }
    if(p.getx() < rows-1 && array[p.getx()+1][p.gety()] == 0) {
      array[p.getx()+1][p.gety()] = -2;
      s.push(new Point(p.getx()+1,p.gety()));
    }
    if(p.gety() > 0 && array[p.getx()][p.gety()-1] == 0) {
      array[p.getx()][p.gety()-1] = -2;
      s.push(new Point(p.getx(),p.gety()-1));
    }
    if(p.gety() < cols-1 && array[p.getx()][p.gety()+1] == 0) {
      array[p.getx()][p.gety()+1] = -2;
      s.push(new Point(p.getx(),p.gety()+1));
    }
  }

  public static void main(String[] args) {
    //commonElements();
    //arrayRotation();
    clicks();
  }

  private static void clicks() {
    int[][] array = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 1, -1, 1, 0}};
    System.out.println("Orig: " + Arrays.deepToString(array));

    clickMineSweeper(array, 0, 1);
    System.out.println("After sweep: " + Arrays.deepToString(array));

    int[][] field2 = {{-1, 1, 0, 0}, 
    {1, 1, 0, 0},
    {0, 0, 1, 1},
    {0, 0, 1, -1}};
    System.out.println("Orig: " + Arrays.deepToString(field2));
    clickMineSweeper(field2, 0, 1);
    System.out.println("After sweep: " + Arrays.deepToString(field2));

    clickMineSweeper(field2, 1, 3);
    System.out.println("After sweep: " + Arrays.deepToString(field2));
  }

  private static void arrayRotation() {
    int[] arr1 = {1, 3, 4, 6, 7, 9};
    int[] arr2 = {1, 2, 4, 5, 9, 10};
    System.out.println(Arrays.toString(arr1) + " is " + (is_rotation(arr1, arr2)?"":"NOT") + " rotation of " + Arrays.toString(arr2));

    int[] arr11 = {11, 13, 14, 16, 17, 19};
    System.out.println(Arrays.toString(arr11) + " is " + (is_rotation(arr11, arr2)?"":"NOT") + " rotation of " + Arrays.toString(arr2));

    int[] arr21 = {11, 13, 14, 16, 17, 19};
    System.out.println(Arrays.toString(arr1) + " is " + (is_rotation(arr1, arr21)?"":"NOT") + " rotation of " + Arrays.toString(arr21));

    int[] arr22 = {6, 7, 9, 1, 3, 4};
    System.out.println(Arrays.toString(arr1) + " is " + (is_rotation(arr1, arr22)?"":"NOT") + " rotation of " + Arrays.toString(arr22));

    int[] array1 = {1, 2, 3, 4, 5, 6, 7};
    int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
    // isRotation(array1, array2a) should return false.
    System.out.println("false " + Arrays.toString(array1) + " is " + (is_rotation(array1, array2a)?"":"NOT") + " rotation of " + Arrays.toString(array2a));

    int[] array2b = {4, 5, 6, 7, 1, 2, 3};
    // isRotation(array1, array2b) should return true.
    System.out.println("true " + Arrays.toString(array1) + " is " + (is_rotation(array1, array2b)?"":"NOT") + " rotation of " + Arrays.toString(array2b));

    int[] array2c = {4, 5, 6, 9, 1, 2, 3};
    // isRotation(array1, array2c) should return false.
    System.out.println("false " + Arrays.toString(array1) + " is " + (is_rotation(array1, array2c)?"":"NOT") + " rotation of " + Arrays.toString(array2c));

    int[] array2d = {4, 6, 5, 7, 1, 2, 3};
    // isRotation(array1, array2d) should return false.
    System.out.println("false " + Arrays.toString(array1) + " is " + (is_rotation(array1, array2d)?"":"NOT") + " rotation of " + Arrays.toString(array2d));

    int[] array2e = {4, 5, 6, 7, 0, 2, 3};
    // isRotation(array1, array2e) should return false.
    System.out.println("false " + Arrays.toString(array1) + " is " + (is_rotation(array1, array2e)?"":"NOT") + " rotation of " + Arrays.toString(array2e));

    int[] array2f = {1, 2, 3, 4, 5, 6, 7};
    // isRotation(array1, array2f) should return true.
    System.out.println("true " + Arrays.toString(array1) + " is " + (is_rotation(array1, array2f)?"":"NOT") + " rotation of " + Arrays.toString(array2f));
    System.out.println("true " + Arrays.toString(array1) + " is " + (is_rotation(array1, array1)?"":"NOT") + " rotation of " + Arrays.toString(array1));
  }

  private static void commonElements() {
    int[] arr1 = {1, 3, 4, 6, 7, 9};
    int[] arr2 = {1, 2, 4, 5, 9, 10};
    System.out.println("common of " + Arrays.toString(arr1) + " and " + Arrays.toString(arr2) + " is " + common(arr1, arr2).toString());

    int[] arr11 = {11, 13, 14, 16, 17, 19};
    System.out.println("common of " + Arrays.toString(arr11) + " and " + Arrays.toString(arr2) + " is " + common(arr11, arr2).toString());

    int[] arr21 = {11, 13, 14, 16, 17, 19};
    System.out.println("common of " + Arrays.toString(arr1) + " and " + Arrays.toString(arr21) + " is " + common(arr11, arr2).toString());

    int[] arr22 = {2, 5, 8, 16, 17, 19};
    System.out.println("common of " + Arrays.toString(arr1) + " and " + Arrays.toString(arr22) + " is " + common(arr1, arr22).toString());
  }
}
