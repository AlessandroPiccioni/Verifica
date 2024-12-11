package gestioneStudente;

import java.util.ArrayList;

public class Classe {
	
	//Dichiarazione di un ArrayList di studenti
	ArrayList <Studenti> studente = new ArrayList <Studenti>();
	
    //Metodo per aggiungere un libro alla lista studenti
    public void addStudente(Studenti l) {
        studente.add(l);
        System.out.println("Studente aggiunto: " + l.getnome() + " " + l.getcognome());
    }
    
    //Metodo per ottenere la lista degli studenti
    public ArrayList <Studenti> getStudenti() {
    	return studente;
    }
    
    //Metodo per visualizzare tutti gli studenti
    public void visualizziLibri() {
    	//Permette di viaggiare tra le celle della lista degli studenti
    	for(int i=0; i<studente.size(); i++) {
    		System.out.println("Stampa del libro n." + i);
    		System.out.println(String.format("Numero di matricola: %s \nNome: %s \nCognome: %s", studente.get(i).getmatricola(), studente.get(i).getnome(), studente.get(i).getcognome()));
    	}
    }
    
    //Metodo per cercare uno studente con la matricola
	public int ricerca (String ricercato) {
		//Controlla se la la lista degli studenti è vuota
	    if (studente.isEmpty()) {
	        System.out.println("La lista degli studenti è vuota.");
	        return -1;//Ritorna -1 se non lo trova la corrispodenzq
	    }
	    //Ricerca lo studente per matricola
		for(int i=0; i<studente.size(); i++) {
			if(ricercato.equals(studente.get(i).matricola)){
				System.out.println("Studente salvato");
				return i;//Trova lo specifico indice
			}
		}
		System.out.println("Studente non trovato.");
		return -1;
	}
    
}
