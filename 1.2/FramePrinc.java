import javax.swing.*;
import java.awt.*;

public class FramePrinc extends JFrame
{
    private PanelHaut panelHaut;
    private PanelCentre panelCentre;
    private PanelBas    panelBas;

    public FramePrinc()
    {
        this.setTitle("Ajout Cuves et Tubes");   
        this.setSize(500,600);
        this.setLocation(20,20);
        this.setLayout(new BorderLayout());

        this.panelHaut = new PanelHaut();
        this.panelCentre = new PanelCentre(this.panelBas, this.panelHaut);
        this.panelBas  = new PanelBas(this.panelCentre);

        this.add(this.panelHaut, BorderLayout.NORTH);
        this.add(this.panelCentre, BorderLayout.CENTER);
        this.add(this.panelBas, BorderLayout.SOUTH);

        this.pack();

        this.setVisible(true);

    }



}