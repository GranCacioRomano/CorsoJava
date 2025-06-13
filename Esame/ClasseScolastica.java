package Esame;
import java.util.ArrayList;
import java.util.Random;

public class ClasseScolastica {

    private String nomeClasse;
    private ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
    private ArrayList<Docente> listaDocenti = new ArrayList<Docente>();

    public ClasseScolastica(String nomeClasse) 
    {
        this.nomeClasse = nomeClasse;
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

    public Docente cercaDocente(String nome)
    {
        for (Docente docente : listaDocenti)
        {
            if(nome.equalsIgnoreCase(nome))
            {
                return docente;
            }
        }
        return null;
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

    public double calcolaMediaGenerale()
    {
        double mediaTotale = 0;

        for(Studente studente : listaStudenti)
        {
            mediaTotale += studente.mediaVoti();
        }
        
        return mediaTotale / listaStudenti.size();
    }

    public String miglioreStudente()
    {
        double mediaMigliore = 0;
        String ris = "";

        for(Studente studente : listaStudenti)
        {
            if(studente.mediaVoti() > mediaMigliore)
            {
                mediaMigliore = studente.mediaVoti();
                ris = "Il miglior studente è " + studente.getNomeCompleto() + " con una media di " + mediaMigliore;
            }
        }

        return ris;
    }

    public String peggiorStudente()
    {
        double mediaPeggiore = 10;
        String ris = "";

        for(Studente studente : listaStudenti)
        {
            if(studente.mediaVoti() < mediaPeggiore)
            {
                mediaPeggiore = studente.mediaVoti();
                ris = "Il peggiore studente è" + studente.getNomeCompleto() + " con una media di " + mediaPeggiore;
            }
        }

        return ris;
    }

    public void effettuaInterrogazione(String materia)
    {
        Random random = new Random();
        
        int i = random.nextInt(listaStudenti.size());
        Studente studente = listaStudenti.get(i);

        int voto = random.nextInt(7) + 4;

        studente.aggiungiVoto(new Voto(materia, voto));

        System.out.println("Studente interrogato: " + studente.getNomeCompleto() + "\n" +
                           "Materia: "              + materia                    + "\n" + 
                           "Voto: "                 + voto);
    }

}
