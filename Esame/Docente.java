package Esame;

import java.util.ArrayList;

public class Docente extends Persona implements Valutabile {
    private String materia;
    private double stipendio;
    private ArrayList<Integer> valutazioniAssegnate = new ArrayList<Integer>();

    public Docente(String materia, double stipendio, String nome, String cognome, int eta) {
        super(nome, cognome, eta);
        this.materia = materia;
        this.stipendio = stipendio;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public ArrayList<Integer> getValutazioniAssegnate() {
        return valutazioniAssegnate;
    }

    public void setValutazioniAssegnate(ArrayList<Integer> valutazioniAssegnate) {
        this.valutazioniAssegnate = valutazioniAssegnate;
    }

    public void aumentaStipendio() {
        stipendio += stipendio * 0.2;
    }

    public void assegnaVoto(Studente studente, int voto) {
        studente.aggiungiVoto(new Voto(materia, voto));
        valutazioniAssegnate.add(voto);
    }

    public double mediaVoti()
     {
        if (valutazioniAssegnate.isEmpty()) 
        {
            return 0;
        } 
        else
         {
            double somma = 0;
            for (int v : valutazioniAssegnate) 
            {
                somma += v;
            }
            return somma / valutazioniAssegnate.size();
        }
    }

    @Override
    public void valutaPrestazione() {
        if (valutazioniAssegnate.isEmpty()) {
            System.out.println("Non ci sono valutazioni assegnate");
        }

        int somma = 0;

        for (int v : valutazioniAssegnate) {
            somma += v;
        }

        double media = somma / valutazioniAssegnate.size();

        if (media > 7) {
            System.out.println("Docente " + getNomeCompleto() + " valutato positivamente con media: "
                    + String.format("%.2f", media));
            aumentaStipendio();
            System.out.println("Stipendio aumentato a " + String.format("%.2f", stipendio) + " euro");
        } else {
            System.out.println("Docente " + getNomeCompleto() + " non ha ricevuto aumento stipendio, media: "
                    + String.format("%.2f", media));
        }
    }

    @Override
    public String descrizione() {
        return "Docente: " + getNomeCompleto() + ", Materia: " + materia + ", Età: " + getEta() + ", Stipendio: "
                + stipendio + " euro";
    }
}
