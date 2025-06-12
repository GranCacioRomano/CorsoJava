import java.util.Random;

public class Arena {

    public static void main(String[] args) {

        Mostro[][] arena = new Mostro[5][5];
        
        Random random = new Random();
        
        Mostro m1 = new Mostro(100, 20, 0, 0);
        Mostro m2 = new Mostro(80, 30, 0, 0);

        int x1 = random.nextInt(5);
        int y1 = random.nextInt(5);

        int x2;
        int y2;

        do
        {  
            x2 = random.nextInt(5);
            y2 = random.nextInt(5);

        }while(x1 == x2 && y1 == y2);

        m1.setPosizione(x1,y1);
        m2.setPosizione(x2,y2);

        arena[x1][y1] = m1;
        arena[x2][y2] = m2;

        System.out.println("Mostro 1: " + m1.getVita() + " " + m1.getAttacco() + " " + m1.getPosizioneX() + " " + m1.getPosizioneY());
        System.out.println("Mostro 2: " + m2.getVita() + " " + m2.getAttacco() + " " + m2.getPosizioneX() + " " + m2.getPosizioneY());
        
        System.out.println("Inizio battaglia!");
        stampaArena(arena);

        for(int turno = 1; turno <= 5; turno++)
        {
            System.out.println("Turno " + turno);

            if(m1.eVivo())
            {
                m1.muovi(arena);

            }

            if(m2.eVivo())
            {
                m2.muovi(arena);
            }
            
            stampaArena(arena);
            if(sonoVicini(m1, m2))
            {
                if(m1.eVivo() && m2.eVivo())
                {
                    System.out.println("Battaglia!");
                    m1.subisceDanno(m2.getAttacco());
                    m2.subisceDanno(m1.getAttacco());
                }
            }
            if(!m1.eVivo() || !m2.eVivo())
            {
                break;
            }
        }
        System.out.println("Fine battaglia!");
        System.out.println("Mostro 1 vita: " + m1.getVita());
        System.out.println("Mostro 2 vita: " + m2.getVita());
        
        if(m1.getVita() > m2.getVita())
        {
            System.out.println("Ha vinto il mostro 1");
        }
        else if(m1.getVita() < m2.getVita())
        {
            System.out.println("Ha vinto il mostro 2");
        }
        else
        System.out.println("Pareggio!!!!!");
    }

    public static void stampaArena(Mostro[][] arena)
    {
        for (int i = 0; i < arena.length; i++) 
        {
            for (int j = 0; j < arena[i].length; j++) 
            {
                if(arena[i][j] == null)
                {
                    System.out.print("-- ");
                }
                else
                {
                    System.out.print("M  ");
                }
                
            }
            System.out.println();
        }
    }

    public static boolean sonoVicini(Mostro m1, Mostro m2)
    {
        int dx = Math.abs(m1.getPosizioneX() - m2.getPosizioneX());
        int dy = Math.abs(m1.getPosizioneY() - m2.getPosizioneY());

        return (dx + dy == 1);
    }
}
