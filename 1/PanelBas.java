import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBas extends JPanel implements ActionListener
{   
    private JButton btnAddCuve;
    private JButton btnAddTube;
    private JRadioButton choixLa;
    private JRadioButton choixMc;
    private JRadioButton choixMca;
    private ButtonGroup bgChoix;
    private JButton btnGenerer;

    private Controleur ctrl;
    private PanelBas   panelBas;
    private PanelCentre panelCentre;

    public PanelBas(Controleur ctrl, PanelCentre panelCentre)
    {
        JPanel panelHaut, panelGenerer, panelChoix;
        this.ctrl = ctrl;
        this.panelCentre = panelCentre;

        this.setLayout(new GridLayout(3,1));

        // creation des composants
        // panel Haut
        panelHaut = new JPanel();
        panelHaut.setLayout(new GridLayout(1,2));
        panelHaut.setBackground(new Color(255,111,111));

        this.btnAddCuve = new JButton("Ajouter Cuve");
        this.btnAddTube = new JButton("Ajouter Tube");

        // panel Centre
        panelChoix = new JPanel();
        panelChoix.setLayout(new FlowLayout());
        panelChoix.setBackground(new Color(255,111,111));

        this.choixLa = new JRadioButton("Liste d'Adjacence", true);
        this.choixMc = new JRadioButton("Matrice de cout");
        this.choixMca = new JRadioButton("Matrice de cout optimisee");

        this.bgChoix = new ButtonGroup();
        this.bgChoix.add(choixLa);
        this.bgChoix.add(choixMc);
        this.bgChoix.add(choixMca);

        // panel Bas
        panelGenerer = new JPanel();
        panelGenerer.setLayout(new FlowLayout());
        panelGenerer.setBackground(new Color(255,111,111));

        this.btnGenerer = new JButton("Generer");

        // positionnement des composants
        // panel Haut
        panelHaut.add(this.btnAddCuve);
        panelHaut.add(this.btnAddTube);

        // panel Centre
        panelChoix.add(this.choixLa);
        panelChoix.add(this.choixMc);
        panelChoix.add(this.choixMca);

        // panel Bas
        panelGenerer.add(this.btnGenerer);
        this.btnAddCuve.addActionListener(this);

        // panels sur frame
        this.add(panelHaut);
        this.add(panelChoix);
        this.add(panelGenerer);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.btnAddCuve)
        {
            this.panelCentre.majIHM();
        }
    }


}