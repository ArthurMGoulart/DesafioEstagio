/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author budi
 */
public class OrganizadorDeDados{
    
    private static OrganizadorDeDados instancia;
    
    private LeitorDadosTsv leitor = LeitorDadosTsv.getInstancia();
    
    private HashMap<Integer,Contato> contatos;
    
    private HashMap<Integer,Empresa> empresas;
    
    private HashMap<Integer,Contrato> contratos;
    
    private HashMap<Integer,Setor> setores;
    
    private HashMap<String, Integer> vendaTotalPorMes;
    
    private int linhaDescartadasDeContratos = 0;

    private OrganizadorDeDados(){
        
        this.contatos = new HashMap<>();
        
        this.empresas = new HashMap<>();
        
        this.contratos = new HashMap<>();
        
        this.setores = new HashMap<>();
        
        vendaTotalPorMes = new HashMap<>();
      
    }
    
    public static OrganizadorDeDados getInstancia(){
    
        if(instancia == null){
        
            instancia = new OrganizadorDeDados();
        
        }
        
        return instancia;
    
    }
    
    public void coletarInformacoesDosContratos(){
    
        for(int i = 1; i <= leitor.getNumeroDeContratos(); i++){
                        
            if(contratos.get(i).getContatoId() > leitor.getNumeroDeContatos() || contratos.get(i).getEmpresaId() > leitor.getNumeroDeEmpresas()){
            
                linhaDescartadasDeContratos++;
            
            }else{
            
                Contato contatoQueVendeu = contatos.get(contratos.get(i).getContatoId());

                Empresa empresaQueVendeu = empresas.get(contratos.get(i).getEmpresaId());
                
                Setor setorQueVendeu = setores.get(empresaQueVendeu.getChaveSetor());
                
                String dataVenda = contratos.get(i).getDataCriado();

                int valorDeVenda = contratos.get(i).getPreco();

                contatoQueVendeu.vendeu(valorDeVenda);

                if(vendaTotalPorMes.get(dataVenda) == null){

                    vendaTotalPorMes.put(dataVenda, valorDeVenda);

                }else{

                    int somaValorDeVenda = vendaTotalPorMes.get(dataVenda) + valorDeVenda;

                    vendaTotalPorMes.put(dataVenda, somaValorDeVenda);

                }

                empresaQueVendeu.somarVendaNoMes(dataVenda, valorDeVenda);
                
                setorQueVendeu.somarVendaNoMes(dataVenda, valorDeVenda);
                
            }
        }
    
    }

    public HashMap<Integer, Contato> getContatos() {
        
        return contatos;
        
    }

    public HashMap<Integer, Empresa> getEmpresas() {
        
        return empresas;
        
    }

    public HashMap<Integer, Contrato> getContratos() {
        
        return contratos;
        
    }

    public HashMap<Integer, Setor> getSetores() {
        
        return setores;
        
    }

    public HashMap<String, Integer> getVendaTotalPorMes() {
        
        return vendaTotalPorMes;
        
    }

    public int getLinhaDescartadasDeContratos() {
        
        return linhaDescartadasDeContratos;
        
    } 

    public void adicionarEmpresa(int id, Empresa empresa) {
        
        this.empresas.put(id, empresa);
        
    }

    public void adicionarContato(int id, Contato contato) {
        
        this.contatos.put(id, contato);
        
    }

    public void adicionarContrato(int id, Contrato contrato) {
        
        this.contratos.put(id, contrato);
        
    }

    public void adicionarSetor(int id, Setor setor) {
        
        this.setores.put(id, setor);
        
    }
    
}
