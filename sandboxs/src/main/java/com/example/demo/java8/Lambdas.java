package com.example.demo.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.example.demo.java8.model.Cliente;
import com.example.demo.java8.model.Conta;
import com.example.demo.java8.model.ContaCorrente;
import com.example.demo.java8.model.ContaPoupanca;

public class Lambdas {
	public static void main(String[] args) {
		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Nico");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Guilherme");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Ana");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		lista.forEach(i -> System.out.println(i));

		NumeroDaContaComparator c = new NumeroDaContaComparator();
		TitularDaContaComparator tc = new TitularDaContaComparator();

//		lista.sort(tc);
		//java7
		Collections.sort(lista, tc);
		
		System.out.println("------------------------------------");

		lista.forEach(i -> System.out.println(i + ", " + i.getTitular().getNome()));

		Date date = new Date();
		date .compareTo(new Date());
	}
}

class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {

		String nomec1 = c1.getTitular().getNome();
		String nomec2 = c2.getTitular().getNome();

		return nomec1.compareTo(nomec2);
	}
}

class NumeroDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {

		return Integer.compare(c1.getNumero(), c2.getNumero());

		// return c1.getNumero() - c2.getNumero();

		// if (c1.getNumero() < c2.getNumero()) {
		// return -1;
		// }
		// if (c1.getNumero() > c2.getNumero()) {
		// return 1;
		// }
		// return 0;
	}

}
