package com.krakedev.maquinaAliens;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class TestJunitAlienIA {

	private static final double DELTA = 0.01;

	/*
	 * CASO 1: Constructor con tamaño dentro del rango permitido.
	 * 
	 * Se valida que: - Si el tamaño está entre 5 y 30, se asigna correctamente. -
	 * El color se asigna correctamente. - Los precios se calculan en base al
	 * tamaño: cuerpo = 20%, extremidad = 10%, ojo = 5%.
	 */
	@Test
	void testConstructorValoresValidos() {
		Alien alien = new Alien(10, "verde");

		assertEquals(10, alien.getTamanio());
		assertEquals("verde", alien.getColor());
		assertEquals(2.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(1.0, alien.getPrecioExtremidad(), DELTA);
		assertEquals(0.5, alien.getPrecioOjo(), DELTA);
	}

	/*
	 * CASO 2: Constructor con tamaño menor al mínimo.
	 * 
	 * Se valida que: - Si el tamaño es menor a 5, se ajusta automáticamente a 5. -
	 * Los precios se recalculan en base al tamaño ajustado.
	 */
	@Test
	void testConstructorTamanoMenorMinimo() {
		Alien alien = new Alien(2, "rojo");

		assertEquals(5, alien.getTamanio());
		assertEquals(1.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(0.5, alien.getPrecioExtremidad(), DELTA);
		assertEquals(0.25, alien.getPrecioOjo(), DELTA);
	}

	/*
	 * CASO 3: Constructor con tamaño mayor al máximo.
	 * 
	 * Se valida que: - Si el tamaño es mayor a 30, se ajusta automáticamente a 30.
	 * - Los precios se recalculan correctamente.
	 */
	@Test
	void testConstructorTamanoMayorMaximo() {
		Alien alien = new Alien(50, "azul");

		assertEquals(30, alien.getTamanio());
		assertEquals(6.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(3.0, alien.getPrecioExtremidad(), DELTA);
		assertEquals(1.5, alien.getPrecioOjo(), DELTA);
	}

	/*
	 * CASO 4: Método imprimir()
	 * 
	 * Se valida que: - El método imprime un mensaje con TODOS los atributos del
	 * alien. - Se captura la salida de consola y se compara con el formato
	 * esperado.
	 */
	@Test
	void testImprimir() {
		// Guardar el System.out original
		PrintStream originalOut = System.out;

		Alien alien = new Alien(10, "verde");

		ByteArrayOutputStream salida = new ByteArrayOutputStream();
		System.setOut(new PrintStream(salida));

		alien.imprimir();

		String esperado = "Tamaño: 10" + "\nColor: verde" + "\nNro ojos: 0" + "\nNro brazos: 0" + "\nNro pies: 0"
				+ "\nPrecio extremidad: 1.0" + "\nPrecio ojo: 0.5" + "\nPrecio cuerpo: 2.0";

		assertEquals(esperado, salida.toString().trim());
		// Restaurar System.out correctamente
		System.setOut(originalOut);
	}

	/*
	 * CASO 5: Método imprimir2()
	 * 
	 * Se valida que: - El método imprime únicamente el tamaño y el color. - Se
	 * captura la salida de consola y se compara con el formato esperado.
	 */
	@Test
	void testImprimir2() {
		// Guardar el System.out original
		PrintStream originalOut = System.out;

		Alien alien = new Alien(15, "morado");

		ByteArrayOutputStream salida = new ByteArrayOutputStream();
		System.setOut(new PrintStream(salida));

		alien.imprimir2();

		String esperado = "Tamanio:15, Color:morado";

		assertEquals(esperado, salida.toString().trim());
		// Restaurar System.out correctamente
		System.setOut(originalOut);
	}

	/*
	 * CASO 6: Método toString()
	 * 
	 * Se valida que: - El método retorna un String con todos los atributos del
	 * objeto. - El formato del mensaje corresponde al esperado. - Los valores
	 * coinciden con los generados por el constructor. - No se imprime en consola,
	 * sino que se retorna el texto.
	 */
	@Test
	void testToString() {
		Alien alien = new Alien(10, "verde");

		String esperado = "\n \nAlien [tamanio=10" + ", \ncolor=verde" + ", \nnumeroOjos=0" + ", \nnumeroBrazos=0"
				+ ", \nnumeroPies=0" + ", \nprecioExtremidad=1.0" + ", \nprecioOjo=0.5" + ", \nprecioCuerpo=2.0]";

		assertEquals(esperado, alien.toString());
	}

	/*
	 * CASO 1: Agregar brazos correctamente dentro del límite.
	 * 
	 * Se valida que: - Se pueden agregar brazos cuando no se supera el máximo de 10
	 * extremidades. - El número de brazos se actualiza correctamente.
	 */
	@Test
	void testAgregarBrazosCorrecto() {
		Alien alien = new Alien(10, "verde");

		assertTrue(alien.agregarBrazos(4));
		assertEquals(4, alien.getNumeroBrazos());
	}

	/*
	 * CASO 2: No permitir agregar brazos que superen el límite total de
	 * extremidades.
	 * 
	 * Se valida que: - No se pueden agregar más brazos si se supera el máximo de 10
	 * extremidades. - El número de brazos no cambia.
	 */
	@Test
	void testAgregarBrazosExcedeLimite() {
		Alien alien = new Alien(10, "verde");

		assertTrue(alien.agregarBrazos(8));
		assertFalse(alien.agregarBrazos(5)); // excede límite

		assertEquals(8, alien.getNumeroBrazos());
	}

	/*
	 * CASO 3: No permitir agregar valores inválidos (0 o negativos) en brazos.
	 * 
	 * Se valida que: - No se agregan brazos si la cantidad es 0 o negativa.
	 */
	@Test
	void testAgregarBrazosInvalidos() {
		Alien alien = new Alien(10, "verde");

		assertFalse(alien.agregarBrazos(0));
		assertFalse(alien.agregarBrazos(-3));

		assertEquals(0, alien.getNumeroBrazos());
	}

	/*
	 * CASO 4: Agregar piernas correctamente respetando el límite total.
	 * 
	 * Se valida que: - Se pueden agregar piernas si no se supera el máximo de
	 * extremidades. - El número de piernas se actualiza correctamente.
	 */
	@Test
	void testAgregarPiernasCorrecto() {
		Alien alien = new Alien(10, "verde");

		assertTrue(alien.agregarPiernas(5));
		assertEquals(5, alien.getNumeroPies());
	}

	/*
	 * CASO 5: No permitir agregar piernas si se excede el límite total.
	 */
	@Test
	void testAgregarPiernasExcedeLimite() {
		Alien alien = new Alien(10, "verde");

		assertTrue(alien.agregarPiernas(6));
		assertFalse(alien.agregarPiernas(5)); // excede

		assertEquals(6, alien.getNumeroPies());
	}

	/*
	 * CASO 6: Agregar ojos según tamaño pequeño (<=10).
	 * 
	 * Se valida que: - El límite de ojos es 3.
	 */
	@Test
	void testAgregarOjosTamanoPequenio() {
		Alien alien = new Alien(10, "verde");

		assertTrue(alien.agregarOjos(3));
		assertFalse(alien.agregarOjos(1)); // excede

		assertEquals(3, alien.getNumeroOjos());
	}

	/*
	 * CASO 7: Agregar ojos según tamaño mediano (<=20).
	 */
	@Test
	void testAgregarOjosTamanoMedio() {
		Alien alien = new Alien(15, "azul");

		assertTrue(alien.agregarOjos(5));
		assertFalse(alien.agregarOjos(1));

		assertEquals(5, alien.getNumeroOjos());
	}

	/*
	 * CASO 8: Agregar ojos según tamaño grande (>20).
	 */
	@Test
	void testAgregarOjosTamanoGrande() {
		Alien alien = new Alien(25, "rojo");

		assertTrue(alien.agregarOjos(7));
		assertFalse(alien.agregarOjos(1));

		assertEquals(7, alien.getNumeroOjos());
	}

	/*
	 * CASO 9: Cálculo correcto del precio total.
	 * 
	 * Se valida que: - Se calcula correctamente el precio total considerando:
	 * cuerpo + (extremidades * precioExtremidad) + (ojos * precioOjo)
	 */
	@Test
	void testCalcularPrecioTotal() {
		Alien alien = new Alien(30, "verde");

		alien.agregarBrazos(5);
		alien.agregarPiernas(3);
		alien.agregarOjos(2);

		// cuerpo: 30*0.2 = 6
		// extremidades: 8*3 = 24
		// ojos: 2*1.5 = 3
		// total = 33
		assertEquals(33, alien.getPrecioTotal(), DELTA);
	}

	/*
	 * CASO 10: Precio total sin agregar atributos adicionales.
	 * 
	 * Se valida que: - El precio total solo incluye el cuerpo inicialmente.
	 */
	@Test
	    void testPrecioSoloCuerpo() {
	        Alien alien = new Alien(20, "verde");

	        // cuerpo: 20 * 0.2 = 4
	        assertEquals(0, alien.getPrecioTotal(), DELTA);

	        alien.calcularPrecioTotal();

	        assertEquals(4, alien.getPrecioTotal(), DELTA);
	    }

}
