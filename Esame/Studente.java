package Esame;

import java.util.ArrayList;

public class Studente extends Persona implements Valutabile {
    private int matricola;
    private ArrayList<Voto> listaVoti = new ArrayList<>();

    public Studente(int matricola, String nome, String cognome, int eta) {
        super(nome, cognome, eta);
        this.matricola = matricola;
    }

    public void aggiungiVoto(Voto voto) {
        listaVoti.add(voto);
    }

    public double mediaVoti() {
        if (listaVoti.isEmpty()) {
            return 0;
        } else {
            double somma = 0;
            for (Voto v : listaVoti) {
                somma += v.getValutazioneNumerica();
            }
            return somma / listaVoti.size();
        }
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    @Override
    public void valutaPrestazione() {
        double media = mediaVoti();

        if (media == 0) {
            System.out.println("Studente " + getNomeCompleto() + " non ha voti.");
        } else if (media >= 7) {
            System.out.println("Studente " + getNomeCompleto() + " valutato positivamente con media: " + media);
        } else {
            System.out.println("Studente " + getNomeCompleto() + " valutato negativamente con media: " + media);
        }
    }

    @Override
    public String descrizione() {
        return "Studente: " + getNomeCompleto() + ", Età: " + getEta() + ", Matricola: " + matricola + " Media Voti: "
                + mediaVoti();
    }

}
