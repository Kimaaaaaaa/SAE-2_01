import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBas extends JPanel implements ActionListener
{   
    private PanelCentre panelCentre;

    private JButton btnAddCuve;
    private JButton btnAddTube;

    private JRadioButton choixLa;
    private JRadioButton choixMc;
    private JRadioButton choixMco;
    private ButtonGroup bgChoix;

    private JButton btnGenerer;

    public PanelBas(PanelCentre panelCentre)
    {
        JPanel panelHaut, panelGenerer, panelChoix;
        this.panelCentre = panelCentre;

        this.setLayout(new GridLayout(3,1));

        // creation des composants
        // panelHaut
        panelHaut = new JPanel();
        panelHaut.setLayout(new GridLayout(1,2));
        panelHaut.setBackground(new Color(101,120,184));

        this.btnAddCuve = new JButton("Ajouter Cuve");
        this.btnAddTube = new JButton("Ajouter Tube");

        // panelCentre
        panelChoix = new JPanel();
        panelChoix.setLayout(new FlowLayout());
        panelChoix.setBackground(new Color(135,114,158));

        this.choixLa = new JRadioButton("Liste d'Adjacence", true);
        this.choixMc = new JRadioButton("Matrice de cout");
        this.choixMco = new JRadioButton("Matrice de cout optimisee");

        this.choixLa.setBackground(new Color(135,114,158));
        this.choixMc.setBackground(new Color(135,114,158));
        this.choixMco.setBackground(new Color(135,114,158));

        this.bgChoix = new ButtonGroup();
        this.bgChoix.add(this.choixLa);
        this.bgChoix.add(this.choixMc);
        this.bgChoix.add(this.choixMco);

        // panelBas
        panelGenerer = new JPanel();
        panelGenerer.setLayout(new FlowLayout());
        panelGenerer.setBackground(new Color(135,114,158));

        this.btnGenerer = new JButton("Generer");

        // POSITIONNEMENT DES COMPOSANTS
        // panelHaut
        panelHaut.add(this.btnAddCuve);
        this.btnAddCuve.addActionListener(this);
        panelHaut.add(this.btnAddTube);
        this.btnAddTube.addActionListener(this);

        // panelCentre
        panelChoix.add(this.choixLa);
        panelChoix.add(this.choixMc);
        panelChoix.add(this.choixMco);

        // panelBas
        panelGenerer.add(this.btnGenerer);
        this.btnGenerer.addActionListener(this);

        // Ajouts des panels sur la Frame
        this.add(panelHaut);
        this.add(panelChoix);
        this.add(panelGenerer);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.btnAddCuve)
            this.panelCentre.majIHM("cuve");

        if (e.getSource() == this.btnAddTube)
            this.panelCentre.majIHM("tube");

        if (e.getSource() == this.btnGenerer)
        {
            this.panelCentre.getStructure().remplirMatrice();
            if (this.choixLa.isSelected())
                this.panelCentre.getStructure().genererData("la");
            if (this.choixMc.isSelected())
                this.panelCentre.getStructure().genererData("mc");
            if (this.choixMco.isSelected())
                this.panelCentre.getStructure().genererData("mco");
        }
    }
}