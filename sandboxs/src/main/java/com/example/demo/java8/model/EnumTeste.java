package com.example.demo.java8.model;

public enum EnumTeste {
	REAL(1), DOLLAR(4);

	private double peso;

	public double getPeso() {
		return peso;
	}

	private EnumTeste(double peso) {
		this.peso = peso;
	}
}
