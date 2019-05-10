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
abstract class Produtos {
    
    protected double preco;
    protected int identificador;
    protected String nome;
    protected String setor;
    protected String descricao;
    
    public Produtos( String nome,double preco, int identificador, String descricao){
        this.preco = preco;
        this.identificador = identificador;
        this.nome = nome;
        this.preco = preco;
 
    }
    
    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }
   

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the drescricao
     */
    public String getDrescricao() {
        return descricao;
    }

    /**
     * @param drescricao the drescricao to set
     */
    public void setDrescricao(String drescricao) {
        this.descricao = drescricao;
    }
    
       public void listaDaPadaria(String produto){ 
       this.nome = produto;
       ArrayList<String> listaProdutos = new ArrayList<>();
        listaProdutos.add(produto);

    System.out.println(listaProdutos);
   }
   
   public void precoDosProdutos(double preco){
       this.preco = preco;
       ArrayList<Double> precoDosProdutos = new ArrayList<>();  
       precoDosProdutos.add(preco);
       
       System.out.println(precoDosProdutos);
   }
   
       
}
