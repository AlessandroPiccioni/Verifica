package gestioneStudente;

public class Studenti {
	
	//Attributi della classe studenti
	protected String nome=" ";
	protected String cognome=" ";
	protected String matricola=" ";
	
	//Costruttore
	public Studenti(String nome, String cognome, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola= matricola;
	}
	
	//Metodo per ottenere il nome
	public String getnome(){
		return this.nome;
	}
    
	//Metodo per modificare il nome
	public void setnome(String nome) {
        this.nome = nome;
    }
	
	//Metodo per ottenere il cognome
	public String getcognome(){
		return this.cognome;
	}
    
	//Metodo per modificare il cognome
	public void setcognome(String cognome) {
        this.cognome = cognome;
    }
	
	//Metodo per ottenere il nome
	public String getmatricola(){
		return this.matricola;
	}
    
	//Metodo per modificare il nome
	public void setmatricola(String matricola) {
        this.matricola = matricola;
    }

}
