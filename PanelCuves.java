import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class PanelCuves extends JPanel
{
	public PanelCuves()
	{	
		this.setLayout( new GridLayout(26, 1) );
	}

	public void ajouterCuve()
	{
		this.add ( new PanelCuve() );
	}
}
