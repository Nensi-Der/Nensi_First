public class Flower{

    String fname;
    int longevity;
    String family;
    public Flower(String fname, int longevity, String family)
    {
        this.fname = fname;
        this.longevity = longevity;
        this.family = family;
    }
    public void Display()
    {
        System.out.println("Flower name: " +fname+ "\nFlower lifespan: " +longevity+ "\nFamily: " +family);
    }
}