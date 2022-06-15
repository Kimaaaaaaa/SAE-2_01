
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class PanelCentre extends JPanel
{   
    private Structure structure;
    //private PanelBas panelBas;
    private PanelHaut panelHaut;

    private JPanel panelGauche;
    private JLabel lblCuve;
    private JTable tblCuve;
    private DefaultTableModel modelCuve;
    private JScrollPane spTblCuve;

    private JPanel panelDroit;
    private JLabel lblTube;
    private JTable tblTube;
    private DefaultTableModel modelTube;
    private JScrollPane spTblTube;

    public PanelCentre(PanelBas panelBas, PanelHaut panelHaut)
    {
        this.structure = new Structure();
        //this.panelBas  = panelBas;
        this.panelHaut = panelHaut;

        this.panelGauche = new JPanel();
        this.panelDroit  = new JPanel();
        this.setLayout(new GridLayout(1, 2));

        // CREATION DES COMPOSANTS
        // panelGauche
        this.panelGauche.setLayout(new BorderLayout());
        this.panelGauche.setBackground(new Color(167,132,196));

        this.lblCuve = new JLabel("Liste des Cuves :" , SwingConstants.CENTER);
        
        this.modelCuve = new DefaultTableModel();
        this.tblCuve = new JTable(this.modelCuve);
        this.tblCuve.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        this.spTblCuve = new JScrollPane(this.tblCuve);
        this.modelCuve.addColumn("ID");
        this.modelCuve.addColumn("Capacite");

        // panelDroit
        this.panelDroit.setLayout(new BorderLayout());
        this.panelDroit.setBackground(new Color(167,132,196));

        this.lblTube = new JLabel("Liste des Tubes : ", SwingConstants.CENTER);

        this.modelTube = new DefaultTableModel();
        this.tblTube = new JTable(this.modelTube);
        this.tblTube.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        this.spTblTube = new JScrollPane(this.tblTube);
        this.modelTube.addColumn("Cuve 1");
        this.modelTube.addColumn("Cuve 2");
        this.modelTube.addColumn("Section");

        // POSITIONNEMENT DES COMPOSANTS   
        // panelGauche
        this.panelGauche.add(this.lblCuve, BorderLayout.NORTH);
        this.panelGauche.add(this.spTblCuve, BorderLayout.CENTER);

        // panelDroit
        this.panelDroit.add(this.lblTube, BorderLayout.NORTH);
        this.panelDroit.add(this.spTblTube, BorderLayout.CENTER);

        // Ajouts des panels sur la Frame
        this.add(this.panelGauche);
        this.add(this.panelDroit);

        this.setVisible(true);
    }

    public Structure getStructure()
    {
        return this.structure;
    }

    public void majIHM(String btn)
    {
        if (btn.equals("cuve"))
        {
            if(!this.panelHaut.getTxtCapacite().equals(""))
            {
                Cuve c = Cuve.fabriquerCuve(Integer.parseInt(this.panelHaut.getTxtCapacite()));

                if (c == null)
                {
                    this.lblCuve.setText("Liste des Cuves : (impossible)");
                    this.lblCuve.setForeground(new Color (230, 50, 50));
                }
                else
                {
                    this.modelCuve.insertRow(0, new Object[]{c.getId(), c.getCapacite()});
                    structure.ajouterCuve(c);
                    this.lblCuve.setText("Liste des Cuves :");
                    this.lblCuve.setForeground(Color.BLACK);
                }
                this.panelHaut.resetTxt();
            }
        }
        
        if (btn.equals("tube"))
        {
            if(!this.panelHaut.getTxtCuve1().equals("") ||
               !this.panelHaut.getTxtCuve2().equals("") ||
               !this.panelHaut.getTxtSection().equals("") )
            {
                Tube t = new Tube(Integer.parseInt(this.panelHaut.getTxtSection()));
                if (structure.ajouterTube(t, this.panelHaut.getTxtCuve1().charAt(0), 
                                             this.panelHaut.getTxtCuve2().charAt(0)))
                {
                    this.modelTube.insertRow(0, new Object[]{t.getCuve1().getId(), t.getCuve2().getId(), t.getSection()});
                    this.lblTube.setText("Liste des Tubes : ");
                    this.lblTube.setForeground(Color.BLACK);
                }
                else
                {
                    this.lblTube.setText("Liste des Tubes : (impossible)");
                    this.lblTube.setForeground(new Color (230, 50, 50));
                }
                this.panelHaut.resetTxt();
            }
        }
    }
}