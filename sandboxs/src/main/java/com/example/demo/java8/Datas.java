package com.example.demo.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		
		
		System.out.println(hoje);
		
		
		LocalDate olimpiadas = LocalDate.of(2020, Month.AUGUST, 5);
		
		
		System.out.println(olimpiadas);
		
		
		Period periodo = Period.between(hoje, olimpiadas);
		
		System.out.println(periodo.getYears());
		
		
		LocalDate daquiA4Anos = hoje.plusYears(4);
		
		System.out.println(daquiA4Anos);
		
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String valorFormatado = daquiA4Anos.format(formatador);
		
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorComhoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		
		LocalDateTime agora = LocalDateTime.now();
		
		System.out.println(agora.format(formatadorComhoras));
		
		
	}

}
