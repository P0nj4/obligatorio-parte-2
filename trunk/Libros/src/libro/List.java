package libro;

public class List {
	private NodeList first;

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
	 * Retorna un elemento del tipo nodeList que corresponda al id recibido por
	 * parametro
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
			// IdCount = ref+"";
			String newId = IdCount + ref + "";
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

	private int ConvertToInt(String number) {
		boolean found = false;
		int counter = 0;
		while (found == false) {
			String aux = counter + "";
			if (aux == number) {
				return counter;
			}
		}
		return counter;
	}

	public void DeleteAll() {
		if (!this.isEmpty()) {
			NodeList aux = this.first;
			while (aux.getNext() != null) {
				NodeList aux2 = aux;
				while (aux2.getNext().getNext() != null) {
					aux2 = aux2.getNext();
				}
				aux2.getChilds().DeleteAll();
				aux2.setNext(null);
				/* aux = aux.getNext(); */
			}
			aux.getChilds().DeleteAll();
			aux.setNext(null);
			this.first = null;
		}
	}

	public void toString(String IdCount, StringBuffer res, int level, int start, int end) {
		if (!this.isEmpty()) {
			NodeList aux = this.first;
			int ref = 0;
			while (aux != null) {
				ref++;
				String newId = IdCount + ref + "";
				if (level >= start && level <= end) {
					res.append("\n " + newId + " " + aux.getName()); // += "\n "
					// +
					// newId +
					// aux.getName();
					if (!aux.getChilds().isEmpty()) {
						aux.getChilds().toString(newId + ".", res, level + 1, start, end);
					}
				} else {
					aux.getChilds().toString(newId + ".", res, level + 1, start, end);
				}
				aux = aux.getNext();
			}

		}

	}

	public void printBook() {
		NodeList libro = this.first;

		int id = 1;

		String idStr = id + "";
		while (libro != null) {

			System.out.print(id);
			System.out.println("\t\t\t" + libro.getName());

			if (!libro.getChilds().isEmpty()) {
				int contador = 1;
				NodeList capitulos = libro.getChilds().getFirst();
				this.printChildrens(capitulos, idStr, contador);
			}
			id = id + 1;
			idStr = id + "";
			libro = libro.getNext();
		}
	}

	public void printChildrens(NodeList capitulos, String id, int contador) {

		while (capitulos != null) {
			System.out.println(id + "." + contador + "\t\t\t" + capitulos.getName());

			if (!capitulos.getChilds().isEmpty()) {
				NodeList subCapitulos = capitulos.getChilds().getFirst();

				String idCompleto = id + "." + contador;
				int nuevo = 1;
				printChildrens(subCapitulos, idCompleto, nuevo);
			}
			contador++;
			capitulos = capitulos.getNext();
		}
	}

	/**
	 * Llama a la funcion getNodeById para obtener el nodo buscado, una vez que
	 * lo encuentra le pide al nodo que se agregue la palabra clave Retorna true
	 * si existe un nodo con el id recibido por parametro y pudo agregar la
	 * palabra clave, en caso contrario retorna false
	 * 
	 * @param word
	 *            - String - Palabra clave
	 * @param id
	 *            - String - id del nodo al que se le desea agregar la palabra
	 *            clave
	 * 
	 * @return Boolean
	 */
	public boolean addKeyword(String word, String id) {
		NodeList node = this.getNodeById(id, this.getFirst(), "");
		if (node != null) {
			node.addKeyword(word);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Dado un id recorre todos los hijos y hermanos del nodo y agrega el nombre
	 * y sus palabras claves correspondientes a un string, para posteriormente
	 * devolverlo
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
				String newId = IdCount + ref + "";
				res.append("\n " + newId + " " + aux.getName() + aux.getKewywordToString());
				if (!aux.getChilds().isEmpty()) {
					aux.getChilds().toStringWithKeywords(newId + ".", res);
				}
				aux = aux.getNext();
			}

		}

	}

	public boolean DeleteKeyword(String id, String word) {
		boolean result = false;
		NodeList wanted = this.getNodeById(id, this.getFirst(), "");
		if (wanted != null) {
			result = wanted.getKeywordList().DeleteKeyword(word);
		}
		return result;
	}
}
