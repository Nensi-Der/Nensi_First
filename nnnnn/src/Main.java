import java.util.Scanner;

/* Class holding constants */
class CONSTANTS {
    public static final int MAX_CNT = 100;
}


public class Main {

    // Function to find sum of 2 integers
    public static int findSum(int first, int second) {
        int sum = first + second;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nensi 19 vjec"); // Print message on screen

        int nr1 = 4;
        int nr2 = 6;
        int result = findSum(nr1, nr2);
        System.out.println("Shuma e nr1 dhe nr2 eshte: " + result);

        System.out.print("Jepi nje vlere numrit b: ");
        double b = scanner.nextDouble();

        System.out.println("A eshte b nje numer pozitiv? ");

        boolean status;
        if (b >= 0)
            status = true;
        else
            status = false;

        System.out.println("status is " +status);

        // Print constant from CONSTANTS class
        System.out.println("Vlera e konstantes MAX_CNT: " +CONSTANTS.MAX_CNT);

        scanner.close();
    }
}