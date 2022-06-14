public class Cuve
{

    /*-----------------*/
    /*----Attributs----*/
    /*-----------------*/
      
    protected static char idInstance  = 'A';
    private char idCuve;

    private int capacite;
    private double contenu;
    /*private int x;
    private int y;
    private String position;*/
    
    /*--------------------*/
    /*----Constructeur----*/
    /*--------------------*/

    public Cuve(int capacite)
    {
        this.idCuve = Cuve.idInstance++;
        this.capacite = capacite;
        this.contenu = 0.0;
        /*this.x = ;
        this.y = ;
        this.position = ; */
    }

    public static Cuve fabriquerCuve(int capacite)
    {
        if (capacite < 200 || capacite > 1000)  
            return null;

        if(Cuve.idInstance > 'Z')              
            return null;

        return new Cuve(capacite);
    }
    
    	/*---------------------*/
      /*------Méthodes-------*/
      /*---------------------*/

    public char getId() { return this.idCuve; }

    public int getCapacite() { return this.capacite; }

    public double getContenu() { return this.contenu; }

    public String toString()
    {
        return "Cuve " + this.idCuve + " : " + this.contenu + "/" + this.capacite;
    }
  
  public boolean remplirCuve(double qteFluide)
    {
        if( (int)qteFluide + (int)this.getContenu() > this.capacite )
        {
            return false;
        }
        this.contenu += qteFluide;
        return true;
    }
}
