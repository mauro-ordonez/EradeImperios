package juegoTest;

public class Soldado extends Unidad {
	private int energia;
	private final int DANIO = 20;
	private final int ENERGIA_INCIAL = 10;
	private final double DISTANCIA_MINIMA_ATAQUE = 1.5;

	public Soldado(Posicion posicion) {
		super(posicion);
		this.energia = ENERGIA_INCIAL;
	}

	@Override
	void atacar(Unidad otraUnidad) {
		if(getEnergi()<=0){
			throw new Error("El soldado esta agotado");
			}
		
		if (this.distanciaCon(otraUnidad) < DISTANCIA_MINIMA_ATAQUE && otraUnidad.estaVivo()
				&& this.estaVivo() && this != otraUnidad) {

			otraUnidad.quitarSalud(DANIO);
			this.energia--;

			if (!otraUnidad.estaVivo()) {
				this.robarDinero(otraUnidad.getDinero());
			}
		}else {throw new Error("No se pudo atacar");}

	}

	public void descansar() {
		this.energia = ENERGIA_INCIAL;
	}

	public int getEnergi() {
		return this.energia;
	}
}
