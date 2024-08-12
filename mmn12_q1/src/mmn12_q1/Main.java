package mmn12_q1;



import java.util.Scanner;

import mmn12_q1.Polynom;

public class Main {
	
	public static void main(String[] args) {
		Polynom p = getPolFrmUsr("P");
		Polynom q = getPolFrmUsr("Q");
		Polynom temp;
		if (p.getPoly() != null && q.getPoly() != null) {// Polynoms were initialized as expected
			System.out.println("The two inserted Polynoms are:");
			System.out.println("P: "+ p.toString());
			System.out.println("Q: "+ q.toString());
			
			System.out.println("The Sum of the Polynoms is:");
			temp = p.plus(q);
			System.out.println("P + Q: " + temp.toString());
			
			System.out.println("The Substruction of the Polynoms is:");
			temp = p.minus(q);
			System.out.println("P - Q: " + temp.toString());
			
			System.out.println("The Diffrentiation of the Polynoms are:");
			temp = p.differentiate();
			System.out.println("P': " + temp.toString());
			temp = q.differentiate();
			System.out.println("Q': " + temp.toString());
			
			if (q.equals(p))
				System.out.println("The two inserted Polynoms are equals");
			else
				System.out.println("The two inserted Polynoms are not equals");
		}
		else
			System.out.println("Too Bad!\nOne or Two of the Polynom wasn't correcly initialized.\nPlease follow the error description to initialized them in the correct manner");
		 
			
	}
	
	// creating a Polynom object from a user input
	private static Polynom getPolFrmUsr(String polName) {
		Polynom p;
		int[] pow;
		double[] coe;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insert the Valus for the Polynom "+ polName);
		
		System.out.println("Enter a comma sperated list for the monoms powers of " + polName);
		String input = scanner.next();
		pow = strToInt(input);
		
		System.out.println("Enter a comma sperated list for the corresponded coefficients of " + polName);
		input = scanner.next();
		coe = strToDbl(input);
			
		p = new Polynom(pow,coe);
		
		return p;
	}
	
	// get string of comma separated real numbers and return them in double array
	private static double[] strToDbl(String s) {
		String[] nums = s.split(",");
		double[] arr = new double[nums.length];
		for (int i = 0;i < arr.length; i++) {
			arr[i] = Double.parseDouble(nums[i].trim());
		}
		return arr;
	}
	
	// get string of comma separated natural numbers and return them in int array
	private static int[] strToInt(String s) {
		String[] nums = s.split(",");
		int[] arr = new int[nums.length];
		for (int i = 0;i < arr.length; i++) {
			arr[i] = Integer.parseInt(nums[i].trim());
		}
		return arr;
	}
}
