/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author budi
 */
public class TelaOpcoes extends JFrame{
    
    private JLabel tituloCriandoArquivoVendaPorMes;
    
    private JLabel tituloCriandoArquivoVendaPorContato;
    
    private JLabel tituloCriandoArquivoProporcaoSetor;
    
    private JLabel insiraNomeArquivoVendaPorContato;
    
    private JTextField nomeArquivoVendaPorContato;
    
    private JLabel insiraNomeArquivoVendaPorMes;
    
    private JTextField nomeArquivoVendaPorMes;
    
    private JLabel insiraAnoVendaPorMes;
    
    private JTextField anoVendaPorMes;
    
    private JLabel insiraNomeArquivoProporcaoSetorNoMes;
    
    private JTextField nomeArquivoProporcaoSetorNoMes;
    
    private JLabel insiraDataProporcaoSetorNoMes;
    
    private JTextField dataProporcaoSetorNoMes;
    
    private JPanel painelMenuOpcoes;
    
    private JPanel criandoArquivoVendaTotalPorMes;
    
    private JPanel criandoArquivoVendaPorContato;
    
    private JPanel criandoArquivoProporcaoSetor;
    
    private JButton menuVendaTotalPorMes;
    
    private JButton confirmarVendaTotalPorMes;
    
    private JButton menuVendaPorContato;
    
    private JButton confirmarVendaPorContato;
    
    private JButton menuProporcaoSetor;
    
    private JButton confirmarProporcaoSetor;
    
    private JButton voltar;
    
    private JButton voltar2;
    
    private JButton voltar3;
    
    private Container container;
    
    private TelaOpcoes.GerenciadorBotoes gerenciador = new TelaOpcoes.GerenciadorBotoes();
    
    public TelaOpcoes(){
    
        super("Opcoes");
        
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        container = getContentPane();
        
        container.setLayout(new GridBagLayout());
        
        setSize(1080,720);
        
        iniciarComponentesMenuOpcoes();
        
        iniciarComponentesVendaTotalPorMes();
        
        iniciarComponentesVendaPorContato();
        
        iniciarComponentesProporcaoSetor();
    
    }

    private void iniciarComponentesMenuOpcoes(){
        
        menuVendaTotalPorMes = new JButton("Criar Arquivo Venda Total Por Mes");
        
        menuVendaTotalPorMes.setActionCommand("Menu Abrir Venda Total Por Mes");
        
        menuVendaPorContato = new JButton("Criar Arquivo Venda Por Contato");
        
        menuVendaPorContato.setActionCommand("Menu Abrir Venda Por Contato");
        
        menuProporcaoSetor = new JButton("Criar Arquivo Proporcao de venda por setor");
        
        menuProporcaoSetor.setActionCommand("Menu Abrir Proporcao Por Setor");
        
        painelMenuOpcoes = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.insets = new Insets(10, 10, 10, 10);
        
        painelMenuOpcoes.add(menuVendaTotalPorMes, c);
        
        c.gridy = 1;
        
        painelMenuOpcoes.add(menuVendaPorContato, c);
        
        c.gridy = 2;
        
        painelMenuOpcoes.add(menuProporcaoSetor, c);

        c.gridy = 3;
        
        menuVendaTotalPorMes.addActionListener(gerenciador);
        
        menuVendaPorContato.addActionListener(gerenciador);
        
        menuProporcaoSetor.addActionListener(gerenciador);
    
    }
    
