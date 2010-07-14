package libro;

public class Main {

	public static void main(String[] args) {
		Sistema s = new Sistema();
		Prueba p = new Prueba();

		// ----PRUEBASok---------------------------------------------------//
		PruebaOK_1(s, p);
		PruebaOK_2(s, p);
		PruebaOK_3(s, p);
		PruebaOK_4(s, p);
		PruebaOK_5(s, p);
		PruebaOK_6(s, p);
		PruebaOK_7(s, p);

		// ----PRUEBASerror---------------------------------------------------//
		PruebaError_1(s, p);
		PruebaError_2(s, p);
		PruebaError_3(s, p);

		// ----Resultados---------------------------------------------------//
		p.imprimirResultadosPrueba();
	}

	/*--------Pruebas OK ---------------------------*/
	public static void PruebaOK_1(Sistema s, Prueba p) {

		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		System.out.println("Se creo el libro");

		tituloPrueba("PRUEBA OK: AGREGAR CAPITULOS");

		p.ver(s.AgregarCapitulo(l, "0", "El solitario"), Sistema.Retorno.OK, "Se agrego el capitulo 1");
		p.ver(s.AgregarCapitulo(l, "0", "La insolacion"), Sistema.Retorno.OK, "Se agrego el capitulo 2");

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		l = s.vaciarLibro(l);

		finPrueba(" Fin PRUEBA OK 1 ");
	}

