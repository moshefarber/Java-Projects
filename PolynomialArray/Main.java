/*
This is a Main class that calls the Polynomial class.
There are no for loops in the Main, and it is doing one
operation at a time, so you can say its "constant time". 
*/

import java.util.Scanner;

public class Main {
	
	public static void main(String [] args){

		Scanner sc = new Scanner(System.in); //for input
		System.out.print("\nEnter the highest degree of the polynomials :");
		int num = sc.nextInt();
		System.out.print("\n Enter the value of x:"); //to evaluate entire expression
		int x = sc.nextInt();
		
		Polynomial p1 = new Polynomial(num,x);
		Polynomial p2 = new Polynomial(num,x);
		
		System.out.print("\nSELECT \n1. Addition \n2. Subtraction \n3. Multiplication\n");
		
		int choice = sc.nextInt();
		
		System.out.println(p1.evalInd() + "-------------" + p1.displayInd());
		
		System.out.println(p2.evalInd() + "-------------" + p2.displayInd());
		
		int[] coeffs = p1.combArr(p1, p2,choice);
        System.out.println(p1.evalComb(coeffs,x) + "--------------" 
                     +p1.displayComb(coeffs));
   }
}//End class Main
