package Controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Modelo.Jugador;
import Vista.ElegirNJ;
import Vista.VentanaPrincipal;

public class Juego {
	public VentanaPrincipal principal;
	public ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	public int Cont = 0;
	public int valorAc = 0;

	public Juego() {
		principal = new VentanaPrincipal();

		acciones();
	}

	public void acciones() {
		principal.girar.addActionListener(ActionEvent -> {
			int aliatorio = generaNumeroAleatorio(1, Cont + 2);
			if (Cont >= 1) {
				principal.girar.setEnabled(false);

				Jugador j = null;
				int i = 0;
				while (i < jugadores.size()) {
					j = jugadores.get(i);

					if (aliatorio == j.getNume()) {
						j.setCont(j.getCont() + 1);
						j.push();
						j.setVida(j.getVida() - 1);

						jugadores.set(i, j);
						break;
					}
					i++;
				}

				HiloGira g = new HiloGira(principal, Cont, aliatorio, valorAc, j.getVida(), i);
				g.start();

				if (revisar()) {
					finalizar();
				} // Fin del if revisar

			} else {
				JOptionPane.showMessageDialog(null, "Elija la cantidad de jugadores");
			}

		});

		principal.finalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}
		});

		principal.NoJ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ElegirNJ ele = new ElegirNJ();

				ele.js.addChangeListener(ChangeEvent -> {
					ele.cant.setText(ele.js.getValue() + "");
				});

				ele.em.addActionListener(ActionEvent -> {
					Cont = ele.js.getValue();
					generarJug();
					ele.dispose();
					principal.NoJ.setEnabled(false);
				});
			}
		});// Fin addAction De NoJ
	}

	public String definir() {
		int max = 0;
		int min = 10;

		int perdedor, ganador;
		String gana = "";
		String pierde = "";

		Jugador j;
		for (int a = 0; a < jugadores.size(); a++) {
			j = jugadores.get(a);
            
			if (j.cont < min) {
				min = j.cont;
				ganador = a;
				gana = "El ganador es el jugador #" + (ganador + 1);
			
			}else if (j.cont > max) {

				max = j.cont;
				perdedor = a;
				pierde = "El perdedor es el jugador #" + (perdedor + 1);
			}
			
		} // Fin for
		int g=0, p=0;
		for (int i = 0; i < jugadores.size(); i++) {
			j = jugadores.get(i);
          if(j.cont==min) {
        	  g++;
        	  if(g>1) {
        		  gana = "No hay ganadores por empate";
        	  }
          }else
		  if(j.cont==max) {
			  p++;
			  if(p>1) {
				  pierde = "Hay mas de un perdedor por empate";
			  }
		  }
          
          
		} // Fin for

		return  gana+ "\n" + pierde;

	}

	public boolean revisar() {
		Jugador pla;
		int o = 0;
		while (o < jugadores.size()) {
			pla = jugadores.get(o);

			if (pla.getCont() == 9) {
				return true;
			}
			o++;
		}
		return false;
	}// Fin for

	public void finalizar() {
		for (int i = 0; i < Cont; i++) {
			principal.panelJ.remove(principal.v[i]);
		}
		principal.n1.setForeground(Color.white);
		principal.n2.setForeground(Color.white);
		principal.n3.setForeground(Color.white);
		principal.n4.setForeground(Color.white);
		principal.n5.setForeground(Color.white);
		principal.n6.setForeground(Color.white);
		principal.n7.setForeground(Color.white);
		principal.n8.setForeground(Color.white);

		principal.NoJ.setEnabled(true);
		String resultados = "";
		Jugador pla;
		for (int i = 0; i < Cont; i++) {
			pla = jugadores.get(i);
			resultados += "Jugador #" + pla.getNume() + ": " + pla.pop() + "\n\n";
		}

		JOptionPane.showMessageDialog(null, definir() + "\n\n" + resultados, "Resultados", JOptionPane.PLAIN_MESSAGE);

		jugadores.removeAll(jugadores);
		Cont = 0;
		principal.panelC.removeAll();
		principal.repaint();
		principal.panelC.add(principal.gif);
		principal.girar.setBounds(200, 460, 80, 30);
		principal.girar.setText("Girar");
	}

	public void generarJug() {
		principal.panelC.remove(principal.gif);
		principal.repaint();
		principal.setVisible(true);
		principal.v = new JLabel[Cont];

		if (Cont >= 2) {
			principal.n1.setForeground(Color.BLACK);
			principal.n2.setForeground(Color.black);
			Jugador pla = new Jugador();
			pla.setNume(1);
			jugadores.add(pla);
			principal.v[0] = new JLabel(new ImageIcon("corazon.png"));
			principal.v[0].setText("9");
			principal.v[0].setForeground(Color.black);
			principal.v[0].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			principal.v[0].setBounds(220, 50, 50, 20);
			principal.panelJ.add(principal.v[0]);

			Jugador pla2 = new Jugador();
			pla2.setNume(2);
			jugadores.add(pla2);
			principal.v[1] = new JLabel(new ImageIcon("corazon.png"));
			principal.v[1].setText("9");
			principal.v[1].setForeground(Color.black);
			principal.v[1].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			principal.v[1].setBounds(220, 420, 50, 20);
			principal.panelJ.add(principal.v[1]);

			if (Cont >= 3) {

				Jugador pla3 = new Jugador();
				pla3.setNume(3);
				jugadores.add(pla3);
				principal.n3.setForeground(Color.BLACK);
				principal.v[2] = new JLabel(new ImageIcon("corazon.png"));
				principal.v[2].setText("9");
				principal.v[2].setForeground(Color.black);
				principal.v[2].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
				principal.v[2].setBounds(25, 235, 50, 20);
				principal.panelJ.add(principal.v[2]);

				if (Cont >= 4) {
					Jugador pla4 = new Jugador();
					pla4.setNume(4);
					jugadores.add(pla4);
					principal.n4.setForeground(Color.BLACK);
					principal.v[3] = new JLabel(new ImageIcon("corazon.png"));
					principal.v[3].setText("9");
					principal.v[3].setForeground(Color.black);
					principal.v[3].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					principal.v[3].setBounds(415, 235, 50, 20);
					principal.panelJ.add(principal.v[3]);

					if (Cont >= 5) {
						Jugador pla5 = new Jugador();
						pla5.setNume(5);
						jugadores.add(pla5);
						principal.n5.setForeground(Color.BLACK);
						principal.v[4] = new JLabel(new ImageIcon("corazon.png"));
						principal.v[4].setText("9");
						principal.v[4].setForeground(Color.black);
						principal.v[4].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
						principal.v[4].setBounds(77, 115, 50, 20);
						principal.panelJ.add(principal.v[4]);

						if (Cont >= 6) {
							Jugador pla6 = new Jugador();
							pla6.setNume(6);
							jugadores.add(pla6);
							principal.n6.setForeground(Color.BLACK);
							principal.v[5] = new JLabel(new ImageIcon("corazon.png"));
							principal.v[5].setText("9");
							principal.v[5].setForeground(Color.black);
							principal.v[5].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
							principal.v[5].setBounds(365, 357, 50, 20);
							principal.panelJ.add(principal.v[5]);

							if (Cont >= 7) {
								Jugador pla7 = new Jugador();
								pla7.setNume(7);
								jugadores.add(pla7);
								principal.n7.setForeground(Color.BLACK);
								principal.v[6] = new JLabel(new ImageIcon("corazon.png"));
								principal.v[6].setText("9");
								principal.v[6].setForeground(Color.black);
								principal.v[6].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
								principal.v[6].setBounds(77, 357, 50, 20);
								principal.panelJ.add(principal.v[6]);

								if (Cont >= 8) {
									Jugador pla8 = new Jugador();
									pla8.setNume(8);
									jugadores.add(pla8);
									principal.n8.setForeground(Color.BLACK);
									principal.v[7] = new JLabel(new ImageIcon("corazon.png"));
									principal.v[7].setText("9");
									principal.v[7].setForeground(Color.black);
									principal.v[7].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
									principal.v[7].setBounds(365, 115, 50, 20);
									principal.panelJ.add(principal.v[7]);

								}
							}
						}
					}

				}

			}

		}
	}

	public int generaNumeroAleatorio(int minimo, int maximo) {

		int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
		return num;
	}// fin del puntos aleatorio
}
