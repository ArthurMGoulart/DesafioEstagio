    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.util.Date;

/**
 *
 * @author budi
 */
public class Contato {
    
    private int id;
    
    private String nome;
    
    private Date dataCriado;
    
    private String criadoPor;
    
    private String email;

    private String numeroCelular;
    
    private String contatoPorFuncionario;
    
    private int funcionarioId;
    
    private String endereco;
    
    private String cordenadas;
    
    private String responsavel;
    
    private int numeroDeVendas = 0;
    
    private int valorTotalVendido = 0;

    public Contato(int id, String nome, Date dataCriado, String criadoPor, String email, String numeroCelular, String contatoPorFuncionario, int funcionarioId, String endereco, String cordenadas, String responsavel) {
        this.id = id;
        this.nome = nome;
        this.dataCriado = dataCriado;
        this.criadoPor = criadoPor;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.contatoPorFuncionario = contatoPorFuncionario;
        this.funcionarioId = funcionarioId;
        this.endereco = endereco;
        this.cordenadas = cordenadas;
        this.responsavel = responsavel;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getContatoPorFuncionario() {
        return contatoPorFuncionario;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCordenadas() {
        return cordenadas;
    }

    public String getResponsavel() {
        return responsavel;
    }
    
    public int getNumeroDeVendas(){
    
        return this.numeroDeVendas;
    
    }
    
    public void vendeu(int valor){
    
        this.numeroDeVendas++;
        
        this.valorTotalVendido+= valor;
    
    }
    
    public int getValorTotalVendido(){
    
        return this.valorTotalVendido;
    
    }      
    
}
