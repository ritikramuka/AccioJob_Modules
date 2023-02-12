import java.io.*;
import java.util.*;

class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();
    TextEditor obj = new TextEditor();
    for (int i = 0; i < q; i++) {
      // String[] s = sc.nextLine().split(" ");
      String s = sc.nextLine();
      if (s.equals("UNDO")) {
        obj.UNDO();
      } else if (s.equals("REDO")) {
        obj.REDO();
      } else if (s.equals("READ")) {
        obj.READ();
      } else {
        char ch = s.charAt(6);
        obj.WRITE(ch);
      }
    }
  }
}

class TextEditor {
  static StringBuilder docs = new StringBuilder();
  static Stack<Character> trash = new Stack<>();

  // your code here
  // TC: O(1)
  static void WRITE(char X) {
    docs.append(X);
  }

  // TC: O(1)
  static void UNDO() {
    if (docs.length() > 0) {
      trash.push(docs.charAt(docs.length() - 1));
      docs.deleteCharAt(docs.length() - 1);
    }
  }

  // TC: O(1)
  static void REDO() {
    if (trash.size() > 0) {
      docs.append(trash.pop());
    }
  }

  // TC: O(1)
  static void READ() {
    System.out.print(docs.toString() + " ");
  }
}
