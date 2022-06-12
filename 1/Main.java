import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre de cuve(s) : " );
        int nbCuveSaisie = sc.nextInt();

        Cuve[] tabCuve = new Cuve[nbCuveSaisie];

        for (int i=0 ; i<tabCuve.length; i++)
        {
            if (Cuve.idInstance <= 'Z')
            {
                System.out.print("Capacite cuve " + ((char)(i+'A')) + " : " );
                int cpct = sc.nextInt();
                Cuve temp = Cuve.fabriquerCuve(cpct);
            
                if (temp != null)
                {
                    tabCuve[i] = temp;
                }
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

        for (int i = 0; i < tabCuve.length; i++)
        {
            if (tabCuve[i] != null)
            {
                System.out.println(tabCuve[i]);
            }
        }
 
        int nbCuve = ((int)(Cuve.idInstance-'A'));
        System.out.println("Nombre de cuve(s) : " + nbCuve);

        System.out.print("Cuves a relier (syntaxe : AB2/AC6/.. pour relier A a B avec une section de 2 et A a C avec une section de 6) : ");

        String s = sc.next();
        // a faire : verifier la validité de la chaine
        //System.out.println(s);

        String[] strSplit = s.split("/");
        /*for (int i=0; i<strSplit.length; i++)
        {
            System.out.println(strSplit[i]);
        }*/

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

        for (int i=0; i<nbCuve; i++)
        {
            for (int j=0; j<nbCuve; j++)
            {
                System.out.print(matriceCout[i][j] + " ");
            }
            System.out.println("");
        }

        Structure structure;

        structure = new Structure(matriceCout);

        structure.genererTxt("mc");
        structure.genererTxt("la");
        structure.genererTxt("mco");
    }
}
