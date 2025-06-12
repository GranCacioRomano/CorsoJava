import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        
        boolean continua = true;
        System.out.println("Benvenuto nel nostro negozio di libri!");
        Scanner tastiera = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.aggiungiLibro(new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", 1954, 10));
        biblioteca.aggiungiLibro(new Libro("Il Codice Da Vinci", "Dan Brown", 2003, 5));
        biblioteca.aggiungiLibro(new Libro("Il Piccolo Principe", "Antoine de Saint-Exupéry", 1943, 8));
        biblioteca.aggiungiLibro(new Libro("Harry Potter e la Pietra Filosofale", "J.K. Rowling", 1997, 12));
        biblioteca.aggiungiLibro(new Libro("Il Nome della Rosa", "Umberto Eco", 1980, 3));
        
        do{
            System.out.println("Cosa vuoi fare?");
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Cerca libro per nome");
            System.out.println("3. Visualizza libri");
            System.out.println("4. Prendi in prestito un libro");
            System.out.println("5. Restituisci un libro");
            System.out.println("6. Esci");
    
            int scelta = tastiera.nextInt();
            
            switch (scelta) 
            {
                case 1:
                    System.out.println("Inserisci il titolo del libro:");
                    String titolo = tastiera.next();
                    System.out.println("Inserisci l'autore del libro:");
                    String autore = tastiera.next();
                    System.out.println("Inserisci l'anno di pubblicazione del libro:");
                    int annoPubblicazione = tastiera.nextInt();
                    System.out.println("Inserisci il numero di copie del libro:");
                    int numeroCopie = tastiera.nextInt();
                    
                    biblioteca.aggiungiLibro(new Libro(titolo, autore, annoPubblicazione, numeroCopie));
                    System.out.println("Libro aggiunto con successo!");
                    break;
                case 2:
                    System.out.println("Inserisci il titolo del libro da cercare");
                    titolo = tastiera.next();
                    biblioteca.cercaLibro(titolo);
                    break;
                case 3:
                    System.out.println("ELENCO LIBRI:");
                    biblioteca.visualizzaLibri();
                    break;
                case 4:
                    biblioteca.visualizzaLibri();
                    System.out.println("Titolo del libro da prendere in prestito: ");
                    String prestitoTitolo = tastiera.nextLine();
                    if (biblioteca.effettuaPrestito(prestitoTitolo)) {
                        System.out.println("Prestito effettuato.");
                    } else {
                        System.out.println("Libro non disponibile.");
                    }
                    break;
                case 5:
                    System.out.println("Titolo del libro da restituire: ");
                    String ritornoTitolo = tastiera.nextLine();
                    if (biblioteca.ritornaLibro(ritornoTitolo)) {
                        System.out.println("Libro restituito con successo.");
                    } else {
                        System.out.println("Libro non trovato.");
                    }
                    break;
                case 6:
                    continua = false;
                    break;
                default:
                System.out.println("Operazione non valida");
                break;
            }
        }while(continua);
            
        tastiera.close();
    }

}
