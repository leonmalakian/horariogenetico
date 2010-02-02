package ar.com.protean.horario.genetico.algoritmo;

import java.util.Random;

public class RandomSingleton {
	private Random r = new Random();
	private static RandomSingleton instance = new RandomSingleton();
	
	private RandomSingleton(){
		
	}
	
	public static Random getInstance(){
		return instance.r;
	}
}
