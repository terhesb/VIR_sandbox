package main;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Első pluszpontos feladat.
		 */
		DecoratedClass decClass = new DecoratedClass();
		System.out.println(decClass.myDecorator(decClass::f));

	}

}
