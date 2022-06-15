import java.io.*;
import java.util.ArrayList;

public class Structure
{
    // Attributs
    private int[][] tabStructure;
    private ArrayList<Cuve> tabCuve;
    private ArrayList<Tube> tabTube;
   
    // Constructeur
    public Structure()
    {
        this.tabStructure = null;
        this.tabCuve = new ArrayList<Cuve>();
        this.tabTube = new ArrayList<Tube>();
    }
    
    // Accesseurs
    public int getNbCuves() { return this.tabCuve.size(); }
    public int getNbTubes() { return this.tabTube.size(); }
    
    // Methodes
    public void ajouterCuve(Cuve c)
    {
        this.tabCuve.add(c);
    }   

    public boolean ajouterTube(Tube t, char cuve1, char cuve2)
    {
        Cuve temp1 = null;
        Cuve temp2 = null;

        for (int i=0; i<this.tabCuve.size(); i++)
        {
            if (this.tabCuve.get(i).getId() == cuve1)
                temp1 = this.tabCuve.get(i);
            
            if (this.tabCuve.get(i).getId() == cuve2)
                temp2 = this.tabCuve.get(i);
        }

        for(int i=0; i<this.tabTube.size(); i++)
        {
            if (this.tabTube.get(i).getCuve1().getId() == temp1.getId() && this.tabTube.get(i).getCuve2().getId() == temp2.getId() ||
                this.tabTube.get(i).getCuve1().getId() == temp2.getId() && this.tabTube.get(i).getCuve2().getId() == temp1.getId() ) 
            {
                temp1 = temp2 = null;
                i = this.tabTube.size();
            }
        }

        if (temp1 == null || temp2 == null)
            return false;
        else 
        {  
            t.relierCuves(temp1, temp2);
            this.tabTube.add(t);
            return true;
        }
    }

    public void remplirMatrice()
    {
        this.tabStructure = new int[this.tabCuve.size()][this.tabCuve.size()];
        for (int i=0; i<this.tabTube.size(); i++)
        {
            int x = (this.tabTube.get(i).getCuve1().getId())-'A';
            int y = (this.tabTube.get(i).getCuve2().getId())-'A';

            this.tabStructure[x][y] = this.tabTube.get(i).getSection();
            this.tabStructure[y][x] = this.tabTube.get(i).getSection();
        }
    }

    // Generation des fichiers .data
    public void genererData(String type)
    {
        File file = new File("donnees.data");

        switch(type) 
        {
            case "mc" :
            {
                try
                {
                    file.delete();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
                    pw.println("Matrice de cout" + "\n---------------");

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
                catch (Exception e) { System.out.println("Erreur"); }
                break;
            }

            default    : 
            {
                try
                {
                    file.delete();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
                    pw.println("Liste d'adjacence" + "\n-----------------");
                    
                    for (int i=0; i<this.tabStructure.length; i++)
                        for (int j = 0; j < this.tabStructure[i].length; j++)
                            if(this.tabStructure[i][j] != 0)
                                if(i < j)
                                    pw.println( (char) (i + 'A') + " <--> " + (char) (j + 'A') + " (" + this.tabStructure[i][j] + ") ");   

                    pw.close();
                }
                catch (Exception e) { System.out.println("Erreur"); }
                break;
            }
            case "mco"  :
            {
                try
                {
                    file.delete();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
                    pw.println("Matrice de cout optimisee" + "\n-------------------------");

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
                catch (Exception e) { System.out.println("Erreur"); }
                break;
            }
        }
    } 
}