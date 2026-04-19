package com.krakedev.maquinaAliens;

public class Alien {
	
	//ATRIBUTOS
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;
	private double precioTotal;
	
	//CONSTRUCTOR CON PARAMETROS Y VALIDACIONES
	public Alien(int tamanio, String color) {
		if(tamanio<5) {
			this.tamanio=5;
		}else if(tamanio>30) {
			this.tamanio=30;
		}else {
			this.tamanio=tamanio;
		}
		
		this.color=color;
		
		this.precioCuerpo=this.tamanio*0.2;
		this.precioExtremidad=this.tamanio*0.1;
		this.precioOjo=this.tamanio*0.05;
		this.precioTotal=0;
	}
	
	//METODOS GET
	public int getTamanio() {
		return tamanio;
	}
	public String getColor() {
		return color;
	}
	public int getNumeroOjos() {
		return numeroOjos;
	}
	public int getNumeroBrazos() {
		return numeroBrazos;
	}
	public int getNumeroPies() {
		return numeroPies;
	}
	public double getPrecioExtremidad() {
		return precioExtremidad;
	}
	public double getPrecioOjo() {
		return precioOjo;
	}
	public double getPrecioCuerpo() {
		return precioCuerpo;
	}	
	public double getPrecioTotal() {
		return precioTotal;
	}

	//METODO IMPRIMIR
	public void imprimir() {
		String mensaje="Tamaño: "+tamanio
				+"\nColor: "+color
				+"\nNro ojos: "+numeroOjos
				+"\nNro brazos: "+numeroBrazos
				+"\nNro pies: "+numeroPies
				+"\nPrecio extremidad: "+precioExtremidad
				+"\nPrecio ojo: "+precioOjo
				+"\nPrecio cuerpo: "+precioCuerpo
				+ "\nPrecio total:"+precioTotal;
		
		System.out.println(mensaje);		
	}
	
	//METODO-PRIVATE SUMA TOTAL EXTREMIDADES
	private int sumarExtremidades(int nuevasExtremidades) {
		return this.numeroBrazos+this.numeroPies+nuevasExtremidades; 
	}
	
	//METODO AGREGAR BRAZOS
	public boolean agregarBrazos(int cantidadBrazos) {
		if((cantidadBrazos>0)&&(sumarExtremidades(cantidadBrazos)<=10)) {
			this.numeroBrazos+=cantidadBrazos;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}
	
	//METODO AGREGAR PIERNAS
	public boolean agregarPiernas(int cantidadPiernas) {
		if((cantidadPiernas>0)&&(sumarExtremidades(cantidadPiernas)<=10)) {
			this.numeroPies+=cantidadPiernas;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}
	
	//METODO PARA VALIDAR NUMERO DE OJOS MEDIANTE VALIDACION
	private boolean validarNumeroojos(int ojosNuevos, int limite) {
		if(numeroOjos+ojosNuevos<=limite) {
			this.numeroOjos+=ojosNuevos;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}
	
	//METODO AGREGAR OJOS
	//DEPENDE DEL METODO VALIDAR NUMERO DE OJOS
	public boolean agregarOjos(int cantidadOjos) {
		if(this.tamanio<=10 ) {
			return validarNumeroojos(cantidadOjos, 3);
			
		}else if(this.tamanio>10 && this.tamanio<=20) {
			return validarNumeroojos(cantidadOjos, 5);
			
		}else {
			return validarNumeroojos(cantidadOjos, 7);
		}		
	}
	
	//METODO PRECIO TOTAL 
	public void calcularPrecioTotal() {
		double suma=(precioCuerpo)+((numeroPies+numeroBrazos)*(precioExtremidad))+(numeroOjos*precioOjo);
		this.precioTotal=suma;		
	}
	
	//METODO IMPRIMIR 2 - PARA HACER PRUEBAS
	public void imprimir2() {
		System.out.println("Tamanio:"+tamanio+", Color:"+color);
	}
	
	//METODO IMPRIMIR 3 - PARA HACER PRUBAS
	public void imprimir3() {
		System.out.println("Tamaño:"+tamanio
				+", Color:"+color
				+", Ojos:"+numeroOjos
				+", Brazos:"+numeroBrazos
				+", Pies:"+numeroPies);
	}
		
	//METODO TO STRING
	@Override
	public String toString() {
		return "\n \nAlien [tamanio=" + tamanio 
				+ ", \ncolor=" + color 
				+ ", \nnumeroOjos=" + numeroOjos 
				+ ", \nnumeroBrazos="	+ numeroBrazos 
				+ ", \nnumeroPies=" + numeroPies 
				+ ", \nprecioExtremidad=" + precioExtremidad
				+ ", \nprecioOjo=" + precioOjo 
				+ ", \nprecioCuerpo=" + precioCuerpo
				+ ", \nPrecio total="+precioTotal+"]";
	}
	
	
	

}
