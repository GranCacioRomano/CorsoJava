package Esame;

import java.util.ArrayList;

public class Scuola {
    private String nome;
    private ArrayList<ClasseScolastica> classi = new ArrayList<>();
    public Scuola(String nome, ArrayList<ClasseScolastica> classi) {
        this.nome = nome;
        this.classi = classi;
    }

    public void aggiungiClasse(ClasseScolastica classe) {
        classi.add(classe);
    }

    public ClasseScolastica cercaClasse(String nomeClasse) {
        for (int i=0; i<classi.size(); i++) {
            if(classi.get(i).getNomeClasse().equals(nomeClasse)) {
                return classi.get(i);
            }
        }
        return null;
    }
    
    public void riepilogo() {
        for (int i=0; i<classi.size(); i++) {
            ClasseScolastica c = classi.get(i);
            System.out.println("Classe: " + c.getNomeClasse());
            System.out.println("Studenti: " + c.getListaStudenti().size());
            System.out.println("Docenti: " + c.getListaDocenti().size());
            System.out.println("Media Generale: " + c.calcolaMediaGenerale());   
        }
    }
}
