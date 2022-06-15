import java.io.*;
import java.util.ArrayList;

public class Structure
{
    // Attributs
    private Controleur ctrl;
    private int[][] tabStructure;
    private ArrayList<Cuve> tabCuve;
    private ArrayList<Tube> tabTube;
   
    // Constructeur
    public Structure(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.tabStructure = null;
        this.tabCuve = new ArrayList<Cuve>();
        this.tabTube = new ArrayList<Tube>();
    }
    
    // Accesseurs
    public int getNbCuves() { return this.tabCuve.size(); }
    public int getNbTubes() { return this.tabTube.size(); }
    
    // Methodes
    public boolean ajouterCuve(int capacite)
    {
        Cuve temp = Cuve.fabriquerCuve(capacite);
        if (temp == null)
            return false;
        else
            this.tabCuve.add(temp);
        
        return true;
    }   

    public void ajouterTubes(String[] strSplit)
    {
        for (int i=0; i<strSplit.length; i++)
        {
            if(strSplit[i].length() == 3)
                this.tabTube.add(new Tube(Character.getNumericValue(strSplit[i].charAt(2))));
    
            if(strSplit[i].length() >= 4)
            {
                String fusion = (strSplit[i].charAt(2) + "" + strSplit[i].charAt(3));
                this.tabTube.add(new Tube(Integer.parseInt(fusion)));
            }
    
            this.tabTube.get(i).relierCuves( (this.tabCuve.get(Character.toUpperCase(strSplit[i].charAt(0))-'A')) , 
                                             (this.tabCuve.get(Character.toUpperCase(strSplit[i].charAt(1))-'A')) );
        }
    }

    public void remplirMatrice()
    {
        this.tabStructure = new int[this.tabTube.size()][this.tabTube.size()];
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
                catch (Exception e) { System.out.println("Erreur"); }
                break;
            }

            default    : 
            {
                try
                {
                    file.delete();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
                    pw.println(type.toUpperCase() + "\n--------------");
                    
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
                catch (Exception e) { System.out.println("Erreur"); }
                break;
            }
        }
    } 
}