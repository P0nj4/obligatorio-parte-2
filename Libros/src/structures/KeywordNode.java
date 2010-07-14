package structures;

public class KeywordNode {
	
	private String keyword;
	
	private KeywordNode next;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public KeywordNode getNext() {
		return next;
	}

	public void setNext(KeywordNode next) {
		this.next = next;
	}

	public KeywordNode(String keyword, KeywordNode next) {
		this.keyword = keyword;
		this.next = next;
	}

	public KeywordNode(String keyword) {
		this.keyword = keyword;
		this.next = null;
	}

}
