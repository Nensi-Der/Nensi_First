import java.util.Map;
import java.util.HashMap;
class Main
{
    public static void main(String[] args)
    {
        Map<Integer, String> muaj = new HashMap<>();
        muaj.put(1 , "Januar");
        muaj.put(2 , "Shkurt");
        muaj.put(3 , "Mars");
        muaj.put(4 , "Prill");
        muaj.put(5 , "Maj");
        muaj.put(6 , "Qershor");
        muaj.put(7 , "Korrik");
        muaj.put(8 , "Gusht");
        muaj.put(9 , "Shtator");
        muaj.put(10 , "Tetor");
        muaj.put(11 , "Nentor");
        muaj.put(12 , "Dhjetor");
        System.out.println("Para update:");
        for (Map.Entry<Integer, String> entry : muaj.entrySet()) {
            System.out.println("Muaji: " + entry.getKey() + ": " + entry.getValue());
        }

        muaj.put(3, "Shtator");
        System.out.println("Pas update:");
            for (Map.Entry<Integer, String> entry : muaj.entrySet()) {
                {
                    System.out.println("Month " + entry.getKey() + ": " + entry.getValue());
                }


        }}}