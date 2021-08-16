package juegoTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadTest {

	@Test
	public void queDistancia() {
		Unidad u1 = new Unidad(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(1, 1));
		assertEquals(Math.sqrt(2), u1.distanciaCon(u2), 0);
	}

	@Test
	public void queUnidadPega() {

		Unidad u1 = new Unidad(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(1, 1));
		Unidad u3 = new Unidad(new Posicion(2, 2));

		assertEquals(100, u2.getSalud());
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		assertEquals(70, u2.getSalud());

		assertEquals(100, u3.getSalud());
		u1.atacar(u3);
		assertEquals(100, u3.getSalud());

	}

	@Test
	public void queSeCreanCaballeros() {
		Caballero c1 = new Caballero(new Posicion(0, 0));
		assertNotNull(c1);
	}

	@Test
	public void queCaballerosPegan() {
		Caballero c1 = new Caballero(new Posicion(0, 0));
		Caballero c2 = new Caballero(new Posicion(1, 1));
		assertEquals(100, c2.getSalud());
		c1.atacar(c2);
		assertEquals(70, c2.getSalud());
	}

	@Test
	public void queSeCreanArquerps() {
		Arqueros a1 = new Arqueros(new Posicion(0, 0));
		assertNotNull(a1);
	}

	@Test
	public void queArquerosPegan() {
		Arqueros a1 = new Arqueros(new Posicion(0, 0));
		Arqueros a2 = new Arqueros(new Posicion(10, 1));
		assertEquals(100, a2.getSalud());
		a1.atacar(a2);
		assertEquals(93, a2.getSalud());
	}

	@Test
	public void queSeCreanSoldado() {
		Soldado s1 = new Soldado(new Posicion(0, 0));
		assertNotNull(s1);
	}

	@Test
	public void queSoldodadosPegan() {
		Soldado s1 = new Soldado(new Posicion(0, 0));
		Soldado s2 = new Soldado(new Posicion(1, 1));
		assertEquals(100, s2.getSalud());
		s1.atacar(s2);
		assertEquals(80, s2.getSalud());
	}

	@Test
	public void queSoldodadosSeCura() {
		Soldado s1 = new Soldado(new Posicion(0, 0));
		Soldado s2 = new Soldado(new Posicion(1, 1));
		assertEquals(100, s2.getSalud());
		s1.atacar(s2);
		s1.atacar(s2);
		s1.atacar(s2);
		s2.comprarPociones();
		assertEquals(100, s2.getSalud());
	}

	@Test
	public void queArqueroSeCura() {
		Arqueros a1 = new Arqueros(new Posicion(0, 0));
		Arqueros a2 = new Arqueros(new Posicion(10, 1));
		assertEquals(100, a2.getSalud());
		a1.atacar(a2);
		assertEquals(93, a2.getSalud());
		a2.comprarPociones();
		assertEquals(100, a2.getSalud());
	}

	@Test
	public void queCabelleroSeCura() {
		Caballero c1 = new Caballero(new Posicion(0, 0));
		Caballero c2 = new Caballero(new Posicion(1, 1));
		assertEquals(100, c2.getSalud());
		c1.atacar(c2);
		assertEquals(70, c2.getSalud());
		c2.comprarPociones();
		assertEquals(100, c2.getSalud());

	}

	@Test
	public void queUnidadSeCura() {

		Unidad u1 = new Unidad(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(1, 1));

		assertEquals(100, u2.getSalud());
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		assertEquals(70, u2.getSalud());
		u2.comprarPociones();
		assertEquals(100, u2.getSalud());

	}

	@Test
	public void queUnidadRoba() {
		Unidad u1 = new Unidad(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(1, 1));
		Unidad u3 = new Unidad(new Posicion(1, 1));

		assertEquals(10, u1.getDinero());
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		assertEquals(20, u1.getDinero());
		assertEquals(10, u3.getDinero());
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		assertEquals(30, u3.getDinero());

	}

	@Test
	public void queSoldadoSeCansa() {
		Soldado s1 = new Soldado(new Posicion(0, 0));
		Soldado s2 = new Soldado(new Posicion(1, 1));
		
		s1.atacar(s2);
		s1.atacar(s2);
		s1.atacar(s2);
		s1.atacar(s2);
		s1.atacar(s2);
		
		assertEquals(5, s1.getEnergi());
		

	}
	
	@Test
	public void queSoldadoSeDescansa() {
		Soldado s1 = new Soldado(new Posicion(0, 0));
		Soldado s2 = new Soldado(new Posicion(1, 1));
		
		s1.atacar(s2);
		s1.atacar(s2);
		s1.atacar(s2);
		s1.atacar(s2);
		s1.atacar(s2);
		
		assertEquals(5, s1.getEnergi());
		s1.descansar();
		assertEquals(10, s1.getEnergi());

	}
	
	@Test(expected = Error.class)
	public void queArqueroSeQuedaSinFlechas() {
		Arqueros a1 = new Arqueros(new Posicion(0, 0));
		Arqueros a2 = new Arqueros(new Posicion(10, 1));
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
	}
	
	@Test
	public void queArqueroRecargaFlechas() {
		Arqueros a1 = new Arqueros(new Posicion(0, 0));
		Arqueros a2 = new Arqueros(new Posicion(10, 1));
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		a1.atacar(a2);
		assertEquals(1, a1.getFlechas());
		a1.recargar();
		assertEquals(10, a1.getFlechas());
		
	}
	
	@Test
	public void queCabelloroPierdeCorajeYloRecupera() {
		Caballero c1 = new Caballero(new Posicion(0, 0));
		Caballero c2 = new Caballero(new Posicion(1, 1));
		Caballero c3 = new Caballero(new Posicion(1, 1));
		assertEquals(100, c2.getSalud());
		
		int corajeInicial = c1.getCoraje();
		c1.atacar(c2);
		c1.atacar(c2);
		c1.atacar(c2);
		assertNotEquals(corajeInicial, c1.getCoraje());
		c1.recuperarCoraje();
		assertEquals(corajeInicial, c1.getCoraje());

	}
	
	

}
