public class TryNumber
{
    public TryNumber(int n)
    {

    }
    public void tryNumber(int a, int b)
    {
        if (b == 0)
        {
            System.out.println("Number must not be 0");
            throw new IllegalArgumentException("Number must not be 0");
        }
        else
        {
            int result = a / b;
            System.out.println("Result: "+result);
        }
    }
}