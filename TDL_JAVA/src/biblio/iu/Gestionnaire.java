package biblio.iu;
import biblio.om.*;
import java.util.*;

public class Gestionnaire {
	private Bibliotheque biblio;
	private Vector <Document> tampon = new Vector <Document> (Parametres.biblioCapacity);
	
	public static void main(String[] args) {
		Gestionnaire gest = new Gestionnaire();
		System.out.println("\n==== SCENARIO 1 ====\n");
		gest.scenario1();
		System.out.println("\n==== SCENARIO 2 ====\n");
		gest.scenario2();
		System.out.println("\n==== SCENARIO 3 ====\n");
		gest.scenario3();
	}
	
	private void scenario1(){ 
//      création des objets et stockage dans le Vector, affichage du contenu du Vector
//		tampon = new Vector(Parametres.biblioCapacity);
//		Vector <Document> tampon = new Vector <Document>(Parametres.biblioCapacity);
		Periodique p1=new Periodique("Le Monde 2", 150,Parametres.bimensuel);
		tampon.add(p1);
		
//		test clone de periodique
//		try{Periodique p2=(Periodique)p1.clone();tampon.add(p2);}catch(CloneNotSupportedException e) {e.printStackTrace();}
		Livre l1 = new Livre("Java 1.5", 786, "Laura Lemay", "SM");
		tampon.add(l1);
		Livre l2=(Livre)l1.clone();
		tampon.add(l2);
		Livre l3=(Livre)l2.clone();
		tampon.add(l3);
		Livre l4 = new Livre("Les Particules Elémentaires", 388, "Michel Houellebecq", "Flammarion");
		tampon.add(l4);
		Livre l5 = new Livre("L'Alchimiste", 189, "Paulo Coelho", "Poche");
		tampon.add(l5);
		
		Periodique p2=new Periodique("MSDN Magazine #1", 140,Parametres.mensuel);
		tampon.add(p2);
		Periodique p3=new Periodique("MSDN Magazine #2", 140,Parametres.mensuel);
		tampon.add(p3);
		Periodique p4=new Periodique("MSDN Magazine #3", 140,Parametres.mensuel);
		tampon.add(p4);
		Periodique p5=new Periodique("MSDN Magazine #4", 140,Parametres.mensuel);
		tampon.add(p5);
		Periodique p6=new Periodique("MSDN Magazine #5", 140,Parametres.mensuel);
		tampon.add(p6);
		
		System.out.println("---> nombre de documents creés : " + tampon.size());
		for(int i = 0;i < tampon.size();i++){ 
			System.out.println(tampon.get(i).getCreationDate()+"--->"+tampon.get(i)); 
			} 

	}
	
	private void scenario2(){	
//      création d'une bibilothèque
		biblio=new Bibliotheque("Bibliotheque Locale");
		System.out.println("---> nom : "+biblio.getNom());
		System.out.println("---> ajout des documents à la bibliotheque dans l'ordre inverse de Vector");
		System.out.println("---> liberation du vector");
		System.out.print( "\n\n");
		System.out.println("==== Affichage du contenu de la Bibliotheque ====");
		System.out.print( "\n");
//      ajout des objets à partir du Vector
		for(int i = tampon.size()-1;i >=0;i--){ 
			biblio.addDocument(tampon.get(i)); 
			} 
//      libération du Vector		
		tampon=null;
//      affichage de la bibliothèque
		Document[] documents_in_biblio=biblio.getDocuments();
		for(int i = 0;i<biblio.getNumberOfDocuments();i++){ 
			System.out.println("---> Inventaire n°"+biblio.getInventoryNb(documents_in_biblio[i]));
			System.out.println("*"+documents_in_biblio[i]);
			System.out.print( "\n");
			} 

		
	}
	
	private void scenario3(){
		Reader p1=new Reader("ZHU","Yazi",24);
		Reader p2=new Reader("Douto","Romain",22);
		Reader p3=new Reader("Gusta","Guillaume",22);
		Reader p4=new Reader("Martinot-Lagarde","Benilde",22);
		biblio.addReader(p1);
		biblio.addReader(p2);
		biblio.addReader(p3);
		biblio.addReader(p4);
		System.out.print( "list de client dans le biblio");
		System.out.print( "\n");
		biblio.show_reader();
		String document="Java 1.5";
		System.out.print( "\n\n");
		System.out.println("Romain va rensigner le <<"+ document +">> dans le biblo et le empreunter");
		System.out.print( "\n");
		List<Integer> result=biblio.rensigner(document);
		System.out.println("Numero de disponiblite  dans le bilio est : "+result+" , Nombre total de dispnibilite est : "+result.size());
		biblio.borrow(result,p2);
		System.out.print( "\n");
		
		System.out.println("Guillaum va rensigner le <<"+ document +">> dans le biblo et le empreunter");
		System.out.print( "\n");
		List<Integer> result2=biblio.rensigner(document);
		System.out.println("Numero de disponiblite  dans le bilio est : "+result2+" , Nombre total de dispnibilite est : "+result2.size());
		biblio.borrow(result2,p3);
		System.out.print( "\n");
		
		System.out.println("Benilde va rensigner le <<"+ document +">> dans le biblo et le empreunter");
		System.out.print( "\n");
		List<Integer> result3=biblio.rensigner(document);
		System.out.println("Numero de disponiblite  dans le bilio est : "+result3+" , Nombre total de dispnibilite est : "+result3.size());
		biblio.borrow(result3,p4);
		System.out.print( "\n");
		
		System.out.println("Yazi va rensigner le <<"+ document +">> dans le biblo et le empreunter");
		System.out.print( "\n");
		List<Integer> result4=biblio.rensigner(document);
		System.out.println("Numero de disponiblite  dans le bilio est : "+result4+" , Nombre total de dispnibilite est : "+result4.size());
		biblio.borrow(result4,p1);
		System.out.print( "\n");
		
		System.out.print("afficher les inforamtions de touts les clients maintenant");
		System.out.print( "\n");
		biblio.show_reader();
		System.out.print( "\n");
		
		Reader p5=new Reader("qqn","qqn",23);
		String document2="MSDN Magazine #1";
		System.out.println("qqn va rensigner le <<"+ document2 +">> dans le biblo et le empreunter");
		System.out.print( "\n");
		List<Integer> result5=biblio.rensigner(document2);
		System.out.println("Numero de disponiblite  dans le bilio est : "+result5+" , Nombre total de dispnibilite est : "+result5.size());
		biblio.borrow(result5,p5);
		System.out.print( "\n");
		
		System.out.print( "Romain va rendre le documneent "+document+" emprunte");
		System.out.print( "\n");
		biblio.return_book(p2);
		List<Integer> result6=biblio.rensigner(document);
		System.out.println("Numero de disponiblite  dans le bilio est : "+result6+" , Nombre total de dispnibilite est : "+result6.size());
		System.out.print( "\n");
		
		System.out.print("afficher les inforamtions de touts les clients maintenant");
		System.out.print( "\n");
		biblio.show_reader();
		System.out.print( "\n");
		
		
		String document3="Python";
		System.out.print( "Si qqn va emprunter "+document3);
		System.out.print( "\n");
		biblio.rensigner(document3);
		
	}

}
