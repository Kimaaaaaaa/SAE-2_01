import java.util.*;
import java.lang.*;

public class Controleur
{
    private Structure structure;

    public Controleur()
    {
        this.structure = new Structure(this);
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre de cuve(s) : " );
        int nbCuveSaisie = sc.nextInt();

        for (int i=0 ; i<nbCuveSaisie; i++)
        {
            System.out.print("Capacite cuve " + ((char)(i+'A')) + " : " );
            int capacite = sc.nextInt();
            if(structure.ajouterCuve(capacite) == false)
            {
                if (Cuve.idInstance <= 'Z')
                {
                    System.out.println("[ERREUR : SAISIE INVALIDE]");
                    i--;
                }
                else
                {
                    System.out.println("[ERREUR : NOMBRE MAX DE CUVES ATTEINTE]");
                    i = nbCuveSaisie;
                }
            }
        } 

        System.out.print("Cuves a relier (SYNTHESE : AB2/AC6/.. pour relier A a B avec une section de 2 et A a C avec une section de 6) : ");
        String s = sc.next();
        String[] strSplit = s.split("/"); 
           
        while (Controleur.verifierLiaison(strSplit) == false)
        {
            System.out.println("[ERREUR : SAISIE INVALIDE]");
            System.out.print("Cuves à relier (SYNTHESE : AB2/AC6/.. pour relier A à B avec une section de 2 et A à C avec une section de 6) : ");
            s = sc.next();
            strSplit = s.split("/");
        }

        structure.ajouterTubes(strSplit);
        structure.remplirMatrice();

        System.out.println("Quelle structure souhaitez-vous generer ? (\"mc\" : Matrice de cout - \"mco\" : Matrice de cout optimisee - Autre : Liste d'adjacence)");
        String choix = sc.next();
        structure.genererData(choix);
    }

    // Main -------------------------------------------------------
    public static void main(String[] args)
    {
        new Controleur();
    } 

    // Méthodes ----------------------------------------------------
    // Verification de la saisie de liaison des cuves
    public static boolean verifierLiaison(String[] strSplit)
    {
        boolean b = true;

        int cpt = 0; 
        while(cpt < strSplit.length)
        {
            if(strSplit[cpt].length() == 3)
                if(Character.isDigit(strSplit[cpt].charAt(0)) || Character.isDigit(strSplit[cpt].charAt(1)) || !Character.isDigit(strSplit[cpt].charAt(2)) || 
                   strSplit[cpt].charAt(0) == strSplit[cpt].charAt(1))
                    b = false;

            else if(strSplit[cpt].length() == 4)
                if( Character.isDigit(strSplit[cpt].charAt(0)) ||  Character.isDigit(strSplit[cpt].charAt(1)) || 
                   !Character.isDigit(strSplit[cpt].charAt(2)) || !Character.isDigit(strSplit[cpt].charAt(3)) || 
                    strSplit[cpt].charAt(0) == strSplit[cpt].charAt(1))
                    b = false;

            else
                b = false;
            
            cpt++;
        }
        return b;
    }
}
