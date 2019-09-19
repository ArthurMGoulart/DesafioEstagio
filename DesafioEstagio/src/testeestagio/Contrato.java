/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

/**
 *
 * @author budi
 */
public class Contrato{
    
    private int id;
    
    private String dataCriado;
    
    private int preco;
    
    private int contatoId;
    
    private int empresaId;

    public Contrato(int id, String dataCriado, int preco, int contatoId, int empresaId) {
        this.id = id;
        this.dataCriado = dataCriado;
        this.preco = preco;
        this.contatoId = contatoId;
        this.empresaId = empresaId;
    }

    public int getId() {
        return id;
    }

    public String getDataCriado() {
        return dataCriado;
    }

    public int getPreco() {
        return preco;
    }

    public int getContatoId() {
        return contatoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }
    
    public void setPreco(int preco){
    
        this.preco = preco;
    
    }
      
}

