import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroPresenze registroPresenze = new RegistroPresenze();
        boolean continua = true;
        System.out.println("Benvenuto nel registro presenze");
        do{ 
            System.out.println("1. Aggiungi presenza");
            System.out.println("2. Stampa le presenze");
            System.out.println("3. Controlla se presente");
            System.out.println("4. Cancella presenza");
            System.out.println("5. Chiudi");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch(input){
                case 1 -> {
                    System.out.println("Aggiungi presenza");
                    registroPresenze.aggiungiPresenza();
                    System.out.println("Presenza aggiunta");
                }
                case 2 -> {
                    System.out.println("Stampa le presenze");
                    registroPresenze.stampaPresenze();
                }
                case 3 -> {
                    System.out.println("Controlla se presente");
                    registroPresenze.controllaSePresente();
                }
                case 4 -> {
                    System.out.println("Cancella presenza");
                    registroPresenze.cancellaPresenze();
                }
                case 5 -> {
                    continua = false;
                }
            }
        } while (continua);
        scanner.close(); 
    }
}
