import java.io.*;
import java.util.Scanner;

public class Structure
{
    /*-------------*/
    /*--Attributs--*/
    /*-------------*/
    
    private static int[][] tabStructure;
    
    /*----------------*/
    /*--Constructeur--*/
    /*----------------*/

    public Structure(/*int[][] tabStructure*/)
    {                                   //  A   B   C   D   E 
        this.tabStructure = new int[][] { { 0 , 1 , 10 , 0 , 0 },  // A 
                                          { 1 , 0 , 7 , 9 , 3  },  // B 
                                          { 10 , 7 , 0 , 4 , 2 },  // C
                                          { 0 , 9 , 4 , 0 , 5  },  // D
                                          { 0 , 3 , 2 , 5 , 0  } };// E
    }
    
    /*----------------*/
    /*---Accesseurs---*/
    /*----------------*/
   
    public void getNbCuves() { }
    
    /*----------------*/
    /*----Méthodes----*/
    /*----------------*/

    public void genererTxt(String type, int[][] tabStructure)
    {
        switch(type) 
        {
            case "matriceCout"       :
            {
                try
                {
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("matriceCout.data"), "UTF8"));
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
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("listeAdjacence.data"), "UTF8"));
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
                    e.printStackTrace();
                }
                break;
            }
            case "matriceCoutOptimise"  :
            {
                try
                {
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("matriceCoutOptimise.data"), "UTF8"));
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
        }
    } 
    
    /*-----Test-----*/

    public static void main(String[] args)
    {
        Structure s1 = new Structure();
        Structure s2 = new Structure();
        Structure s3 = new Structure();
        
        s1.genererTxt("listeAdjacence",     Structure.tabStructure );
        s2.genererTxt("matriceCout"   ,     Structure.tabStructure );
        s3.genererTxt("matriceCoutOptimise", Structure.tabStructure );
    }

}
