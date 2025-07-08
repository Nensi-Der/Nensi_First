import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class ReadFile
{
    public static void main(String[] args) {

        Scanner scanner = null;
        try {

            scanner = new Scanner(new File("data.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        } finally {
            scanner.close();
        }

    }
}