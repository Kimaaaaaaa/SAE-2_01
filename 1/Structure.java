import java.io.*;
import java.util.Scanner;

public class Structure
{
    /*-------------*/
    /*--Attributs--*/
    /*-------------*/
    
    private int[][] tabStructure;
    
    /*----------------*/
    /*--Constructeur--*/
    /*----------------*/

    public Structure(int[][] tabStructure)
    { 
        this.tabStructure = tabStructure;
    }
    
    /*----------------*/
    /*---Accesseurs---*/
    /*----------------*/
   
    public int getNbCuves() { return Cuve.idInstance; }
    
    /*----------------*/
    /*----MÃ©thodes----*/
    /*----------------*/

    public void genererTxt(String type)
    {
        switch(type) 
        {
            case "matriceCout" :
            {
                try
                {
                    File f         = new File("donnees.data");
                    f.delete(); 
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("donnees.data"), "UTF8"));
                    pw.println(type.toUpperCase() + "\n--------------------------");

                    pw.print("   ");
                    for (int h=0; h<this.tabStructure.length; h++)
                        pw.print((char) (h + 'A') + "    ");

                    pw.println();
                    for (int i=0; i<this.tabStructure.length; i++)
                    {
                        pw.print("(");
                        for (int j = 0; j < this.tabStructure[i].length; j++)
                            pw.print(String.format("%3d", this.tabStructure[i][j]) + "  ");
                            
                        pw.println( ") " + (char) (i + 'A') );
                    }
                    pw.close(); 
                }
                catch (Exception e)
                {
                    System.out.println("Erreur");
                    e.printStackTrace();
                }
                break;
            }

            case "listeAdjacence"    : 
            {
                try
                {
                    File f         = new File("donnees.data");
                    f.delete();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("donnees.data"), "UTF8"));
                    pw.println(type.toUpperCase() + "\n--------------");

                    
                    for (int i=0; i<this.tabStructure.length; i++)
                    {
                        for (int j = 0; j < this.tabStructure[i].length; j++)
                        {
                            if(this.tabStructure[i][j] != 0)
                            {
                                if(i < j)
                                    pw.println( (char) (i + 'A') + " <--> " + (char) (j + 'A') + " (" + this.tabStructure[i][j] + ") ");   
                            }
                        }
                    }
                    pw.close();
                }
                catch (Exception e)
                {
                    System.out.println("Erreur");
        System.out.println("Quelle structure choisissez-vous ?");
                    e.printStackTrace();
                }
                break;
            }
            
            case "matriceCoutOptimise"  :
            {
                try
                {
                    File f         = new File("donnees.data");
                    f.delete();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("donnees.data"), "UTF8"));
                    pw.println(type.toUpperCase() + "\n--------------------------");

                    pw.print("   ");
                    for (int h=0; h<this.tabStructure.length; h++)
                        pw.print((char) (h + 'A') + "    ");

                    pw.println();
                    for (int i=0; i<this.tabStructure.length; i++)
                    {
                        pw.print("(");
                        for (int j = 0; j < this.tabStructure[i].length; j++)
                        {
                            if (j>=i)
                                pw.print(String.format("%3d", this.tabStructure[i][j]) + "  ");
                            else
                                pw.print("     ");
                        } 
                            
                        pw.println( ") " + (char) (i + 'A') );
                    }
                    pw.close(); 
                }
                catch (Exception e)
                {
                    System.out.println("Erreur");
                    e.printStackTrace();
                }
                break;
            }
        }
    } 

    public void verifierSaisie()
    {
        Structure structure = new Structure(tabStructure);
        Scanner sc = new Scanner(System.in);
        String sRet = sc.next();
        
        while(! ((sRet.equals("matriceCout")) || sRet.equals("listeAdjacence") || sRet.equals("matriceCoutOptimise")))
        {
            System.out.println("[ERREUR : SAISIE INVALIDE]");
            sRet = sc.next();

            if (sRet.equals("matriceCout"))
                structure.genererTxt("matriceCout");
            
            if (sRet.equals("listeAdjacence"))
                structure.genererTxt("listeAdjacence");

            if (sRet.equals("matriceCoutOptimise"))
                structure.genererTxt("matriceCoutOptimise");
        }
    }  
}
