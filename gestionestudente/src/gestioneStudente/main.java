package gestioneStudente;

import java.util.Scanner;

public class main {
	
	//Overloading del metodo richeista
	//Metodo controllo se vuoi continuare
	static boolean richiesta(String frase, Scanner scanner) {
		boolean ris= false;
		String scelta=" ";
		//Controllo input
		do {
			System.out.println(frase);
			scelta= scanner.nextLine().trim().toLowerCase();
			if(!(scelta.equals("si")||scelta.equals("no"))) {
				System.out.println("input non valido sbagliato.");
			}else if(scelta.equals("no"))
			{
				return ris;//Se ha detto di no ritorna false
			}
		}while(!(scelta.equals("si")||scelta.equals("no")));
		ris=true;
		return ris;//Se ha detto di si ritorna true
	}
	//Metodo per richiedere l'opzioni del menu del gestionale
	static int richiesta (Scanner scanner) {
		int scelta= 0;
		System.out.println("Menu registro di classe: ");
		System.out.println("1) Aggiungere un nuovo studente. \n2) Visualizzare tutti gli studenti. \n3) Ricerca di un determinato studente. \n4) Uscita...");
			//Ciclo per vedere se l'input utente sia valido
			do {
				for(int i=0; i<3; i++) {
					System.out.print("Inserici il numero dell'opzione che vuoi selezionare: ");
					scelta= scanner.nextInt();
					scanner.nextLine();
					//Controllo dell'input
					if(scelta<1||scelta>4) {
						System.out.println("Valore non valido! Deve corrispondere alla numerazione del menu.");
					}else if(scelta>1||scelta<4){
						break;
					}
					//Controlla i numeri di tentativi
					if(i==2){
						System.out.println();
						System.out.println("Stai contnuando a sbagliare...\rRistampo il menu:");
						System.out.println("1) Aggiungere un nuovo studente. \n2) Visualizzare tutti gli studenti. \n3) Ricerca di un determinato studente. \n4) Uscita...");
					}
					System.out.println();
				}
			}while(scelta<1||scelta>4);
		//Ritorna un intero
		return  scelta;
	}
	
	
	//Metodo aggiungere
	static void aggiungereStudente(Classe listStudenti, Scanner scanner) {
		//Dichiarazione variabili
		//Variabili di supporto per la creazione di un studente
		String matricola=" "; 
		String nome=" "; 
		String cognome=" "; 
		int b =0; //Variabile di supporto
		//Variabile di supporto per controllare se l'utente abbia inserito un carattere speciale o uno spazio
		String controllo ="[^a-zA-Z0-9]{1,4}";
 
		//Variabile per far ripetere la creazione
		boolean rip=true;
		
		//Gli chiede se l'opzioen che ha scelto gli vada bene
		if(richiesta("Vuoi aggiungere un nuovo studente? [si/no]: ", scanner)==true) {
			//Controlla se esiste la matricola che vuole inserire non sia gia stata messa
			do {
			    //Controllo che la matricola rispetti le regole
			    do {
			        System.out.println("Imposta la matricola:");
			        System.out.println("- Nessun carattere speciale \n- Non deve essere più lunga di 4 caratteri ");
			        matricola = scanner.nextLine().trim();
			        //Controlla se la matricola contiene caratteri speciali o è troppo lunga
			        if (matricola.matches(".*" + controllo + ".*")) {
			            System.out.println("Non hai rispettato le regole di scrittura della matricola.");
			        } else if (matricola.length() > 4) {
			            System.out.println("La matricola non dpuo avere piu di 4 caratteri");
			        } else {
			            //Verifica la matricola se esiste
			            b = listStudenti.ricerca(matricola);
			            if (b != -1) {
			                System.out.println("Studente già inserito.");
			                //Chiedi se l'utente vuole continuare a inserire un nuovo studente
			                if (!richiesta("Sei ancora interessato ad aggiungere un nuovo studente? [si/no]: ", scanner)) {
			                    System.out.println("Uscita dall'opzione aggiungere un nuovo studente.");
			                    return;//Esce dal metodo
			                }
			                // Se lo studente esiste già, chiedi di reinserire la matricola
			                System.out.println("Reinserisci di nuovo la matricola.");
			            }
			        }
			    } while (matricola.matches(".*" + controllo + ".*") || matricola.length() > 4); 

			} while (b != -1); 
				System.out.println("Matricola inserita.");
				System.out.print("Imposta un nome:");
				nome=scanner.nextLine().trim();
				//Te lo salva il primo carattere in maiuscolo e tutto il resto in minuscolo
				//Non ho avuto tempo per otempo per correggere se l'utente inseriva uno spazio vuoto
				//nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
				System.out.println("Nome inserito.");
				System.out.print("Imposta un cognome:");
				cognome=scanner.nextLine();
				//cognome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
				System.out.println("Cognome inserito.");
				if(richiesta("Ti va bene le informazione del nuovo studente? [si/no]: ", scanner)==true) {
					System.out.println("Nuovo studente aggiunto aggiunto.");
					listStudenti.addStudente(new Studenti(nome, cognome, matricola));//Crea il nuovo studente;
					rip=false;
				}else {
					System.out.println("Avvio ripetizione creazione nuovo studente.");
				}
			}while(rip==true);
		}
	
	
	//Metodo per ricercare uno studente con la matricola
	static void ricerca (Classe listStudenti, Scanner scanner) {
		//listStudenti.ricerca(null);
		String mat=" ";
		int a=0;//vARIABILE DI SUPPORTO
			//Controllo se il codice esiste
			do {
				System.out.println("Imposta un codice id?");
				mat=scanner.nextLine().trim();
				a= listStudenti.ricerca(mat);
				if(a==-1) {
					if(richiesta("Vuoi continuare la ricerca? [si/no]: ", scanner)==false) {
						System.out.println("Uscita dalla ricerca.");
						return;
					}
				}
			}while(a==-1);//Continua se non trova l'indice
		System.out.println(String.format("Lo studente con matricola %s è stato trovato", listStudenti.getStudenti().get(a).getmatricola()));
		System.out.println(String.format("Nome: %s", listStudenti.getStudenti().get(a).getnome()));
		System.out.println(String.format("Cognome: %s", listStudenti.getStudenti().get(a).getcognome()));
	}
	

