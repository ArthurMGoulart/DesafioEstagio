/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author budi
 */
public class Controlador{

    private static Controlador instancia;

    private TelaMenu telaMenu;
    
    private TelaOpcoes telaOpcoes;
    
    private LeitorDadosTsv leitor = LeitorDadosTsv.getInstancia();
    
    private OrganizadorDeDados organizador = OrganizadorDeDados.getInstancia();
    
    private CriadorArquivosCsv criador = CriadorArquivosCsv.getInstancia();
    
    private Controlador() {
        
        this.telaMenu = new TelaMenu();
        
        this.telaOpcoes = new TelaOpcoes();
        
    }
    
    public static Controlador getInstancia(){
    
        
        if(instancia == null){
        
            instancia = new Controlador();
            
        }
        
        return instancia;
    
    }

    public void iniciarTela() {
       
        this.telaMenu.ligar();
        
    }

    public void lerDadosEOrganizar(String contratos, String contatos, String empresas, String setores){
        
        try{
        
            leitor.lerContratos(contratos);

            leitor.lerContatos(contatos);

            leitor.lerEmpresas(empresas);

            leitor.lerSetores(setores);
        
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
        
        organizador.coletarInformacoesDosContratos();
        
        JOptionPane.showMessageDialog(null, "Dados Processados!");
        
        this.telaMenu.desligar();
        
        iniciarTelaOpcoes();
        
    }

    private void iniciarTelaOpcoes() {
        
        this.telaOpcoes.ligarPainelMenuOpcoes();
        
    }

    public void colocarEmpresa(int id, Empresa empresa) {
        
        this.organizador.adicionarEmpresa(id, empresa);
        
    }

    public void colocarContato(int id, Contato contato) {
        
        this.organizador.adicionarContato(id, contato);
        
    }

    public void colocarContrato(int id, Contrato contrato) {
        
        this.organizador.adicionarContrato(id, contrato);
        
    }

    public void colocarSetor(int id, Setor setor) {
        
        this.organizador.adicionarSetor(id, setor);
        
    }

    public void realizarAcao(String actionCommand) throws Exception {
        
        switch(actionCommand){
        
            case "Menu Abrir Venda Total Por Mes":
                
                this.telaOpcoes.desligarPainelMenuOpcoes();
                
                this.telaOpcoes.ligarPainelVendaPorMes();
                
                break;
                
            case "Menu Abrir Venda Por Contato":
                
                this.telaOpcoes.desligarPainelMenuOpcoes();
                
                this.telaOpcoes.ligarPainelVendaPorContato();
        
                break;
            
            case "Menu Abrir Proporcao Por Setor":
                
                this.telaOpcoes.desligarPainelMenuOpcoes();
                
                this.telaOpcoes.ligarPainelProporcaoSetor();
                
                break;
                
            case "Confirmar Venda Total Por Mes":
                
                this.telaOpcoes.desligarPainelVendaPorMes();
                
                this.telaOpcoes.ligarPainelMenuOpcoes();
                
                this.criador.criarArquivoVendaTotalPorMes(this.telaOpcoes.getNomeArquivoVendaPorMes(), this.telaOpcoes.getAnoVendaNoMes());
                
                this.telaOpcoes.apagarVendaPorMes();
                
                break;
                
            case "Confirmar Venda Por Contato":
                
                this.telaOpcoes.desligarPainelVendaPorContato();
                
                this.telaOpcoes.ligarPainelMenuOpcoes();
                
                this.criador.criarArquivoVendaPorContato(this.telaOpcoes.getNomeArquivoVendaPorContato());
                
                this.telaOpcoes.apagarVendaPorContato();
                
                break;
                
            case "Confirmar Proporcao Setor":
                
                this.telaOpcoes.desligarPainelProporcaoSetor();
                
                this.telaOpcoes.ligarPainelMenuOpcoes();
                
                this.criador.criarArquivoProporcaoSetorPorMes(this.telaOpcoes.getNomeArquivoProporcaoSetor(), this.telaOpcoes.getDataProporcaoSetorNoMes());
                
                this.telaOpcoes.apagarProporcaoSetor();
                
            case "Voltar":
                
                this.telaOpcoes.desligarPainelProporcaoSetor();
                
                this.telaOpcoes.desligarPainelVendaPorContato();
                
                this.telaOpcoes.desligarPainelVendaPorMes();
                
                this.telaOpcoes.ligarPainelMenuOpcoes();
                
                break;
                
        }
        
    }

}
