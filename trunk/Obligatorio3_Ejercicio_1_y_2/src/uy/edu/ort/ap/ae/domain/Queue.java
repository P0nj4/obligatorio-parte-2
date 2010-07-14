package uy.edu.ort.ap.ae.domain;

import uy.edu.ort.ap.ae.interfaces.ILista;

public class Queue implements ILista, Cloneable {
	
	private Node front;
	private Node back;
	
	/**
	 * Pos.: Constructor. Crea la cola vacía.
	 */
	public Queue ( ){
		this.front = this.back = null;
	}	

	/**
	 * Inserta el objeto o al final de la cola
	 */
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		
		Node nuevo = new Node(o);
		if (this.front == null){
			this.back = nuevo;
			this.front = this.back;
		}else{
			this.back.setNext(nuevo);
			this.back = this.back.getNext();
		}
	}

	/**
	 * Retorna el elemento del principio de la cola
	 * Pre condicion: Queue no vacia
	 */
	@Override
	public Object head() {
		// TODO Auto-generated method stub
		return this.front.getElement();
	}

	/**
	 * Elimina el primer elemento de la cola
	 * Pre condicion: Queue no vacia
	 */
	@Override
	public void tail() {
		// TODO Auto-generated method stub
		this.front = this.front.getNext();
		if (this.front == null){
			this.back = null;
		}
	}

	public void erease(){
		while(this.front != null){
			this.tail();
		}
	}
	/**
	 * Retorna true sii la cola (Queue) se encuentra vacia, sin elementos
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.front == null;
	}
	
	/**
	 * Retorna una copia de la cola, sin compartir memoria
	 */
	public ILista clone(){
		ILista  copia = new Queue();		
		if(!this.isEmpty()){
			Node aux = this.front;
			while(aux!=null){
				copia.add(aux.getElement());
				aux = aux.getNext();
			}
		}
		return copia;
	}
	
	
	/**
	 * Genera un String con los elementos de la cola
	 */
	public String toString(){
		String out ="";
		Node aux = this.front;
		while (aux!=null){
			out+= aux.getElement().toString() + " - ";
			aux = aux.getNext();
		}
		return out;
	}
	/**
	 * Busca un Elemento dentro de la cola, en caso de encontrarlo retorna True y en caso contrario retorna Flase
	 * */
	public boolean FindElement(Object p){
		if(this.isEmpty()){
			return false;
		}else{
			Node aux = this.front;
			while(aux != null){
				if(((Paso)aux.getElement()).equals((Paso)p)){
					return true;
				}else{
					aux = aux.getNext();
				}
			}
			return false;
		}
	}

	@Override
	public void deleteElement(Object p) {
		// TODO Auto-generated method stub
		
	}
		
}
