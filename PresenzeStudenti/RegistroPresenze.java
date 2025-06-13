import java.util.ArrayList;
import java.util.Scanner;

public class RegistroPresenze {
    private static ArrayList<String> listaPresenze = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public void aggiungiPresenza() {
        System.out.println("Inserisci il nome della persona da aggiungere alle lista presenze:");
        String nome = scanner.nextLine();
        listaPresenze.add(nome);
    }
    public void stampaPresenze() {
        System.out.println("Elenco di tutte le presenze:");
        for (String nome : listaPresenze) {
            System.out.println(nome);
        }
    }
    public void controllaSePresente() {
        System.out.println("Inserisci il nome della persona per controllare se sia presente nella lista:");
        String nome = scanner.nextLine();
        if(listaPresenze.contains(nome)){
            System.out.println("La persona è presente");
        }
    }
    public void cancellaPresenze() {
        System.out.println("Inserisci il nome della persona che vuoi rimuovere dalla lista presenza:");
        String nome = scanner.nextLine();
        if(listaPresenze.contains(nome)){
            listaPresenze.remove(nome);
        }
    }
}