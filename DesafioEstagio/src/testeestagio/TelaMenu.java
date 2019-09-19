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
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author budi
 */
public class TelaMenu extends JFrame{
    
    private JLabel insiraLocalContratos;
    
    private JLabel insiraLocalContatos;
    
    private JLabel insiraLocalEmpresas;
    
    private JLabel insiraLocalSetores;
    
    private JTextField localContratos;
    
    private JTextField localContatos;
    
    private JTextField localEmpresas;
    
    private JTextField localSetores;
    
    private JButton confirmar;
    
    private Container menu;
    
    private GerenciadorBotoes gerenciador = new GerenciadorBotoes();
            
    public TelaMenu(){
    
        super("MENU");
        
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        iniciarComponentes();
        
    }
    
    public void iniciarComponentes(){
        
        menu = getContentPane();
         
        menu.setLayout(new GridBagLayout());
        
        setSize(1080, 720);
        
        insiraLocalContratos = new JLabel("Insira o local da tabela de Contratos: ");
        
        insiraLocalContatos = new JLabel("Insira o local da tabela de Contatos: ");
        
        insiraLocalEmpresas = new JLabel("Insira o local da tabela de Empresas: ");
        
        insiraLocalSetores = new JLabel("Insira o local da tabela de Setores: ");
        
        localContratos = new JTextField(30);
        
        localContatos = new JTextField(30);
        
        localEmpresas = new JTextField(30);
        
        localSetores = new JTextField(30);
    
        confirmar = new JButton("Confirmar");
        
        confirmar.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.insets = new Insets(10, 10, 10, 10);
        
        menu.add(insiraLocalContratos, c);
        
        c.gridx = 1;
        
        menu.add(localContratos, c);
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        menu.add(insiraLocalContatos, c);
        
        c.gridx = 1;
        
        menu.add(localContatos, c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        menu.add(insiraLocalEmpresas, c);
        
        c.gridx = 1;
        
        menu.add(localEmpresas, c);
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        menu.add(insiraLocalSetores, c);
        
        c.gridx = 1;
        
        menu.add(localSetores, c);
        
        c.gridx = 1;
        
        c.gridy = 4;
        
        menu.add(confirmar, c);
 
        confirmar.addActionListener(gerenciador);
    
    }
    
    public void ligar(){   
        
        setVisible(true);
    
    }
    
    public void desligar(){
    
        setVisible(false);
    
    }
    
    private class GerenciadorBotoes implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            
            String contratos = localContratos.getText();
            
            String contatos = localContatos.getText();
            
            String empresas = localEmpresas.getText();
            
            String setores = localSetores.getText();
            
            Controlador.getInstancia().lerDadosEOrganizar(contratos, contatos, empresas, setores);
    
        }

    }
    
}
