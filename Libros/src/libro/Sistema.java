package libro;

public class Sistema {

	public enum Retorno {
		OK, ERROR, NO_IMPLEMENTADA
	};

	public Libro crearLibro(String nomAutor, String nomTitulo) {

		return new Libro(nomAutor, nomTitulo);
	}

	public Libro vaciarLibro(Libro l) {
		l.deleteAll();
		return null;
	}

	public Retorno AgregarCapitulo(Libro l, String nroPadre, String descripcion) {
		l.addChapter(descripcion, nroPadre);
		return Retorno.OK;
	}

	public Retorno BorrarCapitulo(Libro l, String nroCapitulo) {
		return Retorno.NO_IMPLEMENTADA;
	}

	public Retorno MostrarIndice(Libro l) {
		l.printBook();
		return Retorno.OK;
	}

	public Retorno MostrarIndiceNiveles(Libro l, int nivelDesde, int nivelHasta) {
		System.out.println(l.toString(nivelDesde, nivelHasta));
		return Retorno.OK;
	}

	public Retorno AgregarPalabraClave(Libro l, String nroCapitulo, String clave) {
		if (l.AddKeyword(clave, nroCapitulo)) {
			return Retorno.OK;
		} else {
			return Retorno.ERROR;
		}
	}

	public Retorno BorrarPalabraClave(Libro l, String nroCapitulo, String clave) {
		if (l.DeleteKeyword(nroCapitulo, clave)) {
			return Retorno.OK;
		} else {
			return Retorno.ERROR;
		}
	}

	public Retorno MostrarIndiceConClaves(Libro l) {
		System.out.println(l.toStringWithKeyWords());
		return Retorno.OK;
	}

	public Retorno MostrarCapitulosConClave(Libro l, String clave) {
		return Retorno.NO_IMPLEMENTADA;
	}

}
