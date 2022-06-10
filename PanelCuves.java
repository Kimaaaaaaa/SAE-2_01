import javax.swing.*;
import java.awt.*;

public class PanelCuve extends JPanel
{
	private char idCuve;
	private static char stkCuve;
	private JLabel  lblCuveCapacite;
	private JTextField txtCapacite ;

	public PanelCuve()
	{	
		this.idCuve = PanelCuve.stkCuve++;
		this.lblCuveCapacite  = new JLabel ("cuve " + this.idCuve + " : capacité :");
		this.txtCapacite      = new JTextField();

		this.add(this.lblCuveCapacite);
		this.add(this.txtCapacite);

	}
}
