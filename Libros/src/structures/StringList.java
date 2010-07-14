package structures;

public class StringList {
	private StringNode first;

	public StringNode getFirst() {
		return first;
	}

	public void setFirst(StringNode first) {
		this.first = first;
	}

	public StringList() {
		this.first = null;
	}

	public boolean isEmpty() {
		if (this.first == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addAtLast(String dataValue) {
		StringNode newone = new StringNode(dataValue);
		if (this.isEmpty()) {
			this.first = newone;
		} else {
			StringNode aux = this.getFirst();
			while(aux.getNext()!= null){
				aux = aux.getNext();
			}
			aux.setNext(newone);
		}
	}
	
	public StringNode getNodeById(int id){
		StringNode result = null;
		StringNode aux = this.first;
		int i = 0;
		while(i != id && aux != null){
			aux = aux.getNext();
			i++;
		}
		if(aux != null){
			result = aux;
		}
		
		return result;
	}

}
