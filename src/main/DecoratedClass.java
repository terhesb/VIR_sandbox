package main;

import java.util.function.Supplier;

import annotation.Decorate;

public class DecoratedClass {
	
	@Decorate(decoratorFunction = "myDecorator")
	public String f() {
		return "f function";
	}

	public String g() {
		return "g function";
	}
	
	public String myDecorator(Supplier<String> sup) {
		return "-> " + sup.get() + " <-";
	}
	
}
