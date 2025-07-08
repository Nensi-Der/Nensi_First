import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class UserInputToFile
{
    public static void main(String[] args)
    {
Scanner scanner = new Scanner(System.in);
try
{
System.out.println("Enter the name of the file you want to write in: ");
String fileName = scanner.nextLine();

    FileWriter writer = new FileWriter(fileName);

System.out.println("Write on the file(ENTER STOP EXIT): ");
while (true)
{
    String input = scanner.nextLine();
    if(input.equalsIgnoreCase("STOP")) {
        System.out.println("File with chosen name and input was created successfully. ");
        break;
    }
    else writer.write(input+"\n");
}

writer.close();
}
catch (IOException e) {
    System.out.println("An error occurred while writing to the file.");
    e.printStackTrace();
}
finally
{
    scanner.close();
}
    }
}