package Esame;

import java.util.ArrayList;

public class Scuola {
    private String nomeScuola;
    private ArrayList<ClasseScolastica> listaClassi;

    public Scuola(String nomeScuola) {
        this.nomeScuola = nomeScuola;
        this.listaClassi = new ArrayList<>();
    }

    public void aggiungiClasse(ClasseScolastica classe) {
        listaClassi.add(classe);
    }

    public ClasseScolastica cercaClasse(String nomeClasse) {
        for (ClasseScolastica classe : listaClassi) {
            if (classe.getNomeClasse().equalsIgnoreCase(nomeClasse)) {
                return classe;
            }
        }
        return null;
    }

    public Docente cercaDocente(String nome, String cognome) {
        for (ClasseScolastica classe : listaClassi) {
            for (Docente docente : classe.getListaDocenti()) {
                if (docente.getNome().equalsIgnoreCase(nome) && docente.getCognome().equalsIgnoreCase(cognome)) {
                    return docente;
                }
            }
        }
        return null;
    }

    public Studente cercaStudente(String nome, String cognome) {
        for (ClasseScolastica classe : listaClassi) {
            for (Studente studente : classe.getListaStudenti()) {
                if (studente.getNome().equalsIgnoreCase(nome) && studente.getCognome().equalsIgnoreCase(cognome)) {
                    return studente;
                }
            }
        }
        return null;
    }

    public void riepilogo() {
        System.out.println("Riepilogo scuola: " + nomeScuola);
        for (ClasseScolastica classe : listaClassi) {
            System.out.println("Classe: " + classe.getNomeClasse());
            System.out.println(classe.miglioreStudente());
            System.out.println(classe.peggiorStudente());
            System.out.println("Media generale: " + String.format("%.2f", classe.calcolaMediaGenerale()));
            System.out.println();
        }
    }
}
