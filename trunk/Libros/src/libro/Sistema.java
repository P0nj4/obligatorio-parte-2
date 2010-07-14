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
	 * además de las palabras claves de cada uno de estos
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
	 * La descripción del capitulo debe ser única.
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
	 * Si el capítulo a eliminar posee subcapítulos, éstos serán eliminados también, así como las palabras clave asociadas a cada uno de los capítulos.
	 * Si se elimina el capítulo nro 0, se eliminara todo el libro. 
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
	 * @precondiciones: . nivelDesde no puede ser menor a 1 y nivelHasta puede ser más grande que el nivel más grande, pero no menor a nivelDesde, en este caso solo se mostraría hasta el último nivel
	 * 
	 * @poscondiciones: Si el libro no contiene capítulos o no hay capítulos que resulten de la búsqueda se mostrará la siguiente salida. 
		Salida: Horacio Quiroga – Cuentos

		No se encontraron capítulos

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
	 * No puede haber palabras clave repetidas en un mismo capítulo. Tampoco se podrá repetir la palabra clave con distinto formato de mayúsculas/minúsculas
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
	 * Si la palabra clave se encuentra en un distinto formato de mayúsculas/minúsculas también se deberá eliminar.
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
	 * Si el libro no tiene capitulos ingresados el sistema retorna en pantalla el nombre del autor y el nombre del libro según lo especificado.
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
	 * Si la palabra clave se encuentra en un distinto formato de mayúsculas/minúsculas también se deberá mostrar el capítulo.
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
