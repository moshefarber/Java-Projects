/*
  This class takes in and evaluates Polynomials by using
  an array as the data structure.
  Time Complexity: The worst case would be a polynomial of degree 1000,
  since 1000 is hard-coded as the max, but it will not go on forever.
  I believe that since we are talking about a hard coded constant,
  every for loop would have a theta(1) time complexity.     
*/
import java.util.Scanner;
	
public class Polynomial{
		    private int num, degree, x;
	    Scanner sc = new Scanner(System.in);
	    private int[] coeffs;
	    private static int counts = 0;
	    
	public Polynomial(int degree, int x){ //constructor	
	    num = degree;
	    counts++;
	    this.degree = degree;
	    this.x = x;
	    input(sc);
	}

	private void input(Scanner sc){
		int i;
	    int polyResult;
	    coeffs= new int[degree+1];
	    
	    System.out.println("Enter the coefficient of polynomial number " + counts);
	        
	    for (i = 0; i<= num; i++){
	        System.out.print("\n Enter the coefficients " + (i+1) + ":");
	        coeffs[i] = sc.nextInt();
	    }
	}//end input


	public  int evalInd(){ //evaluates at x
		int polyResult = this.coeffs[0];
	    for (int i = 1; i<= this.num; i++){
	    	
	        polyResult = polyResult*this.x +this.coeffs[i];
	    }
	        
	    return polyResult;
	}//end evalInd
	
	public  int evalComb(int[] coeffs, int x){
	    int polyResult = coeffs[0];
	    for (int i = 1; i<= coeffs.length-1; i++){
	        
	        polyResult = polyResult*x +coeffs[i];
	     }
	    
	    return polyResult;
	}//end evalComb
	
	public  int[] combArr(Polynomial p1, Polynomial p2, int x){
		int polyResult[];
		int [] polyResultW;
		int [] polyIndex;
			
	    if (x == 1){ //addition
	       polyResult = new int[p1.degree+1];
	       
	       for(int i = 0; i<=p1.num; i++){
	           polyResult[i] = p1.coeffs[i]+ p2.coeffs[i];
	       }    
	       return polyResult;
	     }
	    else if(x == 2){ //subtraction
	         polyResult= new int[p1.degree+1];
	         
	         for (int i =0; i<=p1.num; i++){
	             polyResult[i] = p1.coeffs[i]- p2.coeffs[i];
	         }
	       return polyResult;
	    }
	    //multiplication
	    int pos=p1.num+p1.num;
	    polyResultW= new int [(p1.degree+1)*(p1.degree+1)];
	    polyIndex = new int[(p1.degree+1)*(p1.degree+1)];
	    int a =0;
	                       
	    for (int j =0; j<=p1.num; j++){
	        int  val=pos;
	        for (int k =0; k<=p2.num; k++){
	             polyResultW[a] = p1.coeffs[j]*p2.coeffs[k];
	             polyIndex[a]= val;
	             val--;
	             a++;
	             }
	        pos--;
	    }
	                   
	     polyResult = new int [p1.degree+p1.degree+1];
	     pos=0; 
	     int sum=0;
	     for (int b=0; b<polyIndex.length; b++){
	         sum=polyResultW[b];
	         if (polyIndex[b]!=1000){ //size
	                       
	            for (int c=b+1; c<polyIndex.length; c++){
	                           
	                 if ((polyIndex[b]==polyIndex[c])) {
	                    sum= sum+ polyResultW[c];
	                    polyIndex[c]=1000;
	                 }
	            }
	           polyResult[pos]=sum; 
	           pos++;
	           sum=0;
	        }
	      }
	    return polyResult;
	}//end combArr

	public String displayComb(int[] coeffs){
		int p = coeffs.length-1;
	    String expr="";
	     for (int i =0; i<= coeffs.length; i++){
	         
	          if (p<0)
	          break;
	          String oper="";
	          if (coeffs[i]>0){
	          if ((i>0))
	        	  oper=" + ";
	          }
	          else if (coeffs[i]<0){
	                   oper=" - ";
	          }
	          else{ 
	              oper=" "; p--; continue;
	          }
	          if (p==0)
	             expr=expr + oper + Math.abs(coeffs[i]) ;
	          else if(p==1)	         	
		         expr=expr + oper + Math.abs(coeffs[i])+ "x" ;

	          else
	             expr=expr + oper + Math.abs(coeffs[i])+"x^" + p;
	          p--;
	      }
	     return expr;
	}//end displayComb
	
	public String displayInd(){
		int p = this.num;
	    String expr="";
	    for (int i =0; i<= this.num; i++){
	         
	        if (p<0)
	           break;
	        String oper="";
	        if (this.coeffs[i]>0){
	            if ((i>0))oper=" + "; //place addition sign, else subtraction
	            }
	        else if (this.coeffs[i]<0){
	                if ((i>0)) oper=" - ";
	                }
	        else{ 
	             oper=" "; p--; continue;
	             }
	        if (p==0)
	           expr=expr + oper + Math.abs(this.coeffs[i]) ;
	        else if(p==1)	         	
	           expr=expr + oper + Math.abs(this.coeffs[i])+ "x" ;
	     
	        else
	           expr=expr + oper + Math.abs(this.coeffs[i])+"x^" + p;
	         p--;
	     }
	        return expr;
	}//end displayInd	   	
}//end class Polynomial
