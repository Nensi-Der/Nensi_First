import java.io.IOException;
import java.util.Scanner;
public class DivisionByZero
{
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int a;
            int b;
            System.out.println("Enter the values of the two numbers you ant to divide. ");
            a = scanner.nextInt();
            b = scanner.nextInt();
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0.");
        }
    }
}