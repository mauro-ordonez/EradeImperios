package juegoTest;

public class Arqueros extends Unidad {

	private int flechas;

	private final int DANIO = 7;
	private final int FLECHAS_INCIAL = 10;
	private final int DISTANCIA_MINIMA_ATAQUE = 5;
	private final int DISTANCIA_MAXIMA_ATAQUE = 25;

	public Arqueros(Posicion posicion) {
		super(posicion);
		this.flechas = FLECHAS_INCIAL;

	}

	private boolean sinFlechas() {
		return flechas <= 0;
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		if (sinFlechas())
			throw new Error("No hay mas flechas");

		if (this.distanciaCon(otraUnidad) > DISTANCIA_MINIMA_ATAQUE
				&& this.distanciaCon(otraUnidad) < DISTANCIA_MAXIMA_ATAQUE && otraUnidad.estaVivo()
				&& this.estaVivo() && this != otraUnidad) {

			otraUnidad.quitarSalud(DANIO);
			flechas--;

			if (!otraUnidad.estaVivo()) {
				this.robarDinero(otraUnidad.getDinero());
			}
		}else {throw new Error("No se pudo atacar");}

	}

	public void recargar() {
		this.flechas = FLECHAS_INCIAL;
	}

	public int getFlechas() {
		// TODO Auto-generated method stub
		return this.flechas;
	}

}
