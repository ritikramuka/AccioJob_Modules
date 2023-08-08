import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        //Write your code here and print the required output

		switch (c) {
			case 'A': 
				System.out.println("I am the first letter");
				break;
			case 'B': 
				System.out.println("I am the second letter");
				break;
			case 'C':
				System.out.println("I am the third letter");
				break;
			case 'D':
				System.out.println("I am the fourth letter");
				break;
			case 'E':
				System.out.println("I am the fifth letter");
				break;
			default:
				System.out.println("I don't belong here");
		}

    }
}