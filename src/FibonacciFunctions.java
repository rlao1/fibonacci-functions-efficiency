import java.util.*;

public class FibonacciFunctions {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int input = scan.nextInt();
		
		Recursive recursive = new Recursive(input);
		Iterative iterative = new Iterative(input);
		
		recursive.run();
		iterative.run();
		
	}
}

class Recursive extends Thread {
	private int n = 0;
	
	public Recursive(int input) 
	{
		n = input;
	}
	
	public void run() 
	{
		long startTime = System.nanoTime();
		int result = Fibonacci(n);
		long duration = System.nanoTime()-startTime;
		System.out.printf("Recursive %d %d(ns)\n", result, duration);
	}
	
	public int Fibonacci(int n) 
	{
		if(n < 2) return n;
		return Fibonacci(n-1) + Fibonacci(n-2);
	}
}

class Iterative extends Thread {
	private int n = 0;
	
	public Iterative(int input) 
	{
		n = input;
	}
	
	public void run() {
		long startTime = System.nanoTime();
		int result = Fibonacci(n);
		long duration = System.nanoTime()-startTime;
		System.out.printf("Iterative %d %d(ns)\n", result, duration);
	}
	
	public int Fibonacci(int n) 
	{
		int a = 0, b = 1, c = 0;
		
		if(n < 2) return n;
		
		for(int i = 2; i <= n; i++) 
		{
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}
