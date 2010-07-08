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
		NodeList aux = null ;
		int ref = 0;
		while (node != null) {
			ref++;
			// IdCount = ref+"";
			String newId = IdCount + ref + "";
			if (newId.equals(id)) {
				return node;
			} else {
				if (!node.getChilds().isEmpty()) {
					aux = getNodeById(id, node.getChilds().getFirst(), newId
							+ ".");
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

	public String toString() {
		if (!this.isEmpty()) {
			NodeList aux = this.first;
			String result = "";
			while (aux != null) {
				if (!aux.getChilds().isEmpty()) {
					result += "\n \t" + aux.getChilds().toString();
				}
				result += "\n" + aux.getName();
				aux = aux.getNext();
			}
			return result;
		}
		return "";
	}

}
