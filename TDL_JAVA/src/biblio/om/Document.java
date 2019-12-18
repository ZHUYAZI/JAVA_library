package biblio.om;
import java.util.*;

public class Document implements Cloneable{
	private static int docTotal=0;
	private int numInv=Parametres.startIndexForInventory;
	private String titre;
	private int pages;
	private Date creationDate;
	
	private String disponibilite;
	
	public Document(String titre,int pages){
		this.titre=titre;
		this.pages=pages;
		this.disponibilite="NON";
		docTotal++;
//		numInv=numInv+docTotal;
		creationDate=java.util.Calendar.getInstance().getTime();
	}
	
	public void change_dispo() {
		if(this.disponibilite=="NON") {
			this.disponibilite="OUI";
		}
		else {
			this.disponibilite="NON";
		}
	}
	
	public String getdisp() {
		return this.disponibilite;
	}
	
	public int getPages(){
		return pages;
	}
	
	public void setPages(int pages){
		this.pages=pages;
	}
	
	public Date getCreationDate() {
		return creationDate;
	} 
	
	public String toString() {
		String className = this.getClass().getCanonicalName();
		return className+": Titre = "+titre+"- Pages = "+pages;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre=titre;
	}

    public Object clone()throws CloneNotSupportedException{  
    	docTotal++;
        return (Document)super.clone();  
    }
	
	public int getNumberOfDocumentCreated() {
		return docTotal;
	}
	
	void setNumberOfInventory(int nb) {
		numInv=nb;
	}
	
	int getNumberOfInventory() {
		return numInv;
	}
	
}
