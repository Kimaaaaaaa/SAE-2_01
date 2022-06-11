import java.util.ArrayList;

public class Tube
{
    private static int nbTube = 0;
    private int numTube;

    private int section;
    private Cuve c1;
    private Cuve c2;

    public Tube(int section)
    {
        if (section < 2)
            this.section = 2;
        
        if (section > 10)
            this.section = 10;

        this.section = section;
        this.c1 = null;
        this.c2 = null;

        this.numTube = ++Tube.nbTube;
    }

    public boolean relierCuves(Cuve c1, Cuve c2)
    {
        this.c1 = c1;
        this.c2 = c2;
        return true;
    }

    public int getSection() { return this.section; }

    public int getNumTube() { return this.numTube; }

    public Cuve getCuve1() { return this.c1; }
    public Cuve getCuve2() { return this.c2; }

    public String toString()
    {
        String s = "Tube : " + this.numTube + " (" + this.section + ")";

        if (this.c1 != null && this.c2 != null)
        {
            s += "   (" + this.c1.toString() + " == " + this.c2.toString() + ")";
        }

        return s;
    }
}
