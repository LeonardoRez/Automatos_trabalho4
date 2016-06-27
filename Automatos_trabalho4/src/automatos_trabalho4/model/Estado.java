package automatos_trabalho4.model;

import java.util.ArrayList;

public class Estado {

    private int ID;
    private static int contID;
    private Alfabeto simbolos;
    public ArrayList<Estado> transicoes;
    private boolean isFinal;

    public Estado(Alfabeto alfabeto) {
        ID = contID;
        contID++;
        this.simbolos = alfabeto;
        this.transicoes = new ArrayList<>();
        this.isFinal = false;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<Estado> getTransicoes() {
        return transicoes;
    }

//    }
    public Alfabeto getSimbolos() {
        return simbolos;
    }

    public void setFinal() {
        this.isFinal = true;
    }

    public boolean isFinal() {
        return isFinal;
    }
    
    public void addTransicao(int pos, Estado q){
        transicoes.add(pos, q);
    }
    
    
    public int miniFT(Simbolo s) {
        int i;
        for (i = 0; i < simbolos.getAlfabeto().size(); i++) {
            if (simbolos.getAlfabeto().get(i).getSimbolo() == s.getSimbolo()) {
                break;
            }
        }
        return transicoes.get(i).getID();
    }
    public String toString(){
        return "Q"+ID;
    }

}
