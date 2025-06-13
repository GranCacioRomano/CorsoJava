package Esame;
import java.util.ArrayList;
import java.util.Random;

public class ClasseScolastica {

    private String nomeClasse;
    private ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
    private ArrayList<Docente> listaDocenti = new ArrayList<Docente>();

    public ClasseScolastica(String nomeClasse, ArrayList<Studente> listaStudenti, ArrayList<Docente> listaDocenti) 
    {
        this.nomeClasse = nomeClasse;
        this.listaStudenti = listaStudenti;
        this.listaDocenti = listaDocenti;
    }

    public String getNomeClasse() 
    {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse)
     {
        this.nomeClasse = nomeClasse;
    }

    public ArrayList<Studente> getListaStudenti() 
    {
        return listaStudenti;
    }

    public void setListaStudenti(ArrayList<Studente> listaStudenti) 
    {
        this.listaStudenti = listaStudenti;
    }

    public ArrayList<Docente> getListaDocenti()
    {
        return listaDocenti;
    }

    public void setListaDocenti(ArrayList<Docente> listaDocenti)
    {
        this.listaDocenti = listaDocenti;
    }

    public void aggiungiStudente(Studente studente)
    {
        listaStudenti.add(studente);
    }

    public void rimuoviStudente(Studente studente)
    {
        listaStudenti.remove(studente);
        System.out.println("Studente rimosso correttamente");
    }

    public void aggiungiDocente(Docente docente)
    {
        listaDocenti.add(docente);
    }

    public void rimuoviDocente(Docente docente)
    {
        listaDocenti.remove(docente);
        System.out.println("Docente rimosso correttamente");
    }

    // extra: stampa orario, 

    // Media generale
    public double calcolaMediaGenerale()
    {
        double mediaTotale = 0;

        for(Studente studente : listaStudenti)
        {
            mediaTotale += studente.calcolaMedia();
        }
        
        return mediaTotale / listaStudenti.size();
    }

    // Migliore studente
    public String miglioreStudente(ArrayList<Studente> listaStudenti)
    {
        double mediaMigliore = 0;
        String ris;

        for(Studente studente : listaStudenti)
        {
            if(studente.calcolaMedia() > mediaMigliore)
            {
                mediaMigliore = studente.calcolaMedia();
                ris = "Il miglior studente è " + studente.getNomeCompleto() + " con una media di " + mediaMigliore;
            }
        }

        return ris;
    }

    // Peggiore studente
    public String peggiorStudente(ArrayList<Studente> listaStudenti)
    {
        double mediaPeggiore = 10;
        String ris;

        for(Studente studente : listaStudenti)
        {
            if(studente.calcolaMedia() < mediaPeggiore)
            {
                mediaPeggiore = studente.calcolaMedia();
                ris = "Il peggiore studente è" + studente.getNomeCompleto() + " con una media di " + mediaPeggiore;
            }
        }

        return ris;
    }

    // Effettua Interrogazione
    public void effettuaInterrogazione(ArrayList<Studente> listaStudenti, String materia)
    {
        Random random = new Random();
        
        int i = random.nextInt(listaStudenti.size());
        Studente studente = listaStudenti.get(i);

        int voto = random.nextInt(7) + 4;

        studente.aggiungiVoto(materia, voto);

        System.out.println("Studente interrogato: " + studente.getNomecompleto() + "\n" +
                           "Materia: "              + materia                    + "\n" + 
                           "Voto: "                 + voto);
    }

    
}
