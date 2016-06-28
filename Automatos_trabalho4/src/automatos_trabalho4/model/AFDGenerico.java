package automatos_trabalho4.model;

import java.util.ArrayList;

public class AFDGenerico {

    private Alfabeto alfabeto;
    private Estado[] estados;
    private int quantEstados;
    private int inicial;

    public AFDGenerico(int quant, Alfabeto a) {
        quantEstados = quant;
        this.alfabeto = a;
        estados = new Estado[quant];
        for (int i=0; i<quant;i++) {
            estados[i] = new Estado(alfabeto);
        }
        inicial = 0;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public void addFinal(int Q) {
        estados[Q].setFinal();
    }

    public void listaEstados() {
        System.out.println("------ESTADOS------");
        for (Estado e : estados) {
            System.out.println(e.toString());
        }
        System.out.println("------fim dos estados------");
    }

    public void listaFinais() {
        System.out.println("------ESTADOS FINAIS------");
        for (Estado e : estados) {
            if (e.isFinal()) {
                System.out.println(e.toString());
            }
        }
        System.out.println("------fim dos estados finais------");
    }

    public void setTransicao(int Qorigem, char s, int Qdestino) {

        if (alfabeto.temSimbolo(s)) {
            Estado Qo = estados[Qorigem];
            int i = 0;
            for (Simbolo a : alfabeto.getAlfabeto()) {
                if (s == a.getSimbolo()) {
                    break;
                }
                i++;
            }
            Estado Qd = estados[Qdestino];
            Qo.addTransicao(i, Qd);

        } else {
            System.out.println("Esse simbolo não faz parte do alfabeto!");
        }
    }

    public int funcTrans(int Q, Simbolo s) {
        return estados[Q].miniFT(s);
    }

    public int fT_Estendida(int Q, String w) {
        if (w.length() == 1) {
            return funcTrans(Q, new Simbolo(w.charAt(0)));
        }
        String temp = "" + w.charAt(w.length() - 1);//pegando ultimo caractere
        String resto = w.substring(0, w.length() - 1); //separando o resto para a 

        return fT_Estendida(fT_Estendida(Q, resto), temp);
    }

    public boolean fT_Estendida(String w) {
        int r = fT_Estendida(inicial, w);
        return estados[r].isFinal();
    }
}
