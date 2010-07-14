package uy.edu.ort.ap.ae.interfaces;


public interface ILista {
	
	public void add (Object o);
	
	public Object head ( );
	
	public void tail ( );
	
	public boolean isEmpty ( );
	
	public ILista clone();
	
	public String toString();
	
	public boolean FindElement(Object p);
	
	public void deleteElement(Object p);
	
	public void erease();
}
