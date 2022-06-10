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

	public static Cuve fabriqueCuve(int capacite)
	{
		if (capacite < 200 || capacite > 1000)  return null;

        if(Cuve.stkId == 'Z')                   return null;

        return new Cuve(capacite);


	}

	/*---------------------*/
	/*------Méthodes-------*/
	/*---------------------*/

	public String toString()
	{
		String sRet;
		sRet = "Ok " + this.capacite;

		return sRet;

	}

	/*-----------------------*/
	/*------Accesseurs-------*/
	/*-----------------------*/


	public int getCapacite  () { return this.capacite; }
	public double getContenu() { return this.contenu;  }
	public int    getX      () { return this.x;        }
	public int    getY      () { return this.y;        }

	/*-----------------------*/
	/*---------Main----------*/
	/*-----------------------*/

	public static void main(String [] args)
	{

		Cuve c ;
		Cuve c2;

		c = Cuve.fabriqueCuve(200);
		c2 = Cuve.fabriqueCuve(199);


		System.out.println(c);
		System.out.println(c2);





	}

	
}
