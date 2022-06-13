import java.util.Scanner;
import iut.algo.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc     = new Scanner(System.in);
        String  sInter = "----------------------"; 

        System.out.print("Nombre de cuve(s) : " );
        
        int nbCuveSaisie = sc.nextInt();

        System.out.println(sInter);

        Cuve[] tabCuve = new Cuve[nbCuveSaisie];

        for (int i=0 ; i<tabCuve.length; i++)
        {
            if (Cuve.idInstance <= 'Z')
            {
                System.out.print("Capacite cuve " + ((char)(i+'A')) + " : " );
                
                int cpct = sc.nextInt();
                Cuve temp = Cuve.fabriquerCuve(cpct);
            
                if (temp != null)
                    tabCuve[i] = temp;
                else
                {
                    System.out.println("[CAPACITE INVALIDE]");
                    i--;
                }
            }
            else
            {
                System.out.println("[NOMBRE DE CUVE MAX ATTEINT]");
                i = tabCuve.length;
            }
        }

        System.out.println(sInter);

        for (int i = 0; i < tabCuve.length; i++)
        {
            if (tabCuve[i] != null)
                System.out.println(tabCuve[i]);
        } 

 
        int nbCuve = ((int)(Cuve.idInstance-'A'));
        
        System.out.println(sInter);
        System.out.print("Cuves à relier (SYNTHESE : AB2/AC6/.. pour relier A à B avec une section de 2 et A à C avec une section de 6) : ");

        String s = sc.next();
        // a faire : verifier la validité de la chaine

        String[] strSplit = s.split("/");
        /*for (int i=0; i<strSplit.length; i++)
        {
            System.out.println(strSplit[i]);
        }*/

        System.out.println(sInter);

        Tube[] tabTube = new Tube[strSplit.length];
        for (int i=0; i<tabTube.length; i++)
        {
            /*System.out.println(strSplit[i].charAt(0));
            System.out.println(strSplit[i].charAt(1));
            System.out.println(strSplit[i].charAt(2));*/
            tabTube[i] = new Tube(Character.getNumericValue(strSplit[i].charAt(2))); //taille section pour creer Tube ((int) ne marche pas)
            tabTube[i].relierCuves( tabCuve[strSplit[i].charAt(0)-'A'], 
                                    tabCuve[strSplit[i].charAt(1)-'A'] );
            // a faire :  verifier validite des reliages

            System.out.println(tabTube[i]);
        }
        
        int[][] matriceCout = new int[nbCuve][nbCuve];

        for (int i=0; i<tabTube.length; i++)
        {
            int x = (tabTube[i].getCuve1().getId())-'A';
            int y = (tabTube[i].getCuve2().getId())-'A';

            matriceCout[x][y] = tabTube[i].getSection();
            matriceCout[y][x] = tabTube[i].getSection();
        }

        System.out.println(sInter);


        Structure structure = new Structure(matriceCout);
        
        System.out.println("Quelle structure choisissez-vous ? (listeAdjacence - matriceCout - matriceCoutOptimise) ");

        structure.verifierSaisie();
    }
}
