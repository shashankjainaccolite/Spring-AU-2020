package triConsumerLambda;

import java.util.Scanner;

public class TriConsumerLambdaUse {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your name");
		
		String name = sc.next();
		
		TriConsumerLambdaUse tri = new TriConsumerLambdaUse();
		
		tri.printThreeString("Hello : \n",(name + "\n") , "Have a nice day !!! ", (p,q,r) -> System.out.println(p + q + r));
		
		tri.threeNumberOperations(10, 20, 30, (a,b,c) -> System.out.println("Sum of the three given numbers is : " + (a+b+c)));
		
		tri.threeNumberOperations(10, 20, 30, (a,b,c) -> System.out.println("Multiplication of the three given numbers is : " + (a*b*c)));
		
		sc.close();

	}
	
	private void printThreeString(String s, String t, String u, TriConsumer<String, String, String> triConsumer) {
		triConsumer.accept(s, t, u);
	}
	
	private void threeNumberOperations(int a, int b, int c, TriConsumer<Integer, Integer, Integer> triConsumer) {
		triConsumer.accept(a, b, c);
	}

}
