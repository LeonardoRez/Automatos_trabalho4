package automatos_trabalho4;

import automatos_trabalho4.model.AFDGenerico;
import automatos_trabalho4.model.Alfabeto;
import automatos_trabalho4.model.Estado;

public class Automatos_trabalho4 {
    public static void main(String[] args) {
        Alfabeto a = new Alfabeto("{a,b}");
        
        AFDGenerico AFD = new AFDGenerico();
        AFD.setAlfabeto(a);
        
        AFD.addEstado();
        AFD.addEstado();
        
        AFD.setTransicao(0, 'b', 0);
        AFD.setTransicao(0, 'a', 1);
        AFD.setTransicao(1, 'b', 0);
        AFD.setTransicao(1, 'a', 1);
        AFD.setInicial(0);
        
        AFD.addFinal(1);
        
        AFD.listaFinais();
        
        AFD.listaEstados();
        
    }
    
}
