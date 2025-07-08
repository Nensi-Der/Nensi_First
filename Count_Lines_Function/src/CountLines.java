import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class CountLines {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("data.txt"));
            int a = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    a++;
            }
            System.out.println("The file has "+a+" lines.");
        }

        catch (IOException e) {
            System.out.println("Problem accessing file.");
        } finally {
            scanner.close();
        }
    }
}