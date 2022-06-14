import java.util.ArrayList;

public class Transfert
{
  public static void main(String[] args)
  {
    Cuve cuveA = Cuve.fabriquerCuve(1000);
    Cuve cuveB = Cuve.fabriquerCuve(900);
    Cuve cuveC = Cuve.fabriquerCuve(200);
    Cuve cuveD = Cuve.fabriquerCuve(700);

    Tube tube1 = new Tube(2);
    Tube tube2 = new Tube(4);
    Tube tube3 = new Tube(6);
    Tube tube4 = new Tube(8);

    cuveA.remplirCuve(500);
    cuveC.remplirCuve(190);

    tube1.relierCuves(cuveA, cuveB);
    tube2.relierCuves(cuveB, cuveC);
    tube3.relierCuves(cuveA, cuveC);
    tube4.relierCuves(cuveB, cuveD);

    Cuve[] listeCuves = {cuveA, cuveB, cuveC, cuveD};

    final int TAILLE = listeCuves.length;

    int[][] matriceCout = {{0, 2, 6, 0}, {0, 0, 4, 8}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    int[][] matriceTransfert = new int[TAILLE][TAILLE];

    for(int i = 0; i < TAILLE; i++)
    {
      System.out.println(listeCuves[i]);
    }

    for(int x = 1; x < 11; x++)
    {
      System.out.println("etape "+x);
      for(int i = 0; i < TAILLE; i++)
      {
        for(int j = 0; j < TAILLE; j++)
        {
          if(i != j)
          {
            matriceTransfert[i][j] = calculTransfert(listeCuves[i], listeCuves[j], matriceCout);
          }
        }
      }

      for(int i = 0; i < TAILLE; i++)
      {
        for(int j = 0; j < TAILLE; j++)
        {
          System.out.print(matriceTransfert[i][j]);
        }
        System.out.println("");
      }

      effecTransfert(listeCuves, matriceTransfert);
      System.out.println("");

      for(int i = 0; i < TAILLE; i++)
      {
        System.out.println(listeCuves[i]);
      }
    }
  }

  public static int calculTransfert(Cuve cuve1, Cuve cuve2, int[][] matriceCout)
  {
    int iCuve1 = (int)cuve1.getId() - 65;
    int iCuve2 = (int)cuve2.getId() - 65;
    int flux = matriceCout[Math.min(iCuve1, iCuve2)][Math.max(iCuve1, iCuve2)];//on recupere la valeur du tuyau entre les 2 cuves (0 si pas de tuyau)

    if( flux != 0 && cuve1.getContenu() > cuve2.getContenu()) //si il y a un tuyau entre les 2 cuves et qu'il y a plus de fluide dans cuve1 que dans cuve2 :
    {
      if( cuve2.getContenu() + flux > cuve2.getCapacite())//si ce qu'on va rajouter dans cuve2 la fait deborder
      {
        flux = cuve2.getCapacite() - (int)cuve2.getContenu();//on fait en sorte que ce qu'on deplace remplisse cuve2 a ras bord
      }
      if( (int)cuve1.getContenu() - flux < 0 )//si il y moins de fluide dans cuve1 que ce qu'on  veut deplacer
      {
        flux = (int)cuve1.getContenu();//on prend ce qui reste dans cuve1
      }
      if( (int)cuve2.getContenu() + flux > (int)cuve1.getContenu() )//si en deplacant les fluides, cuve2 devient plus remplie que cuve2
      {
        flux = (int)cuve1.getContenu() - (int)cuve2.getContenu();//on "equilibre"
      }
      return flux;
    }
    else
    {
      return 0;
    }
  }

  public static boolean effecTransfert(Cuve[] listeCuves, int[][] matriceTransfert)
  {
    int transfert;

    for(int i = 0; i < listeCuves.length; i++)
    {
      for(int j = 0; j < listeCuves.length; j++)
      {
        transfert = matriceTransfert[i][j];
        listeCuves[i].remplirCuve(-transfert);
        listeCuves[j].remplirCuve(transfert);
      }
    }
    return true;
  }
}
