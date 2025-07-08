import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int a ;
        System.out.println("Enter value of a: ");
        a = scanner.nextInt();
        String result = a > 0 ? "Pozitiv" : "Negativ";
        System.out.println(result);
    }

}