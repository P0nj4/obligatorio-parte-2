package structures;


public class List {

	private NodeList first;

	private final String vacio = "";

	public NodeList getFirst() {
		return first;
	}

	public void setFirst(NodeList first) {
		this.first = first;
	}

	public boolean isEmpty() {
		if (this.first == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addAtLast(String NodeName) {
		if (this.isEmpty()) {
			NodeList newNode = new NodeList(NodeName);
			this.first = newNode;
		} else {
			NodeList aux = this.first;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			NodeList newNode = new NodeList(NodeName);
			aux.setNext(newNode);
		}
	}

	/**
	 * Retorna un elemento del tipo nodeList que corresponda al id recibido por parametro
	 * 
	 * @param id
	 *            id buscado
	 * @param node
	 *            Nodo del cual se parte la busqueda
	 * @param IdCount
	 *            Pasar "" siempre
	 * @return nodeList
	 */
	public NodeList getNodeById(String id, NodeList node, String IdCount) {
		NodeList aux = null;
		int ref = 0;
		while (node != null) {
			ref++;
			String newId = IdCount + ref + this.vacio;
			if (newId.equals(id)) {
				return node;
			} else {
				if (!node.getChilds().isEmpty()) {
					aux = getNodeById(id, node.getChilds().getFirst(), newId + ".");
				}
				if (aux != null) {
					node = null;
				} else {
					node = node.getNext();
				}
			}
		}
		return aux;
	}

	public void deleteAll() {
		if (!this.isEmpty()) {
			while (this.first.getNext() != null) {
				NodeList aux2 = this.first;
				while (aux2.getNext().getNext() != null) {
					aux2 = aux2.getNext();
				}
				aux2.getNext().getKeywordList().deleteAll();
				aux2.getNext().getChilds().deleteAll();
				aux2.setNext(null);
			}

			this.first.getChilds().deleteAll();
			this.first = null;
		}
	}

	public void toString(String IdCount, StringBuffer res, int level, int start, int end, String spacing) {
		if (!this.isEmpty()) {
			NodeList aux = this.first;
			int ref = 0;
			while (aux != null) {
				ref++;
				String newId = IdCount + ref + this.vacio;
				if (level >= start && level <= end) {
					res.append("\n " + spacing + newId + " " + aux.getName());
					if (!aux.getChilds().isEmpty()) {
						aux.getChilds().toString(newId + ".", res, level + 1, start, end, spacing + "\t ");
					}
				} else {
					aux.getChilds().toString(newId + ".", res, level + 1, start, end, spacing);
				}
				aux = aux.getNext();
			}

		}

	}

	public boolean printBook() {
		boolean retorno = false;
		NodeList libro = this.first;

		int id = 1;

		String idStr = id + this.vacio;
		while (libro != null) {
			retorno = true;
			System.out.print(id);
			System.out.println(" " + libro.getName());

			if (!libro.getChilds().isEmpty()) {
				int contador = 1;
				NodeList capitulos = libro.getChilds().getFirst();
				this.printChildrens(capitulos, idStr, contador);
			}
			id = id + 1;
			idStr = id + this.vacio;
			libro = libro.getNext();
		}
		return retorno;
	}

	public void printChildrens(NodeList capitulos, String id, int contador) {

		while (capitulos != null) {
			System.out.println("\t" + id + "." + contador + " " + capitulos.getName());

			if (!capitulos.getChilds().isEmpty()) {
				NodeList subCapitulos = capitulos.getChilds().getFirst();

				String idCompleto = "\t" + id + "." + contador;
				int nuevo = 1;
				printChildrens(subCapitulos, idCompleto, nuevo);
			}
			contador++;
			capitulos = capitulos.getNext();
		}
	}

	/**
	 * Llama a la funcion getNodeById para obtener el nodo buscado, una vez que lo encuentra le pide al nodo
	 * que se agregue la palabra clave Retorna true si existe un nodo con el id recibido por parametro y pudo
	 * agregar la palabra clave, en caso contrario retorna false
	 * 
	 * @param word
	 *            - String - Palabra clave
	 * @param id
	 *            - String - id del nodo al que se le desea agregar la palabra clave
	 * 
	 * @return Boolean
	 */
	public boolean addKeyword(String word, String id) {
		boolean resultado = false;

		String[] cap = id.split("[^0-9]");
		NodeList inicioCapitulo = this.getNodeById(cap[0], this.getFirst(), this.vacio);

		if (inicioCapitulo != null && !inicioCapitulo.findKeyWord(word)) {
			NodeList node = this.getNodeById(id, this.getFirst(), this.vacio);
			if (node != null) {
				node.addKeyword(word);
				resultado = true;
			} else {
				resultado = false;
			}
		}
		return resultado;
	}

	/**
	 * Dado un id recorre todos los hijos y hermanos del nodo y agrega el nombre y sus palabras claves
	 * correspondientes a un string, para posteriormente devolverlo
	 * 
	 * @param IdCount
	 *            - String - Se debe pasar un string vacio, es decir ""
	 * @param res
	 *            - String
	 * @return Boolean
	 */
	public void toStringWithKeywords(String IdCount, StringBuffer res) {
		if (!this.isEmpty()) {
			NodeList aux = this.first;
			int ref = 0;
			while (aux != null) {
				ref++;
				String newId = IdCount + ref + this.vacio;
				res.append("\n " + newId + " " + aux.getName() + aux.getKewywordToString());
				if (!aux.getChilds().isEmpty()) {
					aux.getChilds().toStringWithKeywords(newId + ".", res);
				}
				aux = aux.getNext();
			}

		}

	}

	public boolean deleteKeyword(String id, String word) {
		boolean result = false;
		NodeList wanted = this.getNodeById(id, this.getFirst(), this.vacio);
		if (wanted != null) {
			result = wanted.getKeywordList().deleteKeyword(word);
		}
		return result;
	}

	/** Retorna el nodo que tenga mismo nombre al recibido por parametro **/
	public boolean isRepeatedName(String name) {
		if(this.first== null){
			return false;
		}
		if (this.getNodeByName(name) != null) {
			return true;
		} else {
			return false;
		}
		
	}

	private NodeList getNodeByNameOld(String name, NodeList node) {
		NodeList aux = node;
		while (aux != null) {
			if (aux.getName().equals(name)) {
				return aux;
			} else {
				if (!aux.getChilds().isEmpty()) {
					return getNodeByNameOld(name, node.getChilds().getFirst());
				}
			}
			aux = aux.getNext();
		}
		return null;
	}
	
	private NodeList getNodeByName(String name) {
		NodeList aux = this.first;
		NodeList result = null;
		while (aux != null) {
			if (aux.getName().equals(name)) {
				result = aux;
			} else {
				if (!aux.getChilds().isEmpty()) {
					result= aux.getChilds().getNodeByName(name);
				}
			}
			if(result != null){
				return result;
			}
			aux = aux.getNext();
		}
		return result;
	}

	public boolean showChaptersWithKey(String key) {
		boolean resultado = false;

		NodeList libro = this.first;

		int id = 1;
		String idStr = id + this.vacio;
		while (libro != null) {

			KeywordNode keyList = libro.getKeywordList().getFirst();
			if (keyList != null) {
				while (keyList != null) {

					if (keyList.getKeyword() != null && keyList.getKeyword().toLowerCase().equals(key.toLowerCase())) {

						System.out.print(id);
						System.out.println("\t\t\t" + libro.getName() + " : " + key);

						if (!libro.getChilds().isEmpty()) {
							int contador = 1;
							NodeList capitulos = libro.getChilds().getFirst();
							this.showChildrensChapterWhithKey(capitulos, idStr, contador, key, resultado);
							keyList = keyList.getNext();
						}
					} else {
						keyList = keyList.getNext();
					}
				}
			}
			id = id + 1;
			idStr = id + this.vacio;
			libro = libro.getNext();
		}

		return resultado;
	}

	public void showChildrensChapterWhithKey(NodeList capitulos, String id, int contador, String key, boolean resultado) {
		while (capitulos != null) {

			KeywordNode keyList = capitulos.getKeywordList().getFirst();
			if (keyList != null) {
				while (keyList != null) {
					if (keyList.getKeyword() != null) {
						if (keyList.getKeyword().toLowerCase().equals(key.toLowerCase())) {
							System.out.println(id + "." + contador + "\t\t\t" + capitulos.getName() + " : " + key);
							resultado = true;

							if (!capitulos.getChilds().isEmpty()) {
								NodeList subCapitulos = capitulos.getChilds().getFirst();

								String idCompleto = id + "." + contador;
								int nuevo = 1;
								showChildrensChapterWhithKey(subCapitulos, idCompleto, nuevo, key, resultado);
							}
						}
						keyList = keyList.getNext();
					} else {
						contador++;
						capitulos = capitulos.getNext();
					}
				}
				contador++;
				capitulos = capitulos.getNext();

			} else {
				if (!capitulos.getChilds().isEmpty()) {
					NodeList subCapitulos = capitulos.getChilds().getFirst();

					String idCompleto = id + "." + contador;
					int nuevo = 1;
					showChildrensChapterWhithKey(subCapitulos, idCompleto, nuevo, key, resultado);
				}
				contador++;
				capitulos = capitulos.getNext();
			}
		}
	}

	public boolean deleteNode(StringList vecNroCap, int tamanio, int lugarEnElArrayActual, List list) {
		boolean resultado = false;
		if (!list.isEmpty()) {
			if (lugarEnElArrayActual == tamanio) {
				resultado = deleteWithinList(list, vecNroCap.getNodeById(tamanio).getDataValue());
			} else {
				NodeList positionNode = list.getFirst();
				String pos = 1 + this.vacio;
				int conter = 1;
				while (!pos.equals(vecNroCap.getNodeById(lugarEnElArrayActual).getDataValue())) {
					positionNode = positionNode.getNext();
					conter += 1;
					pos = conter + this.vacio;
				}
				resultado = deleteNode(vecNroCap, tamanio, lugarEnElArrayActual + 1, positionNode.getChilds());
			}
		}
		return resultado;
	}

	private boolean deleteWithinList(List list, String position) {
		boolean result = false;
		if (position.equals("1")) {
			list.getFirst().getChilds().deleteAll();
			list.setFirst(list.getFirst().getNext());
			result = true;
		} else {
			NodeList positionNode = list.getFirst();
			int pos = 1;
			String posString = pos+1+""; 
			while (!posString.equals(position) && positionNode != null) {
				positionNode = positionNode.getNext();
				pos++;
				posString = pos+1+""; 
			}
			//pregunto para asegurarme que con el while me quede con el hno del que quiero borrar
			if (positionNode != null && positionNode.getNext() != null) {
				positionNode.getNext().getChilds().deleteAll();
				positionNode.setNext(positionNode.getNext().getNext());
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

}
