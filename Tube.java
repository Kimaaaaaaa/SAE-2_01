
public class Tube
{
   private int section;

    public Tube(int section)
    {
        if (section < 2 || section > 10)
            return null;

        this.section = section;
    }

    public int getSection()
    {
        return this.section;
    }
}
