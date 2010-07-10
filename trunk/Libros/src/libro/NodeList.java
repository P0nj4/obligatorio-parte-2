package libro;

import structures.KeywordList;

public class NodeList {
	private String name;
	private NodeList next;
	private List childs;
	private KeywordList keywordList;

	public KeywordList getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(KeywordList keywordList) {
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
		this.keywordList = new KeywordList();
	}

	public NodeList(String name) {
		this.name = name;
		this.next = null;
		this.childs = new List();
		this.keywordList = new KeywordList();
	}

	public void addKeyword(String word) {
		this.getKeywordList().AddAtLast(word);
	}

	public String getKewywordToString() {
		return ": " + this.getKeywordList().toString();
	}

}