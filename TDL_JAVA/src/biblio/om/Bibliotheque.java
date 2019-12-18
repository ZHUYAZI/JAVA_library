package biblio.om;
import java.util.*;  

public class Bibliotheque {
	
	private String nom="";
	private int nDocuments = 0;
	private int nReaders=0;
	private Document[] documents= new Document[Parametres.biblioCapacity];
	private Reader[] readers= new Reader[Parametres.num_users];
	
	public Bibliotheque(String nom) {
		this.nom=nom;
	}
	
	public int getNumberOfDocuments() {
		return nDocuments;
	} 
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public Document[] getDocuments() {
		return documents;
	}
	
	public void addReader(Reader reader) {
		
		this.readers[nReaders]=reader;
		this.readers[nReaders].setNumberOfId(this.readers[nReaders].getNumberOfId()+nReaders);
		nReaders++;
		
	}
	public void show_reader() {
		

		for (int i=0; i<nReaders; i++){
			System.out.println(this.readers[i]);
			this.readers[i].afficher_document();
            }
		
	}
		
	
	
	public void addDocument(Document document) {
		
		this.documents[nDocuments]=document;
		this.documents[nDocuments].change_dispo();
		this.documents[nDocuments].setNumberOfInventory(this.documents[nDocuments].getNumberOfInventory()+nDocuments+1);
		nDocuments++;
		
	}
	
	public <T> List<Integer> rensigner(String titre) {
		System.out.print( "Information de resulta de rensignement : ");
		List<Integer> result = new ArrayList<Integer>();
		boolean exist=false;
		for (int i=0; i<nDocuments; i++){
			if(documents[i].getTitre()==titre) {
				exist=true;
				if(documents[i].getdisp()=="OUI") {
					result.add(i);
				}	
			}
		}
		
		if(exist==true) {
			System.out.println("le document de "+titre +" existe dans le biblio");
			System.out.print( "\n");
			if(result.size()==0) {
				System.out.println("Pas de disponibilite de "+titre+"  pour l'instant");
			}else {
				for (int i = 0; i < result.size(); i++) {
				    System.out.println(documents[result.get(i)]);
				}
			}
			
		}
		else {
			System.out.println("Desole on a pas ce inventaire de "+ titre +" !!!!!");
		}
		
		return result;
	}
	
	public void borrow(List<Integer> result,Reader reader) {
		if(result.size()==0) {
			System.out.println("Dommage !!! Pas de disponibilite dans le biblio pour emprunter");
		}
		else {
			if (getIDdeClient(reader)>=0) {
				readers[getIDdeClient(reader)].emprunter(documents[result.get(0)]);
				documents[result.get(0)].change_dispo();
			}
			
		}
		
	};
	
	public void return_book(Reader reader) {
		if(reader.get_document()==null) {
			System.out.println("Rien de emprunter donc pas besoin de rendre !");
		}
		else {
		for (int i=0; i<nDocuments; i++){
	            if(documents[i]==reader.get_document()) {
	            	documents[i].change_dispo();
	            	reader.rendre();
	            	break;
	            }
			}
		}
		
	};
	
	public int getIDdeClient(Reader reader) {
		int num=-1;
		for (int i=0; i<nReaders; i++){
			if(readers[i]==reader) {
					num=readers[i].getNumberOfId();
				}
            }
		if (num<0) {
			System.out.println("ID inconu !!! Pas de "+reader+" dans le systeme de biblio, merci de l'ajouter dans le systeme");
		}
		return num;
	}
	
	public int getInventoryNb(Document document) {
		int num=0;
		for (int i=0; i<nDocuments; i++){
	            if(documents[i]==document) {
	            	num=i;
	            	break;
	            }
	    } 
		return documents[num].getNumberOfInventory();
	}
}
