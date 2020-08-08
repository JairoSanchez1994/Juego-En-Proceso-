package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
public class GirarBotella extends JPanel {
 
	private static final long serialVersionUID = 1L;
	
   private int grados = 0, ancho = 0, largo = 0;
    
	public GirarBotella(int ancho, int largo, int grados) {
		this.ancho=ancho;
		this.largo=largo;
		this.grados=grados;
		setBackground(Color.white);
	}
    public int getGrados() {
        return grados;
    }
 
    public void setGrados(int grados) {
        this.grados = grados;
        repaint();
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g); //se borra el contenido anterior
     
        double r = Math.toRadians(grados); //se convierte a radianes lo grados
        
        AffineTransform at = new AffineTransform();
        at.rotate(r,ancho/2,largo/2); //se asigna el angulo y centro de rotacion
        ((Graphics2D) g).setTransform(at);
        
       Image Img = new ImageIcon("Botella.png").getImage();
      //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
      g.drawImage(Img, 0, 0, ancho, largo, null);
      
      
    }
}
