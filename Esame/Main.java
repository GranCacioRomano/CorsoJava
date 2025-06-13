package Esame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scuola scuola = new Scuola(null, null);
        boolean continua = true;


        while (continua) {
            System.out.println("1. Aggiungi Classe");
            System.out.println("2. Aggiungi studente");
            System.out.println("3. Aggiungi docente");
            System.out.println("4. Interroga");
            System.out.println("5. Riepilogo");
            System.out.println("0. Esci");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                System.out.println("Nome classe: ");
                String nomeClasse = scanner.next();
                scuola.aggiungiClasse(new ClasseScolastica(nomeClasse));
                    break;
                case 2:
                    //scuola.aggiungiStudente();
                    break;
                case 3:
                    //scuola.aggiungiDocente();
                    break;
                case 4:
                    //scuola.interroga();
                    break;
                case 5:
                    //scuola.riepilogo();
                    break;
                case 0:
                    continua = false;
                    break;
            }
        }

    }

}
