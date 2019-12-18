package biblio.om;

public class Reader {
	private String Nom = "";
	private	String Prenom = "";
	private int id=0;
	private int	age = 0;
	private Document document;
	
	public Reader(String Nom,String Prenom,int age) {
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.age=age;
	}
	
	public String get_Nom() {
		return this.Nom;
	}
	public String get_Prenom() {
		return this.Prenom;
	}
	public int get_age() {
		return this.age;
	}
	public Document get_document() {
		return this.document;
	}
	public void emprunter(Document document) {
		this.document=document;
	}
	public void rendre() {
		this.document=null;	
	}
	
	public void afficher_document() {
		if(this.document==null) {
			System.out.println(this.Nom+" "+this.Prenom+"  rien de emprunter pour l'instant ");
		}
		else {
			System.out.println(this.Nom+" "+this.Prenom+" a emprunte le doucument "+ this.document);	
		}
	}
	
	public String toString() {
		return "ID : "+ id+" , Nom : "+this.Nom+" , Prenom : "+this.Prenom+" , Age : "+this.age;
	}
	
	void setNumberOfId(int nb) {
		id=nb;
	}
	
	int getNumberOfId() {
		return id;
	}
	
	
}