    private void iniciarComponentesVendaTotalPorMes() {
        
        tituloCriandoArquivoVendaPorMes = new JLabel("Criando Arquivo Base para Grafico de Venda por Mes");
        
        insiraNomeArquivoVendaPorMes = new JLabel("Insira o Nome Do Arquivo: ");
        
        nomeArquivoVendaPorMes = new JTextField(20);
        
        insiraAnoVendaPorMes = new JLabel("Insira o Ano: ");
    
        anoVendaPorMes = new JTextField(20);
        
        confirmarVendaTotalPorMes = new JButton("Confirmar gerar arquivo");
        
        confirmarVendaTotalPorMes.setActionCommand("Confirmar Venda Total Por Mes");
        
        voltar = new JButton("Voltar para Menu Opcoes");
        
        voltar.setActionCommand("Voltar");
        
        criandoArquivoVendaTotalPorMes = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.insets = new Insets(10, 10, 10, 10);
        
        criandoArquivoVendaTotalPorMes.add(tituloCriandoArquivoVendaPorMes, c);
        
        c.gridy = 1;
        
        criandoArquivoVendaTotalPorMes.add(insiraNomeArquivoVendaPorMes, c);
        
        c.gridx = 1;
        
        criandoArquivoVendaTotalPorMes.add(nomeArquivoVendaPorMes, c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        criandoArquivoVendaTotalPorMes.add(insiraAnoVendaPorMes, c);
        
        c.gridx = 1;
        
        criandoArquivoVendaTotalPorMes.add(anoVendaPorMes, c);  
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        criandoArquivoVendaTotalPorMes.add(confirmarVendaTotalPorMes, c);
        
        c.gridy = 4;
        
        criandoArquivoVendaTotalPorMes.add(voltar, c); 
        
        confirmarVendaTotalPorMes.addActionListener(gerenciador);
        
        voltar.addActionListener(gerenciador);
        
    }
    
    private void iniciarComponentesVendaPorContato() {
        
        tituloCriandoArquivoVendaPorContato = new JLabel("Criando Arquivo Base para Grafico de Venda por Contato");
        
        insiraNomeArquivoVendaPorContato = new JLabel("Insira o Nome Do Arquivo: ");
        
        nomeArquivoVendaPorContato = new JTextField(20);
        
        confirmarVendaPorContato = new JButton("Confirmar gerar arquivo");
        
        confirmarVendaPorContato.setActionCommand("Confirmar Venda Por Contato");
        
        voltar2 = new JButton("Voltar para Menu Opcoes");
        
        voltar2.setActionCommand("Voltar");
        
        criandoArquivoVendaPorContato = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.insets = new Insets(10, 10, 10, 10);
        
        criandoArquivoVendaPorContato.add(tituloCriandoArquivoVendaPorContato, c);
        
        c.gridy = 1;
        
        criandoArquivoVendaPorContato.add(insiraNomeArquivoVendaPorContato, c);
        
        c.gridx = 1;
        
        criandoArquivoVendaPorContato.add(nomeArquivoVendaPorContato, c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        criandoArquivoVendaPorContato.add(confirmarVendaPorContato, c);
        
        c.gridy = 3;
        
        criandoArquivoVendaPorContato.add(voltar2, c); 
        
        confirmarVendaPorContato.addActionListener(gerenciador);
        
        voltar2.addActionListener(gerenciador);
        
    }
    
    private void iniciarComponentesProporcaoSetor(){
        
        tituloCriandoArquivoProporcaoSetor = new JLabel("Criando lista de Proporcao do Setor Nas Vendas do Mes");
    
        insiraNomeArquivoProporcaoSetorNoMes = new JLabel("Insira o Nome Do Arquivo: ");
        
        nomeArquivoProporcaoSetorNoMes = new JTextField(20);
        
        insiraDataProporcaoSetorNoMes = new JLabel("Insira mes e ano em formato m/aaaa: ");
        
        dataProporcaoSetorNoMes = new JTextField(20);
        
        confirmarProporcaoSetor = new JButton("Confirmar gerar arquivo");
        
        confirmarProporcaoSetor.setActionCommand("Confirmar Proporcao Setor");
        
        voltar3 = new JButton("Voltar para Menu Opcoes");
        
        voltar3.setActionCommand("Voltar");
        
        criandoArquivoProporcaoSetor = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.insets = new Insets(10, 10, 10, 10);
        
        criandoArquivoProporcaoSetor.add(tituloCriandoArquivoProporcaoSetor, c);
        
        c.gridy = 1;
        
        criandoArquivoProporcaoSetor.add(insiraNomeArquivoProporcaoSetorNoMes, c);
        
        c.gridx = 1;
        
        criandoArquivoProporcaoSetor.add(nomeArquivoProporcaoSetorNoMes, c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        criandoArquivoProporcaoSetor.add(insiraDataProporcaoSetorNoMes, c);
        
        c.gridx = 1;
        
        criandoArquivoProporcaoSetor.add(dataProporcaoSetorNoMes, c); 
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        criandoArquivoProporcaoSetor.add(confirmarProporcaoSetor, c);
        
        c.gridy = 4;
        
        criandoArquivoProporcaoSetor.add(voltar3, c);
        
        confirmarProporcaoSetor.addActionListener(gerenciador);
        
        voltar3.addActionListener(gerenciador);
    
    }
    
    public void ligarPainelMenuOpcoes(){
        
        container.add(painelMenuOpcoes);
        
        setVisible(true);
    
    }
    
    public void ligarPainelVendaPorMes(){
        
        container.add(criandoArquivoVendaTotalPorMes);
        
        setVisible(true);
    
    }
    
    public void ligarPainelVendaPorContato(){
        
        container.add(criandoArquivoVendaPorContato);
        
        setVisible(true);
    
    }
    
    public void ligarPainelProporcaoSetor(){
        
        container.add(criandoArquivoProporcaoSetor);
        
        setVisible(true);
    
    }
    
    public void desligarPainelMenuOpcoes(){
    
        container.remove(painelMenuOpcoes);
        
        setVisible(false);
    
    }
    
    public void desligarPainelVendaPorMes(){
        
        container.remove(criandoArquivoVendaTotalPorMes);
        
        setVisible(false);
    
    }
    
    public void desligarPainelVendaPorContato(){
        
        container.remove(criandoArquivoVendaPorContato);
        
        setVisible(false);
    
    }
    
    public void desligarPainelProporcaoSetor(){
        
        container.remove(criandoArquivoProporcaoSetor);
        
        setVisible(false);
    
    }
    
    public String getNomeArquivoVendaPorMes(){
    
        return this.nomeArquivoVendaPorMes.getText();
    
    }
    
    public String getNomeArquivoVendaPorContato(){
    
        return this.nomeArquivoVendaPorContato.getText();
    
    }
    
    public String getNomeArquivoProporcaoSetor(){
    
        return this.nomeArquivoProporcaoSetorNoMes.getText();
    
    }
    
    public String getDataProporcaoSetorNoMes(){
    
        return this.dataProporcaoSetorNoMes.getText();
    
    }
    
    public String getAnoVendaNoMes(){
    
        return this.anoVendaPorMes.getText();
    
    }

    public void apagarVendaPorMes() {
        
        this.anoVendaPorMes.setText("");
        
        this.nomeArquivoVendaPorMes.setText("");
        
    }

    public void apagarVendaPorContato() {
        
        this.nomeArquivoVendaPorContato.setText("");
    }

    public void apagarProporcaoSetor() {
        
        this.dataProporcaoSetorNoMes.setText("");
        
        this.nomeArquivoProporcaoSetorNoMes.setText("");
        
    }

    private class GerenciadorBotoes implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            
            try {
                Controlador.getInstancia().realizarAcao(ae.getActionCommand());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }

    }
    
}
