import org.apache.commons.lang3.StringUtils;
public class Example
{
    public static void example()
    {
        String s = "  Hello ";
        System.out.println(StringUtils.strip(s));

        System.out.println(StringUtils.isBlank("   "));

    }
    }
