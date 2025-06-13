package Esame;
public class Voto {
    private String nomeMateria;
    private int valutazioneNumerica;

    public Voto(String nomeMateria, int valutazioneNumerica)
    {
        this.nomeMateria = nomeMateria;
        this.valutazioneNumerica = valutazioneNumerica;
    }

    public String getNomeMateria()
    {
        return nomeMateria;
    }

    public int getValutazioneNumerica()
    {
        return valutazioneNumerica;
    }

    public void setNomeMateria(String nomeMateria)
    {
    this.nomeMateria = nomeMateria;
    }

    public void setValutazioneNumerica(int valutazioneNumerica)
    {
        this.valutazioneNumerica = valutazioneNumerica;
    }
}