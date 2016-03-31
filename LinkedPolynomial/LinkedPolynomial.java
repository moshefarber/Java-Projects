import java.util.Scanner;

class LinkedPolynomial{

	private Node head;
	private int degree, x; 
	
	
	public LinkedPolynomial(int degree, int x){ //constructor with parameters
	
		head = null;
		this.degree = degree;
		this.x = x;
	}
	
	public void insertTerms(){
	
		Scanner s = new Scanner(System.in); 
		int maxTerm = degree; //get degree value
		for(int i = 0;i<=degree;i++){
		
			System.out.println("Enter polynomial coefficients " + (i+1) + " : ");
			Node term = new Node(); //creating new term
			term.setCoeff(s.nextInt()); //reading coeff and setting to term
			term.setExp(maxTerm--);     //setting exponent and decrement
			term.setX(x);               //setting x value for every node
			if(head==null)              //if first node of polynomial is inserted
				head = term;              //setting new term as head
			else{				
					Node temp = head; //temp for traversing from head
					
					while(temp.getNext()!=null){
						temp = temp.getNext(); //going next node term
					}
					temp.setNext(term); //finally after loop connect new term as last
				}
		}
	}//end insertTerms
	
	public LinkedPolynomial add(LinkedPolynomial p1,LinkedPolynomial p2){
	
		LinkedPolynomial r = new LinkedPolynomial(p1.degree,p1.x); // creating r polynomial for result
		Node first = p1.head; 
		Node second = p2.head;
		
		while(first!=null && second!=null){ 
		
			if(first.getExp()==second.getExp()){ //when both exp are same
			
				int sCoeff=first.getCoeff() + second.getCoeff();
				Node term = new Node(sCoeff,first.getExp(), first.getX()); //create a new node term
				if(r.head==null){  
					r.head=term; //refer new term as r.head
				}	
				else{
				
					Node temp = r.head;
					while(temp.getNext()!=null){						
						temp = temp.getNext(); 
					}
					temp.setNext(term); 
				}
			}
			first = first.getNext(); //next node of first
			second = second.getNext(); //next node of second
		}
		return r; //finally return result r
	}//end add
	
	public LinkedPolynomial subtract(LinkedPolynomial p1,LinkedPolynomial p2){
	
		LinkedPolynomial r = new LinkedPolynomial(p1.degree,p1.x);
		Node first = p1.head;
		Node second = p2.head;
		
		while(first!=null && second!=null){
		
			if(first.getExp()==second.getExp()){
			
				int sCoeff = first.getCoeff() - second.getCoeff();
				Node term = new Node(sCoeff,first.getExp(),first.getX());
				if(r.head==null){
					r.head = term;
				}
				else{
				
					Node temp = r.head; 
					while(temp.getNext()!=null)
						temp=temp.getNext();
					temp.setNext(term);
				}
			}
			first = first.getNext();
			second = second.getNext();
		}
		return r;
	}//end subtract
	
	
	public LinkedPolynomial multiply(LinkedPolynomial p1,LinkedPolynomial p2){
	
		LinkedPolynomial r = new LinkedPolynomial(p1.degree,p1.x);
		Node first = p1.head;
		Node second = p2.head;
		
		while(first!=null && second!=null){
		
			if(first.getExp()==second.getExp()){
			
				int sCoeff = first.getCoeff() * second.getCoeff(); //multiply coefficients
				int sExp = first.getExp() + second.getExp(); //sum the exponents
				
				Node term = new Node(sCoeff,sExp,first.getX());
				if(r.head==null) 
					r.head = term; 
				else{
				
					Node temp = r.head;
					
					while(temp.getNext()!=null)
						temp=temp.getNext();
					temp.setNext(term);
				}
			}
			first = first.getNext();
			second = second.getNext();
		}
		return r;
	}//end multiplication
	
	public int evalResult(){ //evaluates at chosen value of x
	
		int result = 0;
		Node temp = head; //get head of polynomial
		while(temp!=null){
				
			result+=(temp.getCoeff()*(Math.pow(temp.getX(),temp.getExp()))); //calculate each term and add to result
			temp = temp.getNext();
		}
		return result;
	}//end evalResult
	
	
	public void displayPolynomial(char operator){
	
		Node temp = head;
		while(temp!=null){
		
			if(temp.getExp() > 1)
				System.out.print(" " + temp.getCoeff() + "x^" + temp.getExp() + " " + operator);
			else if(temp.getExp()==1)
				System.out.print(" " + temp.getCoeff() + "x" + " " + operator);
			else
				System.out.print(" " + temp.getCoeff());
			temp = temp.getNext();
		}
	}//end displayPolynomial
	
	
}//end class LinkedPolynomial		