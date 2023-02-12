import java.util.*;

public class Main {

  static class Pair {
    int a;
    int b;
    int c;

    Pair(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public String toString() {
      return a + " " + b + " " + c + "          ";
    }
  }

  public static void main(String[] args) {
    Pair[] arr = new Pair[3];
    arr[0] = new Pair(-2, -2, 3);
    arr[1] = new Pair(-2, -3, 3);
    arr[2] = new Pair(-2, 10, -2);

    Arrays.sort(arr, (a, b) -> {
      String tval = t.a + "" + t.b + "" + t.c;
      String oval = o.a + "" + o.b + "" + o.c;

      return oval.compareTo(tval);
    });

    for (Pair x : arr) {
      System.out.print(x);
    }
  }
}
