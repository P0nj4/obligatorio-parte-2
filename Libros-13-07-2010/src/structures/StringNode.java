package structures;

public class StringNode {
	private String dataValue;
	private StringNode next;

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public StringNode getNext() {
		return next;
	}

	public void setNext(StringNode next) {
		this.next = next;
	}

	public StringNode(String dataValue, StringNode next) {
		this.dataValue = dataValue;
		this.next = next;
	}

	public StringNode(String dataValue) {
		this.dataValue = dataValue;
		this.next = null;
	}
}
