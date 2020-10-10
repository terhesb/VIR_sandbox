package main;

import java.lang.reflect.InvocationTargetException;

import caller.ReflectCaller;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		/**
		 * Első pluszpontos feladat.
		 */
		DecoratedClass decClass = new DecoratedClass();
		System.out.println(decClass.myDecorator(decClass::f));

		/**
		 * Második pluszpontos feladat.
		 */
		ReflectCaller caller = new ReflectCaller(DecoratedClass.class);
		System.out.println(caller.<String>callFunc("f"));
		
	}

}
