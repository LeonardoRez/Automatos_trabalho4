package automatos_trabalho4.model;

import java.util.ArrayList;

public class Estado {

    private int ID;
    private static int contID; //armazena a quantidade de estados instanciados (static)
    private Alfabeto simbolos;
    public Estado[] transicoes;
    private boolean isFinal;

    public Estado(Alfabeto alfabeto) {
        ID = contID;
        contID++;
        this.simbolos = alfabeto;
        this.transicoes = new Estado[alfabeto.getAlfabeto().size()];
        
        this.isFinal = false;
    }

    public int getID() {
        return ID;
    }

    public Estado[] getTransicoes() {
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

    public void addTransicao(int pos, Estado q) {
        transicoes[pos] = q;
    }

    public int miniFT(Simbolo s) {
        int i;
        for (i = 0; i < simbolos.getAlfabeto().size(); i++) {
            if (simbolos.getAlfabeto().get(i).getSimbolo() == s.getSimbolo()) {
                break;
            }
        }
        return transicoes[i].getID();
    }

    public String toString() {
        return "Q" + ID;
    }

}
