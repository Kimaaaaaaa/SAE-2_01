import javax.swing.*;
import java.awt.*;

public class PanelCentre extends JPanel
{   
    private PanelBas panelBas;
    private PanelHaut panelHaut;

    private JPanel panelGauche;
    private JPanel panelDroit;

    public PanelCentre(PanelBas panelBas, PanelHaut panelHaut)
    {
        this.panelBas  =  panelBas;
        this.panelHaut = panelHaut;

        this.panelGauche = new JPanel();
        this.panelDroit  = new JPanel();
        
        JLabel lblCuve, lblTube;

        this.setLayout(new GridLayout(1,2));

        // creation des composants
        // panel Gauche
        this.panelGauche.setLayout(new GridLayout(27, 1));
        this.panelGauche.setBackground(new Color(200, 200, 200));

        lblCuve = new JLabel("Liste des Cuves :" , SwingConstants.CENTER);

        // panel Droit
        this.panelDroit.setLayout(new FlowLayout());
        this.panelDroit.setBackground(new Color(175, 175, 175));

        lblTube = new JLabel("Liste des Tubes : ");

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

    public void majIHM()
    {
        if(!this.panelHaut.getTxtCapacite().equals("") && Integer.parseInt(this.panelHaut.getTxtCapacite()) >= 200 &&  Integer.parseInt(this.panelHaut.getTxtCapacite()) <= 1000)
        {
        
            Cuve c = new Cuve(Integer.parseInt(this.panelHaut.getTxtCapacite()));

            this.panelGauche.add(new JLabel("Cuve : " + c.getId() + " / capacite : " +  this.panelHaut.getTxtCapacite(), SwingConstants.CENTER).setBackground(new Color(124,221,214)));
            this.panelHaut.resetTxtCapacite();

        }
       
    }
}