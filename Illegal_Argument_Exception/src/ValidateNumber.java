public class  ValidateNumber
{
    public ValidateNumber(int number)
    {

    }

    public void validateNumber(int number)
    {
        if (number < 20)
        {
            throw new IllegalArgumentException("Number must be greater than 20");
        }
        else
        {
            System.out.println("Number added successfully. ");
        }
    }
}
