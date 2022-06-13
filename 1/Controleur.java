public class Controleur
{
	private FramePrinc ihm;
	private PanelHaut  panelHaut;

	public Controleur()
	{
		this.ihm = new FramePrinc(this);
	}

	public static void main(String[] a)
	{
		new Controleur();
	}

}