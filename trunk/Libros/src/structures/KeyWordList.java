package structures;

public class KeyWordList {

	private KeywordNode first;

	public KeywordNode getFirst() {
		return first;
	}

	public void setFirst(KeywordNode first) {
		this.first = first;
	}

	public boolean isEmpty() {
		if (this.first == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addAtLast(String keyword) {
		KeywordNode newone = new KeywordNode(keyword);
		if (this.isEmpty()) {
			this.setFirst(newone);
		} else {
			KeywordNode aux = this.getFirst();
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(newone);
		}
	}

	public String toString() {
		KeywordNode aux = this.getFirst();
		String allNodes = "";
		while (aux != null) {
			allNodes += aux.getKeyword() + " ";
			aux = aux.getNext();
		}
		return allNodes;
	}

	public boolean deleteKeyword(String word) {
		boolean found = false;
		if (this.isEmpty()) {
			found = false;
		} else {
			KeywordNode node = this.getFirst();
			while (node != null && node.getNext() != null) {
				if (node.getNext().getKeyword().toLowerCase().equals(word.toLowerCase())) {
					node.setNext(node.getNext().getNext());
					found = true;
				}
				node = node.getNext();
			}
			if (first.getKeyword().toLowerCase().equals(word.toLowerCase())) {
				first = first.getNext();
				found = true;
			}
		}
		return found;
	}

	public void deleteAll() {

		if (!this.isEmpty()) {
			KeywordNode aux = this.first;

			while (aux.getNext() != null) {

				KeywordNode aux2 = aux.getNext();

				while (aux2.getNext() != null) {
					aux2 = aux2.getNext();
				}
				aux2.setNext(null);
				aux = aux.getNext();
			}

			aux.setNext(null);
			this.first = null;
		}
	}

	public boolean findWordChild(String keyWord) {
		boolean resultado = false;

		KeywordNode aux = this.first;

		while (aux != null && resultado == false) {

			if (aux.getKeyword().toLowerCase().trim().equals(keyWord.toLowerCase().trim())) {
				resultado = true;
			} else {
				aux = aux.getNext();
			}
		}

		return resultado;
	}
}
