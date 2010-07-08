package libro;

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
	
	public void addChapter(String NodeName, String fatherId ){
		if(fatherId == "0"){
			this.getChapters().addAtLast(NodeName);
		}else{
			NodeList subChapter = this.getChapters().getNodeById(fatherId, this.getChapters().getFirst(), "");
			subChapter.getChilds().addAtLast(NodeName);			
		}
	}
	
	public void deleteAll(){
		this.getChapters().DeleteAll();
	}
	
	public String toString(){
		if(this.getChapters().isEmpty()){
			return this.getAuthorName() + "\t" + this.getName() + "\n \nNo se ingresaron capítulos" ;
		}else{
			return this.getChapters().toString();
		}
	}
	
}
