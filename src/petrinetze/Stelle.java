package petrinetze;
import java.util.ArrayList; 
import java.io.*;

public class Stelle {
	
	private int anzahlToken;
	private String name;
	
	// Konstruktor
	public Stelle(String name, int anzahlToken){
        this.name=name;
        this.anzahlToken=anzahlToken;
    }
	
	// Gib den Namen der Stelle zurück
	public String getName(){
		return this.name;
	}
	
	// Gib die Anzahl der Token der Stelle zurück
	public int getAnzahlToken(){
		return this.anzahlToken;
	}

	
	// Hat diese Stelle genug Token, dass die Transiton feuer kann. Also mehr als 0.
	public boolean fertigZumFeuern(){
		if(this.anzahlToken > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	// Tokenanzahl veringern
	public boolean removeToken(){
		if(this.anzahlToken > 0 ) {
			this.anzahlToken --;
			return true;
		} else {
			return false;
		}
	}
	
	// Tokenanzahl erhöhen
	public boolean addToken(){
		int tokenBeforeAdd = this.anzahlToken;
		this.anzahlToken ++;
		if( this.anzahlToken - 1 == tokenBeforeAdd) {
			return true;
		} else {
			return false;
		}
	}

//	
//	public static void petriDarstellen( ArrayList<stelle> alleStellen, ArrayList<transition> alleTransitionen){
//	    	// Stellen Ausgeben
//	    	System.out.println("Struktur des Petrinetzes");
//	    	System.out.println("--------------------------------");
//	    	for(int i=0;i<alleStellen.size();i++){
//	    		
//	            System.out.println(((stelle) alleStellen.get(i)).getName() + " Token: " + ((stelle) alleStellen.get(i)).getAnzahlToken());
//	        }
//	    	System.out.println("--------------------------------");
//	    	// Transitionen Ausgeben
//	    		
//	    		for(int i=0;i<alleTransitionen.size();i++){
//	    			System.out.println(" ");
//	    	        System.out.println("Transition: " + ((transition) alleTransitionen.get(i)).getName());
//	    	        System.out.println("--------------------------------");
//	    	        System.out.println("rein => " + ((transition) alleTransitionen.get(i)).printEingangsStellen());
//	    	        System.out.println("raus <= " + ((transition) alleTransitionen.get(i)).printAusgangsStellen());
//	    	        System.out.println("--------------------------------");
//	    	    }
//	    	System.out.println("--------------------------------");
//	    	System.out.println("");
//	    	
//	}
//	
//	public static void stellenDarstellen( ArrayList<stelle> alleStellen){
//    	// Stellen Ausgeben
//    	System.out.println("--------------------------------");
//    	for(int i=0;i<alleStellen.size();i++){
//    		
//            System.out.println(((stelle) alleStellen.get(i)).getName() + " Token: " + ((stelle) alleStellen.get(i)).getAnzahlToken());
//        }
//    	System.out.println("--------------------------------");
//	}
//	
	
	public static void legendeDarstellen(){
			System.out.println( "Legende -----------------------------------------------------------");
			System.out.println( "(Eingangsstellen) => [Transitionsname] => (Ausgangsstellen)");
			System.out.println( "(Name:Token) => [Transitionsname] => (Name:Token)");
			System.out.println( "-------------------------------------------------------------------");
	}
	
	
	public static void darstellen( ArrayList<Transition> alleTransitionen){
		for(int i=0;i<alleTransitionen.size();i++){
			System.out.println( "("+((Transition) alleTransitionen.get(i)).printEingangsStellen() + ") => [" + alleTransitionen.get(i).getName() + "] => (" + ((Transition) alleTransitionen.get(i)).printAusgangsStellen() + ")");
	    }
		System.out.println( "-------------------------------------------------------------------");
	}
	
	// Diese Funktion führt das Feuern aus und gibt das neue Petrinetz aus
	
	public static boolean feuern(ArrayList<Stelle> alleStellen, ArrayList<Transition> alleTransitionen, String Transition){
		Transition zuFeuerndeTransi;
		for(int i=0;i<alleTransitionen.size();i++){
				if ( Transition.equals(alleTransitionen.get(i).getName())){
					// Transitionsnname ist gleich übergebenem String
					zuFeuerndeTransi = alleTransitionen.get(i);
					// Feuern
					if ( zuFeuerndeTransi.feuernMoeglich() ){
						if ( ! zuFeuerndeTransi.feuernDurchfueren() ) {
							System.out.println("Transition gefunden aber Fehler beim Feuern!");
							return false;
						} else {
							System.out.println("[" + zuFeuerndeTransi.getName() + "] hat gefeuert :-)");
							darstellen(alleTransitionen);
							return true;
						}
					} else {
						// Stelle vorhanden aber nicht genuegend Token um zu feuern
						System.out.println("[" + zuFeuerndeTransi.getName() + "] feuern nicht möglich :-(");
						darstellen(alleTransitionen);
						return false;
					}
				} else {
					// Stellenname nicht gleich übergebenem String
					// wird dann durch letzte ausgabe dargestellt
				}
		 }	
		System.out.println("Transition nicht gefunden!");
		darstellen(alleTransitionen);
		return false;
	}
	
	
	public static void main(String [ ] args) throws IOException{
	ArrayList<Stelle> alleStellen = new ArrayList<Stelle>();
	ArrayList<Transition> alleTransitionen = new ArrayList<Transition>();
	
	
	//Stellen erstellen
	Stelle S1 = new Stelle("S1",2);
	Stelle S2 = new Stelle("S2",0);
	Stelle S3 = new Stelle("S3",0);
	Stelle S4 = new Stelle("S4",0);
	
	//Stellen in ArrayList speichern
	alleStellen.add(S1);
	alleStellen.add(S2);
	alleStellen.add(S3);
	alleStellen.add(S4);
	
	//Transitionen erstellen	
	Transition T1 = new Transition("T1");
	Transition T2 = new Transition("T2");
	
	//Transition Ein- und Ausgaenge setzten
	T1.addEingangsStelle(S1);
	T1.addAusgangsStelle(S2);
	T1.addAusgangsStelle(S3);
	
	T2.addAusgangsStelle(S4);
	T2.addEingangsStelle(S2);
	T2.addEingangsStelle(S3);
	
	//Transitionen in ArrayList speichern
	alleTransitionen.add(T1);
	alleTransitionen.add(T2);
	
	// Darstellen
	legendeDarstellen();
	darstellen(alleTransitionen);
	
	// Eingabeaufforderung
	String eingabe;
	do {
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(input);
    System.out.print("Feuere: ");
    eingabe = buffer.readLine();
    feuern(alleStellen, alleTransitionen, eingabe);
	}while(!eingabe.equals("exit"));
    
	
	}
}





      
