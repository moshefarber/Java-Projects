import java.io.*;
import java.math.BigInteger;
import java.util.Random;

public class RSA{

  public static void main(String[] args) throws IOException{
	
	// BigInteger is used because of the huge values that will be generated  
    BigInteger p, q, N, phi, e, d, cipherText, plainText, convertedInput;

    int bitLength = 1024; // used to specify the length of the keys
    
    // generate large prime numbers based on the bit length (1024)
    p = BigInteger.probablePrime(bitLength, new Random());
		System.out.println("p is " + p);
		System.out.println();

	q = BigInteger.probablePrime(bitLength, new Random());
  		System.out.println("q is " + q);
  		System.out.println();
  		
  	// multiply both p and q
  	N = p.multiply(q);
  	    System.out.println("N is " + N);
  	    System.out.println();
  	    
  	// now calculate phi = (p-1)(q-1)
  	phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
  	    System.out.println("phi is " + phi);
  	    System.out.println();
  	    
  	// now calculate e, which is less than and coprime to phi
  	 do{  	    
  	   e = new BigInteger(2*bitLength, new Random()); //execute this first
  	 }
  	 //and if its not less than, or coprime, do it again
  	 while ((e.compareTo(phi) != -1)|| (e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0));
  	 	System.out.println("e is " + e);
  	 	System.out.println();
  	  
  	 	
  	// now calculate d, the inverse of e mod phi
  	d = e.modInverse(phi);
  	    System.out.println("d is " + d);
  	    System.out.println();
  	     
  	 // now we can get the input message
  	 System.out.println("Please enter a message to encrypt.");
	
    String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
    byte[] bytes = input.getBytes(); //converts input into its byte pattern for BigInteger
    
    convertedInput = new BigInteger(bytes);
    	System.out.println("Message to be encrypted: " + input);
    	System.out.println();

    	
    // then encrypt it in the form (message^e mod N) 	
    cipherText = convertedInput.modPow(e, N);
  	    System.out.println("Encrypted message :" + cipherText);
  	    System.out.println();
  
    // Decrypt the message
    plainText = cipherText.modPow(d, N);
    
    // get the converted message from BigInteger and reassemble it as entered
    String convertedPlainText = new String(plainText.toByteArray());
    System.out.println("Decrypted message: " + convertedPlainText);
    
  }//Main
  
}//RSA