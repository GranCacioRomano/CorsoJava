import java.util.ArrayList;

public class Biblioteca {
     ArrayList<Libro> libri = new ArrayList<Libro>();
     
     public void aggiungiLibro(Libro libro) {
         libri.add(libro);
     }
     public void visualizzaLibri(){
         for (Libro libro : libri) {
             System.out.println(libro.toString());
         }
     }
     public Libro cercaLibro(String titolo){
         for (Libro libro : libri) {
             if (libro.getTitolo().equals(titolo)) {
                 return libro;
             }
            }
            return null;
     }
     public boolean effettuaPrestito(String titolo) {
        Libro libro = cercaLibro(titolo);
        if (libro != null && libro.getNumeroCopie() > 0) {
            libro.setNumeroCopie(libro.getNumeroCopie() - 1);
            return true;
        }
        return false;
    }

    // Bonus: ritorna libro
    public boolean ritornaLibro(String titolo) {
        Libro libro = cercaLibro(titolo);
        if (libro != null) {
            libro.setNumeroCopie(libro.getNumeroCopie() + 1);
            return true;
        }
        return false;
    }
}
