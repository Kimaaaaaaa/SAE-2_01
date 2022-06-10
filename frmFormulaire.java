import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frmFormulaire extends JFrame
{
	private PanelCuves panelCuves;
	private PanelTubes panelTubes;
	private PanelBas   panelBas;

	private JPanel     panelCentre;

	public frmFormulaire()
	{

		this.setTitle("Formulaire");
		this.setLocation(100, 100);
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panelCentre = new JPanel    ();
		this.panelCuves  = new PanelCuves();
		this.panelTubes  = new PanelTubes();
		this.panelBas    = new PanelBas  ();

		panelCentre.setLayout(new GridLayout (1, 2));
		panelBas.setLayout(new GridLayout (3, 1));

		panelCentre.add(panelCuves);
		panelCentre.add(panelTubes);

		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelBas, BorderLayout.SOUTH);

		JScrollBar sb     = new JScrollBar();






		this.setVisible(true);
	}

	public static void main(String [] args)
	{
		new frmFormulaire();
	}

	public void actionPerformed(ActionEvent  e)
	{
		if ( e.getSource() == this.panelBas.getBtnAjouterCuves() )
		{
			this.panelCuves.ajouterCuve();
		}
	}

}
