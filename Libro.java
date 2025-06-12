public class Libro {
    private String titolo;
    private String autore;
    private int annoPubblicazione;
    private int numeroCopie;

    public Libro(String titolo, String autore, int annoPubblicazione, int numeroCopie) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroCopie = numeroCopie;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroCopie() {
        return numeroCopie;
    }

    public void setNumeroCopie(int numeroCopie) {
        this.numeroCopie = numeroCopie;
    }

    @Override
    public String toString() {
        return "Libro [titolo =" + titolo + ", autore =" + autore + ", annoPubblicazione =" + annoPubblicazione
                + ", numeroCopie =" + numeroCopie + "]";
    }
}
