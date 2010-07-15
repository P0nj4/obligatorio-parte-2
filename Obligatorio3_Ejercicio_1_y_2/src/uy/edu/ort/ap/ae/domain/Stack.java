package uy.edu.ort.ap.ae.domain;

import uy.edu.ort.ap.ae.interfaces.ILista;

public class Stack implements ILista, Cloneable {

	private Node node;

	/**
	 * Pos.: Constructor. Crea el stack vac�o.
	 */
	public Stack() {
		this.node = null;
	}

	/**
	 * Inserta el objeto o al inicio del stack
	 */
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		Node nuevo = new Node(o, this.node);
		this.node = nuevo;
	}

	/**
	 * Retorna el elemento al principio del stack Pre condicion: Stack no vacio
	 */
	@Override
	public Object head() {
		// TODO Auto-generated method stub
		return this.node.getElement();
	}

	/**
	 * Elimina el primer elemento del stack Pre condicion: Stack no vacio
	 */
	@Override
	public void tail() {
		// TODO Auto-generated method stub
		this.node = this.node.getNext();
	}

	/**
	 * Retorna true sii el stack se encuentra vacio, sin elementos
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.node == null;
	}

	/**
	 * Genera un String con los elementos del stack
	 */
	public String toString() {
		/*
		 * String out = ""; Node aux = this.node; while (aux!=null){ out+=aux.getElement().toString() + " - ";
		 * aux = aux.getNext(); } return out;
		 */
		return desdeAtras(this.node);
	}

	private String desdeAtras(Node n) {
		if (n != null) {
			return desdeAtras(n.getNext()) + "Paso: (X " + ((Paso) n.getElement()).ejeX + " Y " + ((Paso) n.getElement()).ejeY + "), ";
		}
		return "";
	}

	/**
	 * Retorna una copia del stack, sin compartir memoria
	 */
	public Stack clone() {
		Stack copia = new Stack();
		if (!this.isEmpty()) {
			Stack aux = new Stack();
			aux.node = this.node.getNext();
			copia.node = new Node(this.head(), aux.clone().node);
		}
		return copia;
	}

	/**
	 * Busca un Elemento dentro de la cola, en caso de encontrarlo retorna True y en caso contrario retorna
	 * Flase
	 * */
	public boolean FindElement(Object p) {
		if (this.isEmpty()) {
			return false;
		} else {
			Node aux = this.node;
			while (aux != null) {
				if (((Paso) aux.getElement()).equals((Paso) p)) {
					return true;
				} else {
					aux = aux.getNext();
				}
			}
			return false;
		}
	}

	@Override
	public void deleteElement(Object p) {
		// TODO Auto-generated method stub
		if (!this.isEmpty()) {
			if (((Paso) this.node.getElement()).equals(p)) {
				this.node = this.node.getNext();
			} else {
				Node aux = this.node;
				while (aux.getNext() != null) {
					if (((Paso) aux.getElement()).equals(p)) {
						aux.setNext(aux.getNext().getNext());
					}
					aux = aux.getNext();
				}
			}
		}

	}

	@Override
	public void erease() {
		// TODO Auto-generated method stub
		while (this.node != null) {
			this.tail();
		}

	}
}
