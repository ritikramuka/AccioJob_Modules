import java.util.*;

public class Main {
	static int sumOfDigi(int n) {
        //Write code here
		if (n == 0) return 0;
		return sumOfDigi(n / 10) + (n % 10);
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int result = sumOfDigi(n);
        System.out.println(result);
        sc.close();
    }
}