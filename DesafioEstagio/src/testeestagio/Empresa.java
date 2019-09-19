/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author budi
 */
public class Empresa {
    
    private int id;
    
    private String nome;
    
    private Date dataCriada;
    
    private String criadaPor;
    
    private String email;
    
    private String numeroCelular;
    
    private int idFuncionario;
    
    private String nomeFuncionario;
    
    private String responsavel;
    
    private int chaveSetor;

    private HashMap<String, Integer> vendaTotalPorMes;

    public Empresa(int id, String nome, Date dataCriada, String criadaPor, String email, String numeroCelular, int idFuncionario, String nomeFuncionario, String responsavel, int chaveSetor){
        this.id = id;
        this.nome = nome;
        this.dataCriada = dataCriada;
        this.criadaPor = criadaPor;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.responsavel = responsavel;
        this.chaveSetor = chaveSetor;    
        this.vendaTotalPorMes = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataCriada() {
        return dataCriada;
    }

    public String getCriadaPor() {
        return criadaPor;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public int getChaveSetor() {
        return chaveSetor;
    }

    public HashMap<String, Integer> getVendaTotalPorMes(){
        
        return vendaTotalPorMes;
        
    }

    public void somarVendaNoMes(String dataVenda, int valorDeVenda) {
        
        if(this.vendaTotalPorMes.get(dataVenda) == null){
        
            this.vendaTotalPorMes.put(dataVenda, valorDeVenda);
        
        }else{
        
            int somaValorDeVenda = this.vendaTotalPorMes.get(dataVenda) + valorDeVenda;
                
            this.vendaTotalPorMes.put(dataVenda, somaValorDeVenda);
        
        }
        
    }
    
}
