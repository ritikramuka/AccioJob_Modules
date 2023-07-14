import java.util.*;

public class Main {

  static class Pair {
    String str;
    int n;

    Pair(int n, String s) {
      this.n = n;
      this.str = s;
    }
  }

  public static void main(String[] args) {
    // Integer[] arr = {4, 5, 10, 11, 20, 12};

    // // asc order
    // Arrays.sort(arr);

    // for (int i : arr) {
    //     System.out.print(i + " ");
    // }

    // System.out.println();

    // // dec order
    // Arrays.sort(arr, (val1, val2) -> {
    //     return val2 - val1;
    // });

    // for (int i : arr) {
    //     System.out.print(i + " ");
    // }

    // String[] arr = {"apple", "app", "all", "ball"};

    // // lexo order
    // Arrays.sort(arr);
    // for (var i : arr) {
    //     System.out.print(i + " ");
    // }

    // System.out.println();

    // reverse lexo order
    // Arrays.sort(arr, (a, b) -> {
    //     return b.compareTo(a);
    // });
    // for (var i : arr) {
    //     System.out.print(i + " ");
    // }

    // Arrays.sort(arr, (a, b) -> {
    //     if (a.length() == b.length()) {
    //         return a.compareTo(b);
    //     } else {
    //         return b.compareTo(a);
    //     }
    // });
    // for (var i : arr) {
    //     System.out.print(i + " ");
    // }

    Pair[] arr = {
      new Pair(1, "Ritik"),
      new Pair(2, "Jeyan"),
      new Pair(3, "Anuj"),
      new Pair(5, "Pranav"),
      new Pair(7, "bhuta"),
    };

    // sort in terms on n in dec order, but when str size is same then sort in terms of n in asc order
    Arrays.sort(arr, (a, b) -> {
        if(a.str.length() == b.str.length()) {
            return a.n - b.n;
        } else {
            return b.n - a.n;
        }
    });

    for (var i : arr) {
        System.out.print(i.n + ", " + i.str + "  ");
    }
  }
}
