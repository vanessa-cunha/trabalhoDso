/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author Will
 */
public class ProdutosLimpeza extends Produtos{
    
    public ProdutosLimpeza(String nome, double preco, int identificador, String descricao) {
        super(nome, preco, identificador, descricao);
        this.setor = "Limpeza";
    }
    
}
