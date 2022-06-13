import javax.swing.*;
import java.awt.*;

public class PanelCentre extends JPanel
{   
    private PanelBas panelBas;
    private PanelHaut panelHaut;

    private JPanel panelGauche;
    private JPanel panelDroit;
    private FramePrinc frm;

    private JLabel lblErrorCuve;
    private JLabel lblErrorTube;

    public PanelCentre(PanelBas panelBas, PanelHaut panelHaut, FramePrinc frm)
    {
        this.panelBas  =  panelBas;
        this.panelHaut = panelHaut;

        this.lblErrorCuve = new JLabel("");
        this.lblErrorCuve.setForeground(new Color(255, 0, 0));

        this.lblErrorTube = new JLabel("");
        this.lblErrorTube.setForeground(new Color(255, 0, 0));

        this.frm = frm;

        this.panelGauche = new JPanel();
        this.panelDroit  = new JPanel();
        
        JLabel lblCuve, lblTube;

        this.setLayout(new GridLayout(1,2));

        // creation des composants
        // panel Gauche
        this.panelGauche.setLayout(new GridLayout(28, 1));
        this.panelGauche.setBackground(new Color(200, 200, 200));

        lblCuve = new JLabel("Liste des Cuves :" , SwingConstants.CENTER);

        // panel Droit
        this.panelDroit.setLayout(new GridLayout(28, 1));
        this.panelDroit.setBackground(new Color(175, 175, 175));

        lblTube = new JLabel("Liste des Tubes : ", SwingConstants.CENTER);

        // positionnement des composants
        // panel Gauche
        this.panelGauche.add(lblCuve);

        // panel Droit
        this.panelDroit.add(lblTube);

        // panels sur frame
        this.add(this.panelGauche);
        this.add(this.panelDroit);

        this.setVisible(true);
    }

    public void majIHMCuve()
    {
        
                if(!this.panelHaut.getTxtCapacite().equals(""))
                {
                    
                    Cuve c = Cuve.fabriquerCuve(Integer.parseInt(this.panelHaut.getTxtCapacite()));

                    if(Integer.parseInt(this.panelHaut.getTxtCapacite()) > 1000 || Integer.parseInt(this.panelHaut.getTxtCapacite()) < 200 )
                    {
                        this.lblErrorCuve.setText("Saisie Incorrecte !");
                    }
                    else{
                        this.panelGauche.add(new JLabel(String.format("%25s", "Cuve : " + c.getId() + " / capacite : " +  this.panelHaut.getTxtCapacite()), SwingConstants.CENTER));
                        lblErrorCuve.setText(" ");
                    }
                    
                    this.panelGauche.add(lblErrorCuve, SwingConstants.CENTER);
                    this.panelHaut.resetTxtCapacite();

                    this.frm.pack();

                }
                else 
                    this.lblErrorCuve.setText("Pas de saisie !");
            
                

       
    }

    
    public void majIHMTube()
    {
        if(!this.panelHaut.getTxtCuve1().equals("") && !this.panelHaut.getTxtCuve2().equals("") && !this.panelHaut.getTxtSection().equals(""))
        {
        
            Tube t = new Tube(Integer.parseInt(this.panelHaut.getTxtSection()));
            

            this.panelDroit.add(new JLabel("Cuve de départ : " + this.panelHaut.getTxtCuve1().charAt(0) + " ----> " + "Cuve d'arrivée : " + this.panelHaut.getTxtCuve2().charAt(0) + " (" + this.panelHaut.getTxtSection() + ")",  SwingConstants.CENTER));
            this.lblErrorTube.setText(" ");

            this.frm.pack();

        }
        else 
        {
            this.lblErrorTube.setText("Pas de saisie !");
            
        }
        this.panelDroit.add(this.lblErrorTube, SwingConstants.CENTER);
        this.panelHaut.resetTxtCuve1();
        this.panelHaut.resetTxtCuve2();
        this.panelHaut.resetSection();
 
    }
}