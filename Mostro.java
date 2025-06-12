import java.util.Random;

public class Mostro {

    private int vita;
    private int attacco;
    private int posizioneX;
    private int posizioneY;

    public Mostro(int vita, int attacco, int posizioneX, int posizioneY) 
    {
        this.vita = vita;
        this.attacco = attacco;
        this.posizioneX = posizioneX;
        this.posizioneY = posizioneY;
    }

    public int getVita() 
    {
        return vita;
    }

    public void setVita(int vita) 
    {
        this.vita = vita;
    }

    public int getAttacco() 
    {
        return attacco;
    }

    public void setAttacco(int attacco) 
    {
        this.attacco = attacco;
    }

    public int getPosizioneX() 
    {
        return posizioneX;
    }

    public void setPosizione(int posizioneX, int posizioneY) 
    {
        this.posizioneX = posizioneX;
        this.posizioneY = posizioneY;
    }

    public int getPosizioneY() 
    {
        return posizioneY;
    }

    public void muovi(Mostro[][] arena) 
    {
       Random random = new Random();
       int[][] direzioni = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

       
       boolean mosso = false;
       int tentativi = 0;
       
       while(!mosso && tentativi < 4) 
       {
           int[] direzione = direzioni[random.nextInt(4)];
           int nuovaX = posizioneX + direzione[0];
           int nuovaY = posizioneY + direzione[1];
           
           if(nuovaX >= 0 && nuovaX < arena.length && nuovaY >= 0 && nuovaY < arena[0].length && arena[nuovaX][nuovaY] == null) 
           {
               arena[posizioneX][posizioneY] = null;
               arena[nuovaX][nuovaY] = this;
               setPosizione(nuovaX, nuovaY);

               System.out.println("Mostro mosso in posizione " + nuovaX + ", " + nuovaY);
               mosso = true;
            }
            tentativi++;
        }
        if(!mosso)
        {
            System.out.println("Mostro non mosso");
        }
    }

    public boolean eVivo()
    {
        return vita > 0;
    }
    
    public void subisceDanno(int danno)
    {
        vita -= danno;

        if(vita <= 0)
        {
            System.out.println("Mostro ucciso");
        }
    }
}
