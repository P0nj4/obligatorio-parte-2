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
		System.out.print("Autor:");
		System.out.print("\t");
		System.out.println(l.getAuthorName());
		System.out.print("Nombre del Libro:");
		System.out.print("\t");
		System.out.println(l.getName());
		System.out.println("");
		System.out.println("Indice del Libro");
		System.out.println("");

		NodeList libro = l.getChapters().getFirst();
		int id = 1;
		
		String idStr = id + "";
		while (libro.getNext() != null) {
			
			System.out.print(id);
			System.out.println("\t\t\t" + libro.getName());

			if (!libro.getChilds().isEmpty()) {
				
				NodeList capitulos = libro.getChilds().getFirst();
				this.printChildrens(capitulos, idStr);

				// while (capitulos.getNext() != null) {
				//
				// System.out.println(libro.getId() + "." + capitulos.getId() +
				// "\t\t\t" + capitulos.getName());
				//
				// if (!capitulos.getChilds().isEmpty()) {
				// NodeList subCapitulos = capitulos.getChilds().getFirst();
				// while (subCapitulos.getNext() != null) {
				// System.out.println(libro.getId() + "." + capitulos.getId() +
				// "." + subCapitulos.getId() + "\t\t\t"
				// + subCapitulos.getName());
				// subCapitulos = subCapitulos.getNext();
				// }
				// }
				// capitulos = capitulos.getNext();
				// }
			}
			id = id + 1;
			idStr = id + "";
			libro = libro.getNext();
		}
//		this.printChildrens(libro, id);
		// System.out.println(libro.getId() + "\t\t\t" + libro.getName());

		return Retorno.OK;
	}

	public String printChildrens(NodeList capitulos, String id) {
		String idHijo = "1";
		
		while (capitulos.getNext() != null) {
//			System.out.println(id + "." + id++ + "\t\t\t"
//					+ capitulos.getName());
			
			if (!capitulos.getChilds().isEmpty()) {
				NodeList subCapitulos = capitulos.getChilds().getFirst();
//				id = capitulos.getId();
				String idCompleto = id + "." + idHijo;
				return printChildrens(subCapitulos, idCompleto);
			}
			capitulos = capitulos.getNext();
			idHijo = idHijo + 1;
		}
		System.out.println(id + "." + capitulos.getId() + "\t\t\t"
				+ capitulos.getName());

		return null;
	}

	public Retorno MostrarIndiceNiveles(Libro l, int nivelDesde, int nivelHasta) {
		return Retorno.NO_IMPLEMENTADA;
	}

	public Retorno AgregarPalabraClave(Libro l, String nroCapitulo, String clave) {
		return Retorno.NO_IMPLEMENTADA;
	}

	public Retorno BorrarPalabraClave(Libro l, String nroCapitulo, String clave) {
		return Retorno.NO_IMPLEMENTADA;
	}

	public Retorno MostrarIndiceConClaves(Libro l) {
		return Retorno.NO_IMPLEMENTADA;
	}

	public Retorno MostrarCapitulosConClave(Libro l, String clave) {
		return Retorno.NO_IMPLEMENTADA;
	}

}
