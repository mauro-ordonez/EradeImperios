package juegoTest;

public class Posicion {

	private int ejeX;
	private int ejeY;
	

	public int getEjeX() {
		return ejeX;
	}


	public int getEjeY() {
		return ejeY;
	}


	public Posicion(int ejeX, int ejeY) {
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}
	
	protected void setPosicion(int ejeX, int ejeY) {
		this.ejeX = ejeX;
		this.ejeY = ejeY;
		
	}

}
