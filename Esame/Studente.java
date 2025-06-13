package Esame;

import java.util.ArrayList;

public class Studente extends Persona implements Valutabile {
    private int matricola;
    private ArrayList<Voto> listaVoti = new ArrayList<>();

    public Studente(int matricola, String nome, String cognome, int eta)
    {
        super(nome, cognome, eta);
        this.matricola = matricola;
    }

    public void mediaVoti()
    {
        
    }

    public int getMatricola()
    {
        return matricola;
    }

    public void setMatricola(int matricola)
    {
        this.matricola = matricola;
    }

    @Override
    public void valutaPrestazione() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'valutaPrestazione'");
    }

    @Override
    public String descrizione() {
        return "Studente: " + getNomeCompleto() + ", Età: " + getEta() + ", Matricola: " + matricola;
    }

    
}
