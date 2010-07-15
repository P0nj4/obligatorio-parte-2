package uy.edu.ort.ap.ae.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import uy.edu.ort.ap.ae.domain.Exercise;
import uy.edu.ort.ap.ae.domain.Queue;
import uy.edu.ort.ap.ae.domain.Stack;
import uy.edu.ort.ap.ae.interfaces.ILista;

public class Test {
	private int test;
	private int testOk;
	private String output;
	
	public Test(){

	}
	
	public String testAll(String numeroEstudiante){
		output="\n\r";
		
		try{this.testExplorador(true);}
		catch(Exception e){e.printStackTrace(); output+="\n\r --- Fallo el test de EXPLORADOR --- \n\r";}
		
		try{this.testNutricionista(true);}
		catch(Exception e){e.printStackTrace(); output+="\n\r --- Fallo el test de NUTRICIONISTA --- \n\r";}

		System.out.println(output);
		toFile("c:/"+numeroEstudiante+".txt", output);
		
		return output;
	}
	

	
	/**
	 * Prueba el método explorador implementado en la clase Excercise
	 * Agrega al atributo out el resultado de cada una de las pruebas 
	 * realizadas.
	 * 
	 * @param 	isImplemented	determina si está o no implementado el método 
	 * 							explorador
	 */
	private void testExplorador(boolean isImplemented){
								
		if (!isImplemented){output+= "\n\r --- EXPLORADOR: No implementado --- \n\r";}else{
	
		test = 1;
		
		int[][] mapa1=	{{-5, -3, 15, -2, -9, -15, -20,  2},
						 { 3,  0,  2, -4, -3,  -4,  23, 12},
						 { 5, -3, 15, -2, -7,  -5, -14,  2},
						 { 6,  9,  1,  8, -9,  12,  10,  5},
						 { 5, -3,  6, -2,  3, -19,   8,  2}};
		
		System.out.println("salgo :" + mapa1[2][1]);
		System.out.println("llego :" +  mapa1[4][6]);
		
//		int[fila][columna]

		runTestExplorador (2,1, 4,7,  5, 10, mapa1, 5, 8, " \r\nPrueba "+test);
		runTestExplorador (0,0, 4,7, 14,  8, mapa1, 5, 8, " \r\nPrueba "+test);
		runTestExplorador (2,1, 0,0,  4,  5, mapa1, 3, 3, " \r\nPrueba "+test);
			
		test --;
		output+= "\n\r\n\r------------------------------------------------------- \r\n";
		output+="\n\r EXPLORADOR: "+test;}
		output+= "\n\r\n\r------------------------------------------------------- \r\n";
	}
	
	/**
	 * Metodo que ejecuta el metodo explorador implementado en la clase 
	 * Excercise utilizando los parametros del metodo.
	 * Agrega el resultado de la ejecucion al atributo output de la clase.
	 * Aumenta el contador de pruebas realizadas (atributo test)
	 * 
	 * @param iOrigen				fila de origen del explorador
	 * @param jOrigen				columna de origen del explorador
	 * @param iDestino				fila de destino del explorador
	 * @param jDestino				columna de destino del explorador
	 * @param nivelDeEnergiaActual	valor correspondiente a la energia actual
	 * @param maxPasos				cantidad maxima de pasos que puede dar el 
	 * 								explorador desde origen a destino
	 * @param mapa					mapa en el que se encuentra 
	 * @param n						cantidad de filas de la matriz mapa
	 * @param m						cantidad de columnas de la matriz mapa
	 * @param info					string con datos relevantes de la prueba
	 * 
	 */
	public void runTestExplorador (int iOrigen, int jOrigen, int iDestino, 
			int jDestino, int nivelDeEnergiaActual, int maxPasos, int mapa[][],
			int n, int m, String info){
				
		test++;
		output+= info;
		Exercise excercise = new Exercise();
		ILista caminoActual = new Stack();
		ILista mejoresCaminos = new Queue();
		try{	
			excercise.explorador(iOrigen, jOrigen, iDestino, jDestino, nivelDeEnergiaActual, 0, maxPasos, 0, caminoActual, mejoresCaminos, mapa, n, m);
			output+="\n\r"+mejoresCaminos.toString();
			
		}catch(Exception e){
			e.printStackTrace();
			output+= "\n\r FALLÓ";
		}
	}
	
