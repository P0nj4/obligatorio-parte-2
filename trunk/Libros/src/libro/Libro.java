package libro;

import structures.StringList;

public class Libro {
	private String authorName;
	private String name;

	private List chapters;

	public List getChapters() {
		return chapters;
	}

	public void setChapters(List chapters) {
		this.chapters = chapters;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Libro(String AuthorName, String name) {
		this.authorName = AuthorName;
		this.name = name;
		this.chapters = new List();
	}

	public boolean addChapter(String NodeName, String fatherId) {
		boolean result = true;
		if (this.getChapters().getNodeByName(NodeName) == null) {
			if (fatherId.equals("0")) {
				this.getChapters().addAtLast(NodeName);
			} else {
				NodeList subChapter = this.getChapters().getNodeById(fatherId, this.getChapters().getFirst(), "");
				if (subChapter == null) {
					result = false;
				} else {
					subChapter.getChilds().addAtLast(NodeName);
				}
			}
		} else {
			result = false;
		}
		return result;
	}

	public void deleteAll() {
		this.getChapters().DeleteAll();
	}

	public String toString(int start, int end) {
		StringBuffer s = new StringBuffer();
		this.getChapters().toString("", s, 1, start, end, "");
		if (s.toString().equals("")) {
			return this.getAuthorName() + "\t" + this.getName() + "\n \nNo se ingresaron capitulos";
		} else {
			return s.toString();
		}
	}

	public boolean AddKeyword(String word, String id) {
		return this.chapters.addKeyword(word, id);
	}

	public String toStringWithKeyWords() {

		StringBuffer s = new StringBuffer();
		this.getChapters().toStringWithKeywords("", s);
		if (s.toString().equals("")) {
			return this.getAuthorName() + "\t" + this.getName() + "\n \nNo se ingresaron capitulos";
		} else {
			return s.toString();
		}
	}

	public void printBook() {
		System.out.print("Autor:");
		System.out.print("\t");
		System.out.println(this.getAuthorName());
		System.out.print("Nombre del Libro:");
		System.out.print("\t");
		System.out.println(this.getName());
		System.out.println("");
		System.out.println("Indice del Libro");
		System.out.println("");

		chapters.printBook();
	}

	public boolean DeleteKeyword(String id, String word) {
		return this.getChapters().DeleteKeyword(id, word);
	}

	public boolean chapterDelete(String nroCapitulo) {		
		String[] cap = nroCapitulo.split("[^0-9]");
		StringList list = new StringList();
		int cant = -1;
		for (String string : cap) {
			cant++;
			list.addAtLast(string);
		}

		return this.chapters.deleteNode(list, cant, 0, this.chapters);
		
	}
	
	
	public boolean showChaptersWithKey(String key){
		boolean resultado = false;
		this.chapters.showChaptersWithKey(key);
		return resultado;
	}
}
