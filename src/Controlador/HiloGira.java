package Controlador;

import java.awt.BorderLayout;

import Vista.*;

public class HiloGira extends Thread {
	public VentanaPrincipal v;
	public int cantJugadores;
	public int alia;
	public int valor;
	public int cant;
	public int vida;
	public int i;

	public HiloGira(VentanaPrincipal v, int cant, int alia, int valorAc, int vida, int i) {
		this.v = v;
		this.cant = cant;
		this.alia = alia;
		this.valor = valorAc;
		this.vida=vida;
		this.i=i;

		v.gb = new GirarBotella(v.panelC.getWidth(), v.panelC.getHeight(), valorAc);
		v.panelC.add(v.gb, BorderLayout.CENTER);
		v.setVisible(true);
		
		v.gb.setGrados(valor);

		darValor();
	}

	public void darValor() {
		switch (alia) {

		case 1:

			valor = 360;

			break;

		case 2:

			valor = 180;

			break;

		case 3:

			valor = 270;

			break;

		case 4:

			valor = 90;

			break;

		case 5:

			valor = 315;

			break;

		case 6:

			valor = 135;

			break;

		case 7:

			valor = 225;

			break;

		case 8:

			valor = 45;

			break;

		// Dos mas aparte de los 8
		case 9:
			valor = 30;
			break;

		case 10:
			valor = 200;
			break;

		}
	}

	@Override
	public void run() {
		for (int o = 0; o < 3; o++) {
			if (o == 0) {
				for (int i = valor; i < 360; i++) {
					v.gb.setGrados(i);

				
						try {

							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					

				} // For interno
			} else if (o == 1) {

				for (int i = 0; i < 360; i++) {
					v.gb.setGrados(i);

					if (i < 330) {
						try {

							Thread.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} else if (i < 340) {
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();

						}
					} else if (i < 360) {
						try {
							Thread.sleep(4);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
                    }else {
                    	try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						}

				} // For interno
			} else {

				for (int i = 0; i <= valor; i++) {
					v.gb.setGrados(i);

					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} // For interno
			}
		} // For externo
		v.girar.setEnabled(true);
		if(cant>=alia) {
		v.girar.setText("Gira el J# "+alia);
		v.girar.setBounds(150,460,190, 30);
		v.v[i].setText(vida+"");
			
		}
	}

}