	/**
	 * Prueba el método nutricionista implementado en la clase Excercise
	 * Agrega al atributo out el resultado de cada una de las pruebas 
	 * realizadas.
	 * 
	 * @param 	isImplemented	determina si está o no implementado el método 
	 * 							nutricionista
	 */
	private void testNutricionista(boolean isImplemented){
		
		if (!isImplemented){output+= "\n\r --- NUTRICIONISTA: No implementado --- \n\r";}else{
		
		test = 1;
		
		/*
		 *  menu representa una carta con 5 platos
		 * 		plato 1  10 calorias
		 *  	plato 2   8 calorias
		 *   	plato 3  15 calorias
		 *  	plato 4  34 calorias
		 *  	plato 5  26 calorias
		 * 
		 */		
		int[] menu={0,10,8,15,34,26};
		
		runTestNutricionista  (menu, menu.length, 22, 18," \r\nPrueba "+test);
		runTestNutricionista  (menu, menu.length, 40, 36," \r\nPrueba "+test);
		runTestNutricionista  (menu, menu.length, 60, 60," \r\nPrueba "+test);
						
		test --;
		output+= "\n\r\n\r------------------------------------------------------- \r\n";
		output+="\n\r NUTRICIONISTA: "+testOk+" de "+test;}
		output+= "\n\r\n\r------------------------------------------------------- \r\n";
	}
	
	/**
	 * Metodo que ejecuta el metodo nutricionista implementado en la clase 
	 * Excercise utilizando los parametros del metodo.
	 * Agrega el resultado de la ejecucion al atributo output de la clase.
	 * Aumenta el contador de pruebas realizadas (atributo test)
	 * 	 
	 * @param menu				array con las calorias de cada plato. 
	 *							Cada indice corresponde a un plato, y el valor 
	 *							en el array es el número de calorias del plato
	 *							de ese indice, comienza a partir del indice 1, 
	 *							la posicion cero no se considerara como plato
	 * @param cantidadPlatos		cantidad de platos del menu. 
	 *							Corresponde al tamaño-1 de la tabla menu
	 * @param caloriasMaxima		numero de calorias que necesita el 
	 *							nutricionista
	 * @param resultadoEsperado resultado esperado para compara con lo que 
	 * 							retorna la ejecucion del metodo nutricionista
	 * @param info				string con datos relevantes de la prueba
	 * 
	 */
	public void runTestNutricionista (int[] menu, int cantidadPlatos,
			int caloriasMaxima, int resultadoEsperado, String info){
		
		test++;
		output+= info;
		Exercise excercise = new Exercise();
		
		try{	
			int[][] tablaMenu = new int[cantidadPlatos][caloriasMaxima+1];
			boolean [] menuOptimo = new boolean [cantidadPlatos];
			int result = excercise.nutricionista(menu, cantidadPlatos, caloriasMaxima, tablaMenu, menuOptimo);
			if(result == resultadoEsperado){
				testOk++;
				output+= ": OK ";
			}else{
				output+= "\n   Fallo valor esperado = "+resultadoEsperado+ " valor obtenido = "+ result;
			}
		}catch(Exception e){
			e.printStackTrace();
			output+= "\n   FALLÓ";
		}
	}
	
	public static boolean toFile(String filePath,String message){
		boolean output=false;
		try{
			if(filePath!=null && !filePath.isEmpty()){
				File file = new File(filePath);
				if(!file.exists()){
					file.createNewFile();
				}
				if(file.exists()){
					if(file.canWrite()){
					    FileWriter fstream = new FileWriter(file,true);
					    BufferedWriter out = new BufferedWriter(fstream);
					    try{
					    out.append(message);
					    }catch(Exception e){
					    	e.printStackTrace();
					    }finally{
					    	if(out!=null){out.close();}
					    }
					}else{
						System.out.println("No tiene permisos suficientes para escribir en el archivo "+filePath);
					}
				}else{
					System.out.println("El archivo no existe y no puede ser creado.");
				}
			}else{
				System.out.print("Ruta de arhivo inválida.");
			}
		}catch(Exception e){
			e.printStackTrace();
		    output=false;
		}
		return output;
	}
	
}
