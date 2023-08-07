import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter two positive integers");

        int a = scn.nextInt();
        int b = scn.nextInt();

        System.out.println("Enter operation to be performed");
        char ch = scn.next().charAt(0);

        System.out.print("Output: ");
        switch(ch) {
            case '+': 
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            case '%':
                System.out.println(a % b);
                break;
            default:
                System.out.println("Invalid operator");
        }
    }
}