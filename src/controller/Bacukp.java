package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextPane;

import model.Banco;

public class Bacukp {
	
	private JTextPane textPane;
	
	public Bacukp(){
		
	}
	
	public Bacukp(JTextPane textPane){
		this.textPane =textPane;
	}
	
	public static final String DataDeHoje(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);	
	}
	
	public void mySql(Banco banco){
		try {
	        Conexao.ps.println("mysqldump -h "+banco.getHost()+" --user="+banco.getUsuario()+" --password="+banco.getSenha().toString()+" -R --opt "+banco.getDatabase()+"> ./"+DataDeHoje()+".sql");
	        Mensagem mensagem = new Mensagem(textPane);
	        mensagem.exibeMensagem("realizando Backup...");
	        try{
	        	Thread.sleep(1000);
	      		//Thread.sleep(4*60*1000);
	      	 	}catch(Exception ee){
	      	 		ee.printStackTrace();
	      	 }	 
        mensagem.exibeMensagem("Backup realizado com sucesso!");
        }catch (Exception e) {
        	  Mensagem mensagem = new Mensagem(textPane);
  	        mensagem.exibeMensagem("Erro ao realizar Backup...\n"
  	        						+"Favor,verifique os dados e a internet e tente novamente");
		}
	}
	
}
