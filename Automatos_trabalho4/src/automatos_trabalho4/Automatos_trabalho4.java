package automatos_trabalho4;

import automatos_trabalho4.model.AFDGenerico;
import automatos_trabalho4.model.Alfabeto;
import automatos_trabalho4.model.Estado;

public class Automatos_trabalho4 {
    public static void main(String[] args) {
        Alfabeto a = new Alfabeto("{a,b,c}");
        
        AFDGenerico AFD = new AFDGenerico(3,a);
       
        
        AFD.setTransicao(0, 'a', 1);
        AFD.setTransicao(0, 'b', 2);
        AFD.setTransicao(0, 'c', 2);
        AFD.setTransicao(1, 'a', 1);
        AFD.setTransicao(1, 'b', 1);
        AFD.setTransicao(1, 'c', 1);
        AFD.setTransicao(2, 'a', 2);
        AFD.setTransicao(2, 'b', 2);
        AFD.setTransicao(2, 'c', 2);
        
        AFD.setInicial(0);
        
        AFD.addFinal(1);
        
        AFD.listaFinais();
        
        AFD.listaEstados();
        
        if(AFD.fT_Estendida("ababbcacacacacab")){
            System.out.println("PALAVRA ACEITA");
        }else{
            System.out.println("DEU RUIM");
        }
        
    }
    
}
