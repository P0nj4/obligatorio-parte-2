package libro;

import structures.KeyWordList;

public class NodeList {
	private String name;
	private NodeList next;
	private List childs;
	private KeyWordList keywordList;

	public KeyWordList getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(KeyWordList keywordList) {
		this.keywordList = keywordList;
	}

	public List getChilds() {
		return childs;
	}

	public void setChilds(List childs) {
		this.childs = childs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NodeList getNext() {
		return next;
	}

	public void setNext(NodeList next) {
		this.next = next;
	}

	public NodeList(String name, NodeList next) {
		this.name = name;
		this.next = next;
		this.childs = new List();
		this.keywordList = new KeyWordList();
	}

	public NodeList(String name) {
		this.name = name;
		this.next = null;
		this.childs = new List();
		this.keywordList = new KeyWordList();
	}

	public void addKeyword(String word) {
		this.getKeywordList().addAtLast(word);
	}

	public String getKewywordToString() {
		return ": " + this.getKeywordList().toString();
	}

}
