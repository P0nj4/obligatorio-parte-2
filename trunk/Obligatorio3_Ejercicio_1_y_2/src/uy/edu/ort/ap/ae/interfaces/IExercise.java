package uy.edu.ort.ap.ae.interfaces;

public interface IExercise {
	
	public void explorador (int iOrigen, int jOrigen, int iDestino, int jDestino,  
							int nivelDeEnergiaActual, int numPasos, int maxPasos, 
							int mejorNivelDeEnergia, ILista caminoActual, 
							ILista mejoresCaminos, int mapa[][], int n, int m);
	
	public int nutricionista (int[] menu,int cantidadPlatos,int caloriasMaxima,
							  int[][] tablaMenu,boolean[]menuOptimo);
	
	
}
