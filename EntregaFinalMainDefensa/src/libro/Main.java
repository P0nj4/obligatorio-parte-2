package libro;

/**
 *
 * @author Vicky
 */
public class Main {
    
    public static void main(String[] args) {
        
        Sistema s=new Sistema();
        Prueba p=new Prueba();

        //----PRUEBASok---------------------------------------------------//
        //Operaciones Tipo 1
        PruebaOK_1(s,p);
        PruebaOK_2(s,p);
        PruebaOK_3(s,p);
        //Operaciones Tipo 2
        PruebaOK_4(s,p);
        PruebaOK_5(s,p);
        PruebaOK_6(s,p);
        PruebaOK_7(s,p);

        //----PRUEBASerror---------------------------------------------------//
        //Operaciones Tipo 1
        PruebaError_1(s,p);
        PruebaError_2(s,p);
        //Operaciones Tipo 2
        PruebaError_3(s,p);
        PruebaError_4(s,p);

        //----Resultados---------------------------------------------------//
        p.imprimirResultadosPrueba();
    }
    
    /*--------Pruebas OK ---------------------------*/
    public static void PruebaOK_1(Sistema s, Prueba p){

        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
		System.out.println("Se creó el libro");

        tituloPrueba("PRUEBA OK1: Prueba crear un libro y agregar los capítulos");

        p.ver(s.AgregarCapitulo(l, "0", "Solo Mientras Tanto"),Sistema.Retorno.OK, "Se agregó el capitulo 1");
        p.ver(s.AgregarCapitulo(l, "0", "Quemar las Naves"),Sistema.Retorno.OK, "Se agregó el capitulo 2");
        p.ver(s.AgregarCapitulo(l, "1", "Parte 1"),Sistema.Retorno.OK, "Se agregó el capitulo 1.1");
        p.ver(s.AgregarCapitulo(l, "1", "Parte 2"),Sistema.Retorno.OK, "Se agregó el capitulo 1.2");
        p.ver(s.AgregarCapitulo(l, "0", "El Mundo Que Respiro"),Sistema.Retorno.OK, "Se agregó el capitulo 3");
        p.ver(s.AgregarCapitulo(l, "0", "Canciones del mas Aca"),Sistema.Retorno.OK, "Se agregó el capitulo 4");
        p.ver(s.AgregarCapitulo(l, "1.1", "Seccion 1"),Sistema.Retorno.OK, "Se agregó el capitulo 1.1.1");
        p.ver(s.AgregarCapitulo(l, "1.1", "Seccion 2"),Sistema.Retorno.OK, "Se agregó el capitulo 1.1.2");
        p.ver(s.AgregarCapitulo(l, "1.2", "Secciones 1"),Sistema.Retorno.OK, "Se agregó el capitulo 1.2.1");
        p.ver(s.AgregarCapitulo(l, "1.2", "Secciones 2"),Sistema.Retorno.OK, "Se agregó el capitulo 1.2.2");
        p.ver(s.AgregarCapitulo(l, "3", "Poemas Nuevos"),Sistema.Retorno.OK, "Se agregó el capitulo 3.1");
        p.ver(s.AgregarCapitulo(l, "3", "Poemas Antiguos"),Sistema.Retorno.OK, "Se agregó el capitulo 3.2");
        p.ver(s.AgregarCapitulo(l, "4", "Uruguayas"),Sistema.Retorno.OK, "Se agregó el capitulo 4.1");
        p.ver(s.AgregarCapitulo(l, "4", "Extranjeras"),Sistema.Retorno.OK, "Se agregó el capitulo 4.2");
        p.ver(s.AgregarCapitulo(l, "4.1", "Populares"),Sistema.Retorno.OK, "Se agregó el capitulo 4.1.1");
        p.ver(s.AgregarCapitulo(l, "4.1.1", "Parte A"),Sistema.Retorno.OK, "Se agregó el capitulo 4.1.1.1");
        p.ver(s.AgregarCapitulo(l, "4.1.1", "Parte B"),Sistema.Retorno.OK, "Se agregó el capitulo 4.1.1.2");


        p.ver(s.MostrarIndice(l),Sistema.Retorno.OK, "Se mostró el índice de capítulos");

        l=s.vaciarLibro(l);
        
        finPrueba(" Fin PRUEBA OK 1 ");
    }

     public static void PruebaOK_2(Sistema s, Prueba p){
        
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
		
        tituloPrueba("PRUEBA OK 2: Muestra el índice vacío");
        p.ver(s.MostrarIndice(l), Sistema.Retorno.OK, "Se mostró el índice vacío");
        p.ver(s.MostrarIndiceConClaves(l),Sistema.Retorno.OK,"Se mostró el índice con claves vacío");
    
        l=s.vaciarLibro(l);

        finPrueba(" Fin PRUEBA OK 2 ");
    }

