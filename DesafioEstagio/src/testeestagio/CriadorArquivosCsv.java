/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author budi
 */
public class CriadorArquivosCsv {
            
    private static CriadorArquivosCsv instancia;
    
    private CriadorArquivosCsv(){
        
    }
    
    public static CriadorArquivosCsv getInstancia(){
    
        if(instancia == null){
        
            instancia = new CriadorArquivosCsv();
        
        }
        
        return instancia;
    
    }
    
    public void criarArquivoVendaPorContato(String nomeArquivo) throws Exception{
        
        PrintWriter writer = new PrintWriter(nomeArquivo + ".txt", "UTF-8");
        
        try{
        
            FileWriter fw = new FileWriter(nomeArquivo + ".txt", true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            PrintWriter pw = new PrintWriter(bw);
            
            for(int i = 1; i <= LeitorDadosTsv.getInstancia().getNumeroDeContatos(); i++){
            
                String nomeContato = OrganizadorDeDados.getInstancia().getContatos().get(i).getNome();
            
                int valorVendido = OrganizadorDeDados.getInstancia().getContatos().get(i).getValorTotalVendido();
            
                pw.println(nomeContato + "," + valorVendido);
            
            }
            
            pw.flush();
            
            pw.close();
            
            JOptionPane.showMessageDialog(null, "Salvo");
        
        }catch(HeadlessException | IOException e){
        
            JOptionPane.showMessageDialog(null, "Nao salvo");
        
        }
        
    }
    
    public void criarArquivoVendaTotalPorMes(String nomeArquivo, String ano) throws Exception{
        
        PrintWriter writer = new PrintWriter(nomeArquivo + ".txt", "UTF-8");
        
        try{
        
            FileWriter fw = new FileWriter(nomeArquivo + ".txt", true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            PrintWriter pw = new PrintWriter(bw);
            
            for(int i = 1; i <= 12; i++){
        
                String data = i + "/" + ano;
            
                String mes = numeroEmMes(i);

                int valorVendidoNoMes = 0;
            
                if(OrganizadorDeDados.getInstancia().getVendaTotalPorMes().get(data) != null){
            
                    valorVendidoNoMes = OrganizadorDeDados.getInstancia().getVendaTotalPorMes().get(data);
            
                }
            
                pw.println(mes + "," + valorVendidoNoMes);
        
            }
            
            pw.flush();
            
            pw.close();
            
            JOptionPane.showMessageDialog(null, "Salvo");
        
        }catch(HeadlessException | IOException e){
        
            JOptionPane.showMessageDialog(null, "Nao salvo");
        
        }
        
    }
    
    public void criarArquivoProporcaoSetorPorMes(String nomeArquivo, String data){
        
        try{
        
            PrintWriter writer = new PrintWriter(nomeArquivo + ".txt", "UTF-8");
        
            FileWriter fw = new FileWriter(nomeArquivo + ".txt", true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            PrintWriter pw = new PrintWriter(bw);
            
            for(int i = 1; i <= LeitorDadosTsv.getInstancia().getNumeroDeSetores(); i++){
        
                double proporcaoSetor = 0;

                String nomeSetor = OrganizadorDeDados.getInstancia().getSetores().get(i).getNome();

                if(OrganizadorDeDados.getInstancia().getSetores().get(i).getVendaTotalNoSetor().get(data) != null){

                    proporcaoSetor = (double)OrganizadorDeDados.getInstancia().getSetores().get(i).getVendaTotalNoSetor().get(data)/
                            
                            (double)OrganizadorDeDados.getInstancia().getVendaTotalPorMes().get(data);

                }

                pw.println(i + " " + nomeSetor + " " + proporcaoSetor);
        
            }
            
            pw.flush();
            
            pw.close();
            
            JOptionPane.showMessageDialog(null, "Salvo");
        
        }catch(HeadlessException | IOException e){
        
            JOptionPane.showMessageDialog(null, "Nao salvo");
        
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null, "Erro");
        
        }
        
    }
    
    public String numeroEmMes(int numero){
    
        switch(numero){
        
            case 1:
                
                return "Jan";
                
            case 2:
                
                return "Fev";
                
            case 3:
                
                return "Mar";
                
            case 4:
                
                return "Abr";
                
            case 5:
                
                return "Mai";
                
            case 6:
                
                return "Jun";
                
            case 7:
                
                return "Jul";
                
            case 8:
                
                return "Ago";
                
            case 9:
                
                return "Set";
                
            case 10:
                
                return "Out";
                
            case 11:
                
                return "Nov";
                
            case 12:
                
                return "Dez";
        
        }
        
        return "";
    
    }
    
}
