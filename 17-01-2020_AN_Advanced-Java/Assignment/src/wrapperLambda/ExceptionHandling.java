package wrapperLambda;

import java.util.function.BiConsumer;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		
		printInLexiographicOrder("Dheeraj", "Shashank", wrapperLambda((s1, s2) -> System.out.println("The resulrt of the operation is")));
		
	}
	
	private static void printInLexiographicOrder(String s1, String s2, BiConsumer<String, String> biConsumer) {
		biConsumer.accept(s1, s2);
	}
	
	private static BiConsumer<String, String> wrapperLambda(BiConsumer<String, String> biConsumer) {
		return (s1, s2) -> {
			try {
				biConsumer.accept(s1, s2);
				if(s1.compareToIgnoreCase(s2) > 0) {
					System.out.println(s2);
				} else if(s1. compareToIgnoreCase(s2) < 0) {
					System.out.println(s1);
				} else {
					System.out.println("Both strings are equal");
				}
			} catch (NullPointerException e) {
				System.out.println("Please dont pass null strings");
			}
		};
	}
}
