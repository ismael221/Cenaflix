/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.util.Date;

/**
 *
 * @author ismael221
 */
public class Filme {
    
    private int id;
    private String nome;
    private Date datalancamento;
    private String Categoria;
    
    /**
     * Metodo de encapsulamento que
     * retorna o nome do objeto filme 
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo de encapsulamento que altera o valor da propriedade nome 
     * do obejto filme
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo de encapsulamento que retorna o valor da propriedade datalancamento
     * @return 
     */
    public Date getDatalancamento() {
        return datalancamento;
    }
    /**
     * Metodo de encapsulamento que altera o valor da propriedade datalancamento 
     * para o valor recebido por parametro
     * @param datalancamento 
     */
    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }
   /**
    * Metodo de encapsulamento que retorna a datalancamento da propriedade datalancamento
    * @return 
    */
    public String getCategoria() {
        return Categoria;
    }
    /**
     * Metodo que altera o valor da propriedade categoria para o valro recebido por parametro
     * @param Categoria 
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    /**
     * Metodo de encapsultamento que retorna o valor da propriedade categoria 
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo de encapsulamento que recebe por parametro o valor da propriedade id e faz a alteração
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *
     */
   
    
}
