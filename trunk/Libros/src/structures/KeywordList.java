package structures;

public class KeywordList {
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

	public void AddAtLast(String keyword){
		KeywordNode newone = new KeywordNode(keyword);
		if(this.isEmpty()){
			this.setFirst(newone);
		}else{
			KeywordNode aux = this.getFirst();
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			aux.setNext(newone);
		}
	}
}
