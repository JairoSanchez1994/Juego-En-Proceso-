package Vista;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
public class ElegirNJ extends JDialog{
	private static final long serialVersionUID = 1L;
	public JButton em;
	public JSlider js;
	public JLabel cant;
	public ElegirNJ() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300, 200);
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 15));
		setLocationRelativeTo(null);
		setTitle("Numero de jugadores");
		initComp();
		
        setVisible(true);
	}

	public void initComp() {
	em= new JButton("Aceptar");
	em.setBackground(Color.white);
	em.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
	
	js = new JSlider(2, 8);
    js.setValue(2);
    js.setBorder(BorderFactory.createTitledBorder("Deslice para cambiar"));
    
	cant = new JLabel(js.getValue()+"");
	cant.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	
	add(js);
	add(cant);
    add(em);
	}
}
