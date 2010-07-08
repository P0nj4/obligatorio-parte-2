package uy.edu.ort.ap.ae.domain;

public class Node  {
	
	private Object element;
	private Node next;

	public Node (Object o){
		this.element = o;
		this.next = null;
	}
	
	public Node (Object o, Node s){
		this.element = o;
		this.next = s;
	}
	
	public Object getElement(){
		return this.element;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public void setNext(Node n){
		this.next = n;
	}

}
