package com.example.demo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.java8.model.Curso;

public class Stream {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getNome));

		// cursos.forEach(c -> System.out.println(c.getNome()));

		// cursos.stream()
		// .filter(c -> c.getAlunos() > 100)
		// .forEach(c -> System.out.println(c.getNome()));

		// Curso curso = cursos.stream().filter(c -> c.getNome().equals("C"))
		// // .map(c -> c.getAlunos())
		// .findFirst().get();

		// cursos.stream().filter(c -> c.getAlunos() > 100).findAny().ifPresent(c ->
		// System.out.println(c.getNome()));
		
		cursos = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
		
		cursos.forEach(c -> System.out.println(c.getNome()));
	}
}
