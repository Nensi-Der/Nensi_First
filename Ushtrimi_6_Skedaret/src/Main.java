import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {

        try
        {
            Scanner in = new Scanner(System.in);
            Scanner scanner = new Scanner(new File("data.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                int a = in.nextInt();
                int b = in.nextInt();
                Trynumber check = new Trynumber(a, b);
                check.tryNumber(a, b);

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch (IOException e) {
            System.out.println("Problem opening file.");
        }
        catch (NumberFormatException e)
        {
        System.out.println("Denominator cannot be 0.");
        }

    }}

