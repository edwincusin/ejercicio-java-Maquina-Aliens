package com.krakedev.maquinaAliens;

public class TestConstructores {

	public static void main(String[] args) {
		
		//INSTANCIO LACLASE EN UN OBJETO
		Alien alien1=new Alien(100, "VERDE");
		Alien alien2=new Alien(4, "AZUL");
		
		//IMPRESION
		//alien1.imprimir();
		//System.out.println(alien2.toString());
		
		//AGREGAR EXTREMIDADES
		alien1.agregarBrazos(3);
		alien1.agregarPiernas(6);
		alien1.agregarOjos(2);
		alien2.agregarBrazos(3);
		alien2.agregarPiernas(6);
		alien2.agregarOjos(2);
		
		alien1.imprimir();
		System.out.println();
		alien2.imprimir();
	}

}
