package libro;

public class Sistema {
   
    public enum Retorno{OK,ERROR,NO_IMPLEMENTADA};

    public Libro crearLibro(String nomAutor, String nomTitulo){
          
    	return new Libro(nomAutor, nomTitulo);
    }
    
    public Libro vaciarLibro(Libro l){
    	l.deleteAll();
            return null;
    }

    public Retorno AgregarCapitulo(Libro l, String nroPadre, String descripcion){
           l.addChapter(descripcion, nroPadre);    	
    	return Retorno.OK;
    }
    
    public Retorno BorrarCapitulo(Libro l, String nroCapitulo){
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

		while (libro.getNext() != null) {

			System.out.println(libro.getId() + "\t\t\t" + libro.getName());

			if (!libro.getChilds().isEmpty()) {

				NodeList capitulos = libro.getChilds().getFirst();

				while (capitulos.getNext() != null) {

					System.out.println(libro.getId() + "." + capitulos.getId() + "\t\t\t" + capitulos.getName());

					if (!capitulos.getChilds().isEmpty()) {
						NodeList subCapitulos = capitulos.getChilds().getFirst();
						while (subCapitulos.getNext() != null) {
							System.out.println(libro.getId() + "." + capitulos.getId() + "." + subCapitulos.getId() + "\t\t\t"
									+ subCapitulos.getName());
							subCapitulos = subCapitulos.getNext();
						}
					}
					capitulos = capitulos.getNext();
				}
			}
			libro = libro.getNext();
		}
		System.out.println(libro.getId() + "\t\t\t" + libro.getName());

		return Retorno.OK;
	}
    
    public Retorno MostrarIndiceNiveles(Libro l, int nivelDesde, int nivelHasta){
        return Retorno.NO_IMPLEMENTADA;
    }
    
    public Retorno  AgregarPalabraClave(Libro l, String nroCapitulo, String clave){
        return Retorno.NO_IMPLEMENTADA;
    }
    
    public Retorno  BorrarPalabraClave(Libro l, String nroCapitulo, String clave){
        return Retorno.NO_IMPLEMENTADA;
    }
    
    public 	Retorno  MostrarIndiceConClaves(Libro l){
        return Retorno.NO_IMPLEMENTADA;
    }
    
    public Retorno  MostrarCapitulosConClave(Libro l, String clave){
        return Retorno.NO_IMPLEMENTADA;
    }

}
