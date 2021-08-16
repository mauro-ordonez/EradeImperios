package juegoTest;

public class Caballero extends Unidad {

	private int coraje;
	private final int DANIO = 30;
	private final int CORAJE_INCIAL = 10;
	private final int DISTANCIA_MINIMA_ATAQUE = 1;
	private final int DISTANCIA_MAXIMA_ATAQUE = 3;

	public Caballero(Posicion posicion) {
		super(posicion);
		this.coraje = CORAJE_INCIAL;
	}

	@Override
	public void atacar(Unidad otraUnidad) {

		if (this.distanciaCon(otraUnidad) > DISTANCIA_MINIMA_ATAQUE
				&& this.distanciaCon(otraUnidad) < DISTANCIA_MAXIMA_ATAQUE && otraUnidad.estaVivo() && this.estaVivo()
				&& this != otraUnidad) {

			otraUnidad.quitarSalud(DANIO);

			if (!otraUnidad.estaVivo()) {
				this.robarDinero(otraUnidad.getDinero());
			}
		}else {throw new Error("No se pudo atacar");}

		this.coraje -= random(3);

		if (this.coraje < 0) {
			this.espantoOcacional();
			System.out.println("el caballo se espanta");
		}
	}

	private void espantoOcacional() {
		this.getPosicion().setPosicion(this.getPosicion().getEjeX() + random(2),
				this.getPosicion().getEjeY() + random(2));
	}

	private int random(int maximo) {
		return (int) (Math.random() * maximo + 1);
	}

	public void recuperarCoraje() {
		this.coraje = CORAJE_INCIAL;
	}

	public int getCoraje() {
		// TODO Auto-generated method stub
		return this.coraje;
	}

}
