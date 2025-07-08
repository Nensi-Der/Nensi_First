public class Kafshe {
    String lloji;
    int mosha;
    String ngjyra;
    int pesha;

    public Kafshe(String lloji, int mosha, String ngjyra, int pesha) {
        this.lloji = lloji;
        this.mosha = mosha;
        this.ngjyra = ngjyra;
        this.pesha = pesha;
    }

    public String GetLloji() {
        return lloji;
    }

    public int GetMoshe() {
        return mosha;
    }

    public String GetNgjyra() {
        return ngjyra;
    }

    public int GetPesha() {
        return pesha;
    }

    @Override
    public String toString() {
        return ("Lloji: " + this.GetLloji() + "\nMosha: " + this.GetMoshe() + "\nNgjyra: " + this.GetNgjyra() + "\nPesha: " + this.GetPesha());
    }

}