import javax.swing.*;
import java.awt.*;

public class FramePrinc extends JFrame
{
    private Controleur ctrl;

    private PanelHaut panelHaut;
    private PanelCentre panelCentre;
    private PanelBas    panelBas;

    public FramePrinc(Controleur ctrl)
    {
        this.setTitle("Ajout Cuves et Tubes");   
        this.setSize(1920,1080);
        this.setLocation(20,20);
        this.setLayout(new BorderLayout());

        this.panelHaut = new PanelHaut();
        this.panelCentre = new PanelCentre(this.panelBas, this.panelHaut);
        this.panelBas  = new PanelBas(this.ctrl, panelCentre);
        
        this.ctrl = ctrl;

        this.add(this.panelHaut, BorderLayout.NORTH);
        this.add(this.panelCentre, BorderLayout.CENTER);
        this.add(this.panelBas, BorderLayout.SOUTH);

        this.setVisible(true);
    }



}