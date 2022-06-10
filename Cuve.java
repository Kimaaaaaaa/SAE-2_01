public class Cuve{

	/*-----------------*/
	/*----Attributs----*/
	/*-----------------*/

	private static char stkId = 'A';
	private char id                ;
	private int capacite           ;
	private double contenu         ;
	private String position        ;
	private int    x               ;
	private int    y               ;

	/*--------------------*/
	/*----Constructeur----*/
	/*--------------------*/

	public Cuve(int capacite)
	{
		this.id = Cuve.stkId++  ;
		this.capacite = capacite;
		this.contenu  = 0.0     ;
		/*this.position = position;*/
		this.x        = 0       ;
		this.y        = 0       ;
	}

	public boolean fabriqueCuve(int capacite)
	{
		if (capacite < 200 && capacite > 1000)  return false;

        if(Cuve.stkId == 'Z')                   return false;

        new Cuve(capacite);

        return true;
	}

	/*---------------------*/
	/*------Méthodes-------*/
	/*---------------------*/



	/*-----------------------*/
	/*------Accesseurs-------*/
	/*-----------------------*/


	public int getCapacite  () { return this.capacite; }
	public double getContenu() { return this.contenu;  }
	public int    getX      () { return this.x;        }
	public int    getY      () { return this.y;        }

	
}
