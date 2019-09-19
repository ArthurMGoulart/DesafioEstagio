/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeestagio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class LeitorDadosTsv{
    
    private int numeroDeContratos = 0;
    
    private int numeroDeEmpresas = 0;
    
    private int numeroDeContatos = 0;
    
    private int numeroDeSetores = 0;
    
    private static LeitorDadosTsv instancia;
    
    private LeitorDadosTsv(){
    
    
    }
    
    public static LeitorDadosTsv getInstancia(){
    
        if(instancia == null){
        
            instancia = new LeitorDadosTsv();
        
        }
        
        return instancia;
    
    }
    
    public void lerContratos(String localArquivo) throws IOException{

        StringTokenizer st;
        
        BufferedReader TSVFile = new BufferedReader(new FileReader(localArquivo));
        
        String dadosLinha = TSVFile.readLine();
        
        dadosLinha = TSVFile.readLine();

        while (dadosLinha != null){
            
            st = new StringTokenizer(dadosLinha,"\t");
            
            List<String>dadosContrato = new ArrayList<String>();
            
            while(st.hasMoreElements()){
                
                dadosContrato.add(st.nextElement().toString());
                
            }
            
            int id = Integer.parseInt(dadosContrato.get(0));

            String data = ajustarData(dadosContrato.get(1));

            int preco = Integer.parseInt(dadosContrato.get(2));

            int contatoId = Integer.parseInt(dadosContrato.get(3));

            int empresaId = Integer.parseInt(dadosContrato.get(4));

            Contrato contrato = new Contrato(id, data, preco, contatoId, empresaId);
            
            Controlador.getInstancia().colocarContrato(id, contrato);

            dadosLinha = TSVFile.readLine(); // Read next line of data.
            
            numeroDeContratos++;
            
        }
        
        TSVFile.close();

    }
    
    public void lerContatos(String localArquivo) throws IOException, ParseException{

        StringTokenizer st;
        
        BufferedReader TSVFile = new BufferedReader(new FileReader(localArquivo));
        
        String dadosLinha = TSVFile.readLine();
        
        dadosLinha = TSVFile.readLine();

        while (dadosLinha != null){
            
            st = new StringTokenizer(dadosLinha,"\t");
            
            List<String>dadosContrato = new ArrayList<String>();
            
            while(st.hasMoreElements()){
                
                dadosContrato.add(st.nextElement().toString());
                
            }
            
            int id = Integer.parseInt(dadosContrato.get(0));

            String nome = dadosContrato.get(1);

            Date dataCriado = new SimpleDateFormat("dd/MM/yyyy").parse(dadosContrato.get(2));

            String criadoPor = dadosContrato.get(3);

            String email = dadosContrato.get(4);

            String numeroCelular = dadosContrato.get(5);

            String contatoPorFuncionario = dadosContrato.get(6);

            int funcionarioId = Integer.parseInt(dadosContrato.get(7));

            String endereco = dadosContrato.get(8);

            String cordenadas = dadosContrato.get(9);

            String responsavel = dadosContrato.get(10);

            Contato contato = new Contato(id, nome, dataCriado, criadoPor, email, numeroCelular, contatoPorFuncionario,
                              funcionarioId, endereco, cordenadas, responsavel);

            Controlador.getInstancia().colocarContato(id, contato);

            dadosLinha = TSVFile.readLine(); // Read next line of data.
            
            numeroDeContatos++;
            
        }
        
        TSVFile.close();
        
    }
    
    public void lerEmpresas(String localArquivo) throws IOException, ParseException{

        StringTokenizer st;
        
        BufferedReader TSVFile = new BufferedReader(new FileReader(localArquivo));
        
        String dadosLinha = TSVFile.readLine();
        
        dadosLinha = TSVFile.readLine();

        while (dadosLinha != null){
            
            st = new StringTokenizer(dadosLinha,"\t");
            
            List<String>dadosContrato = new ArrayList<String>();
            
            while(st.hasMoreElements()){
                
                dadosContrato.add(st.nextElement().toString());
                
            }
            
            int id = Integer.parseInt(dadosContrato.get(0));
                
            String nome = dadosContrato.get(1);
                
            Date dataCriada = new SimpleDateFormat("dd/MM/yyyy").parse(dadosContrato.get(2));
    
            String criadaPor = dadosContrato.get(3);
    
            String email = dadosContrato.get(4);
    
            String numeroCelular = dadosContrato.get(5);
    
            int idFuncionario = Integer.parseInt(dadosContrato.get(6));
    
            String nomeFuncionario = dadosContrato.get(7);
    
            String responsavel = dadosContrato.get(8);
    
            int chaveSetor = Integer.parseInt(dadosContrato.get(9));
                
            Empresa empresa = new Empresa(id, nome, dataCriada, criadaPor, email, numeroCelular, idFuncionario, nomeFuncionario, responsavel, chaveSetor);

            Controlador.getInstancia().colocarEmpresa(id, empresa);

            dadosLinha = TSVFile.readLine(); // Read next line of data.
            
            numeroDeEmpresas++;
            
        }
        
        TSVFile.close();

    }
    
    public void lerSetores(String localArquivo) throws IOException{

        StringTokenizer st;
        
        BufferedReader TSVFile = new BufferedReader(new FileReader(localArquivo));
        
        String dadosLinha = TSVFile.readLine();
        
        dadosLinha = TSVFile.readLine();

        while (dadosLinha != null){
            
            st = new StringTokenizer(dadosLinha,"\t");
            
            ArrayList<String>dadosContrato = new ArrayList<String>();
            
            while(st.hasMoreElements()){
                
                dadosContrato.add(st.nextElement().toString());
                
            }
            
            int id = Integer.parseInt(dadosContrato.get(0).replace("\"", ""));
                
            String nome = dadosContrato.get(1);
                
            Setor setor = new Setor(id, nome);

            Controlador.getInstancia().colocarSetor(id, setor);

            dadosLinha = TSVFile.readLine();
            
            numeroDeSetores++;
            
        }

        TSVFile.close();

    }
    
    public String ajustarData(String data){
        
        String dataNova = "";
       
        if(data.length() == 10){
        
            dataNova += data.charAt(0);
            
            dataNova += data.charAt(1);
            
            dataNova += "/";
            
            dataNova += data.substring(6);
            
        }else if(data.length() == 9){
            
            if(data.charAt(1) == '/'){
            
                dataNova += data.charAt(0);
                
                dataNova += "/";
            
            }else{
            
                dataNova += data.charAt(0);

                dataNova += data.charAt(1);

                dataNova += "/";

            }
            
            dataNova += data.substring(5);
        
        }else if(data.length() == 8){
        
            dataNova += data.charAt(0);
            
            dataNova += "/";
            
            dataNova += data.substring(4);
            
        }
        
        return dataNova;
    
    }

    public int getNumeroDeContratos() {
        return numeroDeContratos;
    }

    public int getNumeroDeEmpresas() {
        return numeroDeEmpresas;
    }

    public int getNumeroDeContatos() {
        return numeroDeContatos;
    }

    public int getNumeroDeSetores() {
        return numeroDeSetores;
    }
    
}