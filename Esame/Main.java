package Esame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome scuola: ");
        String nomeScuola = scanner.nextLine();
        Scuola scuola = new Scuola(nomeScuola);

        ClasseScolastica classe1 = new ClasseScolastica("5A");

        Studente s1 = new Studente(1001, "Mario", "Rossi", 18);
        s1.aggiungiVoto(new Voto("Matematica", 8));
        s1.aggiungiVoto(new Voto("Italiano", 7));

        Studente s2 = new Studente(1002, "Luca", "Bianchi", 17);
        s2.aggiungiVoto(new Voto("Matematica", 6));
        s2.aggiungiVoto(new Voto("Italiano", 9));

        Studente s3 = new Studente(1003, "Anna", "Verdi", 18);
        s3.aggiungiVoto(new Voto("Matematica", 9));
        s3.aggiungiVoto(new Voto("Italiano", 8));

        classe1.aggiungiStudente(s1);
        classe1.aggiungiStudente(s2);
        classe1.aggiungiStudente(s3);

        Docente d1 = new Docente("Matematica", 1500.0, "Giuseppe", "Neri", 45);
        Docente d2 = new Docente("Italiano", 1400.0, "Laura", "Gialli", 38);

        classe1.aggiungiDocente(d1);
        classe1.aggiungiDocente(d2);

        scuola.aggiungiClasse(classe1);
        boolean continua = true;

        while (continua) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi Classe");
            System.out.println("2. Aggiungi Studente");
            System.out.println("3. Aggiungi Docente");
            System.out.println("4. Effettua Interrogazione");
            System.out.println("5. Riepilogo Scuola");
            System.out.println("6. Gestione valutazione Docente");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = -1;
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
            }
            scanner.nextLine();

            switch (scelta) {
                case 1 -> {
                    System.out.print("Nome classe: ");
                    String nomeClasse = scanner.nextLine();
                    scuola.aggiungiClasse(new ClasseScolastica(nomeClasse));
                    System.out.println("Classe aggiunta.");
                    // sout delle classi presenti nella scuola.
                }
                case 2 -> {
                    System.out.print("Nome classe: ");
                    String nomeClasse = scanner.nextLine();
                    ClasseScolastica classe = scuola.cercaClasse(nomeClasse);
                    if (classe != null) {
                        System.out.print("Nome studente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Cognome studente: ");
                        String cognome = scanner.nextLine();
                        System.out.print("Età studente: ");
                        int eta = scanner.nextInt();
                        System.out.print("Matricola studente: ");
                        int matricola = scanner.nextInt();
                        scanner.nextLine(); // Consuma invio
                        Studente studente = new Studente(matricola, nome, cognome, eta);
                        classe.aggiungiStudente(studente);
                        System.out.println("Studente aggiunto.");
                    } else {
                        System.out.println("Classe non trovata.");
                    }
                }
                case 3 -> {
                    System.out.print("Nome classe: ");
                    String nomeClasse = scanner.nextLine();
                    ClasseScolastica classe = scuola.cercaClasse(nomeClasse);
                    if (classe != null) {
                        System.out.print("Nome docente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Cognome docente: ");
                        String cognome = scanner.nextLine();
                        System.out.print("Età docente: ");
                        int eta = scanner.nextInt();
                        scanner.nextLine(); // Consuma invio
                        System.out.print("Materia docente: ");
                        String materia = scanner.nextLine();
                        System.out.print("Stipendio docente: ");
                        double stipendio = scanner.nextDouble();
                        scanner.nextLine(); // Consuma invio
                        Docente docente = new Docente(materia, stipendio, nome, cognome, eta);
                        classe.aggiungiDocente(docente);
                        System.out.println("Docente aggiunto.");
                    } else {
                        System.out.println("Classe non trovata.");
                    }
                }
                case 4 -> {
                    System.out.print("Nome classe: ");
                    String nomeClasse = scanner.nextLine();
                    ClasseScolastica classe = scuola.cercaClasse(nomeClasse);
                    if (classe != null) {
                        System.out.print("Materia per interrogazione: ");
                        String materia = scanner.nextLine();
                        classe.effettuaInterrogazione(materia);
                    } else {
                        System.out.println("Classe non trovata.");
                    }
                }
                case 5 -> {
                    scuola.riepilogo();
                }
                case 6 -> {
                    System.out.print("Nome docente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cognome docente: ");
                    String cognome = scanner.nextLine();
                    Docente docente = scuola.cercaDocente(nome, cognome);
                    if (docente != null) {
                        docente.valutaPrestazione();
                    } else {
                        System.out.println("Docente non trovato.");
                    }
                }
                case 0 -> {
                    System.out.println("Arrivederci!");
                    continua = false;
                }
                default -> System.out.println("Scelta non valida.");
            }
        }
        scanner.close();
    }
}
