import javax.swing.*;
import java.awt.*;

public class PanelHaut extends JPanel
{
    private JTextField txtCapacite;
    private JTextField txtCuve1;
    private JTextField txtCuve2;
    private JTextField txtSection;
    
    public PanelHaut()
    {
        JPanel panelGauche, panelDroit;
        JLabel lblCapacite, lblCuve1, lblCuve2, lblSection;

        this.setLayout(new GridLayout(1,2));

        // creation des composants
        // panel Gauche
        panelGauche = new JPanel();
        panelGauche.setLayout(new GridLayout(1,1));
        panelGauche.setBackground(new Color(111, 111, 255));

        lblCapacite = new JLabel("Capacite : ", JLabel.RIGHT);
        this.txtCapacite = new JTextField("",15);

        // panel Droit
        panelDroit = new JPanel();
        panelDroit.setLayout(new GridLayout(3,1));
        panelDroit.setBackground(new Color(050, 050, 255));

        lblCuve1 = new JLabel("ID Cuve 1 :   ", JLabel.RIGHT);
        this.txtCuve1 = new JTextField("",15);
        lblCuve2 = new JLabel("ID Cuve 2 :   ", JLabel.RIGHT);
        this.txtCuve2 = new JTextField("",15);
        lblSection = new JLabel("Section :   ", JLabel.RIGHT);
        this.txtSection = new JTextField("",15);

        // positionnement des composants
        // panel Gauche
        panelGauche.add(lblCapacite);
        panelGauche.add(this.txtCapacite);

        // panel Droit
        panelDroit.add(lblCuve1);
        panelDroit.add(this.txtCuve1);
        panelDroit.add(lblCuve2);
        panelDroit.add(this.txtCuve2);
        panelDroit.add(lblSection);
        panelDroit.add(this.txtSection);

        // panels sur frame
        this.add(panelGauche);
        this.add(panelDroit);

        this.setVisible(true);
    }

    public void resetTxtCapacite()
    {
        this.txtCapacite.setText("");
    }

    public String getTxtCapacite()
    {
        if(!this.txtCapacite.equals(""))
        {
            return this.txtCapacite.getText();
        }
      return null;
    }

    
}