package com.krakedev.maquinaAliens;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestImprimirJUnit {
	private ByteArrayOutputStream outPuttStreamCaptor = new ByteArrayOutputStream();
	private final PrintStream standarOut = System.out;

	@BeforeEach
	void inicializar() {
		// se redirije la salida del system.out al capturador
		System.setOut(new PrintStream(outPuttStreamCaptor));
	}

	@AfterEach
	void finalizar() {
		// se devuelve para que lo dema simprima en cosnola normal
		System.setOut(standarOut);
	}

	@Test
	@Order(1)
	@DisplayName("Valida el Metodo imprimir 2 que muestra dos atributos")
	void validaMetodoImprimir() {

		// se instancia la clase aliens y se llama al metodo imprimir
		Alien alien1 = new Alien(10, "Blanco");
		alien1.imprimir2();
		// se espera que imprima
		String valorConsola = "Tamanio:10, Color:Blanco";
		// validamos el valor esperado con el valor que se capturo
		assertEquals(valorConsola, outPuttStreamCaptor.toString().trim());


	}
	@Test
	@Order(2)
	@DisplayName("Valida el Metodo imprimir 3 que muestra 5 atributos")
	void validaMetodoImprimir2() {

		// se instancia la clase aliens y se llama al metodo imprimir
		Alien alien1 = new Alien(10, "Verde");
		alien1.imprimir3();
		// se espera que imprima
		String valorConsola = "Tamaño:10, Color:Verde, Ojos:0, Brazos:0, Pies:0";
		// validamos el valor esperado con el valor que se capturo
		assertEquals(valorConsola, outPuttStreamCaptor.toString().trim());


	}
}
