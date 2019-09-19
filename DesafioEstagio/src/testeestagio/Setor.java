/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.util.HashMap;

/**
 *
 * @author budi
 */
public class Setor {
    
    private int id;
    
    private String nome;
    
    private HashMap<String, Integer> vendaTotalPorMes;;

    public Setor(int id, String nome) {
        this.id = id;
        this.nome = nome;
        vendaTotalPorMes = new HashMap<String, Integer>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public HashMap<String, Integer> getVendaTotalNoSetor() {
        return vendaTotalPorMes;
    }
    
    public void somarVendaNoMes(String dataVenda, int valorDeVenda){
        
        if(this.vendaTotalPorMes.get(dataVenda) == null){
        
            this.vendaTotalPorMes.put(dataVenda, valorDeVenda);
        
        }else{
        
            int somaValorDeVenda = this.vendaTotalPorMes.get(dataVenda) + valorDeVenda;
                
            this.vendaTotalPorMes.put(dataVenda, somaValorDeVenda);
        
        }

    }
    
}
