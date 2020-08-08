package Modelo;

public class Jugador {
	private Nodo Pila;
	private String palabra="Sin letras";
	private int Nume;
	public int cont=0;
	private int vida=9;

	
	public Jugador () {}
	
//getsAndSets
	public String getPalabra() {
		return palabra;
	}
	public void push() {
		char letra=0;
		
		
			if(cont==1) {letra='T';}else
			if(cont==2) {letra='A';}else
		    if(cont==3) {letra='C';}else
		    if(cont==4) {letra='_';}else
		    if(cont==5) {letra='K';}else
		    if(cont==6) {letra='C';}else
		    if(cont==7) {letra='A';}else
		    if(cont==8) {letra='L';}else
		    if(cont==9) {letra='B';}
		
		
		
		Nodo nuevo = new Nodo(letra);
		
		nuevo.sgt=Pila;
		Pila=nuevo;
		
		
	}//Fin push
	public String pop() {
		Nodo Pop;
		palabra="";
		for(int i=1; i<=cont; i++) {
		Pop = Pila;
		Pila = Pila.sgt;
		palabra+=Pop.dato;
		
		}
		
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}


	public Nodo getPila() {
		return Pila;
	}

	public void setPila(Nodo pila) {
		Pila = pila;
	}

	public int getNume() {
		return Nume;
	}
	

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public void setNume(int nume) {
		Nume = nume;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

}
