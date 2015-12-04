package petrinetze;
import java.util.ArrayList; 

public class Transition {
	
	private String name;
	ArrayList<Stelle> eingangsStellen;
	ArrayList<Stelle> ausgangsStellen;
	
	
	
	public Transition(String bezeichnung){
        this.name = bezeichnung;
        this.eingangsStellen = new ArrayList<Stelle>();
        this.ausgangsStellen = new ArrayList<Stelle>();
    }
	
	public void addEingangsStelle(Stelle S){
		this.eingangsStellen.add(S);
	}
	
	public void addAusgangsStelle(Stelle S){
		this.ausgangsStellen.add(S);
	}
	
	public String getName(){
		return this.name;
	}
	
	
	
	public String printEingangsStellen(){
		String out ="";
		for(int i=0;i<eingangsStellen.size();i++){
			out+=((Stelle) eingangsStellen.get(i)).getName() + ":" +((Stelle) eingangsStellen.get(i)).getAnzahlToken();
			// Trenne String mit Kommata aber nicht am Schluss
			if ( i != (eingangsStellen.size()-1) ){
				out+=") (";
			}
	    }
		
		return out;
	}
	
	public String printAusgangsStellen(){
		String out ="";
		for(int i=0;i<ausgangsStellen.size();i++){
			out+=((Stelle) ausgangsStellen.get(i)).getName() + ":" +((Stelle) ausgangsStellen.get(i)).getAnzahlToken();
			// Trenne String mit Kommata aber nicht am Schluss
			if ( i != (ausgangsStellen.size()-1) ){
				out+=") (";
			}
	    }
		
		return out;
	}
	
	
	public boolean feuernMoeglich() {
		boolean alleStellenhabenToken = true;
		// Suche stelle die nicht feuer kann
		for(int i=0;i<this.eingangsStellen.size();i++){
			if ( ! ((Stelle) this.eingangsStellen.get(i)).fertigZumFeuern() ){
				alleStellenhabenToken = false;
			}
	    }
		
		return alleStellenhabenToken;
	}
	
	public boolean feuernDurchfueren() {
		boolean allesOK = true;
		// Eingangsstellen Token entfernen
		for(int i=0;i<this.eingangsStellen.size();i++){
			if( ! ((Stelle) this.eingangsStellen.get(i)).removeToken() ) {
				allesOK = false;
			}
		}
	
		// Ausgangsstellen Token hinzufuegen
		for(int i=0;i<this.ausgangsStellen.size();i++){
			if( ! ((Stelle) this.ausgangsStellen.get(i)).addToken() ) {
				allesOK = false;
			}
		}
		
		return allesOK;
	}

	
}
