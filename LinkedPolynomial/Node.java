class Node{

	private int coeff;
	private int exp,x; //data members for polynomial node
	private Node next; //next term reference of polynomial node
	
	public Node(){ //default constructor
	
		coeff = exp = x = 0;
		next = null;
	}
	
	public Node(int coeff,int exp,int x){ //constructor with parameter	
		this.coeff = coeff;
		this.exp = exp;
		this.x = x;
		next = null; //no next node for new polynomial node created
	}
	
	//setter methods
	public void setCoeff(int coeff){
	this.coeff=coeff;
	}
	
	public void setExp(int exp){
	this.exp=exp;
	}
	
	public void setX(int x){
	this.x=x;	
	}
	
	public void setNext(Node next){
	this.next=next;
	}
	
	//getter methods
	public int getCoeff(){
	 return coeff;
	 }
	
	public int getExp(){
	return exp;	
	}
	
	public int getX(){
	return x;
	}
	
	public Node getNext(){
	 return next;
	}
	
} //end node term class
		
	