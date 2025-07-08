public class Room{
    Scanner scanner = new Scanner(System.in);
    public void Display()
    {
        System.out.println("Enter number of objects and then each object: ");
    }
    int n = scanner.nextInt();
    String object[n];
    public void EnterObjects()
    {
        for(int i = 0; i < n; i++)
        {
            object[i] = scanner.nextLine();
        }
    }
}
