import java.util.Scanner;
import java.util.LinkedList;
class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> vlera = new LinkedList<>();
        System.out.println("Vendos vlerat ne liste(shtyp -1 per te mbaruar): ");

        while (true)
        {
            int i = scanner.nextInt();
            if(i == -1)
                break;
            else
                vlera.add(i);
        }
        for(int num : vlera)
        {
            if (num == 5)
                System.out.println("U gjet");
        }
    }


}