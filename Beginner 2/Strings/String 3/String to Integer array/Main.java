import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> arrayGenerator(String s){
		/*
			  s -> 1234,5678,8771,332

			  step 1: 
					numbers = {"1234", "5678", "8771", "332"}

			  step 2: 
					int value = Integer.parseInt(str);
					eg: str = "1234"
						so, value = 1234
		**/
		
		// step 1: get all positive numbers seperatly as a String
		String[] numbers = s.split(",");

		// step 2: get each String one by one and convert to int value
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			// get each string in string array
			String number = numbers[i];

			// converting string to int value
			int value = Integer.parseInt(number);
			
			// storing in my ans
			ans.add(value);
		}

		return ans;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String s = input.nextLine();
            ArrayList<Integer> ans = arrayGenerator(s);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i));
                if (i != ans.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        
    }
}
