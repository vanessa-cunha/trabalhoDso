/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.ArrayList;

/**
 *
 * @author Will
 */
public class SuperMercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
       ProdutosPadaria pao = new ProdutosPadaria("Pao", 0.4,1, "Pão de trigo" );
       ProdutosPadaria paoQueijo = new ProdutosPadaria("Pao de queijo", 0.8, 2, "Pão de queijo médio");
       ArrayList<Object> listaProdutos = new ArrayList<>();
       listaProdutos.add(pao);
       listaProdutos.add(paoQueijo);
       
        System.out.println(listaProdutos);
              
    }
    
}
