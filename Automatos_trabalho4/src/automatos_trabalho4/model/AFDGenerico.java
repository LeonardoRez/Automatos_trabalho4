package automatos_trabalho4.model;

import java.util.ArrayList;

public class AFDGenerico {

    private Alfabeto alfabeto;
    private ArrayList<Estado> estados;
    private int inicial;
    private ArrayList<Integer> finais;

    public AFDGenerico() {
        alfabeto = new Alfabeto();
        estados = new ArrayList<>();
        inicial = 0;
        finais = new ArrayList<>();
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public void addFinal(int Q) {
        estados.get(Q).setFinal();
    }

    public void addEstado() {
        estados.add(new Estado(alfabeto));
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
            Estado Qo = estados.get(Qorigem);
            int i = 0;
            for (Simbolo a : alfabeto.getAlfabeto()) {
                if (s == a.getSimbolo()) {
                    break;
                }
                i++;
            }
            Estado Qd = estados.get(Qdestino);
            Qo.addTransicao(i, Qd);

        } else {
            System.out.println("Esse simbolo não faz parte do alfabeto!");
        }
    }

    public int funcTrans(int Q, Simbolo s) {
        return estados.get(Q).miniFT(s);
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
        for (int i : finais) {
            if (r == i) {
                return true;
            }
        }
        return false;
    }

}
