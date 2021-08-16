package juegoTest;

public class Unidad {

	private Posicion posicion;
	private int salud;
	private int dinero;

	private int basdrar = 10;
	private int borasdrar2 = 10;
	private int boasdasrrar3 = 10;
	private int boasdasdrrar4check = 10;
	
	
	private final int DANIO = 10;
	private final int DINERO_INICIAL = 10;
	private final int SALUD_INICIAL = 100;
	private final int DISTANCIA_MINIMA_ATAQUE = 2;
	private final int COSTO_POCION = 10;

	public Unidad(Posicion posicion) {
		this.posicion = posicion;
		this.salud    = SALUD_INICIAL;
		this.dinero   = DINERO_INICIAL;
	}

	double distanciaCon(Unidad otraUnidad) {

		return Math.sqrt(Math.pow(this.posicion.getEjeX() - otraUnidad.posicion.getEjeX(), 2)
				+ (Math.pow(this.posicion.getEjeY() - otraUnidad.posicion.getEjeY(), 2)));
	}

	public int getSalud() {

		return this.salud;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public int getDinero() {
		return this.dinero;
	}

	protected void robarDinero(int dinero) {
		this.dinero += dinero;
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	void atacar(Unidad otraUnidad) {
		if (this.distanciaCon(otraUnidad) < DISTANCIA_MINIMA_ATAQUE
			&& otraUnidad.estaVivo() 
			&& this.estaVivo() && this!=otraUnidad)
			
			otraUnidad.quitarSalud(DANIO);
		
			if(!otraUnidad.estaVivo()) {
				this.robarDinero(otraUnidad.getDinero());
			}
	}

	void quitarSalud(int i) {
		this.salud -= i;

	}

	public void comprarPociones() {
		if (this.dinero < 10 )
			throw new Error("dinero insuficiente");
       if(estaVivo()) {
		this.salud = SALUD_INICIAL;
		this.dinero -= COSTO_POCION;
       }
	}

}
