package com.krakedev.maquinaAliens;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestJunitManual {
	@Test
	void testCrearAlienNormal() {
		Alien alien=new Alien(3,"rojo");
		assertEquals(5,alien.getTamanio());
		assertEquals("rojo",alien.getColor());
		assertEquals(1.0,alien.getPrecioCuerpo(),0.01);
		assertEquals(0.5,alien.getPrecioExtremidad(),0.01);
		assertEquals(0.25,alien.getPrecioOjo(),0.01);
		
		alien.imprimir();
		
		Alien alien1=new Alien(50,"rojo");
		assertEquals(30,alien1.getTamanio());
		assertEquals("rojo",alien1.getColor());
		assertEquals(6.0,alien1.getPrecioCuerpo(),0.01);
		assertEquals(3.0,alien1.getPrecioExtremidad(),0.01);
		assertEquals(1.5,alien1.getPrecioOjo(),0.01);
		
		
		Alien alien2=new Alien(20,"rojo");
		assertEquals(20,alien2.getTamanio());
		assertEquals("rojo",alien2.getColor());
		assertEquals(4.0,alien2.getPrecioCuerpo(),0.01);
		assertEquals(2.0,alien2.getPrecioExtremidad(),0.01);
		assertEquals(1.0,alien2.getPrecioOjo(),0.01);
		
		System.out.println(alien2.toString());
		
	}
	
	@Test
	void testCalcularPrecioTotal() {
		double DELTA=0.001;
		//INSTANCIO LACLASE EN UN OBJETO
		Alien alien1=new Alien(100, "VERDE");
		//Alien alien2=new Alien(4, "AZUL");
		
		assertTrue(alien1.agregarBrazos(3)); 
		assertTrue(alien1.agregarBrazos(6)); 
		assertTrue(alien1.agregarOjos(2)); 
		
		assertEquals(36.00, alien1.getPrecioTotal(),DELTA);
		System.out.println(alien1.toString());
	}
}
