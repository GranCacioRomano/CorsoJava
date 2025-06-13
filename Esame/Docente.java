package Esame;

public class Docente extends Persona implements Valutabile {
    private String materia;
    private int stipendio;


    public Docente(String materia, int stipendio, String nome, String cognome, int eta)
    {
        super(nome, cognome, eta);
        this.materia = materia;
        this.stipendio = stipendio;
    }

    public void aumentaStipendio()
    {
    }

    @Override
    public void valutaPrestazione() {
    }

    @Override
    public String descrizione() {
        return "Docente: " + getNomeCompleto() + ", Materia: " + materia + ", Età: " + getEta() + ", Stipendio: " + stipendio + " euro";
    }
}