	public static void main(String[] args) {
		/*
		Nota generale:
			
		caricare link alla repo GitHub, entro le ore 12 e 45, e inserire in risposta all'annuncio il link alla repo caricata.
			
			 
			
		Gestione di un Registro di Studenti
		Creare un programma Java che consenta di gestire un registro degli studenti. Il programma deve:
			
		Registrare nuovi studenti con:
		Nome,
		Cognome,
		Matricola (univoca).
		Visualizzare l'elenco degli studenti.
		Cercare uno studente tramite la matricola.
		Requisiti Tecnici:
		Creare una classe Studente con i campi necessari.
		Utilizzare un ArrayList per memorizzare gli studenti.
		Creare un menu testuale che permetta all'utente di:
			
		Aggiungere uno studente.
		Visualizzare tutti gli studenti.
		Cercare uno studente per matricola.
		Uscire dal programma
		 */
		
		
		//Dichiarazione di un oggetto Claase
		//Ci permette di utilizzare la lista degli studenti
		Classe listStudenti = new Classe();
		
		//Dichiarazione di uno scanner
		Scanner scanner= new Scanner(System.in);
		
		//Dichiarazioni variabili
		boolean ripetizione=true; //Variabile per far ripetere il ciclo
		
		System.out.println("Avvio gestionale di una classe...");
        //Ciclo per far continuare all'utente inserimento delle opzioni nell'interfacccia opretore
        do {
				switch (richiesta(scanner)) {
				case 1:
					System.out.println("Hai selezionato aggiungere un nuovo studente.");
					//aggiungereLibro(listLibri, scanner);
					aggiungereStudente(listStudenti, scanner);
					break;   
				case 2:
					System.out.println("Hai selezionato visualizzare tutti gli studenti.");
					listStudenti.visualizziLibri();
					break;
				case 3: 
					System.out.println("Hai selezionato ricerca un determinato studente.");
					ricerca(listStudenti, scanner);
					break;
				case 4:
					System.out.println("Hai selezionato uscita dal programma....");
					if(richiesta("Vuoi uscire dal programma? [si/no]: ", scanner)==true) {
						ripetizione=false;
					}	 			
					break;
				}
				System.out.println();
	     } while (ripetizione);  
        
        //Chiusura di uno scanner
        scanner.close();
		 
	}

}
