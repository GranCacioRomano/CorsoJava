import java.util.Scanner;

public class Calcolatrice {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Quanti calcoli vuoi fare?");
        int numeroCalcoli = scanner.nextInt();
        
        double[] risultati = new double[numeroCalcoli]; 
        double sommaTotale = 0;

        for (int i = 0; i < numeroCalcoli; i++) {
            System.out.println("Inserisci il primo numero:");
            double primoNumero = scanner.nextDouble();
            
            System.out.println("Inserisci il secondo numero:");
            double secondoNumero = scanner.nextDouble();
            
            System.out.println("Scegli l'operazione: +, -, *, /");
            String operazione = scanner.next();

            
            switch (operazione) {
                case "+":
                    risultati[i] = primoNumero + secondoNumero;
                    break;
                case "-":
                    risultati[i] = primoNumero - secondoNumero;
                    break;
                case "*":
                    risultati[i] = primoNumero * secondoNumero;
                    break;
                case "/":
                    if (secondoNumero != 0) {
                        risultati[i] = primoNumero / secondoNumero;
                    } else {
                        System.out.println("Errore: divisione per zero.");
                        risultati[i] = 0; 
                    }
                    break;
                default:
                    System.out.println("Operazione non valida.");
                    risultati[i] = 0; 
            }
            System.out.println("Risultato del calcolo " + (i + 1) + ": " + risultati[i]);
            sommaTotale += risultati[i];
        }
        
        System.out.println("Risultati dei calcoli:");
        for (int i = 0; i < risultati.length; i++) {
            System.out.println("Calcolo " + (i + 1) + ": " + risultati[i]);
        }
        
        System.out.println("Somma totale dei risultati: " + sommaTotale);
        
        scanner.close();
    }

}

