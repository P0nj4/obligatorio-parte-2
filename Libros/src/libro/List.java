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
			NodeList newNode = new NodeList(1, NodeName);
			this.first = newNode;
		} else {
			NodeList aux = this.first;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			NodeList newNode = new NodeList(childCount() + 1, NodeName);
			aux.setNext(newNode);
		}
	}

	public int childCount() {
		if (this.isEmpty()) {
			return 0;
		} else {
			NodeList aux = this.first;
			int counter = 0;
			while (aux != null) {
				counter++;
				aux = aux.getNext();
			}
			return counter;
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
				node = node.getNext();
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

	// private static String result = new String();

	public void toString(String IdCount, StringBuffer res, int level, int start, int end) {
		if (!this.isEmpty()) {
			NodeList aux = this.first;
			int ref = 0;
			while (aux != null) {
				ref++;
				String newId = IdCount + ref + "";
				if (level >= start && level <= end) {
					res.append("\n " + newId + aux.getName()); // += "\n " +
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

}
