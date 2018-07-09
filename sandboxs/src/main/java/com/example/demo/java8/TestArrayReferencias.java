package com.example.demo.java8;
import com.example.demo.java8.model.Conta;
import com.example.demo.java8.model.ContaCorrente;
import com.example.demo.java8.model.ContaPoupanca;

public class TestArrayReferencias {
	public static void main(String[] args) {

		// int[] idades = new int[5];
		Conta[] contas = new Conta[5];

		ContaCorrente cc1 = new ContaCorrente(22, 11);
		contas[0] = cc1;

		ContaPoupanca cc2 = new ContaPoupanca(22, 22);
		contas[1] = cc2;

		// System.out.println(cc2.getNumero());

		System.out.println(contas[1].getNumero());

		Conta ref = contas[1];
		System.out.println(cc2.getNumero());
		System.out.println(ref.getNumero());

	}
}
