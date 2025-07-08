import java.util.Scanner;
class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int a = scanner.nextInt();
        int b  = scanner.nextInt();
        int c = scanner.nextInt();

                    if(a > b)
            {
                if(a > c)
                {
                   System.out.print(a);
                }
                else System.out.print(c);
            }
            else if(b > c)
                        System.out.print(b);
            else System.out.print(c);
        }
    }
