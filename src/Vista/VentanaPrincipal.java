package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class VentanaPrincipal extends JFrame{
	private static final long serialVersionUID = 1L;
    
	public JPanel panelC, panelJ;
    public JMenuItem NoJ;
    public JButton girar, finalizar;
    public JLabel n1,n2,n3,n4,n5,n6,n7,n8, gif;
    public JLabel v[];
    public GirarBotella gb;
   
	public VentanaPrincipal() {
		setSize(550, 670);
	    getContentPane().setBackground(new Color(108,82,192).darker());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 20,15));
		setResizable(false);
		initComp();
		
		setVisible(true);
	}
	public void initComp() {
		JMenuBar bar= new JMenuBar();
		JMenu ingresar;
		
		panelC = new JPanel();
		panelC.setSize(new Dimension(250, 250));
		panelC.setLocation(120, 100);
		panelC.setLayout(new BorderLayout());
		panelC.setBackground(Color.white);
		
		panelJ = new JPanel();
		panelJ.setPreferredSize(new Dimension(495, 500));
		panelJ.setLayout(null);
		panelJ.setBackground(Color.white);
		
		NoJ= new JMenuItem("Numero de jugadores");
		NoJ.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		
		ingresar= new JMenu("Jugadores");
		ingresar.setIcon(new ImageIcon("jug.png"));
		ingresar.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		ingresar.setMnemonic('s');
		
		finalizar= new JButton("Finalizar");
		finalizar.setPreferredSize(new Dimension(100, 30));
		finalizar.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
		finalizar.setBackground(Color.red);
		finalizar.setForeground(Color.black);
		girar= new JButton("Girar");
		girar.setBackground(Color.green);
		girar.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		girar.setBounds(200,460,80, 30);
		girar.setForeground(Color.black);
		
		n1=new JLabel("J# 1");
		n1.setForeground(Color.white);
		n1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		n1.setBounds(225, 30,50, 20);
		n2=new JLabel("J# 2");
		n2.setForeground(Color.white);
		n2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		n2.setBounds(225, 400,50, 20);
	    n3=new JLabel("J# 3");
	    n3.setForeground(Color.white);
	    n3.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	    n3.setBounds(30, 215,50, 20);
	    n4=new JLabel("J# 4");
	    n4.setForeground(Color.white);
	    n4.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	    n4.setBounds(420, 215,50, 20);
	    n5=new JLabel("J# 5");
	    n5.setForeground(Color.white);
	    n5.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	    n5.setBounds(82, 95,50, 20);
	    n6=new JLabel("J# 6");
	    n6.setForeground(Color.white);
	    n6.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	    n6.setBounds(370, 337,50, 20);
	    n7=new JLabel("J# 7");
	    n7.setForeground(Color.white);
	    n7.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	    n7.setBounds(82, 337,50, 20);
	    n8=new JLabel("J# 8");
	    n8.setForeground(Color.white);
	    n8.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	    n8.setBounds(370, 95,50, 20);
	    gif=new JLabel(new ImageIcon("gif.gif"));
	    
	    panelC.add(gif);
	    panelJ.add(n1);
		panelJ.add(n2);
		panelJ.add(n3);
		panelJ.add(n4);
		panelJ.add(n5);
		panelJ.add(n6);
		panelJ.add(n7);
		panelJ.add(n8);
		panelJ.add(panelC);
		
		ingresar.add(NoJ);
		bar.add(ingresar);
		setJMenuBar(bar);
		panelJ.add(girar);
		add(panelJ);
		add(finalizar);
	}//initComp
	
}
