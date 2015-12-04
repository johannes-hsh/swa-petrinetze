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
	
	
	
}





      
