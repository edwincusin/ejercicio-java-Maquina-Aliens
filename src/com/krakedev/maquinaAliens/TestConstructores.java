package com.krakedev.maquinaAliens;

public class TestConstructores {

	public static void main(String[] args) {

		Alien alien1=new Alien(100, "VERDE");
		Alien alien2=new Alien(4, "AZUL");
		
		alien1.imprimir();
		System.out.println(alien2.toString());

	}

}
