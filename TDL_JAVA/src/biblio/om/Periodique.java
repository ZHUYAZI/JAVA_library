package biblio.om;

public class Periodique extends Document{
	private String frequence;

	public Periodique(String titre,int  pages,String frequence){
		super(titre,pages);
		this.frequence=frequence;
	}
	
	public String getFrequence() {
		return frequence;
	}
	
	public void setFrequence(String frequence) {
		this.frequence=frequence;
	}
	
	public String toString() {
		
		return super.toString()+" - Freq = "+frequence;
	}
	
	public Object clone()throws CloneNotSupportedException{  
		throw new CloneNotSupportedException("peroiodique doesn't support clone");
    }
}
