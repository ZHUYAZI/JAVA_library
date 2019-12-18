package biblio.om;

public class Livre extends Document {
	private String auteur = "";
	private	String editeur = "";
	private int	numExemplaire = 0;
	
	public Livre(String titre, int pages ,String auteur,String editeur){
		super(titre,pages);
		this.auteur=auteur;
		this.editeur=editeur;
		numExemplaire++;
	}
	
	public Object clone(){ 
		Livre l_clone=null;
		try {
			l_clone=(Livre)super.clone();
			l_clone.numExemplaire++;
//			l_clone.setNumberOfInventory(super.getNumberOfInventory()+1);
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	    return l_clone;  
	}
	
	public String getAuteur() {
		return auteur;
	} 
	
	public void setAuteur(String auteur) {
		this.auteur=auteur;
	}
	
	public String getEditeur() {
		return editeur;
	}
	
	public void setEditeur(String editeur) {
		this.editeur=editeur;
	}
	
	public String toString() {
		return super.toString()+" - Auteur = "+auteur+" - Editeur = "+editeur+" - Numéro Exemplaire = "+numExemplaire;
	}

}
