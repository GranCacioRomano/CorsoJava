package Esame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scuola scuola = new Scuola(null, null);
        boolean continua = true;
        ClasseScolastica classe = new ClasseScolastica(null);

        while (continua) {
            System.out.println("1. Aggiungi Classe");
            System.out.println("2. Aggiungi Studente");
            System.out.println("3. Aggiungi Docente");
            System.out.println("4. Interroga");
            System.out.println("5. Riepilogo");
            System.out.println("6. Gestione stipendi e valutazioni docenti");
            System.out.println("0. Esci");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> {
                    System.out.println("Nome classe: ");
                    String nomeClasse = scanner.next();
                    scuola.aggiungiClasse(new ClasseScolastica(nomeClasse));
                }
                case 2 -> {
                    System.out.println("Nome classe: ");
                    String nomeClasse = scanner.nextLine();
                    ClasseScolastica classe1 = scuola.cercaClasse(nomeClasse);
                    if (classe1 != null) {
                        System.out.println("Nome studente: ");
                        String nome = scanner.next();
                        System.out.println("Cognome studente: ");
                        String cognome = scanner.next();
                        System.out.println("Eta studente: ");
                        int eta = scanner.nextInt();
                        System.out.println("Matricola");
                        int matricola = scanner.nextInt();
                        classe1.aggiungiStudente(new Studente(matricola, nome, cognome, eta));
                    }
                }
                case 3 -> {
                    System.out.println("Nome classe: ");
                    String nomeClasse = scanner.nextLine();
                    ClasseScolastica classe1 = scuola.cercaClasse(nomeClasse);
                    if (classe1 != null) {
                        System.out.println("Nome docente: ");
                        String nome = scanner.next();
                        System.out.println("Cognome docente: ");
                        String cognome = scanner.next();
                        System.out.println("Eta docente: ");
                        int eta = scanner.nextInt();
                        System.out.println("Materia");
                        String materia = scanner.nextLine();
                        System.out.println("Stipendio");
                        double stipendio = scanner.nextInt();
                        classe1.aggiungiDocente(new Docente(materia, stipendio, nome, cognome, eta));
                    }
                }
                case 4 -> {
                    System.out.println("Inserisci il nome del docente: ");
                    String nomeDocente = scanner.nextLine();
                    Docente docente = scuola.cercaDocente(nomeDocente);
                    if(docente != null) {
                        classe.effettuaInterrogazione(docente);
                    }
                    else {
                        System.out.println("Docente non trovato");
                    }
                }
                case 5 -> {
                    scuola.riepilogo();
                }
                case 6 -> {
                    System.out.println("Inserisci il nome del docente: ");
                    String nomeDocente = scanner.nextLine();
                    Docente docente = scuola.cercaDocente(nomeDocente);
                    if(docente != null) {
                        docente.valutaPrestazione();
                    }
                    else {
                        System.out.println("Docente non trovato");
                    }
                }
                case 0 -> continua = false;
            }
        }

    }

}
