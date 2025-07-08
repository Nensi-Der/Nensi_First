import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
    int number = scanner.nextInt();
    ValidateNumber checker = new ValidateNumber(number);
    try {
         checker.validateNumber(number);
    }
    catch(IllegalArgumentException iae)
    {
        System.out.println("Number must be greater than 20");
    }
    }

}