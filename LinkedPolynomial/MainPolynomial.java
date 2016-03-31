/*
 * This program takes from user input 2 polynomials and then adds, subtracts, and multiplies them.
 * 
 * There are nested while loops in the linkedlist class, giving a time complexity of n^2.
 */

import java.util.Scanner;
class MainPolynomial{

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the highest degree of the polynomials :");
		int num = sc.nextInt();
		System.out.print("\n Enter the value of x:"); 
		int x = sc.nextInt();
		
		LinkedPolynomial poly1 = new LinkedPolynomial(num,x);
		LinkedPolynomial poly2=new LinkedPolynomial(num,x);
		LinkedPolynomial sum; //third polynomial for sum
		LinkedPolynomial sub; //third polynomial for subtraction
		LinkedPolynomial prod; //third polynomial for multiplication
		
		System.out.println("Enter Polynomial #1");
		poly1.insertTerms(); //inserting nodes to poly1
		
		System.out.println("Enter Polynomial #2");
		poly2.insertTerms(); //inserting nodes to poly2
		int choice = 0;
		while(choice!=4){
		
			System.out.println("\nMenu\n1.Addition\n2.Subtraction\n3.Product\n4.Exit");
			choice = sc.nextInt();
			switch(choice){		
				case 1:
						sum = poly1.add(poly1,poly2); //call add method
						System.out.print("\n1......" + poly1.evalResult() + ":");
						poly1.displayPolynomial('+');
						System.out.print("\n2......" + poly2.evalResult() + ":");
						poly2.displayPolynomial('+');
						System.out.print("\n3: Sum is ......" + sum.evalResult() + ":");
						sum.displayPolynomial('+');
						break;
				case 2:
						sub = poly1.subtract(poly1,poly2); //call subtract method
						System.out.print("\n1......" + poly1.evalResult()+":");
						poly1.displayPolynomial('+');
						System.out.print("\n2......" + poly2.evalResult()+":");
						poly2.displayPolynomial('+');	
						System.out.print("\n3: Difference is ......" + sub.evalResult()+":");
						sub.displayPolynomial('+');
						break;
				case 3:
						prod = poly1.multiply(poly1,poly2); //call multiply method
					    System.out.print("\n1......" + poly1.evalResult() + ":");
					    poly1.displayPolynomial('+');
						System.out.print("\n2......" + poly2.evalResult() + ":");
						poly2.displayPolynomial('+');	
					    System.out.print("\n3: Product is ......" + prod.evalResult() + ":");
					    prod.displayPolynomial('+');
					    break;
				case 4:
						System.out.println("Program Terminated");
						break;
				default:
						System.out.println("Invalid choice..");
			}
		}
	}
}//end class MainPolynomial