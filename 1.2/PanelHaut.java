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
        panelGauche.setLayout(new GridLayout(1, 2));
        panelGauche.setBackground(new Color(200, 157, 235));

        lblCapacite = new JLabel("Capacite : ", JLabel.RIGHT);
        this.txtCapacite = new JTextField("",15);
        
        

        // panel Droit
        panelDroit = new JPanel();
        panelDroit.setLayout(new GridLayout(3,1));
        panelDroit.setBackground(new Color(200, 157, 235));

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

    public String getTxtCapacite()
    {
        return this.txtCapacite.getText();
    }

    public String getTxtCuve1()
    {
        return this.txtCuve1.getText();
    }
    
    public String getTxtCuve2()
    {
        return this.txtCuve2.getText();
    }

    public String getTxtSection()
    {
        return this.txtSection.getText();
    }

    public void resetTxt()
    {
        this.txtCapacite.setText("");
        this.txtCuve1.setText("");
        this.txtCuve2.setText("");
        this.txtSection.setText("");
    }
}