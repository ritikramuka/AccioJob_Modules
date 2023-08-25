import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
    printDI(n);
  }

  // Faith: print number (n.....1 1.....n)
  public static void printDI(int n) {
	// Base case
	if (n == 0) return;
    
    System.out.println(n);
	  
	// print number (n - 1).....1 1......(n - 1)
	printDI(n - 1);

	System.out.println(n);
  }
}