     public static void PruebaOK_3(Sistema s, Prueba p){
        
        //Crea la estructura del libro
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);

        tituloPrueba("PRUEBA OK 3: Prueba agregar las palabras claves a los capitulos y mostrar el indice con palabras claves.");

        p.ver(s.AgregarPalabraClave(l,"1.1.2","caballo"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 1.1.2");
        p.ver(s.AgregarPalabraClave(l,"1.1.2","animales"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 1.1.2");
        p.ver(s.AgregarPalabraClave(l,"1","sol"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 1");
        p.ver(s.AgregarPalabraClave(l,"1","cielo"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 1");
        p.ver(s.AgregarPalabraClave(l,"4.1.1.2","Guitarra"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.1.1.2");
        p.ver(s.AgregarPalabraClave(l,"4.1.1.2","candombe"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.1.1.2");
        p.ver(s.AgregarPalabraClave(l,"4.2","recital"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.2");
        p.ver(s.AgregarPalabraClave(l,"4.2","voz"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.2");
        p.ver(s.AgregarPalabraClave(l,"4.2","Ritmo"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.2");
        p.ver(s.AgregarPalabraClave(l,"1.2.1","NUBE"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 1.2.1");
        p.ver(s.AgregarPalabraClave(l,"1.2.1","atardecer"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 1.2.1");
        p.ver(s.AgregarPalabraClave(l,"1.2.1","amanecer"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 1.2.1");
        p.ver(s.AgregarPalabraClave(l,"2","barco"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 2");
        p.ver(s.AgregarPalabraClave(l,"2","incendio"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 2");
        p.ver(s.AgregarPalabraClave(l,"2","costa"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 2");
        p.ver(s.AgregarPalabraClave(l,"4.1.1","tambor"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.1.1");
        p.ver(s.AgregarPalabraClave(l,"4.1.1","repique"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.1.1");
        p.ver(s.AgregarPalabraClave(l,"4.1.1.2","nube"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 4.1.1.2");
        p.ver(s.AgregarPalabraClave(l,"3","AIRE"),Sistema.Retorno.OK,"Se agregó palabra clave al capitulo 3");
        
        p.ver(s.MostrarIndiceConClaves(l),Sistema.Retorno.OK, "Se mostró el índice con claves");

        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA OK 3");
    }

    public static void PruebaOK_4(Sistema s, Prueba p){
        //Crea estructura del libro
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);

        tituloPrueba("PRUEBA OK 4: Prueba eliminar capÍtulos sin palabras claves");

        s.AgregarCapitulo(l,"0","ABorrar");
        s.AgregarCapitulo(l,"5","ABorrar5.1");
        s.AgregarCapitulo(l,"5","ABorrar5.2");
        s.AgregarCapitulo(l,"5.2","ABorrar 5.2.1");
        s.AgregarCapitulo(l,"5.2","ABorrar 5.2.2");
        s.AgregarCapitulo(l,"5.2","ABorrar 5.2.3");
        s.AgregarCapitulo(l,"1.2.1","ABorrar1");
        //Muestra estructura antes de borrar
        s.MostrarIndice(l);
        //Elimina
        p.ver(s.BorrarCapitulo(l,"5.1"),Sistema.Retorno.OK,"Se eliminó el capítulo ABorrar5.1");
        p.ver(s.MostrarIndice(l),Sistema.Retorno.OK,"Se mostró el índice, contemplando la renumeración de capítulos ABORRAR 5.2.x");

        p.ver(s.BorrarCapitulo(l,"5"),Sistema.Retorno.OK,"Se eliminó el capítulo ABorrar con sus subcapitulos");
        p.ver(s.MostrarIndice(l),Sistema.Retorno.OK,"Se mostró el índice");

        p.ver(s.BorrarCapitulo(l,"1"),Sistema.Retorno.OK,"Se eliminó el capítulo 1=Solo Mientras Tanto con sus subcapitulos");
        p.ver(s.MostrarIndice(l),Sistema.Retorno.OK,"Se mostró el indice, contemplando la renumeración de capítulos del libro de TODA la jerarquía");

        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA OK 4 ");
    }

    public static void PruebaOK_5(Sistema s, Prueba p){
        
        tituloPrueba("PRUEBA OK 5: Prueba eliminar palabras claves y capitulos con palabras claves.");
        //Crea estructura del libro
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);
        CargaClaves(s,l);
        s.AgregarCapitulo(l,"0","ABorrar");
        s.AgregarCapitulo(l,"5","ABorrar5.1");
        s.AgregarCapitulo(l,"5","ABorrar5.2");
        s.AgregarCapitulo(l,"5.2","ABorrar 5.2.1");
        s.AgregarPalabraClave(l,"5","claveBorrar1");
        s.AgregarPalabraClave(l,"5","claveBorrar2");
        s.AgregarPalabraClave(l,"5.2.1","claveBorrar3");
        s.AgregarPalabraClave(l,"1.2.1","claveBorrar5");

        //Muestra estructura completa
        p.ver(s.MostrarIndiceConClaves(l),Sistema.Retorno.OK, "Se mostró el índice de capítulos");
        
        p.ver(s.BorrarPalabraClave(l,"1.2.1","claveBorrar5"),Sistema.Retorno.OK,"Se eliminó la palabra clave claveBorrar5");

        p.ver(s.BorrarCapitulo(l,"5"),Sistema.Retorno.OK,"Se eliminó el capítulo ABorrar junto con sus subcapitulos y claves");
        
        p.ver(s.MostrarIndiceConClaves(l),Sistema.Retorno.OK, "Se mostró el índice de capítulos");
           
        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA OK 5");
    }

    public static void PruebaOK_6(Sistema s, Prueba p){
        
        tituloPrueba("PRUEBA OK 6: Prueba Mostrar el indice por niveles");
        //Crea estructura del libro
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);
        CargaClaves(s,l);

        //Muestra estructura completa
        p.ver(s.MostrarIndice(l),Sistema.Retorno.OK, "Se mostró el índice de capítulos");

        p.ver(s.MostrarIndiceNiveles(l,1,1),Sistema.Retorno.OK,"Se mostraron los capítulos de nivel 1");
    	p.ver(s.MostrarIndiceNiveles(l,3,30),Sistema.Retorno.OK,"Se mostraron los capítulos desde el nivel 3 al último");

        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA OK 6");
    }

    public static void PruebaOK_7(Sistema s, Prueba p){
        //Prueba p=new Prueba();
        //Crea estructura del libro
       

        tituloPrueba("PRUEBA OK 7: Prueba Mostrar capitulos con una clave dada");
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);
        CargaClaves(s,l);
        
        p.ver(s.MostrarIndiceConClaves(l),Sistema.Retorno.OK, "Se mostró el índice de capítulos con palabras clave");


        p.ver(s.MostrarCapitulosConClave(l,"BARco"),Sistema.Retorno.OK,"Se mostró el capítulo *Quemar las naves*");
        p.ver(s.MostrarCapitulosConClave(l,"NUBE"),Sistema.Retorno.OK,"Se mostraron los capítulos 1.2.1  y  4.1.1.2");

        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA OK 7");
    }


    //--------Pruebas Error ---------------------------//
    public static void PruebaError_1(Sistema s, Prueba p){
       
        tituloPrueba("PRUEBA ERROR 1: Errores posibles en operación AgregarCapitulo");
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);

        p.ver(s.AgregarCapitulo(l,"1.1.1.1.3","prueba"),Sistema.Retorno.ERROR,"No existe el nropadre 1.1.1.1.3");
        p.ver(s.AgregarCapitulo(l,"0","Solo Mientras TANTO"),Sistema.Retorno.ERROR,"Ya existe el capítulo elegido *Solo Mientras TANTO*");
        p.ver(s.AgregarCapitulo(l,"4","Extranjeras"),Sistema.Retorno.ERROR,"Ya existe el capítulo *Extranjeras*");
        
        s.MostrarIndice(l);

        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA ERROR 1");
    }
    public static void PruebaError_2(Sistema s, Prueba p){

        tituloPrueba("PRUEBA ERROR 2: Errores posibles en operación Agregar Palabra Clave");
        //Crea estructura del libro
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);
        CargaClaves(s,l);

        p.ver(s.MostrarIndiceConClaves(l),Sistema.Retorno.OK, "Se mostró el índice de capítulos con palabras clave");

        p.ver(s.AgregarPalabraClave(l,"1.1.1.1.1.1","prueba"),Sistema.Retorno.ERROR,"No existe el nroCapitulo 1.1.1.1.1.1");
        p.ver(s.AgregarPalabraClave(l,"1.2.1","amanecer"),Sistema.Retorno.ERROR,"Ya existe la palabra *amanecer* en el capítulo 1.2.1");

        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA ERROR 2");
    }

    public static void PruebaError_3(Sistema s, Prueba p){
        
        tituloPrueba("PRUEBA ERROR 3: Errores Posibles en operación BorrarCapitulo");
        //Crea estructura del libro
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);

        p.ver(s.MostrarIndice(l),Sistema.Retorno.OK, "Se mostró el índice de capítulos");

        p.ver(s.BorrarCapitulo(l, "1.1.1.1.1.1"),Sistema.Retorno.ERROR, "Error: No existe capítulo 1.1.1.1.1.1 en el libro");
        p.ver(s.BorrarCapitulo(l, "2.1.2"),Sistema.Retorno.ERROR, "Error: No existe capítulo 2.1.2 en el libro");

        s.MostrarIndice(l);

        l=s.vaciarLibro(l);
        finPrueba("Fin PRUEBA ERROR 3");
    }


  public static void PruebaError_4(Sistema s, Prueba p){

        tituloPrueba("PRUEBA ERROR 4: Errores posibles en operación Borrar Palabra Clave");
        //Crea estructura del libro
        Libro l = s.crearLibro("Mario Benedetti", "Poesias");
        CargaCapitulos(s,l);
        CargaClaves(s,l);

        p.ver(s.BorrarPalabraClave(l,"1.1.1.1.1.1","prueba"),Sistema.Retorno.ERROR,"Error: No existe el nroCapitulo 1.1.1.1.1.1");
        p.ver(s.BorrarPalabraClave(l,"1.1.2","tormenta"),Sistema.Retorno.ERROR,"Error: No existe la palabra clave *tormenta* en el capitulo 1.1.2");

        l=s.vaciarLibro(l);

        finPrueba("Fin PRUEBA ERROR 4");
    }

    /*------------------------------------------------------------------*/
    public static void CargaCapitulos(Sistema s, Libro l){
        //Crea la estructura de capítulos
        s.AgregarCapitulo(l, "0", "Solo Mientras Tanto");
        s.AgregarCapitulo(l, "0", "Quemar las Naves");
        s.AgregarCapitulo(l, "1", "Parte 1");
        s.AgregarCapitulo(l, "1", "Parte 2");
        s.AgregarCapitulo(l, "0", "El Mundo Que Respiro");
        s.AgregarCapitulo(l, "0", "Canciones del mas Aca");
        s.AgregarCapitulo(l, "1.1", "Seccion 1");
        s.AgregarCapitulo(l, "1.1", "Seccion 2");
        s.AgregarCapitulo(l, "1.2", "Secciones 1");
        s.AgregarCapitulo(l, "1.2", "Secciones 2");
        s.AgregarCapitulo(l, "3", "Poemas Nuevos");
        s.AgregarCapitulo(l, "3", "Poemas Antiguos");
        s.AgregarCapitulo(l, "4", "Uruguayas");
        s.AgregarCapitulo(l, "4", "Extranjeras");
        s.AgregarCapitulo(l, "4.1", "Populares");
        s.AgregarCapitulo(l, "4.1.1", "Parte A");
        s.AgregarCapitulo(l, "4.1.1", "Parte B");
    }

    public static void CargaClaves(Sistema s, Libro l){
        s.AgregarPalabraClave(l,"1.1.2","caballo");
        s.AgregarPalabraClave(l,"1.1.2","animales");
        s.AgregarPalabraClave(l,"1","sol");
        s.AgregarPalabraClave(l,"1","cielo");
        s.AgregarPalabraClave(l,"4.1.1.2","Guitarra");
        s.AgregarPalabraClave(l,"4.1.1.2","candombe");
        s.AgregarPalabraClave(l,"4.2","recital");
        s.AgregarPalabraClave(l,"4.2","voz");
        s.AgregarPalabraClave(l,"4.2","Ritmo");
        s.AgregarPalabraClave(l,"1.2.1","NUBE");
        s.AgregarPalabraClave(l,"1.2.1","atardecer");
        s.AgregarPalabraClave(l,"1.2.1","amanecer");
        s.AgregarPalabraClave(l,"2","barco");
        s.AgregarPalabraClave(l,"2","incendio");
        s.AgregarPalabraClave(l,"2","costa");
        s.AgregarPalabraClave(l,"4.1.1","tambor");
        s.AgregarPalabraClave(l,"4.1.1","repique");
        s.AgregarPalabraClave(l,"4.1.1.2","nube");
        s.AgregarPalabraClave(l,"3","AIRE");
    }
    public static void tituloPrueba(String s){
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println();
        System.out.println("  "+ s );
        System.out.println();
        System.out.println("**************************************************************************");
    }

    public static void finPrueba(String s){
        System.out.println("************************ " + s +" ***********************");
        //System.out.println("*******************************************************************");
        System.out.println();
        System.out.println();
    }

}
