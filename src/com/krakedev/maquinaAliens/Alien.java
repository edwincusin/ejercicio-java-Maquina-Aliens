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
	
	//METODO IMPRIMIR
	public void imprimir() {
		String mensaje="Tamaño: "+tamanio
				+"\nColor: "+color
				+"\nNro ojos: "+numeroOjos
				+"\nNro brazos: "+numeroBrazos
				+"\nNro pies: "+numeroPies
				+"\nPrecio extremidad: "+precioExtremidad
				+"\nPrecio ojo: "+precioOjo
				+"\nPrecio cuerpo: "+precioCuerpo;
		
		System.out.println(mensaje);		
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
				+ ", \nprecioCuerpo=" + precioCuerpo + "]";
	}
	
	
	

}
