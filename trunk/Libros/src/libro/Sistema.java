package libro;

public class Sistema {

	public enum Retorno {
		OK, ERROR, NO_IMPLEMENTADA
	};

	public Libro crearLibro(String nomAutor, String nomTitulo) {
		Libro libro = new Libro(nomAutor, nomTitulo);
		libro.notHaveEpisodes();
		return libro;
	}

	/**
	 * @param l - Libro.
	 * @return
	 * 
	 * @Precondiciones: 
	 * El libro recibido por parametro no debe ser nulo
	 * 
	 * @Postcondiciones:
	 * Del libro recibido por parametro se le borrara cada uno de sus capitulos y los hijos de los mismos, 
	 * adem�s de las palabras claves de cada uno de estos
	 */
	public Libro vaciarLibro(Libro l) {
		l.deleteAll();
		return null;
	}

	/**
	 * 
	 * @param l - Libro.
	 * @param nroPadre
	 * @param descripcion
	 * @return
	 * 
	 * @Precondiciones: 
	 * El nroPadre no debe ser un String vacio.
	 * Si se deseara que el capitulo a agregar sea un hijo directo del libro se debe enviar "0" en nroPadre
	 * El nroPadre debe ser un indice que corresponda a un capitulo existente
	 * La descripci�n del capitulo debe ser �nica.
	 * 
	 * @Postcondiciones:
	 * En caso de que no se cumplan alguna de las anteriores, la insercion del capitulo quedara sin efecto, ademas se retornara error.
	 * En caso de que se cumplan las precondiciones, el capitulo sera insertado como hijo del numero recibido como padre en el parametro nroPadre
	 */
	public Retorno AgregarCapitulo(Libro l, String nroPadre, String descripcion) {
		if (l.addChapter(descripcion, nroPadre)) {
			return Retorno.OK;
		} else {
			return Retorno.ERROR;
		}
	}

	/**
	 * 
	 * @param l
	 * @param nroCapitulo
	 * @return
	 * 
	 * @Precondiciones: 
	 * nroCapitulo debe existir.
	 * nroCapitulo debe ser distinto de cero.
	 * 
	 * @poscondiciones:
	 * Si el cap�tulo a eliminar posee subcap�tulos, �stos ser�n eliminados tambi�n, as� como las palabras clave asociadas a cada uno de los cap�tulos.
	 * Si se elimina el cap�tulo nro 0, se eliminara todo el libro. 
	 * 
	 */
	public Retorno BorrarCapitulo(Libro l, String nroCapitulo) {
		if (l.chapterDelete(nroCapitulo)) {
			return Retorno.OK;
		} else {
			return Retorno.ERROR;
		}
	}

	/**
	 * 
	 * @param l
	 * @return
	 * 
	 * @poscondicion: Muestra en pantalla el contenido del indice del libro.
	 */
	public Retorno MostrarIndice(Libro l) {
		l.printBook();
		return Retorno.OK;
	}

	/**
	 * 
	 * @param l
	 * @param nivelDesde
	 * @param nivelHasta
	 * @return
	 * 
	 * @precondiciones: . nivelDesde no puede ser menor a 1 y nivelHasta puede ser m�s grande que el nivel m�s grande, pero no menor a nivelDesde, en este caso solo se mostrar�a hasta el �ltimo nivel
	 * 
	 * @poscondiciones: Si el libro no contiene cap�tulos o no hay cap�tulos que resulten de la b�squeda se mostrar� la siguiente salida. 
		Salida: Horacio Quiroga � Cuentos

		No se encontraron cap�tulos

	 */
	public Retorno MostrarIndiceNiveles(Libro l, int nivelDesde, int nivelHasta) {
		System.out.println(l.toString(nivelDesde, nivelHasta));
		return Retorno.OK;
	}

	/**
	 * 
	 * @param l
	 * @param nroCapitulo
	 * @param clave
	 * @return
	 * 
	 * @precondiciones: 
	 * nroCapitulo debe existir. 
	 * No puede haber palabras clave repetidas en un mismo cap�tulo. Tampoco se podr� repetir la palabra clave con distinto formato de may�sculas/min�sculas
	 */
	public Retorno AgregarPalabraClave(Libro l, String nroCapitulo, String clave) {
		if (l.addKeyword(clave, nroCapitulo)) {
			return Retorno.OK;
		} else {
			return Retorno.ERROR;
		}
	}

	/**
	 * 
	 * @param l
	 * @param nroCapitulo
	 * @param clave
	 * @return
	 * 
	 * @precondiciones: 
	 * el nroCapitulo debe existir.
	 * la palabra clave debe existir.
	 *
	 * @poscondicion: 
	 * Si la palabra clave se encuentra en un distinto formato de may�sculas/min�sculas tambi�n se deber� eliminar.
	 * 
	 */
	public Retorno BorrarPalabraClave(Libro l, String nroCapitulo, String clave) {
		if (l.deleteKeyword(nroCapitulo, clave)) {
			return Retorno.OK;
		} else {
			return Retorno.ERROR;
		}
	}

	/**
	 * 
	 * @param l
	 * @return
	 * 
	 * @precondiciones:
	 * El libro debe existir y debe tener capitulos ingresados.
	 * 
	 * @poscondiciones:
	 * Si el libro no tiene capitulos ingresados el sistema retorna en pantalla el nombre del autor y el nombre del libro seg�n lo especificado.
	 */
	public Retorno MostrarIndiceConClaves(Libro l) {
		System.out.println(l.toStringWithKeyWords());
		return Retorno.OK;
	}

	/**
	 * 
	 * @param l
	 * @param clave
	 * @return
	 * 
	 * @precondicion:
	 * el libro debe existir y debe tener ingresados capitulos y palabras claves.
	 * 
	 * @poscondicion:
	 * Si la palabra clave se encuentra en un distinto formato de may�sculas/min�sculas tambi�n se deber� mostrar el cap�tulo.
	 * 
	 */
	public Retorno MostrarCapitulosConClave(Libro l, String clave) {
		if (l.showChaptersWithKey(clave)) {
			return Retorno.OK;
		} else {
			l.notHaveEpisodes();
			return null;
		}

	}

}
