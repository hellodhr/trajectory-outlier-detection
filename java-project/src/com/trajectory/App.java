package com.trajectory;

public class App {

	public static void main(String[] args) {
		Database database = new Database("/home/joao/Área de Trabalho/Mestrado/TRA-SOD/trajectories");
		database.initialize();
		System.out.println(database);
	}

}
