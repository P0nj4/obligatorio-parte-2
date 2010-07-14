package libro;

import structures.List;
import structures.NodeList;
import structures.StringList;

public class Libro {

	private final String vacio = "";

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
		if (!this.getChapters().isRepeatedName(NodeName)) {
			if (fatherId.equals("0")) {
				this.getChapters().addAtLast(NodeName);
			} else {
				String[] cap = fatherId.split("[^0-9]");
				NodeList subChapter = this.getChapters().getNodeById(cap, cap.length, 0, chapters.getFirst());
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
		this.getChapters().deleteAll();
	}

	public String toString(int start, int end) {
		StringBuffer s = new StringBuffer();
		this.getChapters().toString(this.vacio, s, 1, start, end, this.vacio);
		if (s.toString().equals(this.vacio)) {
			return this.notFoundEpisodes();
		} else {
			return s.toString();
		}
	}

	public boolean addKeyword(String word, String id) {
		return this.chapters.addKeyword(word, id);
	}

	public String toStringWithKeyWords() {

		StringBuffer s = new StringBuffer();
		this.getChapters().toStringWithKeywords(this.vacio, s);
		if (s.toString().equals(this.vacio)) {
			return this.notHaveEpisodes();
		} else {
			return s.toString();
		}
	}

	public void printBook() {
		System.out.print("Autor: ");
		System.out.print(this.getAuthorName() + " - ");
		System.out.print(" Nombre del Libro: ");
		System.out.println(this.getName());
		System.out.println("");
		
		if (!chapters.printBook()){
			System.out.println("No se ingresaron capitulos");
		}
	}

	public boolean deleteKeyword(String id, String word) {
		return this.getChapters().deleteKeyword(id, word);
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

	public boolean showChaptersWithKey(String key) {
		StringBuffer s = new StringBuffer();
		this.chapters.showChaptersWithKey("",key,s);
		if(s.toString().equals("")){
			return false;
		}else{
			System.out.println(s);
			return true;
		}
	}
	
	public String notHaveEpisodes(){
		return this.getAuthorName() + "\t - " + this.getName() + "\n \n" + "No se ingresaron capitulos";
	}
	public String notFoundEpisodes(){
		return this.getAuthorName() + "\t - " + this.getName() + "\n \n" + "No se encontraron capitulos";
	}
}
