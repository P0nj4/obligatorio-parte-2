package uy.edu.ort.ap.ae.domain;

import uy.edu.ort.ap.ae.interfaces.IExercise;
import uy.edu.ort.ap.ae.interfaces.ILista;
import uy.edu.ort.ap.ae.test.Test;

public class Exercise implements IExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Test prueba = new Test();

		// -------- Ingresar como parametro de la funci�n testAll los n�meros de
		// estudiantes
		// -------- por ejemplo: 123456-789012
		prueba.testAll("141560-142329");
	}

	/**
	 * Un explorador se encuentra perdido en el desierto y desea llegar a un punto de salida dado por sus coordenadas en un mapa de NxM. El explorador puede moverse hacia una de las casillas adyacentes y por cada paso que da consume una unidad de energ�a. Si su nivel de energ�a llega a 0 el explorador fallece. Al pasar por una casilla del mapa el explorador var�a su nivel de energ�a ya que en estas figura un n�mero que puede ser negativo o positivo que le resta o suma al nivel de energ�a del explorador. El explorador dispone de un n�mero m�ximo de pasos para dar hasta llegar al punto de destino. Se pide desarrollar una funci�n que retorne (y posteriormente muestre) una lista con los caminos que, sin exceder el m�ximo n�mero de pasos que el explorador puede dar, lo conduzcan desde el origen al destino con el mayor nivel de energ�a posible. Se debe aplicar backtracking y realizar las podas y controles de factibilidad adecuados.
	 * 
	 * <p>
	 * <b>Pre-condiciones:</b> Detallar las precondiciones
	 * </p>
	 * <p>
	 * <b>Post-condiciones:</b> Detallar las postcondiciones
	 * </p>
	 * 
	 * @param iOrigen
	 *            fila de origen del explorador
	 * @param jOrigen
	 *            columna de origen del explorador
	 * @param iDestino
	 *            fila de destino del explorador
	 * @param jDestino
	 *            columna de destino del explorador
	 * @param nivelDeEnergiaActual
	 *            valor correspondiente a la energia actual
	 * @param numPasos
	 *            numeros de pasos recorridos
	 * @param maxPasos
	 *            cantidad maxima de pasos que puede dar el explorador desde origen a destino
	 * @param mejorNivelDeEnergia
	 *            maximo nivel de energia encontrado entre los caminos desde origen a destino
	 * @param caminoActual
	 *            camino que se esta evaluando
	 * @param mejoresCaminos
	 *            conjunto de caminos desde origen a destino
	 * @param mapa
	 *            mapa en el que se encuentra
	 * @param n
	 *            cantidad de filas de la matriz mapa
	 * @param m
	 *            cantidad de columnas de la matriz mapa
	 * 
	 * */
	@Override
	public void explorador(int iOrigen, int jOrigen, int iDestino, int jDestino, int nivelDeEnergiaActual, int numPasos, int maxPasos, int mejorNivelDeEnergia, ILista caminoActual, ILista mejoresCaminos, int[][] mapa, int n, int m) {
		// TODO Auto-generated method stub
		Util datos = new Util();
		datos.MaxEnergia = mejorNivelDeEnergia;
		explorador(iOrigen, jOrigen, iDestino, jDestino, numPasos, maxPasos, nivelDeEnergiaActual, datos, caminoActual, mejoresCaminos, mapa, n, m);

		// ILista unCamino = (ILista)mejoresCaminos.tail();
		// String tml = unCamino.toString();
		System.out.println(mejoresCaminos.toString());

	}

	private void explorador(int iOrigen, int jOrigen, int iDestino, int jDestino, int numPasos, int maxPasos, int nivelDeEnergiaActual, Util datos, ILista caminoActual, ILista mejoresCaminos, int[][] mapa, int n, int m) {
		if (PerteneceAlMapa(n, m, iOrigen, jOrigen)) {
			if (!Pase(caminoActual, iOrigen, jOrigen)) {
				if (MeAlcanzaEnergiaYpasos(nivelDeEnergiaActual, mapa, iOrigen, jOrigen, numPasos, maxPasos)) {
					AgregoPaso(caminoActual, iOrigen, jOrigen);
					nivelDeEnergiaActual = DescargoEnergia(mapa, iOrigen, jOrigen, nivelDeEnergiaActual);
					numPasos++;
					if (Exito(iOrigen, jOrigen, iDestino, jDestino)) {
						if (datos.MaxEnergia < nivelDeEnergiaActual) {
							datos.MaxEnergia = nivelDeEnergiaActual;
							mejoresCaminos.erease();
							copioCamino(mejoresCaminos, caminoActual);
						}
						if(datos.MaxEnergia == nivelDeEnergiaActual){
							copioCamino(mejoresCaminos, caminoActual);
						}
					} else {
						for (int x = iOrigen - 1; x < iOrigen + 2; x++) {
							for (int y = jOrigen - 1; y < jOrigen + 2; y++) {
								explorador(x, y, iDestino, jDestino, numPasos, maxPasos, nivelDeEnergiaActual, datos, caminoActual, mejoresCaminos, mapa, n, m);
							}
						}
						numPasos--;
						quitoPaso(caminoActual, iOrigen, jOrigen);
					}
				}
			}
		}

	}

	private boolean PerteneceAlMapa(int n, int m, int x, int y) {
		if (x < n && y < m && x >= 0 && y >= 0)
			return true;
		else
			return false;
	}

	private boolean Pase(ILista caminoActual, int x, int y) {
		return (caminoActual).FindElement(new Paso(x, y));
	}

	private boolean MeAlcanzaEnergiaYpasos(int nivelDeEnergiaActual, int[][] mapa, int x, int y, int numPasos, int maxPasos) {
		try{
		if ((mapa[y][x] + nivelDeEnergiaActual) > 0 && numPasos < maxPasos)
			return true;
		else
			return false;
		}catch(Exception ex){
			System.out.println("");
			return false;
		}
	}

	private boolean Exito(int x, int y, int xDest, int yDest) {
		if (x == xDest && y == yDest)
			return true;
		else
			return false; 
	}

	private void AgregoPaso(ILista caminoActual, int x, int y) {
		(caminoActual).add(new Paso(x, y));
	}

	private void copioCamino(ILista mejoresCaminos, ILista caminoActual) {
		ILista otroCamino = (caminoActual).clone();
		mejoresCaminos.add(otroCamino);
	}

	private int DescargoEnergia(int[][] mapa, int x, int y, int nivelDeEnergiaActual) {
		return (nivelDeEnergiaActual + mapa[y][x])-1;
	}

	private void quitoPaso(ILista caminoActual, int x, int y) {
		(caminoActual).tail();
	}

	/**
	 *Un nutricionista va a un restaurante. En la carta aparecen todos los platos disponibles con el n�mero de calor�as que contiene cada uno. El nutricionista conoce el n�mero exacto de calor�as que su cuerpo necesita en esa comida y deber� encontrar el men� que cubra el mayor n�mero de calor�as que no excede las necesarias sin repetir platos. Dise�ar un algoritmo basado en programaci�n din�mica que determine qu� platos forman parte del men� �ptimo y el n�mero de calor�as que aporta dicho men�.
	 * 
	 * <p>
	 * <b>Pre-condiciones:</b> Detallar las precondiciones
	 * </p>
	 * <p>
	 * <b>Post-condiciones:</b> Detallar las postcondiciones
	 * </p>
	 * 
	 *@param menu
	 *            array con las calorias de cada plato. Cada indice corresponde a un plato, y el valor en el array es el n�mero de calorias del plato de ese indice, comienza a partir del indice 1, la posicion cero no se considerara como plato
	 *@param cantidadPlatos
	 *            cantidad de platos del menu. Corresponde al tama�o-1 de la tabla menu
	 *@param caloriasMaxima
	 *            numero de calorias que necesita el nutricionista
	 *@param tablaMenu
	 *            tabla para memorizacion
	 *@param menuOptimo
	 *            array donde se indicara con <code>true</code> cuando el plato de igual indice este incluido en el menu optimo. El tamano del array sera cantidadPlatos+1
	 * 
	 *@return numero de calorias del menu optimo
	 */
	@Override
	public int nutricionista(int[] menu, int cantidadPlatos, int caloriasMaxima, int[][] tablaMenu, boolean[] menuOptimo) {
		// TODO Auto-generated method stub

		tablaMenu = completarTablaMenu(menu, cantidadPlatos, caloriasMaxima, tablaMenu);

		int[] solucion = cantidadObjetos(menu, cantidadPlatos, tablaMenu, caloriasMaxima);

		System.out.println("Platos que puede comer: ");

		int cantidadCalorias = 0;
		for (int i = 0; i < solucion.length; i++) {
			if (solucion[i] > 0) {
				cantidadCalorias = cantidadCalorias + menu[i];
				System.out.println("Plato nro: " + i + " que tiene " + menu[i] + " calorias");
			}
		}
		System.out.println("total calorias consumidas = " + cantidadCalorias + "\n");

		return cantidadCalorias;

	}

	private int[][] completarTablaMenu(int[] menu, int cantidadPlatos, int caloriasMaxima, int[][] tablaMenu) {

		tablaMenu = generarTabla(cantidadPlatos, caloriasMaxima, tablaMenu);

		for (int i = 1; i < cantidadPlatos; i++) {
			for (int j = 1; j < caloriasMaxima + 1; j++) {

				if (j < menu[i]) {
					tablaMenu[i][j] = tablaMenu[i - 1][j];
				} else {

					if (tablaMenu[i - 1][j] > tablaMenu[i - 1][j - menu[i]] + menu[i]) {

						tablaMenu[i][j] = tablaMenu[i - 1][j];

					} else {

						tablaMenu[i][j] = tablaMenu[i - 1][j - menu[i]] + menu[i];
					}
				}

			}
		}
		return tablaMenu;
	}

	public static int[] cantidadObjetos(int[] objetos, int cantidadObjetos, int[][] solucion, int pesoMaximo) {
		int[] cantObj = new int[cantidadObjetos + 1];
		for (int k = 1; k < cantidadObjetos + 1; k++) {
			cantObj[k] = 0;
		}
		int i = cantidadObjetos - 1;
		int j = pesoMaximo;
		while (j > 0 && i > 0) {
			if ((objetos[i] <= j) && (solucion[i][j] != solucion[i - 1][j])) {
				// PUSE UN OBJETO i
				cantObj[i]++;
				j = j - objetos[i];
			} else {
				// NO PUSE UN OBJETO i, cambio el objeto
				i--;
			}
		}

		return cantObj;
	}

	private int max(int a, int b) {

		if (a < b) {
			return b;
		} else {
			return a;
		}

	}

	private int[][] generarTabla(int cantidadPlatos, int caloriasMaxima, int[][] tablaMenu) {

		// Rellenamos la 1ª fila de ceros
		for (int i = 0; i < cantidadPlatos; i++) {
			tablaMenu[i][0] = 0;
		}

		// Rellenamos la 1ª columna de ceros
		for (int i = 0; i < caloriasMaxima + 1; i++) {
			tablaMenu[0][i] = 0;
		}
		return tablaMenu;
	}
}
