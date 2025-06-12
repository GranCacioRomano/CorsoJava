import java.util.ArrayList;

public class Biblioteca {
     ArrayList<Libro> libri = new ArrayList<Libro>();
     
     public void aggiungiLibro(Libro libro) {
         libri.add(libro);
         System.out.println("Libro Aggiunto");
     }
     public void visualizzaLibri(){
         for (Libro libro : libri) {
             System.out.println(libro.toString());
         }
     }
     public void cercaLibro(String titolo){
         for (Libro libro : libri) {
             if (libro.getTitolo().equals(titolo)) {
                 System.out.println(libro.toString());
             }
         }
     }
     public void effettuaPrestito(Libro libro){
         libro.setNumeroCopie(libro.getNumeroCopie()-1);
     }
     public void restituisciLibro(Libro libro){
         libro.setNumeroCopie(libro.getNumeroCopie()+1);
     }
}