	public static void PruebaOK_2(Sistema s, Prueba p) {

		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");

		tituloPrueba("PRUEBA OK 2: AGREGAR SUB-CAPITULOS");

		p.ver(s.AgregarCapitulo(l, "0", "El solitario"), Sistema.Retorno.OK, "Se agrego el capitulo 1");
		p.ver(s.AgregarCapitulo(l, "0", "La insolacion"), Sistema.Retorno.OK, "Se agrego el capitulo 2");
		p.ver(s.AgregarCapitulo(l, "2", "Parte 1"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.1");
		p.ver(s.AgregarCapitulo(l, "0", "El alambre de pua"), Sistema.Retorno.OK, "Se agrego el capitulo 3");
		p.ver(s.AgregarCapitulo(l, "2", "Parte 2"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.2");
		p.ver(s.AgregarCapitulo(l, "2.2", "Seccion 1"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.2.1");
		p.ver(s.AgregarCapitulo(l, "2.2", "Seccion 2"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.2.2");
		p.ver(s.AgregarCapitulo(l, "2", "Parte 3"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.3");
		p.ver(s.AgregarCapitulo(l, "2.3", " Seccion 3"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.3.1");
		p.ver(s.AgregarCapitulo(l, "2.3.1", " Nota"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.3.1");
		p.ver(s.AgregarCapitulo(l, "2.3", " Seccion 4"), Sistema.Retorno.OK, "Se agrego el subcapitulo 2.3.1");

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		l = s.vaciarLibro(l);

		finPrueba(" Fin PRUEBA OK 2 ");
	}

	public static void PruebaOK_3(Sistema s, Prueba p) {

		// Crea la estructura del libro
		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		CargaCapitulos(s, l);

		tituloPrueba("PRUEBA OK 3: BORRAR SUB-CAPITULOS");

		// Muestra estructura antes de eliminar
		s.MostrarIndice(l);
		// Elimina
		p.ver(s.BorrarCapitulo(l, "2.2.2"), Sistema.Retorno.OK, "Se elimino el subcapitulo 2.2.2");
		// Muestra estructura despues de eliminar

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		l = s.vaciarLibro(l);

		finPrueba("Fin PRUEBA OK 3");
	}

	public static void PruebaOK_4(Sistema s, Prueba p) {

		// Crea estructura del libro
		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		CargaCapitulos(s, l);

		tituloPrueba("PRUEBA OK 4: BORRAR CAPITULOS");

		// Muestra estructura antes de borrar
		s.MostrarIndice(l);
		// Elimina
		p.ver(s.BorrarCapitulo(l, "2"), Sistema.Retorno.OK, "Se elimino el capitulo 2");
		// Muestra estructura despues de eliminar

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		l = s.vaciarLibro(l);

		finPrueba("Fin PRUEBA OK 4 ");
	}

	public static void PruebaOK_5(Sistema s, Prueba p) {

		// Crea estructura del libro
		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		CargaCapitulos(s, l);

		tituloPrueba("PRUEBA OK 5: MOSTRAR NIVELES");

		// Muestra estructura completa

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		p.ver(s.MostrarIndiceNiveles(l, 5, 3), Sistema.Retorno.OK, "Se mostraron niveles 2 y 3 de capitulos");

		l = s.vaciarLibro(l);

		finPrueba("Fin PRUEBA OK 5");
	}

	public static void PruebaOK_6(Sistema s, Prueba p) {

		// Crea estructura del libro
		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		CargaCapitulos(s, l);

		tituloPrueba("PRUEBA OK 6: AGREGAR PALABRAS CLAVE");

		// Muestra estructura completa

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		p.ver(s.AgregarPalabraClave(l, "1", "camino"), Sistema.Retorno.OK, "Se agrego palabra clave *camino* al capitulo 1");
		p.ver(s.AgregarPalabraClave(l, "1", "camino2"), Sistema.Retorno.OK, "Se agrego palabra clave *camino* al capitulo 1");
		p.ver(s.AgregarPalabraClave(l, "1", "camino22"), Sistema.Retorno.OK, "Se agrego palabra clave *camino* al capitulo 1");
		p.ver(s.AgregarPalabraClave(l, "2", "CABALLO"), Sistema.Retorno.OK, "Se agrego palabra clave *CABALLO* al capitulo 2");
		p.ver(s.AgregarPalabraClave(l, "2.1", "caballo"), Sistema.Retorno.OK, "Se agrego palabra clave *caballo* al capitulo 2.1");
		p.ver(s.AgregarPalabraClave(l, "2.1", "Sol"), Sistema.Retorno.OK, "Se agrego palabra clave *caballo* al capitulo 2.1");
		p.ver(s.AgregarPalabraClave(l, "2.1.1", "SolSec"), Sistema.Retorno.OK, "Se agrego palabra clave *caballo* al capitulo 2.1");

		p.ver(s.MostrarIndiceConClaves(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos con palabras clave");

		p.ver(s.MostrarCapitulosConClave(l, "caballo"), Sistema.Retorno.OK, "Se mostraron capitulos con la palabra clave *caballo*");

		l = s.vaciarLibro(l);

		finPrueba("Fin PRUEBA OK 6");
	}

	public static void PruebaOK_7(Sistema s, Prueba p) {

		// Crea estructura del libro
		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		CargaCapitulos(s, l);

		tituloPrueba("PRUEBA OK 7: ELIMINAR PALABRAS CLAVE");

		// Agrega claves
		s.AgregarPalabraClave(l, "1", "camino");
		s.AgregarPalabraClave(l, "1", "camino2");
		s.AgregarPalabraClave(l, "1", "camino3");
		s.AgregarPalabraClave(l, "2", "CABALLO");
		s.AgregarPalabraClave(l, "2", "pepe");
		s.AgregarPalabraClave(l, "2", "CABallo");
		s.AgregarPalabraClave(l, "2.1", "caballo");

		p.ver(s.MostrarIndiceConClaves(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos con palabras clave");

		p.ver(s.BorrarPalabraClave(l, "2", "CABALLO"), Sistema.Retorno.OK, "Se elimino la palabra clave *CAMINO* del capitulo 1");

		p.ver(s.MostrarIndiceConClaves(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos con palabras clave");

		l = s.vaciarLibro(l);

		finPrueba("Fin PRUEBA OK 7");
	}

	// --------Pruebas Error ---------------------------//
	public static void PruebaError_1(Sistema s, Prueba p) {

		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");

		tituloPrueba("PRUEBA ERROR 1: AGREGAR CAPITULOS REPETIDOS");

		p.ver(s.AgregarCapitulo(l, "0", "El solitario"), Sistema.Retorno.OK, "Se agrego el capitulo 1");
		p.ver(s.AgregarCapitulo(l, "0", "El solitario"), Sistema.Retorno.ERROR, "Error: El capitulo *El solitario* ya existe");
		p.ver(s.AgregarCapitulo(l, "0", "La insolacion"), Sistema.Retorno.OK, "Se agrego el capitulo 2");
		p.ver(s.AgregarCapitulo(l, "0", "La insolacion"), Sistema.Retorno.ERROR, "Error: El capitulo *La insolacion ya existe");
		s.MostrarIndice(l);

		l = s.vaciarLibro(l);

		finPrueba("Fin PRUEBA ERROR 1");
	}

	public static void PruebaError_2(Sistema s, Prueba p) {

		// Crea estructura del libro
		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		CargaCapitulos(s, l);

		tituloPrueba("PRUEBA ERROR 2: ELIMINAR capitulo QUE NO EXISTE");

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		p.ver(s.BorrarCapitulo(l, "8"), Sistema.Retorno.ERROR, "Error: No existe capitulo 8 en el libro");

		p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos");

		l = s.vaciarLibro(l);
		finPrueba("Fin PRUEBA ERROR 2");
	}

	public static void PruebaError_3(Sistema s, Prueba p) {

		// Crea estructura del libro
		Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
		CargaCapitulos(s, l);
		tituloPrueba("PRUEBA ERROR 3: ELIMINAR PALABRA CLAVE QUE NO EXISTE");

		// Agrega claves
		s.AgregarPalabraClave(l, "1", "camino");
		s.AgregarPalabraClave(l, "2", "CABALLO");
		s.AgregarPalabraClave(l, "2.1", "caballo");

		p.ver(s.MostrarIndiceConClaves(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos con palabras clave");

		p.ver(s.BorrarPalabraClave(l, "3", "CAMINO"), Sistema.Retorno.ERROR, "Error: El capitulo 3 no tiene palabra clave *CAMINO*");

		p.ver(s.MostrarIndiceConClaves(l), Sistema.Retorno.OK, "Se mostro el indice de capitulos con palabras clave");

		l = s.vaciarLibro(l);

		finPrueba("Fin PRUEBA ERROR 3");
	}

	/*------------------------------------------------------------------*/
	public static void CargaCapitulos(Sistema s, Libro l) {
		// Crea la estructura de capitulos
		s.AgregarCapitulo(l, "0", "El solitario");
		s.AgregarCapitulo(l, "0", "La insolacion");
		s.AgregarCapitulo(l, "2", "Parte 1");
		s.AgregarCapitulo(l, "0", "El alambre de pua");
		s.AgregarCapitulo(l, "2", "Parte 2");
		s.AgregarCapitulo(l, "2.2", "Seccion 1");
		s.AgregarCapitulo(l, "2.2", "Seccion 2");
		s.AgregarCapitulo(l, "2", "Parte 3");
		s.AgregarCapitulo(l, "2.3", "Seccion 3");
	}

	public static void tituloPrueba(String s) {
		System.out.println("**************************************************************************");
		System.out.println("  " + s);
		System.out.println("**************************************************************************");
	}

	public static void finPrueba(String s) {
		System.out.println("************************ " + s + " ***********************");
		System.out.println("*******************************************************************");
		System.out.println();
	}

}
