import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.*;



public class PanelBas extends JPanel implements ActionListener
{
	private JPanel panelAjouts, panelChoix, panelGenerer;
	private JButton  btnAjouterTubes;
	private JButton  btnAjouterCuves;
	private JButton  btnGenerer;
	private CheckboxGroup cbChoix;
	private Checkbox cbListe;
	private Checkbox cbMatrice;
	private Checkbox cbMatriceOpti;

	public PanelBas()
	{
		this.panelAjouts     = new JPanel  (new GridLayout(1, 2));
		this.panelChoix      = new JPanel  (new GridLayout(1, 3));
		this.panelGenerer    = new JPanel  ();
		this.btnAjouterTubes = new JButton ("Ajouter Tube");
		this.btnAjouterCuves = new JButton ("Ajouter Cuve");
		this.btnGenerer      = new JButton ("Generer");

		this.cbChoix = new CheckboxGroup();
		this.cbListe = new Checkbox ("Liste d'adjacance", this.cbChoix, false );
		this.cbMatrice = new Checkbox ("Matrice de cout", this.cbChoix, false );
		this.cbMatriceOpti = new Checkbox ("Matrice de cout optimisé", this.cbChoix, false );



		this.panelAjouts.add  (btnAjouterCuves);
		this.panelAjouts.add  (btnAjouterTubes);
		this.panelChoix.add   (cbListe);
		this.panelChoix.add   (cbMatrice);
		this.panelChoix.add   (cbMatriceOpti);
		this.panelGenerer.add (btnGenerer);

		this.add (this.panelAjouts);
		this.add (this.panelChoix);
		this.add (this.panelGenerer);

		this.btnAjouterCuves.addActionListener(this);
	}

	public JButton getBtnAjouterCuves()
	{
		return this.btnAjouterCuves;
	}

	public void actionPerformed(ActionEvent  e)
	{
		System.out.print("");
	}
}
