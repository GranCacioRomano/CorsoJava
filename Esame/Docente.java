package Esame;

import java.util.ArrayList;

public class Docente extends Persona implements Valutabile {
    private String materia;
    private double stipendio;
    private ArrayList<Integer> valutazioniAssegnate = new ArrayList<Integer>();


    public Docente(String materia, double stipendio, String nome, String cognome, int eta)
    {
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

    public void aumentaStipendio()
    { 
        stipendio += stipendio* 0.2;
    }

     public void assegnaVoto(Studente studente, int voto, String materia)
    {
        studente.aggiungiVoto(new Voto(materia, voto));
        valutazioniAssegnate.add(voto);
    }


    @Override
    public void valutaPrestazione() 
    {
       if(valutazioniAssegnate.isEmpty())
       {
           System.out.println("Non ci sono valutazioni assegnate");
       }
       
       int somma = 0;

       for(int v : valutazioniAssegnate)
       {
           somma += v;
       }

       double media = somma/valutazioniAssegnate.size();

       if(media > 7)
       {
           System.out.println("Il docente è stato valutato positivamente");
           aumentaStipendio();
           System.out.println("Stipendio aumentato" + stipendio);
       }
       else
       System.out.println("Nessun aumento dello stipendio");
    }

    @Override
    public String descrizione() {
        return "Docente: " + getNomeCompleto() + ", Materia: " + materia + ", Età: " + getEta() + ", Stipendio: " + stipendio + " euro";
    }
}
