package presentacion;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ayuda extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel mi_pantalla_ayuda;
	
	public Ayuda(){
		
		super("Ayuda JLOGO XXI");
		setLayout(new FlowLayout());
		Icon pantalla = new ImageIcon(getClass().getResource("/images/ayuda.png"));
		mi_pantalla_ayuda = new JLabel("", pantalla, SwingConstants.CENTER);
		add(mi_pantalla_ayuda);
		
	
	}
	
	
}

