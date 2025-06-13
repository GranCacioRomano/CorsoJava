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
        if(listaStudenti.isEmpty())
            return 0;

        double mediaTotale = 0;

        for(Studente studente : listaStudenti)
        {
            mediaTotale += studente.mediaVoti();
        }
        
        return mediaTotale / listaStudenti.size();
    }

    public String miglioreStudente()
    {
        if(listaStudenti.isEmpty())
            return "Nessun studente presente";

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
         if(listaStudenti.isEmpty())
            return "Nessun studente presente";

        double mediaPeggiore = 10;
        String ris = "";

        for(Studente studente : listaStudenti)
        {
            if(studente.mediaVoti() < mediaPeggiore)
            {
                mediaPeggiore = studente.mediaVoti();
                ris = "Il peggiore studente è " + studente.getNomeCompleto() + " con una media di " + mediaPeggiore;
            }
        }

        return ris;
    }

     public String miglioreDocente()
    {
        if(listaDocenti.isEmpty())
            return "Nessun docente presente";

        double mediaMigliore = 0;
        String ris = "";

        for(Docente docente : listaDocenti)
        {
            if(docente.mediaVoti() > mediaMigliore)
            {
                mediaMigliore = docente.mediaVoti();
                ris = "Il miglior studente è " + docente.getNomeCompleto() + " con una media di " + mediaMigliore;
            }
        }

        return ris;
    }

    public String peggiorDocente()
    {
         if(listaDocenti.isEmpty())
            return "Nessun docente presente";

        double mediaPeggiore = 10;
        String ris = "";

        for(Docente docente : listaDocenti)
        {
            if(docente.mediaVoti() < mediaPeggiore)
            {
                mediaPeggiore = docente.mediaVoti();
                ris = "Il peggiore docente è " + docente.getNomeCompleto() + " con una media di " + mediaPeggiore;
            }
        }

        return ris;
    }

   public void effettuaInterrogazione(String materia) 
   {
        Docente docenteMateria = null;

        for (Docente d : listaDocenti) 
        {
            if (d.getMateria().equalsIgnoreCase(materia)) 
            {
                docenteMateria = d;
                break;
            }
        }

        if (docenteMateria == null) 
        {
            System.out.println("Docente per la materia " + materia + " non trovato.");
            return;
        }

        if (listaStudenti.isEmpty())
        {
            System.out.println("Nessuno studente nella classe.");
            return;
        }

        Random rand = new Random();
        Studente studenteInterrogato = listaStudenti.get(rand.nextInt(listaStudenti.size()));
        int voto = rand.nextInt(7) + 4; 

        System.out.println("Studente interrogato: " + studenteInterrogato.getNomeCompleto());
        System.out.println("Docente " + docenteMateria.getNomeCompleto() + " assegna voto " + voto);

        docenteMateria.assegnaVoto(studenteInterrogato, voto);
    }
    
}
